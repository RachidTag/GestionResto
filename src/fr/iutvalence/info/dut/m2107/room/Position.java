package fr.iutvalence.info.dut.m2107.room;
/**
 * Represent the position of a table in a sector
 * @author Projet Resto
 */
public class Position {
	/**
	 * abscissa coordinate
	 */
	private int x;
	/**
	 * ordinate coordinate
	 */
	private int y;
	/**
	 * rotation of the table 
	 */
	private int rotation;
	
	/**
	 * Create a position
	 * @param x int the abscissa coordinate
	 * @param y int the ordinate coordinate
	 * @param rotation int the rotation of the table
	 */
	public Position(int x, int y, int rotation){
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	/**
	 * get the x value
	 * @return x int
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * Set the x value
	 * @param x int
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Get the y value
	 * @return y int
	 */
	public int getY() {
		return this.y;
	}
	/**
	 * Set the y value
	 * @param y int
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Get rotation
	 * @return rotation int
	 */
	public int getRotation() {
		return this.rotation;
	}
	/**
	 * Set the rotation
	 * @param rotation int
	 */
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	
}
