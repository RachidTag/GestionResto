package fr.iutvalence.info.dut.m2107.IHM.Schedule;

import java.awt.BorderLayout;
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
public class ScheduleWindow extends JFrame{
	
	public MainWindow mainWindow;
	
	public JComboBox<?> comboWeeks;
	
	public JComboBox<?> comboDays;
	
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
		
		GridLayout week = new GridLayout(3,1);
		
		JPanel Calendar1 = new JPanel();
		
		Calendar1.setLayout(week);
		this.add(Calendar1);
		
		GridLayout lineLayout = new GridLayout(1, 2);
		
		JPanel aweek = new JPanel();
		aweek.setLayout(lineLayout);
		this.add(aweek);
		aweek.add(new JLabel("Week:"));
		Set<Integer> weekNums = this.mainWindow.theCalendar.getAllWeeks().keySet();
		this.comboWeeks = new JComboBox<Object>(weekNums.toArray());
		aweek.add(this.comboWeeks);
		
		//a voir 
		/*JPanel aday = new JPanel();
		aday.setLayout(lineLayout);
		this.add(aday);
		aday.add(new JLabel("Day"));
		Week theWeek = null;
			try {
				theWeek = this.mainWindow.theCalendar.getWeekCalendar((int)this.comboWeeks.getSelectedItem());
			} catch (WeekNotExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Day[] days = theWeek.getDays();
		this.comboDays = days.length;
		this.comboDays.addActionListener(this);
		aday.add(this.comboDays);*/
		
		
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
					
			//this.add(employes);
			getContentPane().add(new JScrollPane(employes), BorderLayout.CENTER);
		}
		else{
			System.out.println("ERROR !!!");
		}
		
		this.setVisible(true);
	}

	/*@SuppressWarnings("unchecked")
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
	
	}*/

}
