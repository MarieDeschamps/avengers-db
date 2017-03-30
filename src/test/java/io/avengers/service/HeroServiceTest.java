package io.avengers.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.avengers.domain.Hero;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import io.avengers.domain.Movie;
import io.avengers.domain.Team;

public class HeroServiceTest {

	HeroService hService;
	Hero hulk;

	@Before
	public void setUp() throws Exception {
		hService = new HeroService();
		hulk = new Hero(3, "Hulk", "Bruce Banner", null, null, null, null);
	}
	
	@Test
	public void findAllTest() {
		Set<Hero>heroes = hService.findAll();
		assertTrue(heroes.size() >5 );
		
		assertTrue(heroes.contains(hulk) );
	}

	@Test
	public void findHeroTest(){
		assertTrue(hService.findHero(0)==null);
		assertTrue(hService.findHero(3).equals(hulk));
		assertTrue(hService.findHero(500)==null || hService.findHero(500).equals(new Hero()));
	}

	@Test (expected = IllegalArgumentException.class)
	public void createHeroNull(){
		hService.createHero(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createHeroAliasNull(){
		Hero h = new Hero(0, "",null, "Bob", null, null, null);
		hService.createHero(h);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createHeroAliasEmpty(){
		Hero h = new Hero(0, "", "", "Bob", null, null, null);
		hService.createHero(h);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deleteHeroNull(){
		hService.deleteHero(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deleteHeroWithoutId(){
		hService.deleteHero(new Hero(0,"","","",null,null,null));
	}
	
	@Test
	public void createHeroEasy(){
		Hero test = new Hero(0, "Jake", "john", "", null, null, null);
		test = hService.createHero(test);
		assertTrue(test.getId()>0);
		hService.deleteHero(test);
		assertTrue(hService.findHero(test.getId())==null || hService.findHero(test.getId()).equals(new Hero()));
	}
	
	@Test
	public void createHeroComplete(){
		List<Team> teams = new ArrayList<>();
		teams.add(new Team(1, "Avengers", null, null, null));
		teams.add(new Team(2, "Xmen", null, null, null));
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(4, "Xmen", null, 0, null, null, null, null));
		movies.add(new Movie(2, "Civil war", null, 0, null, null, null, null));
		Hero test = new Hero(0, "Jake", "john", "", teams, movies, null);
		test = hService.createHero(test);
		assertTrue(test.getId()>0);
		hService.deleteHero(test);
		assertTrue(hService.findHero(test.getId())==null || hService.findHero(test.getId()).equals(new Hero()));
	}
	
}

	