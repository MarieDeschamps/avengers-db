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
import io.avengers.domain.Team;

public class MovieDaoTest {

	MovieDao dao;
	Connection connect;
	int movieID;

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
		assertTrue(dao.findAll().size() == 7 );
		
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

}
