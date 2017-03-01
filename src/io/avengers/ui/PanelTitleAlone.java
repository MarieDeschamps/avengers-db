package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelTitleAlone extends JPanel {

	String title;
	private JLabel jlabelTitle;
	/**
	 * Create the panel.
	 */
	public PanelTitleAlone() {
		
		jlabelTitle = new JLabel("Title");
		add(jlabelTitle);

	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		getJlabelTitle().setText(title);
	}
	

	public JLabel getJlabelTitle() {
		return jlabelTitle;
	}
}
