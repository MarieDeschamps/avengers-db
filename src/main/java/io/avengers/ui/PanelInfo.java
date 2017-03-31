package io.avengers.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInfo extends JPanel {
	JLabel jtextpaneInfo;

	/**
	 * Create the panel.
	 */
	public PanelInfo() {
		
		jtextpaneInfo = new JLabel("Description générale de l'élément");
		add(jtextpaneInfo);

	}

	public JLabel getJtextpaneInfo() {
		return jtextpaneInfo;
	}

	public void setJtextpaneInfo(JLabel jtextpaneInfo) {
		this.jtextpaneInfo = jtextpaneInfo;
	}
	
}
