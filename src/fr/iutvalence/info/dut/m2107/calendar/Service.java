package fr.iutvalence.info.dut.m2107.calendar;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import fr.iutvalence.info.dut.m2107.Waiter;

/**
 * This class describe a service
 * @author Projet Resto
 */

public class Service implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A set of waiters
	 */
	private Set<Waiter> waiters;
	
	/**
	 * A set of cleaner waiters
	 */
	private Set<Waiter> cleanerWaiter;
	
	/**
	 * The type of service (
	 */
	private ServiceType serviceType;
	
	/**
	 * Generates a Service with a type
	 * @param serviceType (ServiceType.MIDI or SOIR)
	 */
	public Service(ServiceType serviceType) {
		this.waiters = new HashSet<Waiter>();
		this.cleanerWaiter = new HashSet<Waiter>();
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
	 */
	public void addWaiter(Waiter waiter) {
		this.waiters.add(waiter);
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
	 */
	public void addCleanerWaiter(Waiter waiter) {
		this.cleanerWaiter.add(waiter);
	}
	
	/**
	 * Remove a waiter from the list of cleaner waiter
	 * @param waiter the waiter we want to remove from the list of waiter
	 */
	public void removeCleanerWaiter(Waiter waiter) {
		this.cleanerWaiter.remove(waiter);
	}
	
	/**
	 * Get the Set of all the waiters
	 * @return the set
	 */
	public Set<Waiter> getAllWaiters() {
		Set<Waiter> allWaiters = new HashSet<Waiter>();

		Iterator<Waiter> waitersIterator = this.waiters.iterator();
		while(waitersIterator.hasNext())
		{
			allWaiters.add(waitersIterator.next());
		}
		Iterator<Waiter> cleanersIterator = this.cleanerWaiter.iterator();
		while(cleanersIterator.hasNext())
		{
			allWaiters.add(cleanersIterator.next());
		}
		
		return allWaiters;
	}
	
	/**
	 * Return the list of the waiters
	 * @return a set of waiters
	 */
	public Set<Waiter> getWaiters() {
		return this.waiters;
	}
	
	/**
	 * Return the list of the cleaner waiters
	 * @return a set of waiters
	 */
	public Set<Waiter> getCleanerWaiters() {
		return this.cleanerWaiter;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String theString = "";
		theString += this.getServiceType() + "\n";
		theString += "Waiters: ";
		Iterator<Waiter> theIterator = this.waiters.iterator();
		while(theIterator.hasNext())
		{
			theString += theIterator.next() + ", ";
		}
		theString += "\nCleaner waiters: ";
		theIterator = this.cleanerWaiter.iterator();
		while(theIterator.hasNext())
		{
			theString += theIterator.next() + ", ";
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
		Iterator<Waiter> theIterator = this.waiters.iterator();
		while(theIterator.hasNext())
		{
			theString += theIterator.next() + ", ";
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
		 Iterator<Waiter> theIterator = this.cleanerWaiter.iterator();
		 while(theIterator.hasNext())
		 {
		 	theString += theIterator.next() + ", ";
		 }
		 return theString;	
	 }
	
}
