package io.avengers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import io.avengers.domain.Hero;
import io.avengers.domain.Movie;
import io.avengers.domain.Team;

public class HeroDao extends MarvelDao{
	// DAO: direct access object

	public Set<Hero> findAll() throws SQLException {
		String query = "SELECT h.id AS hero_id, h.name AS alias,  h.picture heroPicture, h.abilities, irl.name AS realName "
				+ "FROM heroes h " 
				+ "LEFT JOIN `irl` irl ON h.id = irl.hero_id "
				+ "ORDER BY h.name ASC";

		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Set<Hero> heroes = new HashSet<>();

		while (resultSet.next()) {

			heroes.add(resultSetToHero(resultSet));
		}

		connect.close();

		return heroes;
	}

//	public Set<Hero> findHeroesByName(String term) throws SQLException {
//		String query = "SELECT h.name AS alias, h.id AS hero_id FROM heroes h WHERE h.name LIKE '%" + term + "%'";
//
//		Connection connect = connectToMySql();
//
//		Statement statement = connect.createStatement();
//		ResultSet resultSet = statement.executeQuery(query);
//
//		Set<Hero> heroes = new HashSet<>();
//
//		while (resultSet.next()) {
//			heroes.add(resultSetToHero(resultSet));
//		}
//
//		connect.close();
//
//		return heroes;
//	}

	public Hero findHero(int characterID) throws SQLException {
		String query = "SELECT h.id AS hero_id, h.name AS alias, irl.name as realName, h.abilities, h.picture AS heroPicture, "
				+ "t.name AS team_name, t. team_id, t.picture AS teamPicture, "
				+ "m.name AS movie_title,  m.id AS movie_id, m.picture AS moviePicture, m.history AS synopsis, m.budget AS budget "
				+ "FROM `heroes`  h "
				+ "LEFT JOIN `irl` irl ON h.id = irl.hero_id "
				+ "LEFT JOIN movie_hero mh ON h.id = mh.id_hero " 
				+ "LEFT JOIN `movie` m ON m.id = mh.id_movie "
				+ "LEFT JOIN team_hero th ON h.id = th.hero_id " 
				+ "LEFT JOIN team t ON th.team_id = t.team_id "
				+ "WHERE h.id = " + characterID + ";";

		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Hero hero = null;
		TeamDao tDao = new TeamDao();
		MovieDao mDao = new MovieDao();
		Team team;
		Movie movie;

		while (resultSet.next()) {
			if (hero == null){
				hero = resultSetToHero(resultSet);
			}
			team = tDao.resultSetToTeam(resultSet);
			if(team.getName()!=null)
				hero.addTeam(team);
			
			movie = mDao.resultSetToMovie(resultSet);
			if(movie.getMovie_title()!=null)
				hero.addMovie(movie);
		}

		connect.close();

		return hero;
	}

	protected Hero resultSetToHero(ResultSet resultSet) {
		try {
			int id = resultSet.getInt("hero_id");

			String alias = resultSet.getString("alias");
			String realName = resultSet.getString("realName");
			String abilities = resultSet.getString("abilities");
			byte[] picture = resultSet.getBytes("heroPicture");
			// pour differencier avec l'enum

			Hero h = new Hero(id, alias, realName, abilities, null, null, null);
			return h;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}
	}

}
