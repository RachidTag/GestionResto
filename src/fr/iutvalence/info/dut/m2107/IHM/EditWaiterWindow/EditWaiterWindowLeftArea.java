package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.iutvalence.info.dut.m2107.IHM.CustomButton.CustomButton;

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
	public CustomButton add;
	
	/**
	 * The show staff button
	 */
	public CustomButton showStaff;
	
	/**
	 * The edit button
	 */
	public CustomButton edit;
	
	/**
	 * The remove button
	 */
	public CustomButton remove;
	
	/**
	 * The close button
	 */
	public CustomButton close;

	/**
	 * Generates the left area of the edit waiter window
	 * @param editWaiterWindow
	 */
	public EditWaiterWindowLeftArea(EditWaiterWindow editWaiterWindow){
		/*
		 * Save the reference to the editWaiterWindow
		 */
		this.editWaiterWindow = editWaiterWindow;
		
		/*
		 * Set the layout
		 */
		GridLayout controlPanel = new GridLayout(7,1);
		controlPanel.setVgap(5);
		controlPanel.setHgap(5);
		this.setLayout(controlPanel);
		
		/*
		 * Set the add waiter button
		 */
		this.showStaff = new CustomButton("Show Staff", new Dimension(150,45));
		this.showStaff.addActionListener(this);
		this.add(this.showStaff);
		/*
		 * Set the add waiter button
		 */
		this.add = new CustomButton("Add Waiter", new Dimension(150,45));
		this.add.addActionListener(this);
		this.add(this.add);
		
		/*
		 * Set the edit waiter button
		 */
		this.edit = new CustomButton("Edit Waiter", new Dimension(150,45));
		this.edit.addActionListener(this);
		this.add(this.edit);

		/*
		 * Set the remove waiter button
		 */
		this.remove = new CustomButton("Remove Waiter", new Dimension(150,45));
		this.remove.addActionListener(this);
		this.add(this.remove);
		
		/*
		 * Set the close button
		 */
		this.close = new CustomButton("Close", new Dimension(150,45));
		this.close.addActionListener(this);
		this.add(this.close);
		
		JPanel buttonJPanel1 = new JPanel();
		JPanel buttonJPanel2 = new JPanel();
		JPanel buttonJPanel3 = new JPanel();
		JPanel buttonJPanel4 = new JPanel();
		JPanel buttonJPanel5 = new JPanel();
		JPanel buttonJPanel6 = new JPanel();
		JPanel buttonJPanel7 = new JPanel();
		
		buttonJPanel1.add(this.showStaff);
		buttonJPanel2.add(this.add);
		buttonJPanel3.add(this.edit);
		buttonJPanel4.add(this.remove);
		buttonJPanel7.add(this.close);
		
		this.add(buttonJPanel1);
		this.add(buttonJPanel2);
		this.add(buttonJPanel3);
		this.add(buttonJPanel4);
		this.add(buttonJPanel5);
		this.add(buttonJPanel6);
		this.add(buttonJPanel7);
		
		
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			this.editWaiterWindow.mainWindow.enable();
		    this.editWaiterWindow.dispose();
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
