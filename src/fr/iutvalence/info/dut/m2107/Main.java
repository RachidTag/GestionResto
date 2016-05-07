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
		Calendar calendar = new Calendar();
		Room room = new Room();
		// TODO, think about the integration of the IHM
		
		//Test of the main
		
		//Creation of waiters
		Waiter Didou = new Waiter("FAYANT", "Dylan", Rank.PADDER);
		Waiter Rachou = new Waiter("TAGHAT", "Rachid", Rank.PADDER);
		Waiter Matou = new Waiter("AUBÉ", "Mathieu", Rank.PADDER);
		Waiter Benou = new Waiter("PALMIER", "Benjamin", Rank.PADDER);
		Waiter test1 = new Waiter("test1","pretest1", Rank.CHIEF);
		
		System.out.println(Didou);
		
		//Creation of the tables
		Table table1 = null;
		Table table2 = null;
		Table table3 = null;
		Table table4 = null;
		
		try
		{
			table1 = new Table(1,4,new Position(5,5,0), Progress.NO_PROGRESS, State.FREE);
			table2 = new Table(2,2,new Position(1,5,0), Progress.NO_PROGRESS, State.FREE);
			table3 = new Table(3,4,new Position(8,10,0), Progress.NO_PROGRESS, State.FREE);
			table4 = new Table(4,6,new Position(8,10,0), Progress.APERITIF, State.BUSY);
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
		
		try {
			sector1.addTable(table1);
			sector1.addTable(table2);
			sector1.addTable(table3);
			sector1.addTable(table4);
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
		
		//Creation of services
		Service service1 = new Service(ServiceType.EVENING);
		Service service2 = new Service(ServiceType.MIDDAY);
		service1.addWaiter(Didou);
		service1.addCleanerWaiter(Rachou);
		service1.addCleanerWaiter(Matou);
		service1.addCleanerWaiter(Benou);
		System.out.println(service1);
	}

}
