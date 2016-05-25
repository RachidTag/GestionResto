package fr.iutvalence.info.dut.m2107.IHM.RMModWindow;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Represents the left area of the room manager window
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class RMModWindowLeftArea extends JPanel implements ActionListener {
/**
 * The main window
 */
public RMModWindow rMModWindow;

/**
 * The close button
 */
public JButton close;

/**
 * TODO
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
	this.setLayout(controlPanel);
	
	/*
	 * Set the close button
	 */
	this.close = new JButton("close");
	this.close.addActionListener(this);
	this.add(close);
	
}

/**
 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
 */
public void actionPerformed(ActionEvent e) {
	JComponent source = (JComponent) e.getSource();
	if(source == this.close)
	{
		this.rMModWindow.mainWindow.leftArea.editWaiter.setEnabled(true);
	    this.rMModWindow.mainWindow.leftArea.editTable.setEnabled(true);
	    this.rMModWindow.mainWindow.leftArea.checkRoom.setEnabled(true);
	    this.rMModWindow.mainWindow.leftArea.checkSchedule.setEnabled(true);
	    this.rMModWindow.mainWindow.leftArea.roomManager.setEnabled(true);
	    this.rMModWindow.mainWindow.leftArea.editSchedule.setEnabled(true);
	    this.rMModWindow.mainWindow.leftArea.close.setEnabled(true);
	    this.rMModWindow.setVisible(false);
	    this.rMModWindow.R_Area.removeAll();
	}	
}
}