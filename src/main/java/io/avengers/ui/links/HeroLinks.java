package io.avengers.ui.links;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.SwingUtilities;

import io.avengers.domain.Hero;
import io.avengers.domain.Movie;
import io.avengers.domain.Team;
import io.avengers.service.HeroService;
import io.avengers.ui.DetailsPanel;
import io.avengers.ui.ListPanel;
import io.avengers.ui.MarvelFrame;
import io.avengers.ui.PanelElement;
import io.avengers.ui.PanelLinkName;

public class HeroLinks {

	static private HeroService hService = new HeroService();

	static public void goToPageCharacterList() {
		ListPanel panel = new ListPanel();

		Set<Hero> heroes = hService.findAll();
		panel.getPanelTitle().setTitle("CHARACTERS");

		List<PanelElement> elements = new ArrayList<>();
		for (Hero h : heroes) {
			PanelElement elem = new PanelElement();
			elem.setJlabelElementPicture(h.getPicture());
			elem.setJtextpaneElementDescription(h.getAlias());
			elem.setId(h.getId());
			elements.add(elem);
		}

		panel.getPanelContentList().initComponent(elements);

		MarvelFrame.getFrame().setContentPane(panel);
	}

	static public void goToPageCharacterDetails(int characterID) {
		// Create the page
		DetailsPanel panel = new DetailsPanel();

		// Search for the informations about the hero
		Hero hero = hService.findHero(characterID);

		// Complete the title part
		panel.getPanelTitlePicture().setTitle(hero.getAlias().toUpperCase());
		panel.getPanelTitlePicture().setPicture(hero.getPicture());

		// Set the hero informations
		String text = "Real Name: " + hero.getRealName() + "\nAbilities: " + hero.getAbilities();
		panel.getPanelContentDetail().getPanelInfo().getJtextpaneInfo().setText(text);

		// Set the links to the teams
		panel.getPanelContentDetail().getPanelLink().getJlabelTitle().setText("Team: ");
		if (hero.getTeams() != null) {
			List<PanelLinkName> links = new ArrayList<>();
			for (Team t : hero.getTeams()) {
				PanelLinkName link = new PanelLinkName();
				link.setLink(t.getName());
				link.setId(t.getId());

				links.add(link);
			}
			panel.getPanelContentDetail().getPanelLink().initComponent(links);
		}

		// Set the links to the movies
		panel.getPanelContentDetail().getPanelLink().getJlabelTitle().setText("Movies: ");
		if (hero.getMovies() != null) {
			List<PanelLinkName> links2 = new ArrayList<>();
			for (Movie m : hero.getMovies()) {
				PanelLinkName link = new PanelLinkName();
				link.setLink(m.getMovie_title());
				link.setId(m.getMovie_id());

				links2.add(link);
			}
			panel.getPanelContentDetail().getPanelLink_1().initComponent(links2);
		}

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MarvelFrame.getFrame().setContentPane(panel);
				MarvelFrame.getFrame().getContentPane().revalidate();
				MarvelFrame.getFrame().getContentPane().repaint();
				
			}
		});
		
	}
	
	public void goToDetails(){
		
	}
}
