package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class PanelContentDetail extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelContentDetail() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		PanelInfo panelInfo = new PanelInfo();
		add(panelInfo);
		
		PanelLink panelLink = new PanelLink();
		add(panelLink);
		
		PanelLink panelLink_1 = new PanelLink();
		add(panelLink_1);

	}

}
