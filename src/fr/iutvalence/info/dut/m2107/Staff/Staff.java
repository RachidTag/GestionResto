package fr.iutvalence.info.dut.m2107.Staff;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * Rpresent all the staff of the restaurant
 * @author Projet Resto
 */
public class Staff implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Set of waiter : the staff
	 */
	private Map<Integer, Waiter> waiters;
	
	
	/**
	 * Generates an empty staff
	 */
	public Staff(){
		this.waiters = new HashMap<Integer, Waiter>();
	}
	
	/**
	 * Get all the waiters
	 * @return waiters Map<Integer, Waiter>
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
	 * @throws WaiterAlreadyExistsException 
	 */
	public void addWaiter(Waiter waiter) throws WaiterAlreadyExistsException{
		if(this.waiters.containsValue(waiter)) throw new WaiterAlreadyExistsException();
		if(this.waiters.containsKey(waiter.getNumWaiter())) throw new WaiterAlreadyExistsException();
		this.waiters.put(waiter.getNumWaiter(), waiter);
	}
	
	/**
	 * edit an unique Waiter
	 * @param numWaiter a num of Sector
	 * @param waiter Waiter
	 * @throws WaiterDoesNotExistException 
	 */
	public void editWaiter(int numWaiter, Waiter waiter) throws WaiterDoesNotExistException{
		if(!this.waiters.containsKey(numWaiter)) throw new WaiterDoesNotExistException();
		this.waiters.put(numWaiter, waiter);
	}

	/**
	 * delete a waiters
	 * @param numWaiter int 
	 * @throws WaiterDoesNotExistException 
	 */
	public void deleteWaiter(int numWaiter) throws WaiterDoesNotExistException{
		if(!this.waiters.containsKey(numWaiter)) throw new WaiterDoesNotExistException();
		this.waiters.remove(numWaiter);
	}
	
	/**
	 * Return the 1st free index of the list of waiter
	 * @return int the 1st free index
	 */
	public int findFirstFreeIndex(){
		if(this.waiters == null) return 1;
		int index = 1;
		while(index <= this.waiters.size()){
			if(!this.waiters.containsKey(index)) break;
			index++;
		}
		return index;
	}
	
	/**
	 * Redefine equals method for containsValue method
	 * @param 
	 * @return bool
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		return true;
	}	
}
