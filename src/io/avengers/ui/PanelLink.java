package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelLink extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLink() {
		
		JLabel jlabelTitle = new JLabel("Title");
		add(jlabelTitle);
		
		JLabel jlabelLink = new JLabel("Link");
		add(jlabelLink);

	}

}
