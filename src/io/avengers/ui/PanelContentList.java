package io.avengers.ui;

import java.util.List;

import javax.swing.JPanel;

public class PanelContentList extends JPanel {

	PanelElement panelElement;
	/**
	 * Create the panel.
	 */
	public PanelContentList() {
		
	}
	
	public void initComponent(List<PanelElement> elements){
		for(PanelElement elem : elements){
			add(elem);
		}
	}

}
