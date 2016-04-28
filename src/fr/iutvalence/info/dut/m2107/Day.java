package fr.iutvalence.info.dut.m2107;

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
	
	// TODO : The services
	
	/**
	 * Generates a day with default value(s)
	 */
	public Day()
	{
		this.isClosed = false;
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
	
	

}
