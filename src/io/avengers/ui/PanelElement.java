package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Component;

public class PanelElement extends JPanel {
	JLabel jlabelElementPicture;
	JTextPane jtextpaneElementDescription;

	/**
	 * Create the panel.
	 */
	public PanelElement() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		jlabelElementPicture = new JLabel("element picture");
		add(jlabelElementPicture);
		
		jtextpaneElementDescription = new JTextPane();
		jtextpaneElementDescription.setText("element description");
		add(jtextpaneElementDescription);

	}

	public void setJlabelElementPicture(JLabel jlabelElementPicture) {
		this.jlabelElementPicture = jlabelElementPicture;
	}

	public void setJtextpaneElementDescription(JTextPane jtextpaneElementDescription) {
		this.jtextpaneElementDescription = jtextpaneElementDescription;
	}

	public JLabel getJlabelElementPicture() {
		return jlabelElementPicture;
	}
	public JTextPane getJtextpaneElementDescription() {
		return jtextpaneElementDescription;
	}
}
