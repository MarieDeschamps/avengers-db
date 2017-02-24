package io.avengers.ui;

import io.avengers.dao.HeroDao;
import io.avengers.service.HeroService;

public class TestApplication {

	public static void main(String[] args) throws Exception {
		//HeroDao dao = new HeroDao();
		//System.out.println(dao.findAll());
		
		HeroService service = new HeroService();
		System.out.println(service.findHero(1));
		
	}

}
