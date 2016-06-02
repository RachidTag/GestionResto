package fr.iutvalence.info.dut.m2107.IHM.EditTableWindow;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.iutvalence.info.dut.m2107.IHM.CustomButton.CustomButton;

/**
 * Represents the left area of the edit table window
 * @author Projet Resto
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
	public CustomButton edit;
	
	/**
	 * Delete button
	 */
	public CustomButton delete;
	
	/**
	 * Add button
	 */
	public CustomButton add;
	
	/**
	 * Close button
	 */
	public CustomButton close;

	/**
	 * Generates the left area of the edit table window
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
		GridLayout controlPanel = new GridLayout(7,1);
		controlPanel.setHgap(5);
		controlPanel.setVgap(5);
		this.setLayout(controlPanel);

		/*
		 * Set the buttons
		 */
		this.edit = new CustomButton("Edit", new Dimension(150, 45));
		this.delete = new CustomButton("Delete", new Dimension(150, 45));
		this.add = new CustomButton("Add", new Dimension(150, 45));
		this.close = new CustomButton("Close", new Dimension(150, 45));
		
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
	

		JPanel buttonJPanel1 = new JPanel();
		JPanel buttonJPanel2 = new JPanel();
		JPanel buttonJPanel3 = new JPanel();
		JPanel buttonJPanel4 = new JPanel();
		JPanel buttonJPanel5 = new JPanel();
		JPanel buttonJPanel6 = new JPanel();
		JPanel buttonJPanel7 = new JPanel();
		
		buttonJPanel1.add(this.add);
		buttonJPanel2.add(this.edit);
		buttonJPanel3.add(this.delete);
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
			this.editTableWindow.mainWindow.enable();
		    this.editTableWindow.dispose();
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
