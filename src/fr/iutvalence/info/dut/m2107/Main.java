package fr.iutvalence.info.dut.m2107;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;

import fr.iutvalence.info.dut.m2107.Calendar.*;
import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;
import fr.iutvalence.info.dut.m2107.Room.*;
import fr.iutvalence.info.dut.m2107.Staff.Staff;
import fr.iutvalence.info.dut.m2107.Staff.WaiterAlreadyExistsException;
import fr.iutvalence.info.dut.m2107.Staff.WaiterDoesNotExistException;
/**
 * Application that launches an IHM, a Calendar and a Room 
 * @author Projet Resto
 *
 */
public class Main {
	
	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 * @throws WaiterAlreadyExistsException 
	 */
	public static void main(String[] args) throws WaiterAlreadyExistsException {
		ImageIcon logoIcon = new ImageIcon("img/logoIcon.png");
		Image logo = logoIcon.getImage();
		MainWindow window = null;
		
		Calendar cal = new Calendar();
		Week week1 = new Week(1);
		try {
			cal.addWeekCalendar(week1);
		} catch (WeekAlreadyExistsException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		Staff staf = null;
		try {
			staf = Staff.loadStaff();
		} catch (ObjectReadedIsNotARoomException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (WaiterAlreadyExistsException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Day dai = new Day();
		try {
			week1.editDayCalendar(1, dai);
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
			ser.addWaiter(staf.getWaiter(2));
		} catch (WaiterAllreadyInServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WaiterDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ser.addWaiter(staf.getWaiter(5));
		} catch (WaiterAllreadyInServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WaiterDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ser.addWaiter(staf.getWaiter(7));
		} catch (WaiterAllreadyInServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WaiterDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ser.addWaiter(staf.getWaiter(8));
		} catch (WaiterAllreadyInServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WaiterDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			window = new MainWindow(Room.loadRoom(), cal, Staff.loadStaff());
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
