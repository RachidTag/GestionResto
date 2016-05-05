package fr.iutvalence.info.dut.m2107.calendar;

/**
 * Represents a day in a week
 * @author Projet Resto
 *
 */
public class Day {
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

}
