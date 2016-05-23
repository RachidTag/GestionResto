package fr.iutvalence.info.dut.m2107;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import fr.iutvalence.info.dut.m2107.Calendar.Calendar;
import fr.iutvalence.info.dut.m2107.Room.Room;
import fr.iutvalence.info.dut.m2107.Staff.Staff;

/**
 * Represents the Restaurant
 * @author Projet Resto
 */
public class Restaurant implements Serializable {
	/**
	 * The serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The staff of the restaurant
	 */
	private Staff theStaff;
	
	/**
	 * The Calendar of the restaurant
	 */
	private Calendar theCalendar;
	
	/**
	 * The Room of the restaurant
	 */
	private Room theRoom;
	
	/**
	 * Generates the restaurant
	 * @param theStaff
	 * @param theCalendar
	 * @param theRoom
	 */
	public Restaurant(Staff theStaff, Calendar theCalendar, Room theRoom) {
		this.theStaff = theStaff;
		this.theCalendar = theCalendar;
		this.theRoom = theRoom;
	}

	/**
	 * Get the staff of the restaurant
	 * @return theStaff Staff
	 */
	public Staff getTheStaff() {
		return this.theStaff;
	}

	/**
	 * Set the staff of the restaurant
	 * @param theStaff Staff
	 */
	public void setTheStaff(Staff theStaff) {
		this.theStaff = theStaff;
	}

	/**
	 * Get the calendar of the restaurant
	 * @return theCalendar Calendar
	 */
	public Calendar getTheCalendar() {
		return this.theCalendar;
	}

	/**
	 * Set the calendar of the restaurant
	 * @param theCalendar Calendar
	 */
	public void setTheCalendar(Calendar theCalendar) {
		this.theCalendar = theCalendar;
	}

	/**
	 * Get the room of the restaurant
	 * @return theRoom Room
	 */
	public Room getTheRoom() {
		return this.theRoom;
	}

	/**
	 * Set the room of the restaurant
	 * @param theRoom Room
	 */
	public void setTheRoom(Room theRoom) {
		this.theRoom = theRoom;
	}
	
	/**
	 * Save the current restaurant to the file restaurant.save
	 */
	public void saveRestaurant() {
		saveRestaurant("restaurant.save");
	}
	
	/**
	 * Save the current restaurant to a given file
	 * @param fileName 
	 */
	public void saveRestaurant(String fileName) {
		File saveFile = new File(fileName);
		if(saveFile.exists())
			saveFile.delete();
		try {
			saveFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileOutputStream saveStream = null;
		try {
			saveStream = new FileOutputStream(saveFile, true);
		} catch (FileNotFoundException e) {
			// impossible
		}
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(saveStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			oos.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Load a restaurant from restaurant.save
	 * @return restaurantReaded
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ObjectReadedIsNotARestaurantException
	 */
	public static Restaurant loadRestaurant() throws FileNotFoundException, IOException, ClassNotFoundException, ObjectReadedIsNotARestaurantException {
		return loadRestaurant("restaurant.save");
	}
	
	/**
	 * Load a restaurant from a given file (creates an empty restaurant if the file isn't existing)
	 * @param givenFile 
	 * @return roomReaded
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ObjectReadedIsNotARestaurantException
	 */
	public static Restaurant loadRestaurant(String givenFile) throws FileNotFoundException, IOException, ClassNotFoundException, ObjectReadedIsNotARestaurantException {
		File saveFile = new File(givenFile);
		if(!saveFile.exists())
		{
			saveFile.createNewFile();
			Restaurant newRestaurant = new Restaurant(null, null, null);
			// TODO: generate an empty restaurant
			newRestaurant.saveRestaurant();
			saveFile = new File(givenFile);
		}
		
		FileInputStream loadStream = new FileInputStream(saveFile);
		
		ObjectInputStream ois = new ObjectInputStream(loadStream);
		
		Object readObject = ois.readObject();
		
		ois.close();
		
		Restaurant restaurantReaded = null;
		if(readObject instanceof Restaurant)
		{
			restaurantReaded = (Restaurant)readObject;
		}
		else
		{
			throw new ObjectReadedIsNotARestaurantException();
		}
		
		return restaurantReaded;
	}
}
