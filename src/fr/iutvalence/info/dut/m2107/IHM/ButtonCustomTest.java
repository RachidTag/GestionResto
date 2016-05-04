package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ButtonCustomTest extends JButton implements MouseListener{

	
	public ButtonCustomTest()
	{
		this.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		String[] items = {"item1", "item2"};
		JComboBox<String> list = new JComboBox<String>();
		for (String string : items) {
			list.addItem(string);
		}
		MainWindow.leftArea.add(list);
		
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
