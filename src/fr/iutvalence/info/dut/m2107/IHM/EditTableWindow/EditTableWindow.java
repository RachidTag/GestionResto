package fr.iutvalence.info.dut.m2107.IHM.EditTableWindow;

import javax.swing.*;

import fr.iutvalence.info.dut.m2107.WindowEventHandler;
import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;

/**
 * Represents the edit table window
 * @author Projet Resto
 *
 */
@SuppressWarnings("serial")
public class EditTableWindow extends JFrame {
	
	/**
	 * Main Window
	 */
	public MainWindow mainWindow;
	
	/**
	 * Left Area
	 */
	public JPanel L_Area;
	
	/**
	 * Right Area
	 */
	public JPanel R_Area;
	
	/**
	 * Generates the EditTableWindow
	 * @param mainWindow reference to the main window
	 * 
	 */
	public EditTableWindow(MainWindow mainWindow)
	{
		/*
		 * Save the reference to the main window
		 */
		this.mainWindow = mainWindow;
		
		/*
		 * Init the window
		 */
		this.addWindowListener(new WindowEventHandler(this.mainWindow));
		this.setTitle("Edit Table");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		/*
		 * Init the two areas
		 */
		this.L_Area = new EditTableWindowLeftArea(this);
		this.R_Area = new EditTableWindowRightArea(this);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, this.L_Area, this.R_Area);
		split.setOneTouchExpandable(true);
		split.setDividerLocation(120);
		split.setEnabled(false);
		split.setDividerSize(1);
		this.getContentPane().add(split);
		
		/*
		 * Set the result visible		
		 */
		this.setVisible(true);
	}
}