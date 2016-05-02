package fr.iutvalence.info.dut.m2107.room;
/**
 * Enumeration of the different state of the meal
 * @author Projet Resto
 */
public enum State {
	/**
	 * A table is busy
	 */
	BUSY,
	/**
	 * A table is ready
	 */
	FREE,
	/**
	 * A table is reserved for a customer
	 */
	RESERVED,
	/**
	 * A table is dirty and need to be clean
	 */
	GRIMY;
}
