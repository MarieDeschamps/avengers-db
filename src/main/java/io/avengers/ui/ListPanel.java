package io.avengers.ui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

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
		panelHeader.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelHeader.setMaximumSize(new Dimension(10000, 50));
		add(panelHeader);
		
		panelTitle = new PanelTitleAlone();
		panelTitle.setMaximumSize(new Dimension(10000, 150));
		panelTitle.setPreferredSize(new Dimension(10000, 150));
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
