package fr.iutvalence.info.dut.m2107;

/**
 * Represents a waiter
 * @author Projet Resto
 *
 */
public class Waiter {
	/**
	 * Auto-incrementation ID
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
	 * The first name og the waiter
	 */
	private String firstName;
	/**
	 * The rank of the waiter
	 */
	private Rank rank;
	
	/**
	 * Create a new waiter
	 * @param lastName String the last name of the waiter  
	 * @param firstName String first name og the waiter
	 * @param rank the rank of the waiter
	 */
	public Waiter(String lastName, String firstName, Rank rank){
		this.id = Waiter.autoIncrementID;
		Waiter.autoIncrementID++;
		this.lastName = lastName;
		this.firstName = firstName;
		this.rank = rank;
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
	 * Get the waiter's ID
	 * @return id int
	 */
	public int getId()
	{
		return this.id;
	}
	
	
}
