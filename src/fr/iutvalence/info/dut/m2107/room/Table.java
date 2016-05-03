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
		return this.numTable;
	}

	/**
	 * Get the number of places
	 * @return numberPlaces int
	 */
	public int getNumberPlaces() {
		return this.numberPlaces;
	}

	/**
	 * Set the number of places
	 * @param numberPlaces
	 */
	public void setNumberPlaces(int numberPlaces) {
		this.numberPlaces = numberPlaces;
	}

	/**
	 * Get the position
	 * @return position Position
	 */
	public Position getPosition() {
		return this.position;
	}

	/**
	 * Set the position
	 * @param position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * Get the state of the dinner
	 * @return state State
	 */
	public State getState() {
		return this.state;
	}

	/**
	 * Set the state of the table
	 * @param state
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Get the progress of the dinner 
	 * @return progress Progress
	 */
	public Progress getProgress() {
		return this.progress;
	}

	/**
	 * Set the progress of the dinner
	 * @param progress
	 */
	public void setProgress(Progress progress) {
		this.progress = progress;
	}	
}
