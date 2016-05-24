package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Represents the left area of the edit waiter window
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class EditWaiterWindowLeftArea extends JPanel implements ActionListener{
	/**
	 * The main window
	 */
	public EditWaiterWindow editWaiterWindow;
	
	/**
	 * The add button
	 */
	public JButton add;
	
	/**
	 * The show staff button
	 */
	public JButton showStaff;
	
	/**
	 * The edit button
	 */
	public JButton edit;
	
	/**
	 * The remove button
	 */
	public JButton remove;
	
	/**
	 * The close button
	 */
	public JButton close;

	/**
	 * Generates the left area of the edit waiter window
	 * @param editWaiterWindow
	 */
	public EditWaiterWindowLeftArea(EditWaiterWindow editWaiterWindow){
		/*
		 * Save the reference to the sectorEditionWindo
		 */
		this.editWaiterWindow = editWaiterWindow;
		
		/*
		 * Set the layout
		 */
		GridLayout controlPanel = new GridLayout(5,1);
		this.setLayout(controlPanel);
		
		/*
		 * Set the add waiter button
		 */
		this.showStaff = new JButton("Show Staff");
		this.showStaff.addActionListener(this);
		this.add(this.showStaff);
		/*
		 * Set the add waiter button
		 */
		this.add = new JButton("Add Waiter");
		this.add.addActionListener(this);
		this.add(this.add);
		
		/*
		 * Set the edit waiter button
		 */
		this.edit = new JButton("Edit Waiter");
		this.edit.addActionListener(this);
		this.add(this.edit);

		/*
		 * Set the remove waiter button
		 */
		this.remove = new JButton("Remove Waiter");
		this.remove.addActionListener(this);
		this.add(this.remove);
		
		/*
		 * Set the close button
		 */
		this.close = new JButton("close");
		this.close.addActionListener(this);
		this.add(this.close);
		
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			this.editWaiterWindow.mainWindow.leftArea.editWaiter.setEnabled(true);
		    this.editWaiterWindow.mainWindow.leftArea.editTable.setEnabled(true);
		    this.editWaiterWindow.mainWindow.leftArea.checkRoom.setEnabled(true);
		    this.editWaiterWindow.mainWindow.leftArea.checkSchedule.setEnabled(true);
		    this.editWaiterWindow.mainWindow.leftArea.roomManager.setEnabled(true);
		    this.editWaiterWindow.mainWindow.leftArea.close.setEnabled(true);
		    this.editWaiterWindow.setVisible(false);
		    this.editWaiterWindow.R_Area.removeAll();
		}
		else if(source == this.add)
		{
			this.editWaiterWindow.R_Area.removeAll();
			new EditWaiterWindowAddArea(this.editWaiterWindow);
			SwingUtilities.updateComponentTreeUI(this.editWaiterWindow);
		}
		else if (source == this.edit)
		{
			this.editWaiterWindow.R_Area.removeAll();
			new EditWaiterWindowEditArea(this.editWaiterWindow);
			SwingUtilities.updateComponentTreeUI(this.editWaiterWindow);
		}
		else if (source == this.remove){
			this.editWaiterWindow.R_Area.removeAll();
			new EditWaiterWindowRemoveArea(this.editWaiterWindow);
			SwingUtilities.updateComponentTreeUI(this.editWaiterWindow);
		}
		else if(source == this.showStaff){
			this.editWaiterWindow.R_Area.removeAll();
			new EditWaiterWindowShowStaffArea(this.editWaiterWindow);
			SwingUtilities.updateComponentTreeUI(this.editWaiterWindow);
		}
	}
}
