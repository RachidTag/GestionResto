package fr.iutvalence.info.dut.m2107.IHM.MainWindow;
import javax.swing.*;

import fr.iutvalence.info.dut.m2107.Restaurant;
import fr.iutvalence.info.dut.m2107.IHM.EditTableWindow.EditTableWindow;
import fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow.EditWaiterWindow;
import fr.iutvalence.info.dut.m2107.IHM.RMModEditScheduleWindow.RMModEditScheduleWindow;
import fr.iutvalence.info.dut.m2107.IHM.RMModWindow.RMModWindow;
import fr.iutvalence.info.dut.m2107.IHM.Schedule.ScheduleWindow;

/**
 * The Main Window of the application
 * @author Projet Resto
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
	 * Reference to the restaurant object
	 */
	public Restaurant restaurant;
	
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
	 * The edit schedule window
	 */
	public RMModEditScheduleWindow editScheduleWindow;
	
	/**
	 * The Room Manager Mod window
	 */
	public RMModWindow rMModWindow;
		
	/**
	 * Generates the main window
	 * @param restaurant
	 */
	public MainWindow(Restaurant restaurant)
	{
		/*
		 * Save the restaurant
		 */
		this.restaurant = restaurant;
		
		/*
		 * Main informations of the window
		 */
		this.addWindowListener(new MainWindowEventHandler(this));
		this.setTitle("Gestion Resto");
		this.setResizable(false);
		this.setSize(1100, 720);
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
		 * Set divider location to 200px, 1/4 of the screen
		 */
		splitPane.setDividerLocation(200);
		
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
