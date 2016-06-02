package fr.iutvalence.info.dut.m2107.Room;

import java.io.Serializable;

/**
 * Represent a table
 * @author Projet Resto
 */
public class Table implements Serializable
{
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
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
	 * Reservation informations
	 */
	private String clientName;
	
	/**
	 * Create an instance of table
	 * @param numTable table's num
	 * @param numberPlaces num of places
	 * @param position (Position)
	 * @param state (State)
	 * @param progress (Progress)
	 * @throws ClientNameRequiredException exception
	 */
	public Table(int numTable, int numberPlaces, Position position,
			Progress progress, State state) throws ClientNameRequiredException {
		this.numTable = numTable;
		this.numberPlaces = numberPlaces;
		this.position = position;
		if (state == State.RESERVED) throw new ClientNameRequiredException();
		this.setState(state);
		this.progress = progress;
		this.clientName = null;
	}
	
	/**
	 * Create an instance of table reserved
	 * @param numTable table's num
	 * @param numberPlaces num of places
	 * @param position (Position)
	 * @param clientName client's name
	 */
	public Table(int numTable, int numberPlaces, Position position, String clientName){
		this.numTable = numTable;
		this.numberPlaces = numberPlaces;
		this.position = position;
		this.setState(clientName);
		this.progress = Progress.NO_PROGRESS;
		this.clientName = clientName;
	}
	
	/**
	 * Get the number of the table
	 * @return numTable int
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
	 * @param numberPlaces number of places
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
	 * @param position a Position (X, Y, rot)
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
	 * @param state State of the table
	 * @throws ClientNameRequiredException exception
	 */
	public void setState(State state) throws ClientNameRequiredException {
		if(state == State.RESERVED) throw new ClientNameRequiredException();
		this.state = state;
		this.clientName = null;
	}

	/**
	 * Set the reserved state to the table
	 * @param clientName (string)
	 */
	public void setState(String clientName) {
		this.state = State.RESERVED;
		this.clientName = clientName;
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
	 * @param progress (Progress)
	 */
	public void setProgress(Progress progress) {
		this.progress = progress;
	}

	/**
	 * Get the client name of the table
	 * @return clientName
	 */
	public String getClientName()
	{
		return this.clientName;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.numTable;
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
		Table other = (Table) obj;
		if (this.numTable != other.numTable)
			return false;
		return true;
	}
}
