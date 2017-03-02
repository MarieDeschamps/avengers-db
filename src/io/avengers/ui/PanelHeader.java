package io.avengers.ui;

import javax.swing.JPanel;

import io.avengers.service.HeroService;
import io.avengers.service.ImageService;
import io.avengers.ui.links.HeroLinks;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

public class PanelHeader extends JPanel {

	static JLabel jlabelLogo;
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
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(10);
//		HeroService hService = new HeroService();
		if(jlabelLogo == null){
			byte[] image = new ImageService().findLogo();
			jlabelLogo = new JLabel( new ImageIcon(image));
		}
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
		PanelHeader.jlabelLogo = jlabelLogo;
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
