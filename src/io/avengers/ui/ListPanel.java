package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class ListPanel extends JPanel {

	PanelHeader panelHeader;
	PanelTitleAlone panelTitle;
	PanelContentList panelContentList;
	
	/**
	 * Create the panel.
	 */
	public ListPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panelHeader = new PanelHeader();
		add(panelHeader);
		
		panelTitle = new PanelTitleAlone();
		add(panelTitle);
		
		panelContentList = new PanelContentList();
		add(panelContentList);

	}

	public PanelTitleAlone getPanelTitle() {
		return panelTitle;
	}

	public void setPanelTitle(PanelTitleAlone panelTitle) {
		this.panelTitle = panelTitle;
	}

	public PanelContentList getPanelContentList() {
		return panelContentList;
	}

	public void setPanelContentList(PanelContentList panelContentList) {
		this.panelContentList = panelContentList;
	}

}
