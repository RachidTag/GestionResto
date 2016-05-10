package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * @author 
 *
 */
@SuppressWarnings("serial")
public class MainWindowCloseButton extends JButton implements MouseListener {

	private String Name;
	
	/**
	 * 
	 */
	public MainWindowCloseButton(String name)
	{
		super(name);
		this.addMouseListener(this);
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		System.exit(0);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
