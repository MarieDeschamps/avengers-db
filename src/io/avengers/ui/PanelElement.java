package io.avengers.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Component;

public class PanelElement extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelElement() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel jlabelElementPicture = new JLabel("element picture");
		add(jlabelElementPicture);
		
		JTextPane jtextpaneElementDescription = new JTextPane();
		jtextpaneElementDescription.setText("element description");
		add(jtextpaneElementDescription);

	}

}
