package io.avengers.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.avengers.domain.Hero;
import io.avengers.domain.Movie;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import io.avengers.domain.Team;

public class MovieServiceTest {

	MovieService mService;
	Movie civilWar;

	@Before
	public void setUp() throws Exception {
		mService = new MovieService();
		civilWar = new Movie(2, "Civil war", null, 250, null, null, null, null);
	}
	
	@Test
	public void findAllTest() {
		Set<Movie>movies = mService.findAll();
		assertTrue(movies.size() >5 );
		
		assertTrue(movies.contains(civilWar) );
	}

	@Test
	public void findMovieTest(){
		assertTrue(mService.findMovie(0)==null);
		assertTrue(mService.findMovie(2).equals(civilWar));
		assertTrue(mService.findMovie(500)==null || mService.findMovie(500).equals(new Movie()));
	}

	@Test (expected = IllegalArgumentException.class)
	public void createMovieNull(){
		mService.createMovie(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createMovieAliasNull(){
		Movie m = new Movie(0,null,"",10,null,null,null,null);
		mService.createMovie(m);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createMovieAliasEmpty(){
		Movie m = new Movie(0,"","",10,null,null,null,null);
		mService.createMovie(m);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deleteMovieNull(){
		mService.deleteMovie(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deleteMovieWithoutId(){
		mService.deleteMovie(new Movie(0,"","",10,null,null,null,null));
	}
	
	@Test
	public void createMovieEasy(){
		Movie test = new Movie(0,"titre","synopsis",10,null,null,null,null);
		test = mService.createMovie(test);
		assertTrue(test.getMovie_id()>0);
		mService.deleteMovie(test);
		assertTrue(mService.findMovie(test.getMovie_id())==null || mService.findMovie(test.getMovie_id()).equals(new Movie()));
	}
	
	@Test
	public void createMovieComplete(){
		List<Team> teams = new ArrayList<>();
		teams.add(new Team(1, "Avengers", null, null, null));
		teams.add(new Team(2, "Xmen", null, null, null));
		List<Hero> heroes = new ArrayList<>();
		heroes.add(new Hero(3, "Hulk", "Bruce Banner", null, null, null, null));
		Movie test = new Movie(0,"titre","synopsis",10,heroes, teams,null,null);
		test = mService.createMovie(test);
		assertTrue(test.getMovie_id()>0);
		mService.deleteMovie(test);
		assertTrue(mService.findMovie(test.getMovie_id())==null || mService.findMovie(test.getMovie_id()).equals(new Movie()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void linkMovieToHeroMovieNull(){
		Hero h = new Hero(3, "Hulk", "Bruce Banner", null, null, null, null);
		mService.linkMovieToHero(null, h);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void linkMovieToHeroHeroNull(){
		mService.linkMovieToHero(civilWar, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void linkMovieToHeroHeroWithoutId(){
		Hero h = new Hero(0, "Hulk", "Bruce Banner", null, null, null, null);
		mService.linkMovieToHero(civilWar, h);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void unlinkMovieToHeroMovieNull(){
		Hero h = new Hero(3, "Hulk", "Bruce Banner", null, null, null, null);
		mService.unlinkMovieToHero(null, h);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void unlinkMovieToHeroHeroNull(){
		mService.unlinkMovieToHero(civilWar, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void unlinkMovieToHeroHeroWithoutId(){
		Hero h = new Hero(0, "Hulk", "Bruce Banner", null, null, null, null);
		mService.unlinkMovieToHero(civilWar, h);
	}
	
	@Test
	public void linkUnlinkMovieToHeroTest(){
		Hero h = new Hero(3, "Hulk", "Bruce Banner", null, null, null, null);
		mService.linkMovieToHero(civilWar, h);
		mService.unlinkMovieToHero(civilWar, h);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateMovieTestNull(){
		mService.updateMovie(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateMovieTestNoId(){
		mService.updateMovie(new Movie(0, "Civil war", null, 250, null, null, null, null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateMovieTestNoName(){
		mService.updateMovie(new Movie(2, null, null, 250, null, null, null, null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateMovieTestEmptyName(){
		mService.updateMovie(new Movie(2, "", null, 250, null, null, null, null));
	}
	
	@Test
	public void updateMovieTestOK(){
		Movie test = new Movie(2, "Civil war2", null, 250, null, null, null, null);
		test = mService.updateMovie(test);
		assertTrue(test.getMovie_title().equals("Civil war2"));
		test = new Movie(2, "Civil war", null, 250, null, null, null, null);
		test = mService.updateMovie(test);
		assertTrue(test.getMovie_title().equals("Civil war"));
	}
	
}

	