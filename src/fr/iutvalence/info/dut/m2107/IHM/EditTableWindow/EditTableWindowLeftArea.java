package fr.iutvalence.info.dut.m2107.IHM.EditTableWindow;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author TODO
 *
 */
@SuppressWarnings("serial")
public class EditTableWindowLeftArea extends JPanel implements ActionListener{
	/**
	 * The main window
	 */
	public EditTableWindow editTableWindow;
	
	/**
	 * Edit button
	 */
	public JButton edit;
	
	/**
	 * Delete button
	 */
	public JButton delete;
	
	/**
	 * Add button
	 */
	public JButton add;
	
	/**
	 * Close button
	 */
	public JButton close;

	/**
	 * TODO
	 * @param editTableWindow
	 */
	public EditTableWindowLeftArea(EditTableWindow editTableWindow){
		/*
		 * Save the reference to the sectorEditionWindo
		 */
		this.editTableWindow = editTableWindow;
		
		/*
		 * Set the layout
		 */
		GridLayout controlPanel = new GridLayout(4,1);
		this.setLayout(controlPanel);

		/*
		 * Set the buttons
		 */
		this.edit = new JButton("Edit");
		this.delete = new JButton("Delete");
		this.add = new JButton("Add");
		this.close = new JButton("Close");
		
		/*
		 * Set the buttons' listeners
		 */
		this.edit.addActionListener(this);
		this.delete.addActionListener(this);
		this.add.addActionListener(this);
		this.close.addActionListener(this);
		
		/*
		 * Add the buttons
		 */

		this.add(this.add);
		this.add(this.edit);
		this.add(this.delete);
		this.add(this.close);
		
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			this.editTableWindow.mainWindow.leftArea.editWaiter.setEnabled(true);
		    this.editTableWindow.mainWindow.leftArea.editTable.setEnabled(true);
		    this.editTableWindow.mainWindow.leftArea.checkRoom.setEnabled(true);
		    this.editTableWindow.mainWindow.leftArea.checkSchedule.setEnabled(true);
		    this.editTableWindow.mainWindow.leftArea.roomManager.setEnabled(true);
		    this.editTableWindow.mainWindow.leftArea.close.setEnabled(true);
		    this.editTableWindow.setVisible(false);
		    this.editTableWindow.R_Area.removeAll();
		}
		else if(source == this.add)
		{
			this.editTableWindow.R_Area.removeAll();
			new EditTableWindowAddArea(this.editTableWindow);
			SwingUtilities.updateComponentTreeUI(this.editTableWindow);
		}
		else if(source == this.edit)
		{
			this.editTableWindow.R_Area.removeAll();
			new EditTableWindowEditArea(this.editTableWindow);
			SwingUtilities.updateComponentTreeUI(this.editTableWindow);
		}
		else if(source == this.delete)
		{
			this.editTableWindow.R_Area.removeAll();
			new EditTableWindowDeleteArea(this.editTableWindow);
			SwingUtilities.updateComponentTreeUI(this.editTableWindow);
		}
	}
}
