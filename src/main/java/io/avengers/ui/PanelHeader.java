package io.avengers.ui;

import javax.swing.JPanel;

import io.avengers.service.HeroServiceTest;
import io.avengers.service.ImageService;
import io.avengers.service.ImageServiceTest;
import io.avengers.ui.links.HeroLinks;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

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
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(10);
//		HeroService hService = new HeroService();
		if(jlabelLogo == null){
			byte[] image = new ImageService().findLogo();
			jlabelLogo = new JLabel( new ImageIcon(image));
		}
		add(jlabelLogo);
		
		jlabelNews = new JLabel("News");
		setMenu(jlabelNews);
		add(jlabelNews);
		
		jlabelCharacters = new JLabel("Characters");
		setMenu(jlabelCharacters);
		jlabelCharacters.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HeroLinks.goToPageCharacterList();
			}
		});
		add(jlabelCharacters);
		
		jlabelMovies = new JLabel("Movies");
		setMenu(jlabelMovies);
		add(jlabelMovies);
		
		jlabelComics = new JLabel("Comics");
		setMenu(jlabelComics);
		add(jlabelComics);
		
		jlabelTeams = new JLabel("Teams");
		setMenu(jlabelTeams);
		add(jlabelTeams);
		
		jlabelShop = new JLabel("Shop");
		setMenu(jlabelShop);
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
	
	public void setMenu(JLabel label){
		label.setBackground(SystemColor.controlHighlight);
		label.setOpaque(true);
		label.setForeground(new Color(204, 0, 0));
		label.setFont(new Font("Raleway", Font.BOLD, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setSize(new Dimension(140, 50));
		label.setPreferredSize(new Dimension(140, 50));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
	}


}
