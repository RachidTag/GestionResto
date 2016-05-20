package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import fr.iutvalence.info.dut.m2107.IHM.WindowEventHandler;
import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;

/**
 * @author TODO
 *
 */
@SuppressWarnings("serial")
public class EditWaiterWindow extends JFrame {
	/**
	 * The left area
	 */
	public EditWaiterWindowLeftArea L_Area;
	
	/**
	 * The right area
	 */
	public EditWaiterWindowRightArea R_Area;
	
	/**
	 * The main window
	 */
	public MainWindow mainWindow;
	
	/**
	 * Generates an EditSectorWindow
	 * @param theMainWindow reference
	 */
	public EditWaiterWindow(MainWindow theMainWindow)
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
		 * Generates the L_Area
		 */
		this.L_Area = new EditWaiterWindowLeftArea(this);
		
		/*
		 * Generates the R_Area
		 */
		this.R_Area = new EditWaiterWindowRightArea(this);
		
		/*
		 * Split the SectorEditionWindow in two parts
		 */
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, this.L_Area, this.R_Area);
		split.setOneTouchExpandable(true);
		split.setDividerLocation(120);
		split.setEnabled(false);
		split.setDividerSize(1);
		this.getContentPane().add(split);
		
		this.setVisible(true);
	}
}
