package fr.iutvalence.info.dut.m2107.IHM.Schedule;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import fr.iutvalence.info.dut.m2107.WindowEventHandler;
import fr.iutvalence.info.dut.m2107.Calendar.Day;
import fr.iutvalence.info.dut.m2107.Calendar.DayNotExistsException;
import fr.iutvalence.info.dut.m2107.Calendar.Service;
import fr.iutvalence.info.dut.m2107.Calendar.ServiceType;
import fr.iutvalence.info.dut.m2107.Calendar.WeekNotExistsException;
import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;

/**
 * Represents the schedule window
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class ScheduleWindow extends JFrame implements ActionListener{
	
	/**
	 * Reference to the main window
	 */
	public MainWindow mainWindow;
	
	/**
	 * Weeks' combo box
	 */
	public JComboBox<?> comboWeeks;
	
	/**
	 * Days' combo box
	 */
	public JComboBox<?> comboDays;
	
	/**
	 * Services' combo box
	 */
	public JComboBox<?> comboServices;
	
	/**
	 * Bottom area (schedule)
	 */
	public JPanel bottomArea = new JPanel();
	
	/**
	 * Top area (selecting the week)
	 */
	public JPanel topArea = new JPanel();
	
	/**
	 * Generates the schedule window
	 * @param theMainWindow
	 */
	public ScheduleWindow(MainWindow theMainWindow)
	{
		/* 
		 * Save a reference to the main window
		 */
		this.mainWindow = theMainWindow;
		
		/*
		 * Initialize the ScheduleWindow
		 */
		this.addWindowListener(new WindowEventHandler(this.mainWindow));
		this.setTitle("Check the Schedule");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		/*
		 * Set the layouts
		 */
		this.topArea.setLayout(new GridLayout(1, 3));
		this.bottomArea.setLayout(new GridLayout(1, 1));
		
		/*
		 * Creates the line layout
		 */
		GridLayout lineLayout = new GridLayout(1,2);
		
		/*
		 * Top Area part 1 (Selecting week)
		 */
		JPanel aWeek = new JPanel();
		aWeek.setLayout(lineLayout);
		this.topArea.add(aWeek);
		aWeek.add(new JLabel("Week:"));
		Set<Integer> weekNums = this.mainWindow.restaurant.getTheCalendar().getAllWeeks().keySet();
		this.comboWeeks = new JComboBox<Object>(weekNums.toArray());
		aWeek.add(this.comboWeeks);

		/*
		 * Top Area part 2 (Selecting day)
		 */
		JPanel aDay = new JPanel();
		aDay.setLayout(lineLayout);
		this.topArea.add(aDay);
		aDay.add(new JLabel("Day"));
		Integer[] days = {1, 2, 3, 4, 5, 6, 7};
		this.comboDays = new JComboBox<Object>(days);
		this.comboDays.addActionListener(this);
		aDay.add(this.comboDays);

		/*
		 * Top Area part 3 (Selecting service)
		 */
		JPanel aService = new JPanel();
		aService.setLayout(lineLayout);
		this.topArea.add(aService);
		aService.add(new JLabel("Service"));
		ServiceType[] services = {ServiceType.EVENING, ServiceType.MIDDAY};
		this.comboServices = new JComboBox<Object>(services);
		this.comboServices.addActionListener(this);
		aService.add(this.comboServices);
		
		/*
		 * Split the page
		 */
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, topArea, bottomArea);
		splitPane.setOneTouchExpandable(true);
		
		/*
		 * Set the divider location
		 */
		splitPane.setDividerLocation(50);
		
		/*
		 * Disable divider control
		 */
		splitPane.setEnabled(false);
		
		/*
		 * Set divider size to 1 px
		 */
		splitPane.setDividerSize(1);
		
		/*
		 * Add splitpane to basic Pane
		 */
		this.getContentPane().add(splitPane);
		
		this.setVisible(true);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent arg0) {
		JComponent source = (JComponent) arg0.getSource();
		if(source == this.comboDays || source == this.comboServices)
		{
			this.bottomArea.removeAll();
			
			Day theDay = null;
			try {
				theDay = this.mainWindow.restaurant.getTheCalendar().getWeekCalendar((int)this.comboWeeks.getSelectedItem()).getDay((int)this.comboDays.getSelectedItem());
			} catch (DayNotExistsException | WeekNotExistsException e) {
				// impossible
			}			
			
			Service theService = theDay.getService((ServiceType)this.comboServices.getSelectedItem());

			Set<Waiter> waiters = theService.getAllWaiters();
			if(!theDay.isClosed())
			{
				if (waiters != null)
				{
					// Make the array of the waiters 
					Object[][] ws = new Object[waiters.size()][6];
					int i = 0;
					for (Waiter waiter : waiters)
					{
						if(theService.getCleanerWaiters().containsValue(waiter)) 
						{
							if((ServiceType)this.comboServices.getSelectedItem() == ServiceType.MIDDAY)
							{
								ws[i][4] = "11h";
								ws[i][5] = "15h";
							}
							else
							{
								ws[i][4] = "18h30";
								ws[i][5] = "22h30";
							}
						}
						else
						{
							if((ServiceType)this.comboServices.getSelectedItem() == ServiceType.MIDDAY)
							{
								ws[i][4] = "11h45";
								ws[i][5] = "15h";
							}
							else
							{
								ws[i][4] = "19h";
								ws[i][5] = "22h30";
							}
	
						}
						
						ws[i][0] = waiter.getNumWaiter();
						ws[i][1] = waiter.getFirstName();
						ws[i][2] = waiter.getLastName();
						ws[i][3] = waiter.getRank();
						
						i++;
					}
					
					String[] titles = {"numbers","First Name", "Last Name", "Rank", "Began Hours", "End Hours"};
					
					JTable employes = new JTable(ws, titles);
					employes.disable();
						
					this.bottomArea.add(new JScrollPane(employes), BorderLayout.CENTER);
			
					employes.getTableHeader().setReorderingAllowed(false);
					employes.getTableHeader().setResizingAllowed(false);
					
					this.bottomArea.validate();
				}
				else{
					System.err.println("Waiters is null");
				}
			}
			else
			{
				/*
				 * Set the layout
				 */
				this.bottomArea.setLayout(new GridBagLayout());
				
				/*
				 * Add the default text
				 */
				JLabel defaultText = new JLabel("The restaurant is closed today !");
				GridBagConstraints gbc = new GridBagConstraints();
				defaultText.setFont(defaultText.getFont().deriveFont(Font.ITALIC, 24.f));
				this.bottomArea.add(defaultText, gbc);
				
				/*
				 * Refresh
				 */
				this.bottomArea.validate();
			}
		}
	}
}
