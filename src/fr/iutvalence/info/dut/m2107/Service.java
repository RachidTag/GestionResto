package fr.iutvalence.info.dut.m2107;

import java.util.HashSet;
import java.util.Set;

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
	
	// TODO add/remove method for cleaner waiter list
}
