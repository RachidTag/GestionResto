package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * @author Projet Resto
 *
 */
public class ButtonCustomTest extends JButton implements MouseListener{
		
	private String Name;
	
	/**
	 * 
	 */
	public ButtonCustomTest(String name)
	{
		super();
		this.addMouseListener(this);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		MainWindow.win = new EditTableWindow();
		MainWindow.editTable.setEnabled(false);
		MainWindow.editSector.setEnabled(false);
		MainWindow.checkRoom.setEnabled(false);
		MainWindow.checkSchedule.setEnabled(false);
		MainWindow.roomManager.setEnabled(false);
		MainWindow.exit.setEnabled(false);
		
		
		
		//MainWindow.leftArea.validate();
		
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
