package fr.iutvalence.info.dut.m2107.Calendar;

import java.io.Serializable;

/**
 * The type of service
 * @author Projet Resto
 *
 */
public enum ServiceType implements Serializable {
	/**
	 * Midday service
	 */
	MIDDAY(0),
	
	/**
	 * Evening service
	 */
	EVENING(1);
	
	/**
	 * The number of the service in the day's table
	 */
	private int numService;
	
	/**
	 * Generates the service type with the good numService
	 * @param numService
	 */
	private ServiceType(int numService)
	{
		this.numService = numService;
	}
	
	/**
	 * Returns the num service, used for the table in the day class
	 * @return numService
	 */
	public int getNumService()
	{
		return this.numService;
	}
}
