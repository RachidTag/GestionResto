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
		
		//Creation of waiters
		Waiter Didou = new Waiter("FAYANT", "Dylan", Rank.PADDER);
		Waiter Rachou = new Waiter("TAGHAT", "Rachid", Rank.PADDER);
		Waiter Matou = new Waiter("AUBÉ", "Mathieu", Rank.PADDER);
		Waiter Benou = new Waiter("PALMIER", "Benjamin", Rank.PADDER);
		Waiter test1 = new Waiter("test1","pretest1", Rank.CHIEF);
		
		System.out.println(Didou);
		
		//Creation of the tables
		try
		{
			Table table1 = new Table(1,4,new Position(5,5,0), Progress.NO_PROGRESS, State.FREE);
			Table table2 = new Table(2,2,new Position(1,5,0), Progress.NO_PROGRESS, State.FREE);
			Table table3 = new Table(3,4,new Position(8,10,0), Progress.NO_PROGRESS, State.FREE);
			Table table4 = new Table(4,6,new Position(8,10,0), Progress.APERITIF, State.BUSY);
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
		} catch (SectorAlreadyExistsException e) {
			System.err.println("A sector is already in the room.");
			e.printStackTrace();
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
