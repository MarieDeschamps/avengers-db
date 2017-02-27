package io.avengers.domain;

import java.util.ArrayList;
import java.util.List;

public class Hero {
	int id;
	String alias;
	String realName;
	Sex sex;
	long likes;
	long dislikes;
	String abilities;
	List<Team> teams;
	List<Movie> movies;
	byte[] picture;

	public Hero(int id, String alias, String realName, String abilities, List<Team> teams, List<Movie> movies,
			byte[] picture) {
		super();
		this.id = id;
		this.alias = alias;
		this.realName = realName;
		this.abilities = abilities;
		if (teams == null) {
			teams = new ArrayList<>();
		} else {
			this.teams = teams;
		}
		if (movies == null) {
			movies = new ArrayList<>();
		} else {
			this.movies = movies;
		}
		this.picture = picture;
	}

	@Override
	public String toString() {
		return this.alias + " (teams = " + teams + " / movies = " + movies + " )";
	}

	public int getId() {
		return id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAbilities() {
		return abilities;
	}

	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public void addTeam(Team team) {
		if (teams == null){
			teams = new ArrayList<>();
		}
		if (team != null &&  !teams.contains(team)){
			this.teams.add(team);
			
		}	
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public void addMovie(Movie movie) {
		if (movies == null) {
			movies = new ArrayList<>();
		}
		if (movie != null && !movies.contains(movie)){
			movies.add(movie);
		}
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + id;
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
		Hero other = (Hero) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
