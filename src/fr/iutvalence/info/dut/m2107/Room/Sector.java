package fr.iutvalence.info.dut.m2107.Room;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.iutvalence.info.dut.m2107.Staff.Rank;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;
import fr.iutvalence.info.dut.m2107.Staff.WaiterIsNotAPadderException;

/**
 * Represent the Sector
 * @author Projet Resto
 */
public class Sector implements Serializable
{
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
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
	 * @throws ATableIsAlreadyInThisPositionException 
	 */
	public void addTable(Table table) throws TableAlreadyExistsException, ATableIsAlreadyInThisPositionException{
		if(this.tables.containsValue(table)) throw new TableAlreadyExistsException();
		for(Table aTable : this.tables.values())
		{
			if(aTable.getPosition().equals(table.getPosition())) throw new ATableIsAlreadyInThisPositionException();
		}
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
	 * @throws WaiterIsNotAPadderException 
	 */
	public void setPadder(Waiter padder) throws WaiterIsNotAPadderException{
		if (padder.getRank() != Rank.PADDER) throw new WaiterIsNotAPadderException();
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
	 * Get the tables list
	 * @param numTable int
	 * @return Table
	 * @throws TableNotExistsException 
	 */
	public Map<Integer, Table> getTables(){
		return this.tables;
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
	 * Return the 1st free index of the list of table
	 * @return int the 1st free index
	 */
	public int findFirstFreeIndex(){
		if(this.tables == null) return 1;
		int index = 1;
		while(index <= this.tables.size()){
			if(!this.tables.containsKey(index)) break;
			index++;
		}
		return index;
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
