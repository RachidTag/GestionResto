package fr.iutvalence.info.dut.m2107.IHM;

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
	public void windowClosing(WindowEvent evt) {
		this.mainWindow.leftArea.editWaiter.setEnabled(true);
		this.mainWindow.leftArea.editTable.setEnabled(true);
		this.mainWindow.leftArea.checkRoom.setEnabled(true);
		this.mainWindow.leftArea.checkSchedule.setEnabled(true);
		this.mainWindow.leftArea.roomManager.setEnabled(true);
		this.mainWindow.leftArea.close.setEnabled(true);
		
		// TODO add all windows
		if(this.mainWindow.editSectorWindow != null && this.mainWindow.editSectorWindow.isVisible())
		{
			this.mainWindow.editSectorWindow.R_Area.removeAll();
			this.mainWindow.editSectorWindow.setVisible(false);
		}
		if(this.mainWindow.editTableWindow != null && this.mainWindow.editTableWindow.isVisible())
		{
			this.mainWindow.editTableWindow.R_Area.removeAll();
			this.mainWindow.editTableWindow.setVisible(false);
		}
	}
}