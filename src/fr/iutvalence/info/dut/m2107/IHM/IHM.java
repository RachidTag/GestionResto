package fr.iutvalence.info.dut.m2107.IHM;

import java.io.FileNotFoundException;
import java.io.IOException;

import fr.iutvalence.info.dut.m2107.calendar.Calendar;
import fr.iutvalence.info.dut.m2107.room.ObjectReadedIsNotARoomException;
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
		try {
			MainWindow window = new MainWindow(Room.loadRoom(), new Calendar());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObjectReadedIsNotARoomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
