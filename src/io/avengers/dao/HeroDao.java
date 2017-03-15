package io.avengers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import java.util.Set;

import io.avengers.domain.Hero;
import io.avengers.domain.Movie;
import io.avengers.domain.Team;

public class HeroDao extends MarvelDao {
	// DAO: data access object

	public Set<Hero> findAll() throws SQLException {
		String query = "SELECT h.id AS hero_id, h.name AS alias,  h.picture heroPicture, h.abilities, irl.name AS realName "
				+ "FROM heroes h " + "LEFT JOIN `irl` irl ON h.id = irl.hero_id " + "ORDER BY h.name ASC";

		Connection connect = connectToMySql();
		Set<Hero> heroes = new TreeSet<>();

		try {
			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				heroes.add(resultSetToHero(resultSet));
			}

		} finally {
			connect.close();
		}
		return heroes;
	}

	// public Set<Hero> findHeroesByName(String term) throws SQLException {
	// String query = "SELECT h.name AS alias, h.id AS hero_id FROM heroes h
	// WHERE h.name LIKE '%" + term + "%'";
	//
	// Connection connect = connectToMySql();
	//
	// Statement statement = connect.createStatement();
	// ResultSet resultSet = statement.executeQuery(query);
	//
	// Set<Hero> heroes = new TreeSet<>();
	//
	// while (resultSet.next()) {
	// heroes.add(resultSetToHero(resultSet));
	// }
	//
	// connect.close();
	//
	// return heroes;
	// }

	public Hero findHero(int characterID) throws SQLException {
		String query = "SELECT h.id AS hero_id, h.name AS alias, irl.name as realName, h.abilities, h.picture AS heroPicture, "
				+ "t.name AS team_name, t. team_id, t.picture AS teamPicture, "
				+ "m.name AS movie_title,  m.id AS movie_id, m.picture AS moviePicture, m.history AS synopsis, m.budget AS budget "
				+ "FROM `heroes`  h " + "LEFT JOIN `irl` irl ON h.id = irl.hero_id "
				+ "LEFT JOIN movie_hero mh ON h.id = mh.id_hero " + "LEFT JOIN `movie` m ON m.id = mh.id_movie "
				+ "LEFT JOIN team_hero th ON h.id = th.hero_id " + "LEFT JOIN team t ON th.team_id = t.team_id "
				+ "WHERE h.id = " + characterID + ";";

		Connection connect = connectToMySql();

		Hero hero = null;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			TeamDao tDao = new TeamDao();
			MovieDao mDao = new MovieDao();
			Team team;
			Movie movie;

			while (resultSet.next()) {
				if (hero == null) {
					hero = resultSetToHero(resultSet);
				}
				team = tDao.resultSetToTeam(resultSet);
				if (team.getName() != null)
					hero.addTeam(team);

				movie = mDao.resultSetToMovie(resultSet);
				if (movie.getMovie_title() != null)
					hero.addMovie(movie);
			}

		} finally {
			connect.close();
		}

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

			Hero h = new Hero(id, alias, realName, abilities, null, null, picture);
			return h;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}
	}

	public Hero createHero(Hero hero) throws SQLException {
		Connection connect = connectToMySql();
		
		try {
			connect.setAutoCommit(false);

			String query1 = "INSERT INTO `heroes` " + "(`name`, `picture`, `abilities`) " + "VALUES (?, null, ?);"; // TODO
																													// add
																													// the
																													// picture
																													// query

			PreparedStatement ps1 = connect.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
			ps1.setString(1, hero.getAlias());
			ps1.setString(2, hero.getAbilities());
			ps1.execute();

			ResultSet rs = ps1.getGeneratedKeys();
			int resultId =-1;
			if (rs.next()) {
				resultId = rs.getInt(1);
			}

			if (resultId <= 0) {
				connect.rollback();
				throw new IllegalStateException("hero not created in database !");
			}else{
				hero.setId(resultId);
			}

			if (hero.getRealName() != null && !hero.getRealName().isEmpty()) {
				String query2 = "INSERT INTO `irl` (`hero_id`, `name`) VALUES (?, ?);";

				PreparedStatement ps2 = connect.prepareStatement(query2);
				ps2.setInt(1, resultId);
				ps2.setString(2, hero.getRealName());
				ps2.execute();
			}

			connect.commit();
		} catch (Exception e) {
			connect.rollback();
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		} finally {
			connect.close();
		}
		return hero;
	}

	public void deleteHero(Hero hero) throws SQLException {
		Connection connect = connectToMySql();
		try {
			connect.setAutoCommit(false);

			String queryIrl = "DELETE FROM `irl` WHERE `irl`.`hero_id` = ?;";

			PreparedStatement psIrl = connect.prepareStatement(queryIrl);
			psIrl.setInt(1, hero.getId());
			psIrl.execute();

			String queryMovie = "DELETE FROM `movie_hero` WHERE `movie_hero`.`id_hero` = ?;";

			PreparedStatement psMovie = connect.prepareStatement(queryMovie);
			psMovie.setInt(1, hero.getId());
			psMovie.execute();

			String queryTeam = "DELETE FROM `team_hero` WHERE `team_hero`.`hero_id` = ?;";

			PreparedStatement psTeam = connect.prepareStatement(queryTeam);
			psTeam.setInt(1, hero.getId());
			psTeam.execute();

			String queryHero = "DELETE FROM `heroes` WHERE `heroes`.`id` = ?;";

			PreparedStatement psHero = connect.prepareStatement(queryHero);
			psHero.setInt(1, hero.getId());
			psHero.execute();

			connect.commit();
		} catch (Exception e) {
			connect.rollback();
			throw new IllegalStateException("Hero not deleted!! " + e.getMessage());
		} finally {
			connect.close();
		}
	}

}
