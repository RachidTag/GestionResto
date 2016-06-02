package fr.iutvalence.info.dut.m2107;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;

/**
 * Represents the events in the window
 * @author Projet Resto
 *
 */
public class WindowEventHandler extends WindowAdapter {
	/**
	 * The mainWindow
	 */
	private MainWindow mainWindow;
	
	/**
	 * Generates the WindowEventHandler with the mainWindow in params
	 * @param mainWindow
	 */
	public WindowEventHandler(MainWindow mainWindow)
	{
		this.mainWindow = mainWindow;
	}
	
	/**
	 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
	 */
	@SuppressWarnings("deprecation")
	public void windowClosing(WindowEvent evt) {

		this.mainWindow.enable();
		
		// TODO add all windows
		if(this.mainWindow.editWaiterWindow != null && this.mainWindow.editWaiterWindow.isVisible())
		{
			this.mainWindow.editWaiterWindow.R_Area.removeAll();
		}
		if(this.mainWindow.editTableWindow != null && this.mainWindow.editTableWindow.isVisible())
		{
			this.mainWindow.editTableWindow.R_Area.removeAll();
		}
		if(this.mainWindow.rMModWindow != null && this.mainWindow.rMModWindow.isVisible())
		{
			this.mainWindow.rMModWindow.R_Area.removeAll();
		}
		if(this.mainWindow.editScheduleWindow != null && this.mainWindow.editScheduleWindow.isVisible())
		{
			this.mainWindow.editScheduleWindow.R_Area.removeAll();
		}
		if(this.mainWindow.scheduleWindow != null && this.mainWindow.scheduleWindow.isVisible())
		{
			this.mainWindow.scheduleWindow.removeAll();
		}
	}
}