package fr.iutvalence.info.dut.m2107.IHM.Schedule;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.iutvalence.info.dut.m2107.WindowEventHandler;
import fr.iutvalence.info.dut.m2107.Calendar.DayNotExistsException;
import fr.iutvalence.info.dut.m2107.Calendar.ServiceType;
import fr.iutvalence.info.dut.m2107.Calendar.WeekNotExistsException;
import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;

@SuppressWarnings("serial")
public class ScheduleWindow extends JFrame{
	
	public MainWindow mainWindow;
	
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
		
		GridLayout week = new GridLayout(1,1);
		
		JPanel Day = new JPanel();
		
		Day.setLayout(week);
		this.add(Day);
		
		
		
		
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
		
		
        /*Object[][] bite = {
                {"jacquie", "Van de Kampf", Color.black, true, Sport.FOOTBALL},
                {"Damien", "Cuthbert", Color.cyan, true, Sport.RIEN},
                {"Corinne", "Valance", Color.blue, false, Sport.NATATION},
                {"Emilie", "Schrödinger", Color.magenta, false, Sport.FOOTBALL},
                {"Delphine", "Duke", Color.yellow, false, Sport.TENNIS},
                {"Eric", "Trump", Color.pink, true, Sport.FOOTBALL},
        };*/
		
		this.setVisible(true);
	}
	
	

}
