package io.avengers.service;

import java.sql.SQLException;
import io.avengers.dao.ImageDao;

public class ImageService {

	IllegalStateException stateException = new IllegalStateException("Connection impossible, try again later");
	
	public byte[] findLogo() {
		try {
			return new ImageDao().findLogo();
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
}
