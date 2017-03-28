package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;

public class DetailsPanel extends JPanel {

	PanelHeader panelHeader;
	PanelTitlePicture panelTitlePicture;
	PanelContentDetail panelContentDetail;
	/**
	 * Create the panel.
	 */
	public DetailsPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panelHeader = new PanelHeader();
		panelHeader.setMaximumSize(new Dimension(10000, 50));
		add(panelHeader);
		panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelTitlePicture = new PanelTitlePicture();
		panelTitlePicture.setPreferredSize(new Dimension(10000, 200));
		panelTitlePicture.setMaximumSize(new Dimension(10000, 200));
		add(panelTitlePicture);
		
		panelContentDetail = new PanelContentDetail();
		add(panelContentDetail);

	}
	public PanelHeader getPanelHeader() {
		return panelHeader;
	}
	public void setPanelHeader(PanelHeader panelHeader) {
		this.panelHeader = panelHeader;
	}
	public PanelTitlePicture getPanelTitlePicture() {
		return panelTitlePicture;
	}
	public void setPanelTitlePicture(PanelTitlePicture panelTitlePicture) {
		this.panelTitlePicture = panelTitlePicture;
	}
	public PanelContentDetail getPanelContentDetail() {
		return panelContentDetail;
	}
	public void setPanelContentDetail(PanelContentDetail panelContentDetail) {
		this.panelContentDetail = panelContentDetail;
	}
	
	

}
