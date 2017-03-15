package io.avengers.service;

import java.sql.SQLException;
import java.util.Set;

import io.avengers.dao.MovieDao;
import io.avengers.domain.Hero;
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

	public void createMovie(Movie movie) {
		if (movie == null || movie.getMovie_title() == null) {
			throw new IllegalStateException("The movie cannot be created");
		}

		try {
			new MovieDao().createMovie(movie);

			if (movie.getHeroes() != null && !movie.getHeroes().isEmpty()) {
				for (Hero hero : movie.getHeroes()) {
					this.linkMovieToHero(movie, hero);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
	public void deleteMovie(Movie movie) {
		if (movie == null) {
			throw new IllegalStateException("The movie cannot be deleted");
		}

		try {
			new MovieDao().deleteMovie(movie);

		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	public void linkMovieToHero(Movie movie, Hero hero) {
		if (movie == null || hero == null) {
			throw new IllegalStateException("The link cannot be created");
		}

		try {
			new MovieDao().linkMovieToHero(movie, hero);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	/*
	 * Unused method !!! public Set<Movie> findMovieByName(String term) {
	 * 
	 * if (term == null) {
	 * System.out.println("Potential bug or illegal request"); return
	 * this.findAll(); }
	 * 
	 * if (term.isEmpty()) { return this.findAll(); }
	 * 
	 * try { return new MovieDao().findMoviesByName(term); } catch (SQLException
	 * e) { e.printStackTrace(); throw stateException; }
	 * 
	 * }
	 */
}
