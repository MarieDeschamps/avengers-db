package io.avengers.service;

import java.sql.SQLException;
import java.util.Set;

import io.avengers.dao.TeamDao;
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
	
}
