package fr.iutvalence.info.dut.m2107.IHM.MainWindow;
import javax.swing.*;

import fr.iutvalence.info.dut.m2107.IHM.ScheduleWindow;
import fr.iutvalence.info.dut.m2107.IHM.EditTableWindow.EditTableWindow;
import fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow.EditWaiterWindow;
import fr.iutvalence.info.dut.m2107.IHM.RMModWindow.RMModWindow;
import fr.iutvalence.info.dut.m2107.calendar.Calendar;
import fr.iutvalence.info.dut.m2107.room.Room;

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
	public EditWaiterWindow editSectorWindow;
	
	/**
	 * The Schedule window
	 */
	public ScheduleWindow scheduleWindow;
	
	/**
	 * The Room Manager Mod window
	 */
	public RMModWindow rMModWindow;
		
	/**
	 * Generates the main window
	 * @param theRoom 
	 * @param theCalendar 
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
		this.addWindowListener(new MainWindowEventHandler(this));
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
		
		/*
		 * Set the result visible
		 */
		this.setVisible(true);
	}
}
