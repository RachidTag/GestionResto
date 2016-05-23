package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

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
	 * TODO
	 * @param sectorEditionWindow
	 */
	public EditWaiterWindowLeftArea(EditWaiterWindow sectorEditionWindow){
		/*
		 * Save the reference to the sectorEditionWindo
		 */
		this.editWaiterWindow = sectorEditionWindow;
		
		/*
		 * Set the layout
		 */
		GridLayout controlPanel = new GridLayout(4,1);
		this.setLayout(controlPanel);
		
		/*
		 * Set the add waiter button
		 */
		this.add = new JButton("Add Waiter");
		this.add.addActionListener(this);
		this.add(add);
		
		/*
		 * Set the edit waiter button
		 */
		this.edit = new JButton("Edit Waiter");
		this.edit.addActionListener(this);
		this.add(edit);

		/*
		 * Set the remove waiter button
		 */
		this.remove = new JButton("Remove Waiter");
		this.remove.addActionListener(this);
		this.add(remove);
		
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
	}
}
