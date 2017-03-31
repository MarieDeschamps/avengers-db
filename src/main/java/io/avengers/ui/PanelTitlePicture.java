package io.avengers.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		jlabelTitle.setForeground(new Color(204, 0, 0));
		jlabelTitle.setFont(new Font("Space Comics", Font.BOLD, 20));
		jlabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
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
	public void setJlabelPicture(byte[] image) {
		if (image != null && image.length > 0) {
			jlabelPicture.setText("");
			jlabelPicture.setIcon(new ImageIcon(image));
		}
	}
	public JLabel getJlabelTitle() {
		return jlabelTitle;
	}
	public JLabel getJlabelPicture() {
		return jlabelPicture;
	}
}
