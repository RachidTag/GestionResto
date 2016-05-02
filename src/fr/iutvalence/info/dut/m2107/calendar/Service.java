package fr.iutvalence.info.dut.m2107.calendar;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import fr.iutvalence.info.dut.m2107.Waiter;

/**
 * This class describe a service
 * @author Projet Resto
 */

public class Service {

	
	/**
	 * A list of waiter
	 */
	private Set<Waiter> waiter = new HashSet<Waiter>();
	
	/**
	 * A list of cleaner waiter
	 */
	private Set<Waiter> cleanerWaiter = new HashSet<Waiter>();
	
	/**
	 * The type of service (
	 */
	private ServiceType serviceType;
	
	/**
	 * Generates a Service with a type
	 * @param serviceType (ServiceType.MIDI or SOIR)
	 */
	public Service(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	
	/**
	 * Returns the type of the service
	 * @return ServiceType
	 */
	public ServiceType getServiceType() {
		return serviceType;
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
		this.waiter.add(waiter);
	}
	
	/**
	 * Remove a waiter from the list of waiter
	 * @param waiter the wiater we want to remove from the list of waiter
	 */
	public void removeWaiter(Waiter waiter) {
		this.waiter.remove(waiter);
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
	 * @param waiter the wiater we want to remove from the list of waiter
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

		Iterator<Waiter> waitersIterator = this.waiter.iterator();
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
		return this.waiter;
	}
	
	/**
	 * Return the list of the cleaner waiters
	 * @return a set of waiters
	 */
	public Set<Waiter> getCleanerWaiters() {
		return this.cleanerWaiter;
	}
}
