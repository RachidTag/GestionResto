package fr.iutvalence.info.dut.m2107.room;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.iutvalence.info.dut.m2107.Waiter;

/**
 * Represent the Sector
 * @author Projet Resto
 */
public class Sector implements Serializable
{
	/**
	 * Number of the sector
	 */
	private final int numSector;
	/**
	 * A padder assigned to a sector
	 */
	@SuppressWarnings("unused")
	private Waiter padder;
	/**
	 * List of tables
	 */
	private Map<Integer, Table> tables;
	
	/**
	 * Create a new instance of Sector
	 * @param numSector int
	 * @param padder Waiter
	 */
	public Sector(int numSector, Waiter padder){
		this.numSector = numSector;
		this.padder = padder;
		this.tables = new HashMap<Integer, Table>();
	}
	/**
	 * Add a table to a sector
	 * @param table Table
	 * @throws TableAlreadyExistsException 
	 */
	public void addTable(Table table) throws TableAlreadyExistsException{
		if(this.tables.containsValue(table)) throw new TableAlreadyExistsException();
		this.tables.put(table.getNumTable(), table);
	}
	/**
	 * Remove a table from the sector
	 * @param numTable int
	 * @throws TableNotExistsException 
	 */
	public void removeTable(int numTable) throws TableNotExistsException{
		if(!this.tables.containsKey(numTable)) throw new TableNotExistsException();
		this.tables.remove(numTable);
	}
	/**
	 * Edit the current padder
	 * @param padder Waiter
	 */
	public void setPadder(Waiter padder){
		this.padder = padder;
	}
	/**
	 * Get a table from the list
	 * @param numTable int
	 * @return Table
	 * @throws TableNotExistsException 
	 */
	public Table getTable(int numTable) throws TableNotExistsException{
		if(!this.tables.containsKey(numTable)) throw new TableNotExistsException();
		return this.tables.get(numTable);
	}
	
	/**
	 * Get the number of the sector
	 * @return numSector int
	 */
	public int getNumSector() {
		return this.numSector;
	}
	
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.numSector;
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
		if (this.getClass() != obj.getClass())
			return false;
		Sector other = (Sector) obj;
		if (this.numSector != other.numSector)
			return false;
		return true;
	}	
}
