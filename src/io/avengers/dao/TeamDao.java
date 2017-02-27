package io.avengers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import io.avengers.domain.Team;

public class TeamDao extends MarvelDao {

	public Set<Team> findAll() throws SQLException {
		String query = "SELECT t.team_id AS team_id, t.name AS team_name, t.picture AS teamPicture "
				+ "FROM team t "
				+ "ORDER BY t.name ASC";

		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Set<Team> teams = new HashSet<>();

		while (resultSet.next()) {

			teams.add(resultSetToTeam(resultSet));
		}

		connect.close();

		return teams;
	}

	public Team findTeam(int teamID) throws SQLException {
		String query = "SELECT h.id AS hero_id, h.name AS alias, irl.name as realName, h.abilities, h.picture AS heroPicture, "
				+ "t.name AS team_name, t. team_id, t.picture AS teamPicture, "
				+ "m.name AS movie_title,  m.id AS movie_id, m.picture AS moviePicture, m.history AS synopsis, m.budget AS budget "
				+ "FROM team t " 
				+ "LEFT JOIN team_hero th ON th.team_id = t.team_id "
				+ "LEFT JOIN heroes h ON h.id = th.hero_id " 
				+ "LEFT JOIN `irl` irl ON h.id = irl.hero_id "
				+ "LEFT JOIN movie_hero mh ON h.id = mh.id_hero "
				+ "LEFT JOIN `movie` m ON m.id = mh.id_movie " 
				+ "WHERE t.team_id = " + teamID;

		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Team team = null;
		HeroDao hDao = new HeroDao();
		MovieDao mDao = new MovieDao();

		while (resultSet.next()) {
			if (team == null){
				team = resultSetToTeam(resultSet);
			}
				team.addHeroe(hDao.resultSetToHero(resultSet));
				team.addMovie(mDao.resultSetToMovie(resultSet));
		}

		connect.close();

		return team;
	}

	protected Team resultSetToTeam(ResultSet resultSet) {
		try {
			int id = resultSet.getInt("team_id");
			String name = resultSet.getString("team_name");
			byte[] picture = resultSet.getBytes("teamPicture");

			Team h = new Team(id, name, picture, null, null);
			return h;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}
	}

}
