package fr.iutvalence.info.dut.m2107.Calendar;

import java.io.Serializable;

/**
 * Represents a day in a week
 * @author Projet Resto
 *
 */
public class Day implements Serializable {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * If the restaurant is closed today
	 */
	private boolean isClosed;
	
	/**
	 * A table of the two services for the day
	 */
	private Service[] services;

	/**
	 * Generates a day with default value(s)
	 */
	public Day()
	{
		this.isClosed = false;
		this.services = new Service[2];
		this.services[0] = new Service(ServiceType.MIDDAY);
		this.services[1] = new Service(ServiceType.EVENING);
	}

	/**
	 * Return true if the restaurant is closed today
	 * @return true if the restaurant is closed, false if it's not
	 */
	public boolean isClosed() {
		return this.isClosed;
	}

	/**
	 * Set the state of the restaurant
	 * @param isClosed
	 */
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	
	/**
	 * Give the chosen service from the day
	 * @param serviceType the service's type
	 * @return Service the service
	 */
	public Service getService(ServiceType serviceType) {
		return this.services[serviceType.getNumService()];
	}
	
	/**
	 * Set a service for the day
	 * @param serviceType
	 * @param service
	 * @throws RestaurantIsClosedException 
	 */
	public void setService(Service service) throws RestaurantIsClosedException{
		if (this.isClosed) throw new RestaurantIsClosedException();
		this.services[service.getServiceType().getNumService()] = service;
	} 

}
