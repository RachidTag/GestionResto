package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

/**
 * @author 
 *
 */
@SuppressWarnings("serial")
public class MainWindowCloseButton extends JButton {
	
	/**
	 * 
	 */
	private String Name;
	
	/**
	 * @param name
	 */
	public MainWindowCloseButton(String name)
	{
		super(name);
		this.Name = name;
	}
	
	/**
	 * @param e
	 */
	public void actionPerformed(ActionEvent e)
    {
		    System.exit(0);
    }
}
