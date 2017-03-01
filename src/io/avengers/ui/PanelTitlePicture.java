package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelTitlePicture extends JPanel {

	String title;
	byte[] picture;
	JLabel jlabelTitle;
	JLabel jlabelPicture;
	/**
	 * Create the panel.
	 */
	public PanelTitlePicture() {
		
		jlabelPicture = new JLabel("Picture");
		add(jlabelPicture);
		
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
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	

	public void setJlabelTitle(JLabel jlabelTitle) {
		this.jlabelTitle = jlabelTitle;
	}
	public void setJlabelPicture(JLabel jlabelPicture) {
		this.jlabelPicture = jlabelPicture;
	}
	public JLabel getJlabelTitle() {
		return jlabelTitle;
	}
	public JLabel getJlabelPicture() {
		return jlabelPicture;
	}
}
