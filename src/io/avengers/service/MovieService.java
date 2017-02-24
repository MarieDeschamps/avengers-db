package io.avengers.service;

import java.sql.SQLException;
import java.util.Set;

import io.avengers.dao.MovieDao;
import io.avengers.domain.Movie;

public class MovieService {

	IllegalStateException stateException = new IllegalStateException("Connection impossible, try again later");

	public Set<Movie> findAll() {
		try {
			return new MovieDao().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	public Movie findMovie(int movieID) {
		if (movieID <= 0) {
			System.out.println("Potential bug or illegal request");
		}

		try {
			return new MovieDao().findMovie(movieID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	/* Unused method !!!
	public Set<Movie> findMovieByName(String term) {

		if (term == null) {
			System.out.println("Potential bug or illegal request");
			return this.findAll();
		}

		if (term.isEmpty()) {
			return this.findAll();
		}

		try {
			return new MovieDao().findMoviesByName(term);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}

	}*/
}
