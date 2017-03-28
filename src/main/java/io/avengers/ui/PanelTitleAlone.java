package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import java.awt.FlowLayout;

public class PanelTitleAlone extends JPanel {

	String title;
	JLabel jlabelTitle;
	/**
	 * Create the panel.
	 */
	public PanelTitleAlone() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		
		jlabelTitle = new JLabel("NEWS");
		jlabelTitle.setForeground(new Color(204, 0, 0));
		jlabelTitle.setFont(new Font("Space Comics", Font.BOLD, 20));
		jlabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelTitle.setPreferredSize(new Dimension(500, 100));
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
	public void setJlabelTitle(JLabel jlabelTitle) {
		this.jlabelTitle = jlabelTitle;
	}
}
