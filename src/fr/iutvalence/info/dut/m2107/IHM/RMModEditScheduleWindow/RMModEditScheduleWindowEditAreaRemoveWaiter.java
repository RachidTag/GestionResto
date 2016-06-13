package fr.iutvalence.info.dut.m2107.IHM.RMModEditScheduleWindow;

import java.awt.Dimension;
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

import fr.iutvalence.info.dut.m2107.Calendar.DayNotExistsException;
import fr.iutvalence.info.dut.m2107.Calendar.ServiceType;
import fr.iutvalence.info.dut.m2107.Calendar.WeekNotExistsException;
import fr.iutvalence.info.dut.m2107.IHM.CustomButton.CustomButton;
import fr.iutvalence.info.dut.m2107.Staff.Rank;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;
import fr.iutvalence.info.dut.m2107.Staff.WaiterDoesNotExistException;

/**
 * Represent the area where we can remove a waiter from the schedule
 * @author Projet Resto
 *
 */
@SuppressWarnings("serial")
public class RMModEditScheduleWindowEditAreaRemoveWaiter extends JPanel implements ActionListener {
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
	public JButton processRemoveWaiter;
	/**
	 * the last name of the waiter
	 */
	public String lastName;
	/**
	 * the first name of the waiter
	 */
	public String firstName;
	/**
	 * the label of the name
	 */
	public JLabel name;
	
	
	/**
	 * create the edit waiter right area
	 * @param rmModEditScheduleWindow
	 */
	public RMModEditScheduleWindowEditAreaRemoveWaiter(RMModEditScheduleWindow rmModEditScheduleWindow) {
		
		/*
		 * Set the strings
		 */
		this.lastName = "";
		this.firstName = "";
		
		/*
		 * Set the reference of the rmMod edit schedule window
		 */
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
		JLabel title = new JLabel("Remove waiter", SwingConstants.CENTER);
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
		this.comboNumDay.addActionListener(this);
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
		/*
		 * Take all the available waiter
		 */
		Set<Integer> numWaitersInService = this.waitersInService();
		/*
		 * Create the combo box
		 */
		this.comboNumWaiter = new JComboBox<Object>(numWaitersInService.toArray());
		line4.add(this.comboNumWaiter);
		this.comboNumWaiter.addActionListener(this);
		
		/*
		 * Set the fifth line (label)
		 */
		JPanel line5 = new JPanel();
		line5.setLayout(lineLayout);
		this.rmModEditScheduleWindow.R_Area.add(line5);
		if(this.waitersInService().size() != 0){
			try {
				this.lastName = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter((int)this.comboNumWaiter.getSelectedItem()).getLastName();
				this.firstName = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter((int)this.comboNumWaiter.getSelectedItem()).getFirstName();
			} catch (WaiterDoesNotExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.name = new JLabel(this.lastName + " " + this.firstName);
		line5.add(new JLabel("Name :"));
		line5.add(this.name);
		
		/*
		 * Set the sixth line (send)
		 */
		JPanel line6 = new JPanel();
		line6.setLayout(lineLayout);
		this.rmModEditScheduleWindow.R_Area.add(line6);
		line6.add(new JLabel());
		this.processRemoveWaiter = new CustomButton("Remove waiter", new Dimension(240,50));
		line6.add(this.processRemoveWaiter);
		this.processRemoveWaiter.addActionListener(this);

	}
	
		/**
		 * Return the number of the waiters in service
		 * @return the set of number of all waiter in service
		 */
		public Set<Integer> waitersInService(){
		/*
		 * Take all the waiter in the service
		 */
		Set<Integer> numWaitersInService = new TreeSet<Integer>();
		
		try {
			for(Integer numWaiters : this.rmModEditScheduleWindow.mainWindow.restaurant.getTheCalendar().getWeekCalendar((int)this.comboNumWeek.getSelectedItem()).getDay((int)this.comboNumDay.getSelectedItem()-1).getService((ServiceType)this.comboServices.getSelectedItem()).getAllWaiters().keySet()){
				numWaitersInService.add(numWaiters);
			}
		} catch (DayNotExistsException | WeekNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numWaitersInService;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JComponent source = (JComponent) arg0.getSource();
			
			if (source == this.processRemoveWaiter){
				
				int numWaiter = 0;
				String lastName = "";
				String firstName = "";
				Rank rank = null;
				try {
					numWaiter = (int) this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter((int)this.comboNumWaiter.getSelectedItem()).getNumWaiter();
					lastName = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter((int)this.comboNumWaiter.getSelectedItem()).getLastName();
					firstName = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter((int)this.comboNumWaiter.getSelectedItem()).getFirstName();
					rank = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter((int)this.comboNumWaiter.getSelectedItem()).getRank();
				} catch (WaiterDoesNotExistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Waiter theWaiter = new Waiter(numWaiter, lastName, firstName, rank);
				
				/*
				 * Remove the waiter
				 */
				try {
					this.rmModEditScheduleWindow.mainWindow.restaurant.getTheCalendar().getWeekCalendar((int)this.comboNumWeek.getSelectedItem()).getDay((int)this.comboNumDay.getSelectedItem()-1).getService((ServiceType)this.comboServices.getSelectedItem()).removeWaiter(theWaiter);
					JOptionPane.showMessageDialog(null, "The waiter has been correctly removed");
				} catch (DayNotExistsException | WeekNotExistsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			if (source == this.comboNumWaiter){
				try {
					this.lastName = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter((int)this.comboNumWaiter.getSelectedItem()).getLastName();
					this.firstName = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter((int)this.comboNumWaiter.getSelectedItem()).getFirstName();
				} catch (WaiterDoesNotExistException e) {
					// TODO Auto-generated catch block
					this.lastName = "";
					this.firstName = "";
					e.printStackTrace();
				}
			}
			/*
			 * Refresh the combo boxes
			 */
			if(source != this.comboNumWaiter){
				if(this.waitersInService().size() != 0){
					@SuppressWarnings({ "rawtypes" })
					DefaultComboBoxModel model = new DefaultComboBoxModel(this.waitersInService().toArray());
					this.comboNumWaiter.setModel(model);
					try {
						this.lastName = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter((int)this.comboNumWaiter.getSelectedItem()).getLastName();
						this.firstName = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheStaff().getWaiter((int)this.comboNumWaiter.getSelectedItem()).getFirstName();
					} catch (WaiterDoesNotExistException e) {
						// TODO Auto-generated catch block
						this.lastName = "";
						this.firstName = "";
						e.printStackTrace();
					}
				}
				else {
					this.comboNumWaiter.removeAllItems();
					this.lastName = "";
					this.firstName = "";
				}
				
				this.name.setText(this.lastName + " " + this.firstName);
			}
		}

}
