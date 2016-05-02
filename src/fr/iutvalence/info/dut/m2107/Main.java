package fr.iutvalence.info.dut.m2107;

import fr.iutvalence.info.dut.m2107.calendar.Calendar;
import fr.iutvalence.info.dut.m2107.room.Room;

/**
 * Application that launches an IHM, a Calendar and a Room 
 * @author Projet Resto
 *
 */
public class Main {
	
	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Calendar calendar = new Calendar();
		Room room = new Room();
		// TODO, think about the integration of the IHM
	}

}
