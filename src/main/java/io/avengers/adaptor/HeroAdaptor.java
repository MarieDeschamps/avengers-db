package io.avengers.adaptor;

import java.util.List;

import io.avengers.domain.Hero;
import io.avengers.domain.Movie;
import io.avengers.domain.Team;

public class HeroAdaptor extends Hero implements Detailable{

	public HeroAdaptor(int id, String alias, String realName, String abilities, List<Team> teams, List<Movie> movies,
			byte[] picture) {
		super(id, alias, realName, abilities, teams, movies, picture);
	}

	@Override
	public void getPanel() {
	}

}
