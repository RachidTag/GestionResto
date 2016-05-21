package fr.iutvalence.info.dut.m2107;

import java.util.HashMap;
import java.util.Map;

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
	 * @param waiter Sector
	 * @throws SectorAlreadyExistsException 
	 */
	public void addSector(Waiter waiter) throws SectorAlreadyExistsException{
		if(this.waiters.containsValue(waiter)) throw new SectorAlreadyExistsException();
		this.waiters.put(waiter.getNumWaiter(), waiter);
	}
	
}
