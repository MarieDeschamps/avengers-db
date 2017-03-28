package io.avengers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
import java.util.Set;

import io.avengers.domain.Hero;
import io.avengers.domain.Team;

public class TeamDao extends MarvelDao {

	public Set<Team> findAll() throws SQLException {
		String query = "SELECT t.team_id AS team_id, t.name AS team_name, t.picture AS teamPicture " + "FROM team t "
				+ "ORDER BY t.name ASC";

		Connection connect = connectToMySql();
		Set<Team> teams = new TreeSet<>();
		try {
			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
	
			while (resultSet.next()) {
				teams.add(resultSetToTeam(resultSet));
			}
		
		} finally {
			connect.close();
		}
		return teams;
	}

	public Team findTeam(int teamID) throws SQLException {
		String query = "SELECT h.id AS hero_id, h.name AS alias, irl.name as realName, h.abilities, h.picture AS heroPicture, "
				+ "t.name AS team_name, t. team_id, t.picture AS teamPicture, "
				+ "m.name AS movie_title,  m.id AS movie_id, m.picture AS moviePicture, m.history AS synopsis, m.budget AS budget "
				+ "FROM team t " + "LEFT JOIN team_hero th ON th.team_id = t.team_id "
				+ "LEFT JOIN heroes h ON h.id = th.hero_id " + "LEFT JOIN `irl` irl ON h.id = irl.hero_id "
				+ "LEFT JOIN movie_hero mh ON h.id = mh.id_hero " + "LEFT JOIN `movie` m ON m.id = mh.id_movie "
				+ "WHERE t.team_id = " + teamID;

		Connection connect = connectToMySql();
		Team team = null;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
	
			
			HeroDao hDao = new HeroDao();
			MovieDao mDao = new MovieDao();
	
			while (resultSet.next()) {
				if (team == null) {
					team = resultSetToTeam(resultSet);
				}
				team.addHeroe(hDao.resultSetToHero(resultSet));
				team.addMovie(mDao.resultSetToMovie(resultSet));
			}
	
		} finally {
			connect.close();
		}
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

	public Team createTeam(Team team) throws SQLException {
		Connection connect = connectToMySql();
		try {
			connect.setAutoCommit(false);

			String query1 = "INSERT INTO `team` (`name`) VALUES (?);"; // TODO
																		// add
																		// the
																		// picture
																		// query

			PreparedStatement ps1 = connect.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
			ps1.setString(1, team.getName());
			ps1.execute();

			ResultSet rs = ps1.getGeneratedKeys();
			int resultId = -1;
			if (rs.next()) {
				resultId = rs.getInt(1);
			}

			if (resultId <= 0) {
				connect.rollback();
				throw new IllegalStateException("team not created in database !");
			}else{
				team.setId(resultId);
			}

			connect.commit();
		} catch (Exception e) {
			connect.rollback();
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		} finally {
			connect.close();
		}
		return team;
	}

	public void linkTeamToHero(Team team, Hero hero) throws SQLException {
		String query = "INSERT INTO `team_hero` (`team_id`,`hero_id`) VALUES (?,?);";

		Connection connect = connectToMySql();

		try {
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1, team.getId());
			ps.setInt(2, hero.getId());
			ps.execute();
		} finally {

			connect.close();
		}
	}
	
	public void deleteTeam(Team team) throws SQLException {
		Connection connect = connectToMySql();
		try {
			connect.setAutoCommit(false);

			String queryHero = "DELETE FROM `team_hero` WHERE `team_hero`.`team_id` = ?;";

			PreparedStatement psHero = connect.prepareStatement(queryHero);
			psHero.setInt(1, team.getId());
			psHero.execute();

			String queryTeam = "DELETE FROM `team` WHERE `team`.`team_id` = ?;";

			PreparedStatement psTeam = connect.prepareStatement(queryTeam);
			psTeam.setInt(1, team.getId());
			psTeam.execute();
			

			connect.commit();
		} catch (Exception e) {
			connect.rollback();
			throw new IllegalStateException("Team not deleted!! " + e.getMessage());
		} finally {
			connect.close();
		}
	}

}
