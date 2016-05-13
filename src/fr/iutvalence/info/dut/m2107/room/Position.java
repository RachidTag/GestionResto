package fr.iutvalence.info.dut.m2107.room;

import java.io.Serializable;

/**
 * Represent the position of a table in a sector
 * @author Projet Resto
 */
public class Position implements Serializable, Comparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Object o) 
	{
		if (getClass() != o.getClass())
			return 1;
		Position other = (Position) o;
		
		if (this.y < other.y) return -1;
		if (this.y > other.y) return 1;
		if (this.x < other.x) return -1;
		if (this.x > other.x) return 1;
		
		return 0;
	}
	
	
	/**
	 * @param i
	 * @param j
	 * @return boolean if position is equals 
	 */
	public boolean hasSamePosition(int i, int j)
	{
		if(this.x == i && this.y == j)
		{
			return true;
		}
		return false;
	
	}
	
	
}
