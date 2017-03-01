package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class ListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		PanelHeader panelHeader = new PanelHeader();
		add(panelHeader);
		
		PanelTitleAlone panelTitle = new PanelTitleAlone();
		add(panelTitle);
		
		PanelContentList panelContentList = new PanelContentList();
		add(panelContentList);

	}

}
