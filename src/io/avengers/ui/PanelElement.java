package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import io.avengers.adaptor.Detailable;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;

public class PanelElement extends JPanel {
	JLabel jlabelElementPicture;
	JTextPane jtextpaneElementDescription;
	int id;
	Detailable type;

	/**
	 * Create the panel.
	 */
	public PanelElement() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		jlabelElementPicture = new JLabel("Picture not available");
		jlabelElementPicture.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(jlabelElementPicture);

		jtextpaneElementDescription = new JTextPane();
		jtextpaneElementDescription.setText("element description");
		StyledDocument doc = jtextpaneElementDescription.getStyledDocument();		
		MutableAttributeSet center = new SimpleAttributeSet();		
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, 0, center, true);
		add(jtextpaneElementDescription);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Detailable getType() {
		return type;
	}

	public void setType(Detailable type) {
	}

	public JLabel getJlabelElementPicture() {
		return jlabelElementPicture;
	}

	public JTextPane getJtextpaneElementDescription() {
		return jtextpaneElementDescription;
	}

	public void setJlabelElementPicture(byte[] image) {
		if (image != null && image.length > 0) {
			jlabelElementPicture.setText("");
			jlabelElementPicture.setIcon(new ImageIcon(image));
		}
	}

	public void setJtextpaneElementDescription(String name) {
		this.jtextpaneElementDescription.setText(name);
	}
}
