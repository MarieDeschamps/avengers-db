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


import java.sql.SQLException;
import io.avengers.dao.ImageDao;

public class ImageServiceTest {

	ImageService iService;

	@Before
	public void setUp() throws Exception {
		iService = new ImageService();
	}
	
	@Test
	public void findLogo() {
		assertTrue(iService.findLogo().length>0);
	}
}
