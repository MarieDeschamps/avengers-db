package io.avengers.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

import io.avengers.ui.links.HeroLinks;

public class PanelContentList extends JPanel {

	PanelElement panelElement;
	/**
	 * Create the panel.
	 */
	public PanelContentList() {
		
	}
	
	public void initComponent(List<PanelElement> elements){
		for(PanelElement elem : elements){
			elem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					HeroLinks.goToPageCharacterDetails(elem.getId());
				}
			});
			add(elem);
		}
	}

}
