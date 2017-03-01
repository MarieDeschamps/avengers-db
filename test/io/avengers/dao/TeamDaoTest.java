package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.avengers.domain.Hero;
import io.avengers.domain.Team;

public class TeamDaoTest {

	TeamDao dao;
	Connection connect;

	@Before
	public void setUp() throws Exception {
		dao = new TeamDao();
		connect = dao.connectToMySql();
	}

	@After
	public void tearDown() throws Exception {
		connect.close();
	}

	@Test
	public void testFindAll() throws SQLException {
		assertTrue(dao.findAll().size() == 2 );
		
		Team avengers = new Team(1, "Avengers",null, null, null);
		assertTrue(dao.findAll().contains(avengers) );
	}

	@Test
	public void testFindTeam() throws SQLException {
		int teamID = 2;
		System.out.println(dao.findTeam(teamID));
		
		assertTrue(dao.findTeam(teamID).toString().contains("Xmen"));
		
		assertFalse(dao.findTeam(teamID).getHeroes().contains(null));
		assertFalse(dao.findTeam(teamID).getMovies().contains(null));
		
	}

}
