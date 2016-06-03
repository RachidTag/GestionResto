package fr.iutvalence.info.dut.m2107;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

import fr.iutvalence.info.dut.m2107.IHM.MainWindow.MainWindow;
/**
 * Application that launches an IHM and load the restaurant
 * When you launch this for the first time, the restaurant is totally empty
 * @author Projet Resto
 */
public class CleanMain {
	
	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		ImageIcon logoIcon = new ImageIcon("img/logoIcon.png");
		Image logo = logoIcon.getImage();
		MainWindow window = null;
		
		try {
			window = new MainWindow(Restaurant.loadRestaurant());
		} catch (ClassNotFoundException | IOException | ObjectReadedIsNotARestaurantException e) {
			e.printStackTrace();
		}
		
		window.setIconImage(logo);
	}

}
