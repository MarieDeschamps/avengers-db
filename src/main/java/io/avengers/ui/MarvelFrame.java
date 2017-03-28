package io.avengers.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MarvelFrame extends JFrame {

	private JPanel contentPane;
	private static MarvelFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MarvelFrame();
					 frame.setSize(new Dimension(1000, 1000));
					getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MarvelFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.WHITE);
		contentPane.setOpaque(true);
		setContentPane(contentPane);
		
		ListPanel listPanel = new ListPanel();
		contentPane.add(listPanel);
	}

	public static MarvelFrame getFrame() {
		return frame;
	}

	public static void setFrame(MarvelFrame frame) {
		MarvelFrame.frame = frame;
	}
	
	

}
