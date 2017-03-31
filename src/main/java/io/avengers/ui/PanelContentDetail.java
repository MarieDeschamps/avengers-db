package io.avengers.ui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelContentDetail extends JPanel {

	PanelInfo panelInfo;
	PanelLink panelLink;
	PanelLink panelLink_1;
	/**
	 * Create the panel.
	 */
	public PanelContentDetail() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panelInfo = new PanelInfo();
		panelInfo.setPreferredSize(new Dimension(10000, 400));
		add(panelInfo);
		
		panelLink = new PanelLink();
		panelLink.setPreferredSize(new Dimension(10000, 150));
		add(panelLink);
		
		panelLink_1 = new PanelLink();
		panelLink_1.setPreferredSize(new Dimension(10000, 150));
		add(panelLink_1);

	}
	public PanelInfo getPanelInfo() {
		return panelInfo;
	}

	public PanelLink getPanelLink() {
		return panelLink;
	}
	public void setPanelLink(PanelLink panelLink) {
		this.panelLink = panelLink;
	}
	public PanelLink getPanelLink_1() {
		return panelLink_1;
	}
	public void setPanelLink_1(PanelLink panelLink_1) {
		this.panelLink_1 = panelLink_1;
	}

}
