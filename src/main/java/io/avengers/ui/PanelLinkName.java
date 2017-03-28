package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelLinkName extends JPanel {
	private JLabel link;
	private int id;
	/**
	 * Create the panel.
	 */
	public PanelLinkName() {
		
		link = new JLabel("Link");
		add(link);

	}

	public JLabel getLink() {
		return link;
	}

	public void setLink(String text) {
		this.link.setText(text);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
