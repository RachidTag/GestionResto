package fr.iutvalence.info.dut.m2107.room;

import java.util.ArrayList;
import java.util.List;

import fr.iutvalence.info.dut.m2107.Waiter;

/**
 * Represent the Sector
 * @author Projet Resto
 */
public class Sector
{
	/**
	 * Number of the sector
	 */
	private final int numSector;
	/**
	 * A padder assigned to a sector
	 */
	private Waiter padder;
	/**
	 * List of tables
	 */
	private List<Table> tables = new ArrayList<Table>();
	
	/**
	 * Create a new instance of Sector
	 * @param numSector int
	 * @param padder Waiter
	 */
	public Sector(int numSector, Waiter padder){
		this.numSector = numSector;
		this.padder = padder;
		this.tables = null;
	}
	/**
	 * Add a table to a sector
	 * @param table Table
	 * @throws TableAlreadyExistsException 
	 */
	public void addTable(Table table) throws TableAlreadyExistsException{
		if(this.tables.get(table.getNumTable())!= null) throw new TableAlreadyExistsException();
		this.tables.add(table.getNumTable(), table);
	}
	/**
	 * Remove a table from the sector
	 * @param numTable int
	 * @throws TableNotExistsException 
	 */
	public void removeTable(int numTable) throws TableNotExistsException{
		if(this.tables.get(numTable)== null) throw new TableNotExistsException();
		this.tables.remove(numTable);
	}
	/**
	 * Edit the current padder
	 * @param padder Waiter
	 */
	public void editPadder(Waiter padder){
		this.padder = padder;
	}
	/**
	 * Get a table from the list
	 * @param numTable int
	 * @return Table
	 * @throws TableNotExistsException 
	 */
	public Table getTable(int numTable) throws TableNotExistsException{
		if(this.tables.get(numTable)== null) throw new TableNotExistsException();
		return this.tables.get(numTable);
	}
	/**
	 * Get the number of the sector
	 * @return numSector int
	 */
	public int getNumSector() {
		return numSector;
	}
	
}
