package io.avengers.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Movie {

	int movie_id;
	String movie_title;
	String synopsis;
	long budget;
	List<Hero> heroes;
	List<Team> teams;
	byte[] picture;
	Date date;
	public Movie(int movie_id, String movie_title, String synopsis, long budget, List<Hero> heroes, List<Team> teams,
			byte[] picture, Date date) {
		super();
		this.movie_id = movie_id;
		this.movie_title = movie_title;
		this.synopsis = synopsis;
		this.budget = budget;
		if(heroes == null){
			heroes = new ArrayList<>();
		}else{
			this.heroes = heroes;
		}
		if(teams == null){
			teams = new ArrayList<>();
		}else{
			this.teams = teams;
		}
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
	public List<Team> Team() {
		return teams;
	}
	public void setTeam(List<Team> teams) {
		this.teams = teams;
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
		return movie_title + "\r\n" + date;
	}
	
}
