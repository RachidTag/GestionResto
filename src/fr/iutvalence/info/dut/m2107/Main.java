package fr.iutvalence.info.dut.m2107;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import fr.iutvalence.info.dut.m2107.calendar.*;
import fr.iutvalence.info.dut.m2107.room.*;
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
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		//Creation of the Calendar
		Room room = new Room();
		
		// TODO, think about the integration of the IHM
		
		//Creation of waiters
		Waiter Didou = new Waiter("FAYANT", "Dylan", Rank.PADDER);
		Waiter Rachou = new Waiter("TAGHAT", "Rachid", Rank.PADDER);
		Waiter Matou = new Waiter("AUBÉ", "Mathieu", Rank.PADDER);
		Waiter Benou = new Waiter("PALMIER", "Benjamin", Rank.PADDER);
		Waiter test1 = new Waiter("test1","pretest1", Rank.CHIEF);
		
		System.out.println(Didou); 
		
		//Creation of the tables
		Table table11 = null;
		Table table12 = null;
		Table table13 = null;
		Table table14 = null;
		Table table21 = null;
		Table table22 = null;
		Table table23 = null;
		Table table24 = null;
		Table table31 = null;
		Table table32 = null;
		Table table33 = null;
		Table table34 = null;
		Table table41 = null;
		Table table42 = null;
		Table table43 = null;
		Table table44 = null;
		
		try
		{
			table11 = new Table(11,4,new Position(5,5,0), Progress.NO_PROGRESS, State.FREE);
			table12 = new Table(12,2,new Position(1,5,0), Progress.NO_PROGRESS, State.FREE);
			table13 = new Table(13,4,new Position(8,10,0), Progress.NO_PROGRESS, State.FREE);
			table14 = new Table(14,6,new Position(8,10,0), Progress.APERITIF, State.BUSY);
			table21 = new Table(21,4,new Position(5,5,0), Progress.NO_PROGRESS, State.FREE);
			table22 = new Table(22,2,new Position(1,5,0), Progress.NO_PROGRESS, State.FREE);
			table23 = new Table(23,5, new Position(4, 4, 15), "DUPONT");
			table24 = new Table(4,6,new Position(8,10,0), Progress.APERITIF, State.BUSY);
			table31 = new Table(1,4,new Position(5,5,0), Progress.BILL_SETTED, State.BUSY);
			table32 = new Table(2,2,new Position(1,5,0), Progress.NO_PROGRESS, State.FREE);
			table33 = new Table(3,4,new Position(8,10,0), Progress.DESSERT, State.BUSY);
			table34 = new Table(4,6,new Position(8,10,0), Progress.APERITIF, State.BUSY);
			table41 = new Table(1,4,new Position(5,5,0), Progress.NO_PROGRESS, State.FREE);
			table42 = new Table(2,2,new Position(1,5,0), "MARC");
			table43 = new Table(3,4,new Position(8,10,0), Progress.NO_PROGRESS, State.FREE);
			table44 = new Table(4,6,new Position(8,10,0), Progress.APERITIF, State.BUSY);
		}
		catch (ClientNameRequiredException e1)
		{
			System.err.println("Need a name for reserved table.");
			e1.printStackTrace();
		}
		
		//Creation of the room
		Room room1 = new Room();
		
		//Creation of the sectors
		Sector sector1 = new Sector(1, Didou);
		Sector sector2 = new Sector(2, Rachou);
		Sector sector3 = new Sector(3, Matou);
		Sector sector4 = new Sector(4, Benou);
		
		//Set the sectors in the room
		try {
			room1.addSector(sector1);
			room1.addSector(sector2);
			room1.addSector(sector3);
			room1.addSector(sector4);
		} catch (SectorAlreadyExistsException e) {
			System.err.println("A sector is already in the room.");
			e.printStackTrace();
		}
		
		//Set the table in the sector
		try {
			sector1.addTable(table11);
			sector1.addTable(table12);
			sector1.addTable(table13);
			sector1.addTable(table14);
			sector2.addTable(table21);
			sector2.addTable(table22);
			sector2.addTable(table23);
			sector2.addTable(table24);
			sector3.addTable(table31);
			sector3.addTable(table32);
			sector3.addTable(table33);
			sector3.addTable(table34);
			sector4.addTable(table41);
			sector4.addTable(table42);
			sector4.addTable(table43);
			sector4.addTable(table44);
		} catch (TableAlreadyExistsException e) {
			System.err.println("Num of the table allready in the sector");
		}
		
		/*
		 * Système qui va sauvegarder la room en tant qu'objet 
		 * Suivi du système qui va charger la room
		 * Pourra être utile pour l'IHM (on fait notre room, ça la save et on la load ensuite)
		 */
		File saveFile = new File("savingRoom.save");
		if(saveFile.exists())
			saveFile.delete();
		try {
			saveFile.createNewFile();
		} catch (IOException e) {
			// impossible
		}
		
		FileOutputStream saveStream = null;
		try {
			saveStream = new FileOutputStream(saveFile, true);
		} catch (FileNotFoundException e) {
			// impossible
		}
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(saveStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			oos.writeObject(room1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileInputStream loadStream = null;
		try {
			loadStream = new FileInputStream(saveFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(loadStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Object readObject = null;
		try {
			readObject = ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		Room roomReaded = (Room)readObject;
		try {
			System.out.println(roomReaded.getSector(1).getNumSector());
		} catch (SectorNotExistsException e) {
			System.err.println("Error");
		}
		
		//Creation of calendar
		
		Calendar calendar = new Calendar();
		
		//Creation of weeks
		
		Week week20 = new Week(20);
		Week week21 = new Week(21);
		Week week22 = new Week(22);

		Day monday = new Day();
		monday.isClosed();
		Day tuesday = new Day();
		Day wednesday = new Day();
		Day thursday = new Day();
		Day friday = new Day();
		Day saturday = new Day();
		Day sunday = new Day();
		
		//Add weeks to calendar
		try {
			calendar.addWeekCalendar(week20);
			calendar.addWeekCalendar(week21);
			calendar.addWeekCalendar(week22);
		} catch (WeekAlreadyExistsException e1) {
			e1.printStackTrace();
		}
		//Edit a week with the day
		try {
			week20.editDayCalendar(1, monday);
			week20.editDayCalendar(2, tuesday);
			week20.editDayCalendar(3, wednesday);
			week20.editDayCalendar(4, thursday);
			week20.editDayCalendar(5, friday);
			week20.editDayCalendar(6, saturday);
			week20.editDayCalendar(7, sunday);
		} catch (DayNotExistsException e) {
			e.printStackTrace();
		}
		
		//Creation of services
		Service service1 = new Service(ServiceType.EVENING);
		Service service2 = new Service(ServiceType.MIDDAY);
		try {
			service1.addWaiter(Didou);
			service1.addCleanerWaiter(Rachou);
			service1.addCleanerWaiter(Matou);
			service1.addCleanerWaiter(Benou);
			service2.addWaiter(Didou);
			service2.addCleanerWaiter(Matou);
			service2.addWaiter(Rachou);
		} catch (WaiterAllreadyInServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(service1);
		System.out.println(service2);
		
		//Add services for a day
		try {
			tuesday.setService(service1);
			wednesday.setService(service1);
			thursday.setService(service1);
			friday.setService(service1);
			saturday.setService(service2);
			sunday.setService(service2);
		} catch (RestaurantIsClosedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
