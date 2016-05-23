package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.*;

import fr.iutvalence.info.dut.m2107.Room.Sector;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Staff.Rank;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;
import fr.iutvalence.info.dut.m2107.Staff.WaiterAlreadyExistsException;
import fr.iutvalence.info.dut.m2107.Staff.WaiterIsNotPadderException;

/**
 * Represent the area where we can add a new waiter
 * @author Théo
 */
public class EditWaiterWindowAddArea extends JPanel implements ActionListener {

	/**
	 * The main window
	 */
	public EditWaiterWindow editWaiterWindow;
	/**
	 * The spinner for the number of the waiter
	 */
	public JLabel numWaiter;
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
		 * Set the first line (last name)
		 */
		JPanel line1 = new JPanel();
		line1.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line1);
		line1.add(new JLabel("Waiter Number"));
		this.numWaiter = new JLabel(String.valueOf(this.editWaiterWindow.mainWindow.restaurant.getTheStaff().findFirstFreeIndex()));
		line1.add(this.numWaiter);

		/*
		 * Set the second line (last name)
		 */
		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line2);
		line2.add(new JLabel("Last Name"));
		this.lastName = new JTextField();
		line2.add(this.lastName);
		
		/*
		 * Set the third line (first name)
		 */
		JPanel line3 = new JPanel();
		line3.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line3);
		line3.add(new JLabel("First Name"));
		this.firstName = new JTextField();
		line3.add(this.firstName);
		
		/*
		 * Set the fourth line (rank)
		 */
		JPanel line4 = new JPanel();
		line4.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line4);
		line4.add(new JLabel("Rank"));
		this.comboRanks = new JComboBox<Rank>(Rank.values());
		this.comboRanks.addActionListener(this);
		line4.add(this.comboRanks);
		
		/*
		 * Set the fifth line (Sector)
		 */
		JPanel line5 = new JPanel();
		line5.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line5);
		line5.add(new JLabel("Sector assignement"));
		Set<Integer> sectorsNum = this.editWaiterWindow.mainWindow.restaurant.getTheRoom().getSectors().keySet();
		this.comboSectors = new JComboBox<Object>(sectorsNum.toArray());
		this.comboSectors.disable();
		this.comboSectors.addActionListener(this);
		line5.add(this.comboSectors);
		
		/*
		 * Set the sixth line (send)
		 */
		JPanel line6 = new JPanel();
		line6.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line6);
		line6.add(new JLabel());
		this.processAddWaiter = new JButton("Send");
		line6.add(this.processAddWaiter);
		this.processAddWaiter.addActionListener(this); 
		
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
			int numWaiter = (int) this.editWaiterWindow.mainWindow.restaurant.getTheStaff().findFirstFreeIndex();
			String lastName = this.lastName.getText();
			String firstName = this.firstName.getText();
			Rank rank = (Rank) this.comboRanks.getSelectedItem();
			int numSector = (int )this.comboSectors.getSelectedItem();
			int action = 0;
			
			Waiter theWaiter = new Waiter(numWaiter, lastName, firstName, rank);
			
			try {
				this.editWaiterWindow.mainWindow.restaurant.getTheStaff().addWaiter(theWaiter);
				action++;
			} catch (WaiterAlreadyExistsException e) {
				JOptionPane.showMessageDialog(null, "This number already exists");
				e.printStackTrace();
			}
			
			if (rank == Rank.PADDER){
				try {
					this.editWaiterWindow.mainWindow.restaurant.getTheRoom().getSector(numSector).setPadder(theWaiter);
				} catch (WaiterIsNotPadderException | SectorNotExistsException e) {
					// ...
					e.printStackTrace();
				}
			}
				if (action!=0)
					JOptionPane.showMessageDialog(null, "The waiter has been correctly added");
				else
					JOptionPane.showMessageDialog(null, "Error : the waiter can't be added");
		}
		
	}

}
