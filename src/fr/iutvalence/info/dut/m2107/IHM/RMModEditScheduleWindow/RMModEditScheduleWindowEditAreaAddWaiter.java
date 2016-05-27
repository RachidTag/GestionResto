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

import fr.iutvalence.info.dut.m2107.Calendar.Service;
import fr.iutvalence.info.dut.m2107.Calendar.ServiceType;
import fr.iutvalence.info.dut.m2107.Room.Sector;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Room.State;
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
		public JComboBox<?> comboNumWeek;
		/**
		 * The combo box for the days
		 */
		public JComboBox<?> comboNumDay;
		/**
		 * The combo box for the service
		 */
		public JComboBox<?> comboServices;
		/**
		 * the combo box for the num waiter we want to add
		 */
		public JComboBox<?> comboNumWaiter;
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
			 Set<Integer> weeksNum = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheCalendar().getAllWeeks().keySet();
			 this.comboNumWeek = new JComboBox<Object>(weeksNum.toArray());
			 this.comboNumWeek.addActionListener(this);
			 line1.add(this.comboNumWeek);
			 
			 /*
			  * Set the second line (days)
			  */
			 JPanel line2 = new JPanel();
			 line2.setLayout(lineLayout);
			 this.rmModEditScheduleWindow.R_Area.add(line2);
			 line2.add(new JLabel("Num day :"));
			 Integer[] days = {1, 2, 3, 4, 5, 6, 7};
			 this.comboNumDay =  new JComboBox<Object>(days);
			 line2.add(this.comboNumDay);
			 
			 /*
			  * Set the third line (service)
			  */
			 JPanel line3 = new JPanel();
			 line3.setLayout(lineLayout);
			 this.rmModEditScheduleWindow.R_Area.add(line3);
			 line3.add(new JLabel("Service :"));
			 this.comboServices = new JComboBox<Object>(ServiceType.values());
			 this.comboServices.addActionListener(this);
			 line3.add(this.comboServices);
			 
			 /*
			  * Set the forth line (num waiter)
			  */
			 JPanel line4 = new JPanel();
			 line4.setLayout(lineLayout);
			 this.rmModEditScheduleWindow.R_Area.add(line4);
			 line4.add(new JLabel("Num  waiter"));
			 Set<Waiter> numWaiter = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiters().values();
			 Set<Integer> numWaiterInService = this.mainWindow.restaurant.getTheCalendar().getWeekCalendar((int)this.comboWeeks.getSelectedItem()).getDay((int)this.comboDays.getSelectedItem());
			 this.comboNumWaiter = new JComboBox<Object>(numWaiter.toArray());
			 line4.add(this.comboNumWaiter);
			 this.comboNumWaiter.addActionListener(this);
			 
				/*
				 * Set the fifth line (send)
				 */
				JPanel line5 = new JPanel();
				line5.setLayout(lineLayout);
				this.rmModEditScheduleWindow.R_Area.add(line5);
				this.processEditWaiterAsNormalWaiter = new JButton("Add Waiter");
				this.processEditWaiterAsCleanerWaiter = new JButton("Add Cleaner Waiter");
				line5.add(this.processEditWaiterAsNormalWaiter);
				line5.add(this.processEditWaiterAsCleanerWaiter);
				this.processEditWaiterAsNormalWaiter.addActionListener(this);
				this.processEditWaiterAsCleanerWaiter.addActionListener(this);

		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComponent source = (JComponent) arg0.getSource();
		
		
	}
}
