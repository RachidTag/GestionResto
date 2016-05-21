package fr.iutvalence.info.dut.m2107.Staff;

import java.io.Serializable;

/**
 * Represents the different waiter's ranks in the restaurant
 * @author Projet Resto
 *
 */
public enum Rank implements Serializable {
	/**
	 * A people who runs in the restaurant (#lol)
	 * Give the plates...
	 */
	RUNNER,
	/**
	 * A people who have a sector and who take the orders
	 */
	PADDER,
	/**
	 * The chief of the waiters
	 */
	CHIEF;
}
