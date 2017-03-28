package io.avengers.ui;

import javax.swing.JPanel;

import java.util.List;

import javax.swing.JLabel;

public class PanelLink extends JPanel {

	JLabel jlabelTitle;
	PanelLinkName panelLinkName;
	/**
	 * Create the panel.
	 */
	public PanelLink() {
		
		jlabelTitle = new JLabel("Title");
		add(jlabelTitle);
		
		PanelLinkName panelLinkName = new PanelLinkName();
		add(panelLinkName);

	}
	public JLabel getJlabelTitle() {
		return jlabelTitle;
	}
	public void setJlabelTitle(JLabel jlabelTitle) {
		this.jlabelTitle = jlabelTitle;
	}
	
	public PanelLinkName getPanelLinkName() {
		return panelLinkName;
	}
	public void initComponent(List<PanelLinkName> elements){
		for(PanelLinkName elem : elements){
			add(elem);
		}
	}

}
