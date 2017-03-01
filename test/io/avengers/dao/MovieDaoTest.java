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
	int teamID;

	@Before
	public void setUp() throws Exception {
		dao = new MovieDao();
		connect = dao.connectToMySql();
		teamID = 2;
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
	public void testFindHero1() throws SQLException {
		System.out.println(dao.findMovie(teamID));
		assertTrue(dao.findMovie(teamID).toString().contains("Civil"));
	}
	
	@Ignore
	@Test
	public void testFindHero2() throws SQLException {
		assertFalse(dao.findMovie(teamID).getHeroes().contains(null));
		assertFalse(dao.findMovie(teamID).getTeams().contains(null));
	}

}
