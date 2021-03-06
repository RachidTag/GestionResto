package fr.iutvalence.info.dut.m2107.IHM.RMModWindow;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import fr.iutvalence.info.dut.m2107.IHM.CustomButton.CustomButton;

/**
 * Represents the left area of the room manager window
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class RMModWindowLeftArea extends JPanel implements ActionListener {
	/**
	 * Reference to the main window
	 */
	public RMModWindow rMModWindow;
	
	/**
	 * The close button
	 */
	public CustomButton close;
	
	/**
	 * Generates the left area of the RM mod window
	 * @param rMModWindow
	 */
	public RMModWindowLeftArea(RMModWindow rMModWindow){
		/*
		 * Save the reference to the sectorEditionWindo
		 */
		this.rMModWindow = rMModWindow;
		
		/*
		 * Set the layout
		 */
		GridLayout controlPanel = new GridLayout(8,1);
		controlPanel.setVgap(5);
		this.setLayout(controlPanel);
		
		/*
		 * Set the close button
		 */
		this.close = new CustomButton("Close", new Dimension(120,50));
		this.close.addActionListener(this);
		JPanel buttonJPanel = new JPanel();
		buttonJPanel.add(this.close);
		this.add(this.close);
		this.add(buttonJPanel);
	}
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			this.rMModWindow.mainWindow.enable();
		    this.rMModWindow.dispose();
		    this.rMModWindow.R_Area.removeAll();
		}	
	}
}