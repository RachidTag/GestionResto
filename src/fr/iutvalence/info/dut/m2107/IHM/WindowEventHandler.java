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
		this.mainWindow.leftArea.editSector.setEnabled(true);
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