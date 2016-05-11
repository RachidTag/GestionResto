package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowEventHandler extends WindowAdapter {
	
	private MainWindow mainWindow;
	public WindowEventHandler(MainWindow mainWindow)
	{
		this.mainWindow = mainWindow;
	}
	public void windowClosing(WindowEvent evt) {
		this.mainWindow.editSector.setEnabled(true);
		this.mainWindow.editTable.setEnabled(true);
		this.mainWindow.checkRoom.setEnabled(true);
		this.mainWindow.checkSchedule.setEnabled(true);
		this.mainWindow.roomManager.setEnabled(true);
		this.mainWindow.close.setEnabled(true);
		this.mainWindow.editTableWindow.setVisible(false);
		this.mainWindow.editTableWindow.R_Area.removeAll();
	}
}