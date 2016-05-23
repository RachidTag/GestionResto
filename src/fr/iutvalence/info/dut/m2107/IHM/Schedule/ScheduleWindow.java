package fr.iutvalence.info.dut.m2107.IHM.Schedule;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
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
import fr.iutvalence.info.dut.m2107.Calendar.ServiceType;
import fr.iutvalence.info.dut.m2107.Calendar.Week;
import fr.iutvalence.info.dut.m2107.Calendar.WeekNotExistsException;
import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;
import fr.iutvalence.info.dut.m2107.Room.Sector;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;

@SuppressWarnings("serial")
public class ScheduleWindow extends JFrame implements ActionListener{
	
	public MainWindow mainWindow;
	
	public JComboBox<?> comboWeeks;
	
	public JComboBox<?> comboDays;
	
	public JPanel bottomArea = new JPanel();
	
	public JPanel topArea = new JPanel();
	
	public ScheduleWindow(MainWindow theMainWindow)
	{
		/* 
		 * Save a reference to the main window
		 */
		this.mainWindow = theMainWindow;
		
		/*
		 * Initialise the SectorEditionWindow
		 */
		this.addWindowListener(new WindowEventHandler(this.mainWindow));
		this.setTitle("Check the Schedule");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		
		this.topArea.setLayout(new GridLayout(1, 2));
		
		
		this.bottomArea.setLayout(new GridLayout(1, 1));
		
		GridLayout lineLayout = new GridLayout(1,2);
		
		JPanel aWeek = new JPanel();
		aWeek.setLayout(lineLayout);
		this.topArea.add(aWeek);
		aWeek.add(new JLabel("Week:"));
		Set<Integer> weekNums = this.mainWindow.theCalendar.getAllWeeks().keySet();
		this.comboWeeks = new JComboBox<Object>(weekNums.toArray());
		aWeek.add(this.comboWeeks);
		
		JPanel aDay = new JPanel();
		aDay.setLayout(lineLayout);
		this.topArea.add(aDay);
		aDay.add(new JLabel("Day"));
		Integer[] days = {1, 2, 3, 4, 5, 6, 7};
		this.comboDays = new JComboBox<Object>(days);
		this.comboDays.addActionListener(this);
		aDay.add(this.comboDays);
		

		

		
		/*
		 * Split the page
		 */
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, topArea, bottomArea);
		splitPane.setOneTouchExpandable(true);
		
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

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JComponent source = (JComponent) arg0.getSource();
		if(source == this.comboWeeks)
		{
			Week theWeek = null;
				try {
					theWeek = this.mainWindow.theCalendar.getWeekCalendar((int)this.comboWeeks.getSelectedItem());
				} catch (WeekNotExistsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			@SuppressWarnings({ "rawtypes" })
			DefaultComboBoxModel model = new DefaultComboBoxModel(new TreeSet<Integer>().toArray());
			this.comboDays.setModel(model);
		
		}
		else if(source == this.comboDays)
		{
			
			Set<Waiter> waiters = null;
			try {
				waiters = this.mainWindow.theCalendar.getWeekCalendar(1).getDay(1).getService(ServiceType.MIDDAY).getAllWaiters();
			} catch (DayNotExistsException | WeekNotExistsException e) {
				e.printStackTrace();
			}
			
			if (waiters != null)
			{
			
				Waiter[] wArray = new Waiter[waiters.size()];
				wArray = waiters.toArray(wArray);
				Object[][] ws = new Object[waiters.size()][4];
				for (int i = 0; i < ws.length; i++) {
					ws[i][0] = wArray[i].getNumWaiter();
					ws[i][1] = wArray[i].getFirstName();
					ws[i][2] = wArray[i].getLastName();
					ws[i][3] = wArray[i].getRank();
				}
				
				String[] titles = {"numbers","First Name", "Last Name", "Rank"};
				
				JTable employes = new JTable(ws, titles);
				employes.disable();
						
				//this.add(employes);
				this.bottomArea.add(new JScrollPane(employes), BorderLayout.CENTER);
			}
			else{
				System.out.println("ERROR !!!");
			}
			
		}
	
	}

}
