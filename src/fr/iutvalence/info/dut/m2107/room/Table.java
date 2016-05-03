package fr.iutvalence.info.dut.m2107.room;
/**
 * Represent a table
 * @author Projet Resto
 */
public class Table
{
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
	
	/**
	 * Create an instance of table
	 * @param numTable
	 * @param numberPlaces
	 * @param position
	 * @param state
	 * @param progress
	 */
	public Table(int numTable, int numberPlaces, Position position,
			State state, Progress progress) {
		this.numTable = numTable;
		this.numberPlaces = numberPlaces;
		this.position = position;
		this.state = state;
		this.progress = progress;
	}
	/**
	 * Get the number of the table
	 * @return int
	 */
	public int getNumTable() {
		return numTable;
	}
	
}
