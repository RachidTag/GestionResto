package fr.iutvalence.info.dut.m2107;

import java.io.Serializable;

import fr.iutvalence.info.dut.m2107.room.Sector;

/**
 * Represents a waiter
 * @author Projet Resto
 *
 */
public class Waiter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The last name of the waiter
	 */
	private String lastName;
	/**
	 * The first name of the waiter
	 */
	private String firstName;
	/**
	 * The rank of the waiter
	 */
	private Rank rank;
	/**
	 * If the waiter is a padder, his sector
	 */
	private Sector aSector;
	
	/**
	 * Create a new waiter
	 * @param lastName String the last name of the waiter  
	 * @param firstName String first name og the waiter
	 * @param rank the rank of the waiter
	 */
	public Waiter(String lastName, String firstName, Rank rank){
		this.lastName = lastName;
		this.firstName = firstName;
		this.rank = rank;
		this.aSector = null;
	}
	
	/**
	 * Create a new waiter with a sector
	 * @param lastName String the last name of the waiter  
	 * @param firstName String first name og the waiter
	 * @param rank the rank of the waiter
	 * @param sector the padder' sector
	 */
	public Waiter(String lastName, String firstName, Rank rank, Sector sector){
		this.lastName = lastName;
		this.firstName = firstName;
		this.rank = rank;
		this.aSector = sector;
	}

	/**
	 * Get the waiter's last name
	 * @return lastName String
	 */
	public String getLastName()
	{
		return this.lastName;
	}

	/**
	 * Edit the waiter's last name
	 * @param lastName
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * Get the waiter's first name
	 * @return firstName String
	 */
	public String getFirstName()
	{
		return this.firstName;
	}

	/**
	 * Set the waiter's first name
	 * @param firstName String
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Get the waiter's rank
	 * @return rank Rank
	 */
	public Rank getRank()
	{
		return this.rank;
	}

	/**
	 * Set the waiter's rank
	 * @param rank Rank
	 */
	public void setRank(Rank rank)
	{
		this.rank = rank;
	}
	
	/**
	 * Get the padder's sector (null if no sector)
	 * @return aSector
	 */
	public Sector getaSector() {
		return this.aSector;
	}
	
	/**
	 * Set a sector to a padder
	 * @param aSector
	 * @throws WaiterIsNotAPadderException 
	 */
	public void setaSector(Sector aSector) throws WaiterIsNotAPadderException {
		if(this.rank != Rank.PADDER) throw new WaiterIsNotAPadderException();
		this.aSector = aSector;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[lastName=" + lastName + ", firstName=" + firstName + ", rank=" + rank + ", aSector=" + aSector
				+ "]";
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waiter other = (Waiter) obj;
		if (this.firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!this.firstName.equals(other.firstName))
			return false;
		if (this.lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!this.lastName.equals(other.lastName))
			return false;
		return true;
	}
}
