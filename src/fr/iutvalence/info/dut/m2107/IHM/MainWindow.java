package fr.iutvalence.info.dut.m2107.IHM;
import javax.swing.*;
import javax.swing.border.*;

import fr.iutvalence.info.dut.m2107.calendar.Calendar;
import fr.iutvalence.info.dut.m2107.room.Room;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Main Window of the application
 * @author Projet Resto
 *
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	/**
	 * The left panel
	 */
	public MainWindowLeftArea leftArea;
	
	/**
	 * The right panel
	 */
	public MainWindowRightArea rightArea;	

	/**
	 * The room object
	 */
	public Room theRoom;

	/**
	 * The calendar object
	 */
	public Calendar theCalendar;
	
	/**
	 * The edit table window
	 */
	public EditTableWindow editTableWindow;
	
	/**
	 * The edit sector window
	 */
	public SectorEditionWindow editSectorWindow;
		
	/**
	 * Generates the main window
	 */
	public MainWindow(Room theRoom, Calendar theCalendar)
	{
		/*
		 * Save the room
		 */
		this.theRoom = theRoom;
		
		/*
		 * Save the calendar
		 */
		this.theCalendar = theCalendar;
		
		/*
		 * Main informations of the window
		 */
		this.setTitle("Gestion Resto");
		this.setResizable(false);
		this.setSize(1200, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		/*
		 * Init the different areas
		 */
		this.leftArea = new MainWindowLeftArea(this);
		this.rightArea = new MainWindowRightArea(this);
		
		/*
		 * Split the page
		 */
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, this.leftArea, this.rightArea);
		splitPane.setOneTouchExpandable(true);
		
		/*
		 * Set divider location to 300px, 1/4 of the screen
		 */
		splitPane.setDividerLocation(300);
		
		/*
		 * Disable divider control
		 */
		splitPane.setEnabled(false);
		
		/*
		 * Set divider size to 1 px
		 */
		splitPane.setDividerSize(1);
		
		/*
		 * Add splitpane to basic Pane
		 */
		this.getContentPane().add(splitPane);
		
		rightArea.refreshSectors();
		
		/*
		 * Set the result visible
		 */
		this.setVisible(true);
	}
}
