package io.avengers.ui.links;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.avengers.domain.Hero;
import io.avengers.service.HeroService;
import io.avengers.ui.ListPanel;
import io.avengers.ui.MarvelFrame;
import io.avengers.ui.PanelElement;

public class HeroLinks {

	static private HeroService hService = new HeroService();
	
	static public void goToPageCharacterList(){
		ListPanel panel = new ListPanel();
		
		Set<Hero> heroes = hService.findAll();
		panel.getPanelTitle().setTitle("Characters");
		
		List<PanelElement> elements = new ArrayList<>();
		for(Hero h : heroes){
			PanelElement elem = new PanelElement();
			elem.setJlabelElementPicture(h.getPicture());
			elem.setJtextpaneElementDescription(h.getAlias());
			
			elements.add(elem);
		}
		
		panel.getPanelContentList().initComponent(elements);
		
		MarvelFrame.getFrame().setContentPane(panel);
	}
}
