package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.avengers.domain.Hero;

public class HeroDaoTest {

	HeroDao dao;
	Connection connect;

	@Before
	public void setUp() throws Exception {
		dao = new HeroDao();
		connect = dao.connectToMySql();
	}

	@After
	public void tearDown() throws Exception {
		connect.close();
	}

	@Test
	public void testFindAll() throws SQLException {
		assertTrue(dao.findAll().size() >5 );
		
		Hero hulk = new Hero(3, "Hulk", "Bruce Banner", null, null, null, null);
		assertTrue(dao.findAll().contains(hulk) );
	}

	@Test
	public void testFindHero() throws SQLException {
		int heroID = 2;
		System.out.println(dao.findHero(heroID));
		
		assertTrue(dao.findHero(heroID).toString().contains("Iron"));
		
		assertFalse(dao.findHero(heroID).getTeams().contains(null));
		assertFalse(dao.findHero(heroID).getMovies().contains(null));
		
	}

}
