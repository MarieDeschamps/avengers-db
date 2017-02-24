package io.avengers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import io.avengers.domain.Hero;
import io.avengers.domain.Sex;

public class HeroDao {
	// DAO: direct access object

	static Class c;

	public HeroDao() {
		if (c == null) {
			try {
				c = Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("SQL Driver is not here: " + e.getMessage());
			}
		}
	}

	public Set<Hero> findAll() throws SQLException {
		String query = "SELECT * FROM heroes";

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

	public Set<Hero> findHeroesByName(String term) throws SQLException {
		String query = "SELECT h.name FROM heroes h WHERE name LIKE%" + term + "% ORDER BY h.name";

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

	Hero resultSetToHero(ResultSet resultSet) {
		try {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			// pour differencier avec l'enum
			String sSex = resultSet.getString("sex");
			long likes = resultSet.getLong("likes");
			long dislikes = resultSet.getLong("dislikes");

			Hero h = new Hero(id, name, Sex.O, likes, dislikes);

			return h;
		} catch (SQLException e) {
			throw new IllegalStateException("Database moved: " + e.getMessage());
		}

	}

	Connection connectToMySql() {
		Connection connect;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/marvel", "root", "");
			return connect;
		} catch (SQLException e) {
			throw new IllegalStateException("Wrong credentials, URL or overloaded connection: " + e.getMessage());
		}

	}

}
