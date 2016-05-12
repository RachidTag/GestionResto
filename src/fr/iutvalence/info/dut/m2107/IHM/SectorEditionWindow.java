package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * @author TODO
 *
 */
public class SectorEditionWindow extends JFrame {
	/**
	 * The left area
	 */
	public EditSectorWindowLeftArea L_Area;
	
	/**
	 * The right area
	 */
	public EditSectorWindowRightArea R_Area;
	
	/**
	 * The main window
	 */
	public MainWindow mainWindow;
	
	/**
	 * Generates an EditSectorWindow
	 * @param theMainWindow reference
	 */
	public SectorEditionWindow(MainWindow theMainWindow)
	{	
		/* 
		 * Save a reference to the main window
		 */
		this.mainWindow = theMainWindow;
		
		/*
		 * Initialise the SectorEditionWindow
		 */
		this.addWindowListener(new WindowEventHandler(this.mainWindow));
		this.setTitle("Edit Sector");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		/*
		 * Split the SectorEditionWindow in two parts
		 */
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, this.L_Area, this.R_Area);
		split.setOneTouchExpandable(true);
		split.setDividerLocation(120);
		split.setEnabled(false);
		split.setDividerSize(1);
		this.getContentPane().add(split);
		
		/*
		 * Generates the L_Area
		 */
		this.L_Area = new EditSectorWindowLeftArea(this);
		
		/*
		 * Generates the R_Area
		 */
		this.R_Area = new EditSectorWindowRightArea(this);
		
		this.setVisible(true);
	}
}
