package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelLink extends JPanel {

	JLabel jlabelTitle;
	JLabel jlabelLink;
	/**
	 * Create the panel.
	 */
	public PanelLink() {
		
		jlabelTitle = new JLabel("Title");
		add(jlabelTitle);
		
		jlabelLink = new JLabel("Link");
		add(jlabelLink);

	}
	public JLabel getJlabelTitle() {
		return jlabelTitle;
	}
	public void setJlabelTitle(JLabel jlabelTitle) {
		this.jlabelTitle = jlabelTitle;
	}
	public JLabel getJlabelLink() {
		return jlabelLink;
	}
	public void setJlabelLink(JLabel jlabelLink) {
		this.jlabelLink = jlabelLink;
	}

}
