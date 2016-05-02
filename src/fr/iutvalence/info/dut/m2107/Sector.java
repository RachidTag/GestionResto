package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the Sector
 * @author Projet Resto
 */
public class Sector
{
	/**
	 * Auto-Incrementation number
	 */
	private static int autoIncrementation = 1;
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
	private List<Table> tables= new ArrayList<Table>();
	
	/**
	 * Create a new instance of Sector
	 * @param padder Waiter
	 * @param tables List<Tables>
	 */
	public Sector(Waiter padder, List<Table> tables){
		this.numSector = autoIncrementation++;
		this.padder = padder;
		this.tables = tables;
	}
	/**
	 * Add a table to a sector
	 * @param numTable int
	 * @param table Table
	 * @throws TableAlreadyExistsException 
	 */
	public void addTable(int numTable, Table table) throws TableAlreadyExistsException{
		if(this.tables.get(numTable)== null) throw new TableAlreadyExistsException();
		this.tables.add(numTable, table);
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
}
