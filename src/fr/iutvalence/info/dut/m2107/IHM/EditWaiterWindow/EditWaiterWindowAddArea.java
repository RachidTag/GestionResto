package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.*;

import fr.iutvalence.info.dut.m2107.Rank;
import fr.iutvalence.info.dut.m2107.room.Sector;
import fr.iutvalence.info.dut.m2107.room.SectorNotExistsException;

/**
 * Represent the area where we can add a new waiter
 * @author Théo
 */
public class EditWaiterWindowAddArea extends JPanel implements ActionListener {

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
	public JComboBox<?> comboRanks;
	/**
	 * The combo box for the sector
	 */
	public JComboBox<?> comboSectors;
	/**
	 * The send button
	 */
	public JButton processAddWaiter;
	
	/**
	 * TODO
	 * @param editWaiterWindow
	 */
	@SuppressWarnings("deprecation")
	public EditWaiterWindowAddArea(EditWaiterWindow editWaiterWindow) {

		this.editWaiterWindow = editWaiterWindow;
		
		/*
		 * Set the GridLayout
		 */
		GridLayout controlPanel = new GridLayout(8,1);
		controlPanel.setHgap(10);
		controlPanel.setVgap(5);
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
		this.comboRanks = new JComboBox<Rank>(Rank.values());
		this.comboRanks.addActionListener(this);
		line3.add(this.comboRanks);
		
		/*
		 * Set the fourth line (Sector)
		 */
		JPanel line4 = new JPanel();
		line4.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line4);
		line4.add(new JLabel("Sector assignement"));
		Set<Integer> sectorsNum = this.editWaiterWindow.mainWindow.theRoom.getSectors().keySet();
		this.comboSectors = new JComboBox<Object>(sectorsNum.toArray());
		this.comboSectors.disable();
		this.comboSectors.addActionListener(this);
		line4.add(this.comboSectors);
		
		/*
		 * Set the fifth line (send)
		 */
		JPanel line5 = new JPanel();
		line5.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line5);
		line5.add(new JLabel());
		this.processAddWaiter = new JButton("Send");
		line5.add(this.processAddWaiter);
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent arg0){
		JComponent source = (JComponent) arg0.getSource();
		
		if(source == this.comboRanks){
			if(this.comboRanks.getSelectedItem() == Rank.PADDER)
				this.comboSectors.enable();
			else 
				this.comboSectors.disable();
		}
		else if(source == comboSectors){
			//TODO
		}
		else if(source == processAddWaiter){
			String lastName = this.lastName.getText();
			String firstName = this.firstName.getText();
			Rank rank = (Rank) this.comboRanks.getSelectedItem();
			int numSector = (int )this.comboSectors.getSelectedItem();
			
			
			
		}
	}

}
