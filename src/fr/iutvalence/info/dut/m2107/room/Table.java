package fr.iutvalence.info.dut.m2107.room;
/**
 * Represent a table
 * @author Projet Resto
 */
public class Table
{
	/**
	 * Auto-Incrementation number
	 */
	private static int autoIncrementation = 1;
	/**
	 * Number of the table
	 */
	private final int numTable;
	/**
	 * Number of places for the table
	 */
	private int numberPlaces;
	/**
	 * Position of the table in the sector
	 */
	private Position position;
	/**
	 * State of the table
	 */
	private State state;
	/**
	 * Progress of the meal
	 */
	private Progress progress;
	
}
