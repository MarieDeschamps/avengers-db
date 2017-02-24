package io.avengers.domain;

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
		this.teams = teams;
		this.movies = movies;
		this.picture = picture;
	}

	@Override
	public String toString() {
		return this.alias;
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

	

}
