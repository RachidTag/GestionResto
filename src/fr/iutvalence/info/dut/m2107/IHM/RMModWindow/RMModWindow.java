package fr.iutvalence.info.dut.m2107.IHM.RMModWindow;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import fr.iutvalence.info.dut.m2107.IHM.WindowEventHandler;
import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;

/**
 * @author TODO
 *
 */
@SuppressWarnings("serial")
public class RMModWindow extends JFrame
{
	/**
	 * The left area
	 */
	public RMModWindowLeftArea L_Area;
	
	/**
	 * The right area
	 */
	public RMModWindowRightArea R_Area;
	
	/**
	 * The main window
	 */
	public MainWindow mainWindow;

	/**
	 * TODO
	 * @param mainWindow
	 */
	public RMModWindow(MainWindow mainWindow)
	{
		/* 
		 * Save a reference to the main window
		 */
		this.mainWindow = mainWindow;
		
		/*
		 * Initialise the SectorEditionWindow
		 */
		this.addWindowListener(new WindowEventHandler(this.mainWindow));
		this.setTitle("Room Manager Mod");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		/*
		 * Generates the L_Area
		 */
		this.L_Area = new RMModWindowLeftArea(this);
		
		/*
		 * Generates the R_Area
		 */
		this.R_Area = new RMModWindowRightArea(this);
		
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
