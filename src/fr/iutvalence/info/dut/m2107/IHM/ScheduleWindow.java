package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		GridLayout week = new GridLayout(3,7);
		
		JPanel Day = new JPanel();
		
		Day.setLayout(week);
		this.add(Day);
		Day.add(new JLabel("Monday"));
		Day.add(new JLabel("Tuesday"));
		Day.add(new JLabel("Wednesday"));
		Day.add(new JLabel("Thursday"));
		Day.add(new JLabel("Friday"));
		Day.add(new JLabel("Saturday"));
		Day.add(new JLabel("Sunday"));
		
		
		
		this.setVisible(true);
	}
	
	

}
