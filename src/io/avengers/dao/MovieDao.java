package io.avengers.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import io.avengers.domain.Movie;

public class MovieDao extends MarvelDao {

	public Set<Movie> findAll() throws SQLException {
		String query = "SELECT m.id AS movie_id, m.name as movie_title, m.date, m.picture FROM `movie` m";

		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Set<Movie> movies = new HashSet<>();

		while (resultSet.next()) {

			movies.add(resultSetToMovie(resultSet));
		}

		connect.close();

		return movies;
	}
/* Unused method !!!!
	public Set<Movie> findMoviesByName(String term) throws SQLException {
		String query = "SELECT h.name AS alias, h.id AS hero_id FROM heroes h WHERE h.name LIKE '%" + term + "%'";

		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Set<Movie> movies = new HashSet<>();

		while (resultSet.next()) {
			movies.add(resultSetToMovie(resultSet));
		}

		connect.close();

		return movies;
	}*/

	public Movie findMovie(int movieID) throws SQLException {
		String query = "SELECT h.id AS hero_id, h.name AS alias, irl.name as realName, h.abilities, h.picture AS heroPicture, "
				+ "t.name AS team_name, t. team_id, t.picture AS teamPicture, "
				+ "m.name AS movie_title,  m.id AS movie_id, m.picture AS moviePicture, m.history AS synopsis, m.budget AS budget "
				+ "FROM `movie` m "
				+ "LEFT JOIN `movie_hero` mh ON m.id = mh.id_movie "
				+ "LEFT JOIN heroes h ON h.id = mh.id_hero "
				+ "LEFT JOIN `irl` irl ON h.id = irl.hero_id "
				+ "LEFT JOIN team_hero th ON h.id = th.hero_id "
				+ "LEFT JOIN team t ON th.team_id = t.team_id "
				+ "WHERE m.id = "+ movieID+";";

		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Movie movie = null;
		if (resultSet.next()) {
			movie = resultSetToMovie(resultSet);
		}

		connect.close();

		return movie;
	}

	protected Movie resultSetToMovie(ResultSet resultSet) {
		try {
			int movie_id = resultSet.getInt("movie_id");
			long budget = resultSet.getInt("budget");

			String movie_title = resultSet.getString("movie_title");
			String synopsis = resultSet.getString("synopsis");
			//Date date = resultSet.getString("date");

			// pour differencier avec l'enum

			Movie m = new Movie (movie_id, movie_title, synopsis, budget, null, null,
					null, null);
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}
	}

}
