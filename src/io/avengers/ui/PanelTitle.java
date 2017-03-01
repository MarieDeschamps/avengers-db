package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelTitle extends JPanel {

	String title;
	byte[] picture;
	private JLabel jlabelTitle;
	private JLabel jlabelPicture;
	/**
	 * Create the panel.
	 */
	public PanelTitle() {
		
		jlabelTitle = new JLabel("New label");
		add(jlabelTitle);
		
		jlabelPicture = new JLabel("New label");
		add(jlabelPicture);

	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		getJlabelTitle().setText(title);
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	

	public JLabel getJlabelTitle() {
		return jlabelTitle;
	}
	public JLabel getJlabelPicture() {
		return jlabelPicture;
	}
}
