package fr.iutvalence.info.dut.m2107.IHM;

import fr.iutvalence.info.dut.m2107.calendar.Calendar;
import fr.iutvalence.info.dut.m2107.room.Room;

/**
 * TODO PUT IT IN THE MAIN DAMNED !
 * @author Projet Resto
 *
 */
public class IHM {

	/**
	 * TODO
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MainWindow window = new MainWindow(new Room(), new Calendar());

	}

}
