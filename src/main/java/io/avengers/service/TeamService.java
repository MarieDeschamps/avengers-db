package io.avengers.service;

import java.sql.SQLException;
import java.util.Set;

import io.avengers.dao.HeroDao;
import io.avengers.dao.MovieDao;
import io.avengers.dao.TeamDao;
import io.avengers.domain.Hero;
import io.avengers.domain.Movie;
import io.avengers.domain.Team;

public class TeamService {

IllegalStateException stateException = new IllegalStateException("Connection impossible, try again later");
	
	public Set<Team> findAll() {
		try {
			return new TeamDao().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
	public Team findTeam(int teamID) {
		if(teamID<=0){
			System.out.println("Potential bug or illegal request");
		}
		try {
			return new TeamDao().findTeam(teamID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
	public void createTeam(Team team){
		if(team==null || team.getName()==null){
			throw new IllegalStateException("The team cannot be created");
		}
		
		try {
			team = new TeamDao().createTeam(team);
			if(team.getHeroes()!=null && !team.getHeroes().isEmpty()){
				for(Hero h : team.getHeroes()){
					this.linkTeamToHero(team, h);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
	public void linkTeamToHero(Team team, Hero hero){
		if(team==null || hero==null){
			throw new IllegalStateException("The link cannot be created");
		}
		
		try {
			new TeamDao().linkTeamToHero(team, hero);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
	public void deleteTeam(Team team) {
		if (team == null) {
			throw new IllegalStateException("The team cannot be deleted");
		}

		try {
			new TeamDao().deleteTeam(team);

		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
}
