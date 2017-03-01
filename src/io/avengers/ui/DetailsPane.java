package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
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
		add(panelHeader);
		panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelTitlePicture = new PanelTitlePicture();
		add(panelTitlePicture);
		
		panelContentDetail = new PanelContentDetail();
		add(panelContentDetail);

	}

}
