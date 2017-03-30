package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.avengers.domain.Hero;
import io.avengers.domain.Movie;

public class MovieDaoTest {

	MovieDao dao;
	Connection connect;
	int movieID;
	Hero thor = new Hero(5, "Thor", null, null, null, null, null);
	Movie testM = new Movie(0, "Grrr", "", 0, null, null, null, null);
	Movie xmen = new Movie(4, "Xmen", "", 75, null, null, null, null);

	@Before
	public void setUp() throws Exception {
		dao = new MovieDao();
		connect = dao.connectToMySql();
		movieID = 2;
	}

	@After
	public void tearDown() throws Exception {
		connect.close();
	}

	@Test
	public void testFindAll() throws SQLException {
		assertTrue(dao.findAll().size() >= 5 );
		
		Movie xmen = new Movie(4, "Xmen", "", 75, null, null, null, null);
		assertTrue(dao.findAll().contains(xmen) );
	}

	@Test
	public void testFindMovie1() throws SQLException {
		System.out.println(dao.findMovie(movieID));
		assertTrue(dao.findMovie(movieID).toString().contains("Civil war"));
	}
	
	@Test
	public void testFindMovie2() throws SQLException {
		System.out.println(dao.findMovie(movieID));
		assertFalse(dao.findMovie(movieID).getHeroes().contains(null));
		assertFalse(dao.findMovie(movieID).getTeams().contains(null));
	}
	
	@Test
	public void testCreateDeleteMovie() throws SQLException {
		testM = dao.createMovie(testM);
		
		assertTrue(testM.getMovie_id() != 0 );
		
		dao.deleteMovie(testM);
		
	}
	
	@Test
	public void testUpdateMovie() throws SQLException {
		Movie test = new Movie(4, "Xmen2", "", 75, null, null, null, null);
		assertTrue(dao.updateMovie(test).getMovie_title().equals("Xmen2") );
		test = new Movie(4, "Xmen", "", 75, null, null, null, null);
		assertTrue(dao.updateMovie(test).getMovie_title().equals("Xmen") );
	}
	
	@Test
	public void testLinkMovie() throws SQLException {
		dao.linkMovieToHero(xmen, thor);		
	}
	
	@Test
	public void testUnlinkMovie() throws SQLException {
		dao.unlinkMovieToHero(xmen, thor);		
	}

}
