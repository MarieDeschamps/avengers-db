package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;

public class DetailsPane extends JPanel {

	PanelHeader panelHeader;
	PanelTitlePicture panelTitlePicture;
	PanelContentDetail panelContentDetail;
	/**
	 * Create the panel.
	 */
	public DetailsPane() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panelHeader = new PanelHeader();
		panelHeader.setMaximumSize(new Dimension(10000, 50));
		add(panelHeader);
		panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelTitlePicture = new PanelTitlePicture();
		panelTitlePicture.setMaximumSize(new Dimension(10000, 100));
		add(panelTitlePicture);
		
		panelContentDetail = new PanelContentDetail();
		add(panelContentDetail);

	}

}
