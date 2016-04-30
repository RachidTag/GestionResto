package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;
import java.util.List;

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
	 * 
	 */
	private List<Service> services = new ArrayList<Service>();
	
	

	/**
	 * Generates a day with default value(s)
	 */
	public Day()
	{
		this.isClosed = false;
		this.services.add(1, new Service(ServiceType.MIDDAY));
		this.services.add(2, new Service(ServiceType.EVENING));
	}

	/**
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
	 * Give the list of services
	 * @param numService the number of the service (1/2)
	 * @return List<Services> a list of services 
	 * @throws ServiceNotExistsException 
	 */
	public Service getServices(int numService) throws ServiceNotExistsException {
		if(this.services.get(numService) == null) throw new ServiceNotExistsException();
		return this.services.get(numService);
	}
	
	/**
	 * Edit a service
	 * @param numService the service we want to edit (1 or 2)
	 * @param service the service we want instead
	 * @throws ServiceNotExistsException 
	 */
	public void editService(int numService, Service service) throws ServiceNotExistsException {
		if(this.services.get(numService) == null) throw new ServiceNotExistsException();
		this.services.set(numService, service);
	}

}
