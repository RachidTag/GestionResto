package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Set;

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
	public JComboBox<?> sector;
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
		GridLayout controlPanel = new GridLayout(8,1);
		this.editWaiterWindow.R_Area.setLayout(controlPanel);

		
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
		 * Add some space (empty JLabel)
		 */
		this.editWaiterWindow.R_Area.add(new JLabel());

		/*
		 * Set the first line (last name)
		 */
		JPanel line1 = new JPanel();
		line1.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line1);
		line1.add(new JLabel("Last Name"));
		this.lastName = new JTextField();
		line1.add(this.lastName);
		
		/*
		 * Set the second line (first name)
		 */
		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line2);
		line2.add(new JLabel("Fist Name"));
		this.firstName = new JTextField();
		line2.add(this.firstName);
		
		/*
		 * Set the third line (rank)
		 */
		JPanel line3 = new JPanel();
		line3.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line3);
		line3.add(new JLabel("Rabk"));
		this.rank = new JComboBox<Rank>(Rank.values());
		line3.add(this.rank);
		
		/*
		 * Set the fourth line (Sector)
		 */
		JPanel line4 = new JPanel();
		line4.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line4);
		line4.add(new JLabel("Sector assignement"));
		Set<Integer> sectorsNum = this.editWaiterWindow.mainWindow.theRoom.getSectors().keySet();
		this.sector = new JComboBox<Object>(sectorsNum.toArray());
		this.sector.disable();
		line4.add(this.sector);
		
		/*
		 * Add some space (empty JLabel)
		 */
		this.editWaiterWindow.R_Area.add(new JLabel());
		
		/*
		 * Set the fifth line (send)
		 */
		JPanel line5 = new JPanel();
		line5.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line5);
		line5.add(new JLabel());
		this.send = new JButton("Send");
		line5.add(this.send);
		
	}

}
