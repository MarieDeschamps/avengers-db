package io.avengers.domain;

import java.util.ArrayList;
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
		if(heroes == null){
			heroes = new ArrayList<>();
		}else{
			this.heroes = heroes;
		}
		if(movies == null){
			movies = new ArrayList<>();
		}else{
			this.movies = movies;
		}
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
	
	public void addHeroe(Hero hero) {
		heroes.add(hero);
	}

	public List<Movie> getMovies() {
		return movies;
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
