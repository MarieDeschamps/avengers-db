package io.avengers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImageDao extends MarvelDao{
	public byte[] findLogo() throws SQLException {
		String query = "SELECT * FROM image WHERE ID = 1";

		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		byte[] logo = null;

		while (resultSet.next()) {
			logo = resultSetToImage(resultSet);
		}

		connect.close();

		return logo;
	}
	
	protected byte[] resultSetToImage(ResultSet resultSet) {
		try {
			byte[] picture = resultSet.getBytes("image");
			
			return picture;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}
	}
}
