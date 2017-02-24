package io.avengers.domain;

import java.sql.Date;
import java.util.List;

public class Movie {

	int movie_id;
	String movie_title;
	String synopsis;
	long budget;
	List<Hero> heroes;
	List<Movie> movies;
	byte[] picture;
	Date date;
	public Movie(int movie_id, String movie_title, String synopsis, long budget, List<Hero> heroes, List<Movie> movies,
			byte[] picture, Date date) {
		super();
		this.movie_id = movie_id;
		this.movie_title = movie_title;
		this.synopsis = synopsis;
		this.budget = budget;
		this.heroes = heroes;
		this.movies = movies;
		this.picture = picture;
		this.date = date;
	}
	public int getMovie_id() {
		return movie_id;
	}

	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public long getBudget() {
		return budget;
	}
	public void setBudget(long budget) {
		this.budget = budget;
	}
	public List<Hero> getHeroes() {
		return heroes;
	}
	public void setHeroes(List<Hero> heroes) {
		this.heroes = heroes;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return movie_title + "\r\n" + date;
	}
	
}
