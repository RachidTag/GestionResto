package fr.iutvalence.info.dut.m2107.IHM;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ScheduleWindow extends JFrame{
	
	public MainWindow mainWindow;
	
	public ScheduleWindow(MainWindow theMainWindow)
	{
		/* 
		 * Save a reference to the main window
		 */
		this.mainWindow = theMainWindow;
		
		/*
		 * Initialise the SectorEditionWindow
		 */
		this.addWindowListener(new WindowEventHandler(this.mainWindow));
		this.setTitle("Check the Schedule");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setVisible(true);
	}
	
	

}
