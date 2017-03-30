package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.avengers.domain.Hero;
import io.avengers.domain.Movie;
import io.avengers.domain.Team;

public class TeamDaoTest {

	TeamDao dao;
	Connection connect;
	Hero thor = new Hero(5, "Thor", null, null, null, null, null);
	Team xmen = new Team(2, "Xmen",null, null, null);
	Team test = new Team(0, "Boo",null, null, null);

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
	
	@Test
	public void testCreateDeleteTeam() throws SQLException {
		test = dao.createTeam(test);
		
		assertTrue(test.getId() != 0 );
		
		dao.deleteTeam(test);
		
	}
	
	/*@Test
	public void testUpdateTeam() throws SQLException {
		assertFalse(dao.updateTeam(xmen).getName().equals("Xmen") );		
	}*/
	
	@Test
	public void testLinkTeam() throws SQLException {
		dao.linkTeamToHero(xmen, thor);		
	}
	
	@Test
	public void testUnlinkMovie() throws SQLException {
		dao.unlinkTeamToHero(xmen, thor);		
	}


}
