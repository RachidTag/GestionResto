package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class TableEditionClosingButton extends JButton implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	    MainWindow.editSector.setEnabled(true);
	    MainWindow.editTable.setEnabled(true);
	    MainWindow.checkRoom.setEnabled(true);
	    MainWindow.checkSchedule.setEnabled(true);
	    MainWindow.roomManager.setEnabled(true);
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		// TODO link closing button of TableEdition poppup to this, re-enabling all buttons of mainwindow.
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
