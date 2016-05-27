package fr.iutvalence.info.dut.m2107.IHM.RMModEditScheduleWindow;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.iutvalence.info.dut.m2107.Room.Sector;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Staff.Rank;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;
import fr.iutvalence.info.dut.m2107.Staff.WaiterDoesNotExistException;
import fr.iutvalence.info.dut.m2107.Staff.WaiterIsNotAPadderException;
	/**
	 * Represent the area where we can edit a week
	 * @author Théo
	 */
public class RMModEditScheduleWindowEditAreaAddWaiter extends JPanel implements ActionListener{

		/**
		 * The main window
		 */
		public RMModEditScheduleWindow rmModEditScheduleWindow;
		/**
		 * The combo box for the weeks
		 */
		public JComboBox<?> numWeek;
		/**
		 * The combo box for the days
		 */
		public JComboBox<?> numDay;
		/**
		 * The combo box for the service
		 */
		public JComboBox<?> service;
		/**
		 * the combo box for the num waiter we want to add
		 */
		public JComboBox<?> numWaiter;
		/**
		 * The send button for a normal waiter
		 */
		public JButton processEditWaiterAsNormalWaiter;
		/**
		 * The send button for a cleaner waiter
		 */
		public JButton processEditWaiterAsCleanerWaiter;
		
		
		/**
		 * create the edit waiter right area
		 * @param editWaiterWindow
		 */
		public RMModEditScheduleWindowEditAreaAddWaiter(RMModEditScheduleWindow rmModEditScheduleWindow) {
			
			this.rmModEditScheduleWindow = rmModEditScheduleWindow;

			/*
			 * Set the grid layout
			 */
			GridLayout controlPanel = new GridLayout(8,1);
			controlPanel.setHgap(10);
			controlPanel.setVgap(5);
			this.rmModEditScheduleWindow.R_Area.setLayout(controlPanel);
			
			/*
			 * Set the title of the panel 
			 */
			 JLabel title = new JLabel("Edit waiter", SwingConstants.CENTER);
			 title.setFont(title.getFont().deriveFont(Font.BOLD,20.f));
			 this.rmModEditScheduleWindow.R_Area.add(title);
			 
			 /*
			  * Set the layout
			  */
			 GridLayout lineLayout = new GridLayout(1,2);
			 
			 /*
			  * Set first line (weeks)
			  */
			 JPanel line1 = new JPanel();
			 line1.setLayout(lineLayout);
			 this.rmModEditScheduleWindow.R_Area.add(line1);
			 line1.add(new JLabel("Num weeks"));
			 Set<Integer> waitersNum = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheCalendar().getAllWeeks().keySet();
			 this.numWeek = new JComboBox<Object>(waitersNum.toArray());
			 this.numWeek.addActionListener(this);
			 line1.add(this.numWeek);
			 
			 /*
			  * Set the second line (days)
			  */
			 JPanel line2 = new JPanel();
			 line2.setLayout(lineLayout);
			 this.rmModEditScheduleWindow.R_Area.add(line2);
			 line2.add(new JLabel("Num day :"));
			 Integer[] days = {1, 2, 3, 4, 5, 6, 7};
			 this.numDay.
			 line2.add(this.numDay);
			 
			 /*
			  * Set the third line (first name)
			  */
			 JPanel line3 = new JPanel();
			 line3.setLayout(lineLayout);
			 this.rmModEditScheduleWindow.R_Area.add(line3);
			 line3.add(new JLabel("First name :"));
			 line3.add(this.labelFirstName);
			 
			 /*
			  * Set the forth line (Rank)
			  */
			 JPanel line4 = new JPanel();
			 line4.setLayout(lineLayout);
			 this.rmModEditScheduleWindow.R_Area.add(line4);
			 line4.add(new JLabel("Rank"));
			 this.comboRank = new JComboBox<Rank>(Rank.values());
			 line4.add(this.comboRank);
			 this.comboRank.addActionListener(this);
			 
				/*
				 * Set the fifth line (Sector)
				 */
				JPanel line5 = new JPanel();
				line5.setLayout(lineLayout);
				this.rmModEditScheduleWindow.R_Area.add(line5);
				line5.add(new JLabel("Sector assignement"));
				Set<Integer> sectorsNum = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheRoom().getSectors().keySet();
				this.comboSector = new JComboBox<Object>(sectorsNum.toArray());
				this.comboSector.disable();
				this.comboSector.addActionListener(this);
				line5.add(this.comboSector);
				
				/*
				 * Set the sixth line (send)
				 */
				JPanel line6 = new JPanel();
				line6.setLayout(lineLayout);
				this.rmModEditScheduleWindow.R_Area.add(line6);
				line6.add(new JLabel());
				this.processEditWaiter = new JButton("Send");
				line6.add(this.processEditWaiter);
				this.processEditWaiter.addActionListener(this);
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComponent source = (JComponent) arg0.getSource();
		
		if(source == this.numWeek){
			try {
				Waiter theWaiter = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter((int) this.numWeek.getSelectedItem());
				this.lastName = theWaiter.getLastName();
				this.firstName = theWaiter.getFirstName();
				this.comboRank.setSelectedItem(theWaiter.getRank());
				this.labelLastName.setText(this.lastName);
				this.labelFirstName.setText(this.firstName);
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
			int theNumWaiter = (int) this.numWeek.getSelectedItem();
			Rank theRank = (Rank) this.comboRank.getSelectedItem();
			int theNumSector = (int) this.comboSector.getSelectedItem();
			int action = 0;
			
			Waiter theWaiter = null;
			try {
				theWaiter = rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter(theNumWaiter);
				theWaiter.setRank(theRank);
				action++;
			} catch (WaiterDoesNotExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				rmModEditScheduleWindow.mainWindow.restaurant.getTheRoom().getSector(theNumSector).setPadder(theWaiter);
				action++;
			} catch (WaiterIsNotAPadderException | SectorNotExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (action !=0)
				JOptionPane.showMessageDialog(null, "The waiter has been correctly edited");
			else 
				JOptionPane.showMessageDialog(null, "The waiter can't be edited");
		}
		
	}
}
