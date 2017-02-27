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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
		if(heroes == null){
			heroes = new ArrayList<>();
		}
		heroes.add(hero);
	}

	public List<Movie> getMovies() {
		return movies;
	}
	
	public void addMovie(Movie movie) {
		if(movies == null){
			movies = new ArrayList<>();
		}
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
