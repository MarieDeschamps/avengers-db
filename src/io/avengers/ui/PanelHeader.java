package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelHeader extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHeader() {
		
		JLabel jlabelLogo = new JLabel("Logo");
		add(jlabelLogo);
		
		JLabel jlabelNews = new JLabel("News");
		add(jlabelNews);
		
		JLabel jlabelCharacters = new JLabel("Characters");
		add(jlabelCharacters);
		
		JLabel jlabelMovies = new JLabel("Movies");
		add(jlabelMovies);
		
		JLabel jlabelComics = new JLabel("Comics");
		add(jlabelComics);
		
		JLabel jlabelTeams = new JLabel("Teams");
		add(jlabelTeams);
		
		JLabel jlabelShop = new JLabel("Shop");
		add(jlabelShop);

	}

}
