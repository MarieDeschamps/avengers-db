package io.avengers.service;

import java.sql.SQLException;
import java.util.Set;

import io.avengers.dao.HeroDao;
import io.avengers.domain.Hero;
import io.avengers.domain.Movie;
import io.avengers.domain.Team;

public class HeroService {

	IllegalStateException stateException = new IllegalStateException("Connection impossible, try again later");

	public Set<Hero> findAll() {
		try {
			return new HeroDao().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	public Hero findHero(int characterID) {
		if (characterID <= 0) {
			System.out.println("Potential bug or illegal request");
		}

		try {
			return new HeroDao().findHero(characterID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	public Hero createHero(Hero hero) {
		if (hero == null || hero.getAlias() == null) {
			throw new IllegalStateException("The hero cannot be created");
		}

		try {
			hero = new HeroDao().createHero(hero);
			if (hero.getTeams() != null && !hero.getTeams().isEmpty()) {
				for (Team t : hero.getTeams()) {
					new TeamService().linkTeamToHero(t, hero);
				}
			}
			if (hero.getMovies() != null && !hero.getMovies().isEmpty()) {
				for (Movie m : hero.getMovies()) {
					new MovieService().linkMovieToHero(m, hero);
				}
			}
			return hero;
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	public void deleteHero(Hero hero) {
		if (hero == null) {
			throw new IllegalStateException("The hero cannot be deleted");
		}

		try {
			new HeroDao().deleteHero(hero);

		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	// public Set<Hero> findHeroesByName(String term) {
	//
	// if(term== null){
	// System.out.println("Potential bug or illegal request");
	// return this.findAll();
	// }
	//
	// if(term.isEmpty()){
	// return this.findAll();
	// }
	//
	// try {
	// return new HeroDao().findHeroesByName(term);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// throw stateException;
	// }
	//
	// }
}
