package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;

import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;
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
	public static void main(String[] args){
		ImageIcon logoIcon = new ImageIcon("img/logoIcon.png");
		Image logo = logoIcon.getImage();
		MainWindow window = null;
		try {
			window = new MainWindow(Room.loadRoom(), new Calendar());
			if (window != null)
				window.setIconImage(logo);
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
