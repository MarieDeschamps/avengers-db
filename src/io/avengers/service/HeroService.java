package io.avengers.service;

import java.sql.SQLException;
import java.util.Set;

import io.avengers.dao.HeroDao;
import io.avengers.domain.Hero;

public class HeroService {

	IllegalStateException stateException= new IllegalStateException("Database error! Please, try again later");
	
	public Set<Hero> findAll() {
		try {
			return new HeroDao().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
	public Hero findHero(int characterID) {
		if(characterID<=0){
			System.out.println("Potential bug or illegal request");
		}
		
		try {
			return new HeroDao().findHero(characterID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

}
