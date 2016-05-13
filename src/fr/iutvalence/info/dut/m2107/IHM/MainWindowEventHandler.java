package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Represents the events in the window
 * @author Projet Resto
 *
 */
class MainWindowEventHandler extends WindowAdapter {
	/**
	 * The mainWindow
	 */
	private MainWindow mainWindow;
	
	/**
	 * Generates the WindowEventHandler with the mainWindow in params
	 * @param mainWindow
	 */
	public MainWindowEventHandler(MainWindow mainWindow)
	{
		this.mainWindow = mainWindow;
	}
	
	/**
	 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
	 */
	public void windowClosing(WindowEvent evt) {
		this.mainWindow.theRoom.saveRoom();
		// TODO this.mainWindow.theCalendar.saveCalendar();
	}
}