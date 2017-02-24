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
		String query = "SELECT h.id AS hero_id, h.name AS alias, h.picture "
				+ "FROM heroes h "
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

	public Set<Hero> findHeroesByName(String term) throws SQLException {
		String query = "SELECT h.name AS alias, h.id AS hero_id FROM heroes h WHERE h.name LIKE '%" + term + "%'";

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

	public Hero findHero(int characterID) throws SQLException {
		String query = "SELECT h.id AS hero_id, h.name AS alias, irl.name as realName, h.abilities, t.name AS team, t. team_id, m.name AS movie,  m.id AS movie_id, h.picture "
				+ "FROM `heroes`  h LEFT JOIN `irl` irl ON h.id = irl.hero_id "
				+ "LEFT JOIN movie_hero mh ON h.id = mh.id_hero " + "LEFT JOIN `movie` m ON m.id = mh.id_movie "
				+ "LEFT JOIN team_hero th ON h.id = th.hero_id " + "LEFT JOIN team t ON th.team_id = t.team_id "
				+ "WHERE h.id = " + characterID + ";";

		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Hero hero = null;
		if (resultSet.next()) {
			hero = resultSetToHero(resultSet);
		}

		connect.close();

		return hero;
	}

	private Connection connectToMySql(){
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/marvel", "root", "");
			return connect;
		} catch (SQLException e) {
			throw new IllegalStateException("Wrong credentials (= login / password), or url or overloaded connection: " + e.getMessage());
		}
	}

	protected Hero resultSetToHero(ResultSet resultSet) {
		try {
			int id = resultSet.getInt("hero_id");

			String alias = resultSet.getString("alias");
			String realName = resultSet.getString("realName");
			String abilities = resultSet.getString("abilities");
			
			// pour differencier avec l'enum

			Hero h = new Hero(id, alias, realName, abilities, null, null, null);
			return h;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}
	}

}
