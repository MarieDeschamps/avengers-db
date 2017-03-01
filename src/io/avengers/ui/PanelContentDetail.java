package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

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
		add(panelInfo);
		
		panelLink = new PanelLink();
		add(panelLink);
		
		panelLink_1 = new PanelLink();
		add(panelLink_1);

	}

}
