package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MainWindowSectorEditionButton extends JButton implements MouseListener {

	private String Name;
	
	/**
	 * 
	 */
	public MainWindowSectorEditionButton(String name)
	{
		super(name);
		this.addMouseListener(this);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(MainWindow.editSector.isEnabled())
		{
			MainWindow.editSectorWindow = new SectorEditionWindow();
			MainWindow.editTable.setEnabled(false);
			MainWindow.editSector.setEnabled(false);
			MainWindow.checkRoom.setEnabled(false);
			MainWindow.checkSchedule.setEnabled(false);
			MainWindow.roomManager.setEnabled(false);
			MainWindow.close.setEnabled(false);	
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
