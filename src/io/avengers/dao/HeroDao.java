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
	//DAO: direct access object
	
	public Set<Hero> findAll() throws ClassNotFoundException, SQLException{
		String query = "SELECT * FROM heroes";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/marvel", "root", "");
		
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		Set<Hero> heroes = new HashSet<>();
		
		while (resultSet.next()){
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			//pour differencier avec l'enum
			String sSex = resultSet.getString("sex");
			long likes = resultSet.getLong("likes");
			long dislikes = resultSet.getLong("dislikes");
			
			Hero h = new Hero(id, name, Sex.O, likes, dislikes);
			heroes.add(h);
		}
		
		connect.close();
		
		return heroes;
	}
	
}
