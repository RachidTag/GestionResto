package fr.iutvalence.info.dut.m2107;
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
		Waiter Didou = new Waiter("FAYANT", "Dylan", Rank.PADDER);
		
		Table table1 = new Table(1,4,new Position(5,5,0), State.FREE, Progress.NO_PROGRESS);
		Table table2 = new Table(2,2,new Position(1,5,0), State.FREE, Progress.NO_PROGRESS);
		Table table3 = new Table(3,4,new Position(8,10,0), State.FREE, Progress.NO_PROGRESS);
		Table table4 = new Table(4,6,new Position(8,10,0), State.BUSY, Progress.APERITIF);
		
		Room room1 = new Room();
		
		Sector sector1 = new Sector(1, Didou);
		
		try {
			room1.addSector(sector1);
		} catch (SectorAlreadyExistsException e) {
			System.err.println("The sector is already on the room");
			e.printStackTrace();
		}
		
	}

}
