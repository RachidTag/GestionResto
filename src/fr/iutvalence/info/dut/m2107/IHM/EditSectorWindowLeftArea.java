package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author TODO
 *
 */
public class EditSectorWindowLeftArea extends JPanel implements ActionListener{
	/**
	 * The main window
	 */
	public EditSectorWindow sectorEditionWindow;
	
	/**
	 * The edit button
	 */
	public JButton edit;
	
	/**
	 * The close button
	 */
	public JButton close;

	/**
	 * TODO
	 * @param mainWindow
	 */
	public EditSectorWindowLeftArea(EditSectorWindow sectorEditionWindow){
		/*
		 * Save the reference to the sectorEditionWindo
		 */
		this.sectorEditionWindow = sectorEditionWindow;
		
		/*
		 * Set the layout
		 */
		GridLayout controlPanel = new GridLayout(4,1);
		this.setLayout(controlPanel);
		
		/*
		 * Set the edit sector button
		 */
		this.edit = new JButton("Edit Sector");
		this.add(edit);
		
		/*
		 * Set the close button
		 */
		this.close = new JButton("close");
		this.close.addActionListener(this);
		this.add(close);
		
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			this.sectorEditionWindow.mainWindow.leftArea.editSector.setEnabled(true);
		    this.sectorEditionWindow.mainWindow.leftArea.editTable.setEnabled(true);
		    this.sectorEditionWindow.mainWindow.leftArea.checkRoom.setEnabled(true);
		    this.sectorEditionWindow.mainWindow.leftArea.checkSchedule.setEnabled(true);
		    this.sectorEditionWindow.mainWindow.leftArea.roomManager.setEnabled(true);
		    this.sectorEditionWindow.mainWindow.leftArea.close.setEnabled(true);
		    this.sectorEditionWindow.setVisible(false);
		    this.sectorEditionWindow.R_Area.removeAll();
		}
		else if(source == this.edit)
		{
			
		}
		else
		{
			// TODO
		}	
	}
}
