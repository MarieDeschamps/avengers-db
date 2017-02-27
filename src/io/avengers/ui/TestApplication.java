package io.avengers.ui;

import io.avengers.dao.HeroDao;
import io.avengers.service.HeroService;
import io.avengers.service.MovieService;

public class TestApplication {

	public static void main(String[] args) throws Exception {
		//HeroDao dao = new HeroDao();
		//System.out.println(dao.findAll());
		
		MovieService service = new MovieService();
		System.out.println(service.findMovie(1));
		
		HeroService heroservice = new HeroService();
		System.out.println(heroservice.findHero(2));
		
	}

}
