package fr.iutvalence.info.dut.m2107.Calendar;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fr.iutvalence.info.dut.m2107.Staff.Waiter;

/**
 * This class describe a service
 * @author Projet Resto
 */

public class Service implements Serializable {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A set of waiters
	 */
	private Map<Integer,Waiter> waiters;
	
	/**
	 * A set of cleaner waiters
	 */
	private Map<Integer,Waiter> cleanerWaiters;
	
	/**
	 * The type of service (
	 */
	private ServiceType serviceType;
	
	/**
	 * Generates a Service with a type
	 * @param serviceType (ServiceType.MIDI or SOIR)
	 */
	public Service(ServiceType serviceType) {
		this.waiters = new HashMap<Integer,Waiter>();
		this.cleanerWaiters = new HashMap<Integer,Waiter>();
		this.serviceType = serviceType;
	}
	
	/**
	 * Returns the type of the service
	 * @return ServiceType
	 */
	public ServiceType getServiceType() {
		return this.serviceType;
	}
	
	/**
	 * Set the type of the service
	 * @param serviceType
	 */
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * Add a waiter to the list of waiter
	 * @param waiter the waiter we want to add to the list
	 * @throws WaiterAllreadyInServiceException 
	 */
	public void addWaiter(Waiter waiter) throws WaiterAllreadyInServiceException {
		if(this.cleanerWaiters.containsValue(waiter) || this.waiters.containsValue(waiter)) throw new WaiterAllreadyInServiceException();
		this.waiters.put(waiter.getNumWaiter(), waiter);
	}
	
	/**
	 * Remove a waiter from the list of waiter
	 * @param waiter the waiter we want to remove from the list of waiter
	 */
	public void removeWaiter(Waiter waiter) {
		this.waiters.remove(waiter);
	}
	
	/**
	 * Add a waiter to the list of cleaner waiter
	 * @param waiter the waiter we want to add to the list
	 * @throws WaiterAllreadyInServiceException 
	 */
	public void addCleanerWaiter(Waiter waiter) throws WaiterAllreadyInServiceException {
		if(this.cleanerWaiters.containsValue(waiter) || this.waiters.containsValue(waiter)) throw new WaiterAllreadyInServiceException();
		this.cleanerWaiters.put(waiter.getNumWaiter(),waiter);
	}
	
	/**
	 * Remove a waiter from the list of cleaner waiter
	 * @param waiter the waiter we want to remove from the list of waiter
	 */
	public void removeCleanerWaiter(Waiter waiter) {
		this.cleanerWaiters.remove(waiter);
	}
	
	/**
	 * Get the Set of all the waiters
	 * @return the set
	 */
	public Map<Integer, Waiter> getAllWaiters() {
		Map<Integer,Waiter> allWaiters = new HashMap<Integer,Waiter>();

		for(Entry<Integer, Waiter> waiter : this.waiters.entrySet())
		{
			allWaiters.put(waiter.getKey(),waiter.getValue());
		}
		for(Entry<Integer, Waiter> cleanerWaiter : this.cleanerWaiters.entrySet())
		{
			allWaiters.put(cleanerWaiter.getKey(),cleanerWaiter.getValue());
		}
		
		return allWaiters;
	}
	
	/**
	 * Return the list of the waiters
	 * @return a set of waiters
	 */
	public Map<Integer,Waiter> getWaiters() {
		return this.waiters;
	}
	
	/**
	 * Return the list of the cleaner waiters
	 * @return a set of waiters
	 */
	public Map<Integer,Waiter> getCleanerWaiters() {
		return this.cleanerWaiters;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String theString = "";
		theString += this.getServiceType() + "\n";
		theString += "Waiters: ";
		for(Entry<Integer, Waiter> waiter : this.waiters.entrySet())
		{
			theString += waiter.getValue() + ", ";
		}
		theString += "\nCleaner waiters: ";
		for(Entry<Integer, Waiter> cleanerWaiter : this.cleanerWaiters.entrySet())
		{
			theString += cleanerWaiter.getValue() + ", ";
		}
		return theString;	
	}
	
	/**
	 * To string for the set of waiters
	 * @return String
	 */
	public String waitersToString(){
		String theString = "";
		theString += "Waiters: ";
		for(Entry<Integer, Waiter> waiter : this.waiters.entrySet())
		{
			theString += waiter.getValue() + ", ";
		}
		return theString;
	}
	
	/**
	 * To string for the set of cleaner waiters
	 * @return String
	 */
	 public String cleanerWaitersToString(){
		 String theString = "";
		 theString += "Cleaner waiters: ";
		 for(Entry<Integer, Waiter> cleanerWaiter : this.cleanerWaiters.entrySet())
		 {
		 	theString += cleanerWaiter.getValue() + ", ";
		 }
		 return theString;	
	 }
	
}
