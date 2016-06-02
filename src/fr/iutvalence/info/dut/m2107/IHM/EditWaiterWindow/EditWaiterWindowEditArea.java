package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.iutvalence.info.dut.m2107.IHM.CustomButton.CustomButton;
import fr.iutvalence.info.dut.m2107.Room.Sector;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Staff.Rank;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;
import fr.iutvalence.info.dut.m2107.Staff.WaiterDoesNotExistException;
import fr.iutvalence.info.dut.m2107.Staff.WaiterIsNotAPadderException;

/**
 * Represent the area where we can edit a waiter
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class EditWaiterWindowEditArea extends JPanel implements ActionListener{
	/**
	 * The main window
	 */
	public EditWaiterWindow editWaiterWindow;
	
	/**
	 * The combo box of the waiters
	 */
	public JComboBox<?> comboWaiter;
	
	/**
	 * the combo box of the ranks
	 */
	public JComboBox<?> comboRank;
	
	/**
	 * the combo box for the sector
	 */
	public JComboBox<?> comboSector;
	
	/**
	 * the last name of the waiter
	 */
	public String lastName;
	
	/**
	 * the first name of the waiter
	 */
	public String firstName;
	
	/**
	 * The send button
	 */
	public CustomButton processEditWaiter;
	
	/**
	 * JLabel for the last name
	 */
	public JLabel labelLastName;
	
	/**
	 * JLabel for the first name
	 */
	public JLabel labelFirstName;
	
	/**
	 * create the edit waiter right area
	 * @param editWaiterWindow
	 */
	@SuppressWarnings("deprecation")
	public EditWaiterWindowEditArea(EditWaiterWindow editWaiterWindow) {
		/*
		 * Save a reference to the edit waiter window
		 */
		this.editWaiterWindow = editWaiterWindow;
		
		/*
		 * Set the grid layout
		 */
		GridLayout controlPanel = new GridLayout(8,1);
		controlPanel.setHgap(10);
		controlPanel.setVgap(5);
		this.editWaiterWindow.R_Area.setLayout(controlPanel);
		
		/*
		 * Set the title of the panel 
		 */
		 JLabel title = new JLabel("Edit waiter", SwingConstants.CENTER);
		 title.setFont(title.getFont().deriveFont(Font.BOLD,20.f));
		 this.editWaiterWindow.R_Area.add(title);
		 
		 /*
		  * Set the layout
		  */
		 GridLayout lineLayout = new GridLayout(1,2);
		 
		 /*
		  * Set first line (waiters)
		  */
		 JPanel line1 = new JPanel();
		 line1.setLayout(lineLayout);
		 this.editWaiterWindow.R_Area.add(line1);
		 line1.add(new JLabel("Num waiters"));
		 Set<Integer> waitersNum = this.editWaiterWindow.mainWindow.restaurant.getTheStaff().getWaiters().keySet();
		 this.comboWaiter = new JComboBox<Object>(waitersNum.toArray());
		 this.comboWaiter.addActionListener(this);
		 line1.add(this.comboWaiter);
		 
		 /*
		 * Set default waiter
		 */
		 Waiter defaultWaiter = null;
		 try {
		 	defaultWaiter = this.editWaiterWindow.mainWindow.restaurant.getTheStaff().getWaiter((int)this.comboWaiter.getSelectedItem());
		 } catch (WaiterDoesNotExistException e) {
		 	defaultWaiter = new Waiter(1, "", "", Rank.RUNNER);
		 	e.printStackTrace();
		 }
			 
		 /*
		  * Set the second line (last name)
		  */
		 JPanel line2 = new JPanel();
		 line2.setLayout(lineLayout);
		 this.editWaiterWindow.R_Area.add(line2);
		 line2.add(new JLabel("Last name :"));
		 this.labelLastName = new JLabel(defaultWaiter.getLastName());
		 line2.add(this.labelLastName);
		 this.labelLastName.setText(defaultWaiter.getLastName());
		 
		 /*
		  * Set the third line (first name)
		  */
		 JPanel line3 = new JPanel();
		 line3.setLayout(lineLayout);
		 this.editWaiterWindow.R_Area.add(line3);
		 line3.add(new JLabel("First name :"));
		 this.labelFirstName = new JLabel(defaultWaiter.getFirstName());
		 line3.add(this.labelFirstName);
		 this.labelFirstName.setText(defaultWaiter.getFirstName());
		 
		 /*
		  * Set the forth line (Rank)
		  */
		 JPanel line4 = new JPanel();
		 line4.setLayout(lineLayout);
		 this.editWaiterWindow.R_Area.add(line4);
		 line4.add(new JLabel("Rank"));
		 this.comboRank = new JComboBox<Rank>(Rank.values());
		 line4.add(this.comboRank);
		 this.comboRank.setSelectedItem(defaultWaiter.getRank());
		 this.comboRank.addActionListener(this);

		 /*
		 * Set the fifth line (Sector)
		 */
		JPanel line5 = new JPanel();
		line5.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line5);
		line5.add(new JLabel("Sector assignement"));
		Set<Integer> sectorsNum = this.editWaiterWindow.mainWindow.restaurant.getTheRoom().getSectors().keySet();
		this.comboSector = new JComboBox<Object>(sectorsNum.toArray());
		// this.comboSector.setSelectedItem(defaultWaiter); TODO : default sector
		if(defaultWaiter.getRank() == Rank.PADDER)
			this.comboSector.enable();
		else
			this.comboSector.disable();
		this.comboSector.addActionListener(this);
		line5.add(this.comboSector);
		
		/*
		 * Set the sixth line (send)
		 */
		JPanel line6 = new JPanel();
		line6.setLayout(lineLayout);
		this.editWaiterWindow.R_Area.add(line6);
		line6.add(new JLabel());
		this.processEditWaiter = new CustomButton("Send", new Dimension(250, 50));
		line6.add(this.processEditWaiter);
		this.processEditWaiter.addActionListener(this);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent arg0) {
		JComponent source = (JComponent) arg0.getSource();
		
		if(source == this.comboWaiter){
			try {
				Waiter theWaiter = this.editWaiterWindow.mainWindow.restaurant.getTheStaff().getWaiter((int) this.comboWaiter.getSelectedItem());
				this.lastName = theWaiter.getLastName();
				this.firstName = theWaiter.getFirstName();
				this.comboRank.setSelectedItem(theWaiter.getRank());
				this.labelLastName.setText(this.lastName);
				this.labelFirstName.setText(this.firstName);
				// TODO : set the sector of the padder !
			} catch (WaiterDoesNotExistException e) {
				this.lastName = null;
				this.firstName = null;
				e.printStackTrace();
			}
		}
		else if(source == this.comboRank){
			if(this.comboRank.getSelectedItem() == Rank.PADDER)
				this.comboSector.enable();
			else
				this.comboSector.disable();
		}
		else if(source == this.processEditWaiter){
			int theNumWaiter = (int) this.comboWaiter.getSelectedItem();
			Rank theRank = (Rank) this.comboRank.getSelectedItem();
			int numSector = (int) this.comboSector.getSelectedItem();
			int action = 0;
			
			Waiter theWaiter = null;
			try {
				theWaiter = this.editWaiterWindow.mainWindow.restaurant.getTheStaff().getWaiter(theNumWaiter);
				theWaiter.setRank(theRank);
				action++;
			} catch (WaiterDoesNotExistException e) {
				// impossible
			}
			
			if(theRank == Rank.PADDER)
			{
				// Remove the name of the padder in the old sector
				for(Sector sector : this.editWaiterWindow.mainWindow.restaurant.getTheRoom().getSectors().values())
				{
					if(sector.getPadder() != null && sector.getPadder().equals(theWaiter))
					{
						try {
							sector.setPadder(null);
						} catch (WaiterIsNotAPadderException e) {
							// impossible
						}
						this.editWaiterWindow.mainWindow.rightArea.setPadderName(sector.getNumSector(), null);
					}
				}
				
				// Set the name of the padder in the sector
				try {
					this.editWaiterWindow.mainWindow.restaurant.getTheRoom().getSector(numSector).setPadder(theWaiter);
					action++;
				} catch (WaiterIsNotAPadderException | SectorNotExistsException e) {
					// impossible
				}
				
				// write the name of the padder in the sector's part of the IHM
				this.editWaiterWindow.mainWindow.rightArea.setPadderName(numSector, theWaiter.getFirstName() + " " + theWaiter.getLastName());
			}
			
			if (action !=0)
				JOptionPane.showMessageDialog(null, "The waiter has been correctly edited");
			else 
				JOptionPane.showMessageDialog(null, "The waiter can't be edited");
		}
		
	}
}
