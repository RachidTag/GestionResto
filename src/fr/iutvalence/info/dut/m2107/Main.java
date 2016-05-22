package fr.iutvalence.info.dut.m2107;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;

import fr.iutvalence.info.dut.m2107.Calendar.*;
import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;
import fr.iutvalence.info.dut.m2107.Room.*;
import fr.iutvalence.info.dut.m2107.Staff.Rank;
import fr.iutvalence.info.dut.m2107.Staff.Staff;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;
/**
 * Application that launches an IHM, a Calendar and a Room 
 * @author Projet Resto
 *
 */
public class Main {
	
	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		ImageIcon logoIcon = new ImageIcon("img/logoIcon.png");
		Image logo = logoIcon.getImage();
		MainWindow window = null;
		
		Calendar cal = new Calendar();
		Week weeeee = new Week(1);
		try {
			cal.addWeekCalendar(weeeee);
		} catch (WeekAlreadyExistsException e1) {
			e1.printStackTrace();
		}
		Day dai = new Day();
		try {
			weeeee.editDayCalendar(1, dai);
		} catch (DayNotExistsException e1) {
			e1.printStackTrace();
		}
		Service ser = new Service(ServiceType.MIDDAY);
		try {
			dai.setService(ser);
		} catch (RestaurantIsClosedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ser.addWaiter(new Waiter(1, "Jacquie", "michel", Rank.CHIEF));
		} catch (WaiterAllreadyInServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ser.addWaiter(new Waiter(2, "Pierre", "Poulpe", Rank.PADDER));
		} catch (WaiterAllreadyInServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ser.addWaiter(new Waiter(3, "Pikachu", "sacha", Rank.RUNNER));
		} catch (WaiterAllreadyInServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ser.addWaiter(new Waiter(4, "Alfred", "Batman", Rank.RUNNER));
		} catch (WaiterAllreadyInServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		try {
			window = new MainWindow(Room.loadRoom(),cal, new Staff());
			if (window != null)
				window.setIconImage(logo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObjectReadedIsNotARoomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
