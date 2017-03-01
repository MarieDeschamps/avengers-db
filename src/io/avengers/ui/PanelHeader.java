package io.avengers.ui;

import javax.swing.JPanel;

import io.avengers.service.HeroService;
import io.avengers.ui.links.HeroLinks;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelHeader extends JPanel {

	JLabel jlabelLogo;
	JLabel jlabelNews;
	JLabel jlabelCharacters;
	JLabel jlabelMovies;
	JLabel jlabelComics;
	JLabel jlabelTeams;
	JLabel jlabelShop;
	
	/**
	 * Create the panel.
	 */
	public PanelHeader() {
		HeroService hService = new HeroService();
		
		jlabelLogo = new JLabel("Logo");
		add(jlabelLogo);
		
		jlabelNews = new JLabel("News");
		add(jlabelNews);
		
		jlabelCharacters = new JLabel("Characters");
		jlabelCharacters.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HeroLinks.goToPageCharacterList();
			}
		});
		add(jlabelCharacters);
		
		jlabelMovies = new JLabel("Movies");
		add(jlabelMovies);
		
		jlabelComics = new JLabel("Comics");
		add(jlabelComics);
		
		jlabelTeams = new JLabel("Teams");
		add(jlabelTeams);
		
		jlabelShop = new JLabel("Shop");
		add(jlabelShop);

	}
	
	public JLabel getJlabelLogo() {
		return jlabelLogo;
	}

	public void setJlabelLogo(JLabel jlabelLogo) {
		this.jlabelLogo = jlabelLogo;
	}

	public JLabel getJlabelNews() {
		return jlabelNews;
	}

	public void setJlabelNews(JLabel jlabelNews) {
		this.jlabelNews = jlabelNews;
	}

	public JLabel getJlabelCharacters() {
		return jlabelCharacters;
	}

	public void setJlabelCharacters(JLabel jlabelCharacters) {
		this.jlabelCharacters = jlabelCharacters;
	}

	public JLabel getJlabelMovies() {
		return jlabelMovies;
	}

	public void setJlabelMovies(JLabel jlabelMovies) {
		this.jlabelMovies = jlabelMovies;
	}

	public JLabel getJlabelComics() {
		return jlabelComics;
	}

	public void setJlabelComics(JLabel jlabelComics) {
		this.jlabelComics = jlabelComics;
	}

	public JLabel getJlabelTeams() {
		return jlabelTeams;
	}

	public void setJlabelTeams(JLabel jlabelTeams) {
		this.jlabelTeams = jlabelTeams;
	}

	public JLabel getJlabelShop() {
		return jlabelShop;
	}

	public void setJlabelShop(JLabel jlabelShop) {
		this.jlabelShop = jlabelShop;
	}


}
