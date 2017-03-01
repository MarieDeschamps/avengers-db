package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class DetailsPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public DetailsPane() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		PanelHeader panelHeader = new PanelHeader();
		add(panelHeader);
		panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		PanelTitlePicture panelTitlePicture = new PanelTitlePicture();
		add(panelTitlePicture);
		
		PanelContentDetail panelContentDetail = new PanelContentDetail();
		add(panelContentDetail);

	}

}
