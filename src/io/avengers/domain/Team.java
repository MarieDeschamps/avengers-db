package io.avengers.domain;

import java.util.List;

public class Team {
	int id;
	String name;
	byte[] picture;
	List<Hero> heroes;
	List<Movie> movies;
	
	public Team(int id, String name, byte[] picture, List<Hero> heroes, List<Movie> movies) {
		this.id = id;
		this.name = name;
		this.picture = picture;
		this.heroes = heroes;
		this.movies = movies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
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

	@Override
	public String toString() {
		return "Team [name=" + name + "]";
	}
	
}
