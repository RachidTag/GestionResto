package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import fr.iutvalence.info.dut.m2107.Rank;
import fr.iutvalence.info.dut.m2107.room.Sector;

/**
 * Represent the area where we can add a new waiter
 * @author Théo
 */
public class EditWaiterWindowAddArea {

	/**
	 * 
	 */
	public EditWaiterWindow editWaiterWindow;
	/**
	 * The text field for the last name
	 */
	public JTextField lastName;
	/**
	 * The text field for the first name
	 */
	public JTextField firstName;
	/**
	 * The combo box for the rank
	 */
	public JComboBox<Rank> rank;
	/**
	 * The combo box for the sector
	 */
	public JComboBox<Sector> sector;
	/**
	 * The send button
	 */
	public JButton send;
	
	/**
	 * TODO
	 * @param editWaiterWindow
	 */
	public EditWaiterWindowAddArea(EditWaiterWindow editWaiterWindow) {

		this.editWaiterWindow = editWaiterWindow;
		
		/*
		 * Set the GridLayout
		 */
		GridLayout controlPanel = new GridLayout(7,1);
		
		/*
		 * Set the title of the panel
		 */
		JLabel title = new JLabel("Add Waiter",SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 20.f));
		this.editWaiterWindow.R_Area.add(title);
		
		/*
		 * Create a line layout
		 */
		GridLayout lineLayout = new GridLayout(1,2);
		
		/*
		 * Set the first line (last name)
		 */
		JPanel line1 = new JPanel();
		line1.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line1);
		line1.add(new JLabel("Last Name"));
		this.lastName = new JTextField();
		line1.add(this.lastName);
		
		
		
	}

}
