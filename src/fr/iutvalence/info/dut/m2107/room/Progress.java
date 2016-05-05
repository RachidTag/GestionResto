package fr.iutvalence.info.dut.m2107.room;

import java.io.Serializable;

/**
 * Enumeration of the different type of progress for a table
 * @author Projet Resto
 */
public enum Progress implements Serializable {
	/**
	 * No progress
	 */
	NO_PROGRESS,
	/**
	 * Aperitif
	 */
	APERITIF,
	/**
	 * Starter
	 */
	STARTER,
	/**
	 * Main Course
	 */
	MAIN_COURSE,
	/**
	 * Dessert
	 */
	DESSERT,
	/**
	 * Bill Setted
	 */
	BILL_SETTED;
}
