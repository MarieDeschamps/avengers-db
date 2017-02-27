package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	}

	@Test
	public void testFindHeroesByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindHero() {
		fail("Not yet implemented");
	}

	@Test
	public void testResultSetToHero() {
		fail("Not yet implemented");
	}

}
