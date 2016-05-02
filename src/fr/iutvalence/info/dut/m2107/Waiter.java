package fr.iutvalence.info.dut.m2107;

import fr.iutvalence.info.dut.m2107.room.Rank;
import fr.iutvalence.info.dut.m2107.room.Sector;

/**
 * Represents a waiter
 * @author Projet Resto
 *
 */
public class Waiter {
	/**
	 * common Auto-incrementing ID
	 */
	private static int autoIncrementID = 1;
	/**
	 * The ID number of the waiter
	 */
	private final int id;
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
	private Sector aSector = null;
	
	/**
	 * Create a new waiter
	 * @param lastName String the last name of the waiter  
	 * @param firstName String first name og the waiter
	 * @param rank the rank of the waiter
	 */
	public Waiter(String lastName, String firstName, Rank rank){
		this.id = Waiter.autoIncrementID++;
		this.lastName = lastName;
		this.firstName = firstName;
		this.rank = rank;
	}
	
	/**
	 * Create a new waiter with a sector
	 * @param lastName String the last name of the waiter  
	 * @param firstName String first name og the waiter
	 * @param rank the rank of the waiter
	 * @param sector the padder' sector
	 */
	public Waiter(String lastName, String firstName, Rank rank, Sector sector){
		this.id = Waiter.autoIncrementID++;
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
	 * Get the waiter's ID
	 * @return id int
	 */
	public int getId()
	{
		return this.id;
	}
}
