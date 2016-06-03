package fr.iutvalence.info.dut.m2107;
import java.awt.Image;
import javax.swing.ImageIcon;

import fr.iutvalence.info.dut.m2107.Calendar.*;
import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;
import fr.iutvalence.info.dut.m2107.Room.ATableIsAlreadyInThisPositionException;
import fr.iutvalence.info.dut.m2107.Room.ClientNameRequiredException;
import fr.iutvalence.info.dut.m2107.Room.Position;
import fr.iutvalence.info.dut.m2107.Room.Progress;
import fr.iutvalence.info.dut.m2107.Room.Room;
import fr.iutvalence.info.dut.m2107.Room.Sector;
import fr.iutvalence.info.dut.m2107.Room.SectorAlreadyExistsException;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Room.State;
import fr.iutvalence.info.dut.m2107.Room.Table;
import fr.iutvalence.info.dut.m2107.Room.TableAlreadyExistsException;
import fr.iutvalence.info.dut.m2107.Staff.Rank;
import fr.iutvalence.info.dut.m2107.Staff.Staff;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;
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
		Week week1 = null;
		try {
			week1 = new Week(1);
		} catch (InvalidWeekException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		try {
			cal.addWeekCalendar(week1);
		} catch (WeekAlreadyExistsException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		Staff staf = new Staff();
		staf.addWaiter(new Waiter(1, "Fayant", "Dylan" , Rank.CHIEF));
		staf.addWaiter(new Waiter(2, "Lorette", "Theo" , Rank.PADDER));
		staf.addWaiter(new Waiter(3, "Palmier", "Benjamin" , Rank.RUNNER));
		staf.addWaiter(new Waiter(4, "Aubé", "Mathieu" , Rank.PADDER));
		staf.addWaiter(new Waiter(5, "Taghat", "Rachid" , Rank.RUNNER));
		staf.addWaiter(new Waiter(6, "Brisac", "Alfred" , Rank.RUNNER));
		staf.addWaiter(new Waiter(7, "Prades", "Mickael" , Rank.RUNNER));
		staf.addWaiter(new Waiter(8, "di Valentin", "Olivia" , Rank.PADDER));
		staf.addWaiter(new Waiter(9, "Jean", "Sebastien" , Rank.PADDER));
		staf.addWaiter(new Waiter(10, "Rotteleur", "Pierre" , Rank.RUNNER));

		Day dai = new Day();
		Day dai3 = new Day();
		dai3.setClosed(true);
		try {
			week1.editDayCalendar(1, dai);
			week1.editDayCalendar(3, dai3);
		} catch (DayNotExistsException e1) {
			e1.printStackTrace();
		}
		Day dai2 = new Day();
		try {
			week1.editDayCalendar(2, dai2);
		} catch (DayNotExistsException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Service ser = new Service(ServiceType.MIDDAY);
		try {
			dai.setService(ser);
		} catch (RestaurantIsClosedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Service ser2 = new Service(ServiceType.EVENING);
		try {
			dai.setService(ser2);
		} catch (RestaurantIsClosedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ser.addCleanerWaiter(staf.getWaiter(6));
		} catch (WaiterAllreadyInServiceException | WaiterDoesNotExistException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
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
			ser2.addWaiter(staf.getWaiter(5));
		} catch (WaiterAllreadyInServiceException | WaiterDoesNotExistException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ser2.addWaiter(staf.getWaiter(9));
		} catch (WaiterAllreadyInServiceException | WaiterDoesNotExistException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ser2.addWaiter(staf.getWaiter(10));
		} catch (WaiterAllreadyInServiceException | WaiterDoesNotExistException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ser2.addCleanerWaiter(staf.getWaiter(8));
		} catch (WaiterAllreadyInServiceException | WaiterDoesNotExistException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Room theRoom = new Room();
		
		try {
			theRoom.addSector(new Sector(1,staf.getWaiter(2)));
			theRoom.addSector(new Sector(2,staf.getWaiter(4)));
			theRoom.addSector(new Sector(3,staf.getWaiter(8)));
			theRoom.addSector(new Sector(4,staf.getWaiter(9)));
		} catch (SectorAlreadyExistsException | WaiterDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			theRoom.getSector(1).addTable(new Table(1, 4, new Position(0,0,1), "Dupond"));
			theRoom.getSector(1).addTable(new Table(2, 2, new Position(1,1,2),Progress.APERITIF, State.BUSY));
			theRoom.getSector(1).addTable(new Table(3, 6, new Position(2,1,1),Progress.NO_PROGRESS,State.GRIMY));
			theRoom.getSector(1).addTable(new Table(4, 2, new Position(2,3,2), "Jean"));
			theRoom.getSector(2).addTable(new Table(1, 4, new Position(0,0,1), Progress.NO_PROGRESS, State.FREE));
			theRoom.getSector(2).addTable(new Table(2, 4, new Position(1,2,2),Progress.APERITIF, State.BUSY));
			theRoom.getSector(2).addTable(new Table(3, 6, new Position(2,1,1),Progress.NO_PROGRESS,State.GRIMY));
			theRoom.getSector(2).addTable(new Table(4, 6, new Position(3,3,2), "Jean"));
			theRoom.getSector(3).addTable(new Table(1, 4, new Position(0,0,1), "Dupond"));
			theRoom.getSector(3).addTable(new Table(2, 2, new Position(1,0,2),Progress.NO_PROGRESS, State.FREE));
			theRoom.getSector(3).addTable(new Table(3, 6, new Position(2,3,1),Progress.NO_PROGRESS,State.GRIMY));
			theRoom.getSector(3).addTable(new Table(4, 2, new Position(3,3,2), "Jean"));
			theRoom.getSector(4).addTable(new Table(1, 2, new Position(1,1,1), "Dupond"));
			theRoom.getSector(4).addTable(new Table(2, 6, new Position(1,3,2),Progress.APERITIF, State.BUSY));
			theRoom.getSector(4).addTable(new Table(3, 2, new Position(2,1,1),Progress.NO_PROGRESS,State.GRIMY));
			theRoom.getSector(4).addTable(new Table(4, 2, new Position(2,2,2), "Jean"));
		} catch (TableAlreadyExistsException | ATableIsAlreadyInThisPositionException | SectorNotExistsException | ClientNameRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		window = new MainWindow(new Restaurant(staf, cal, theRoom));
		if (window != null)
			window.setIconImage(logo);
	}

}
