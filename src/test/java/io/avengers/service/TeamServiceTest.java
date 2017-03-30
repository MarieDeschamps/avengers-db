package io.avengers.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.avengers.domain.Hero;
import io.avengers.domain.Movie;
import io.avengers.domain.Team;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TeamServiceTest {

	TeamService tService;
	Team avengers;

	@Before
	public void setUp() throws Exception {
		tService = new TeamService();
		avengers = new Team(1, "Avengers", null, null, null);
	}
	
	@Test
	public void findAllTest() {
		Set<Team>Teams = tService.findAll();
		assertTrue(Teams.size() >= 2 );
		
		assertTrue(Teams.contains(avengers) );
	}

	@Test
	public void findTeamTest(){
		assertTrue(tService.findTeam(0)==null);
		assertTrue(tService.findTeam(1).equals(avengers));
		assertTrue(tService.findTeam(500)==null || tService.findTeam(500).equals(new Team()));
	}

	@Test (expected = IllegalArgumentException.class)
	public void createTeamNull(){
		tService.createTeam(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createTeamAliasNull(){
		Team m = new Team(0,null,null,null,null);
		tService.createTeam(m);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createTeamAliasEmpty(){
		Team m = new Team(0,"",null,null,null);
		tService.createTeam(m);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deleteTeamNull(){
		tService.deleteTeam(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deleteTeamWithoutId(){
		tService.deleteTeam(new Team(0,"",null,null,null));
	}
	
	@Test
	public void createTeamEasy(){
		Team test = new Team(0,"titre",null,null,null);
		test = tService.createTeam(test);
		assertTrue(test.getId()>0);
		tService.deleteTeam(test);
		assertTrue(tService.findTeam(test.getId())==null || tService.findTeam(test.getId()).equals(new Team()));
	}
	
	@Test
	public void createTeamComplete(){
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(4, "Xmen", null, 0, null, null, null, null));
		movies.add(new Movie(2, "Civil war", null, 0, null, null, null, null));
		List<Hero> heroes = new ArrayList<>();
		heroes.add(new Hero(3, "Hulk", "Bruce Banner", null, null, null, null));
		Team test = new Team(0,"test",null,heroes,movies);
		test = tService.createTeam(test);
		assertTrue(test.getId()>0);
		tService.deleteTeam(test);
		assertTrue(tService.findTeam(test.getId())==null || tService.findTeam(test.getId()).equals(new Team()));
	}
	
}

	