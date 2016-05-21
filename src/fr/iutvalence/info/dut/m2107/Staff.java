package fr.iutvalence.info.dut.m2107;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import fr.iutvalence.info.dut.m2107.room.ObjectReadedIsNotARoomException;
import fr.iutvalence.info.dut.m2107.room.Room;
import fr.iutvalence.info.dut.m2107.room.Sector;
import fr.iutvalence.info.dut.m2107.room.SectorAlreadyExistsException;
import fr.iutvalence.info.dut.m2107.room.SectorNotExistsException;


/**
 * Rpresent all the staff of the restaurant
 * @author Théo
 *
 */
public class Staff {

	/**
	 * Set of waiter : the staff
	 */
	private Map<Integer, Waiter> waiters;
	
	
	/**
	 * Generate an empty staff
	 */
	public Staff(){
		this.waiters = new HashMap<Integer, Waiter>();
	}
	
	/**
	 * Get all the waiters
	 * @return
	 */
	public Map<Integer, Waiter> getStaff(){
		return this.waiters;
	}
	
	/**
	 * Get a unique waiter
	 * @param numWaiter
	 * @return a waiter
	 * @throws WaiterDoesNotExistException
	 */
	public Waiter getWaiter(int numWaiter) throws WaiterDoesNotExistException{
		if(!this.waiters.containsKey(numWaiter)) throw new WaiterDoesNotExistException();
		return this.waiters.get(numWaiter);
	}
	
	/**
	 * Edit list of waiters
	 * @param waiters
	 */
	public void setWaiters(Map<Integer, Waiter> waiters) {
		this.waiters = waiters;
	}
	
	/**
	 * add an unique waiter
	 * @param waiter Waiter
	 * @throws SectorAlreadyExistsException 
	 */
	public void addSector(Waiter waiter) throws SectorAlreadyExistsException{
		if(this.waiters.containsValue(waiter)) throw new SectorAlreadyExistsException();
		this.waiters.put(waiter.getNumWaiter(), waiter);
	}
	
	/**
	 * edit an unique Waiter
	 * @param numWaiter a num of Sector
	 * @param waiter Waiter
	 * @throws WaiterDoesNotExistException 
	 */
	public void editSector(int numWaiter, Waiter waiter) throws WaiterDoesNotExistException{
		if(!this.waiters.containsKey(numWaiter)) throw new WaiterDoesNotExistException();
		this.waiters.put(numWaiter, waiter);
	}

	/**
	 * delete a waiters
	 * @param numWaiter int
	 * @throws WaiterDoesNotExistException 
	 */
	public void deleteSector(int numWaiter) throws WaiterDoesNotExistException{
		if(!this.waiters.containsKey(numWaiter)) throw new WaiterDoesNotExistException();
		this.waiters.remove(numWaiter);
	}
	
	/**
	 * Save the current room to the file savingRoom.save
	 */
	public void saveStaff() {
		saveStaff("savingStaff.save");
	}

	private void saveStaff(String string) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Load a staff from savingStaff.save
	 * @return staffReaded
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ObjectReadedIsNotARoomException
	 */
	public static Room loadStaff() throws FileNotFoundException, IOException, ClassNotFoundException, ObjectReadedIsNotARoomException {
		return loadStaff("savingRoom.save");
	}

	private static Room loadStaff(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
