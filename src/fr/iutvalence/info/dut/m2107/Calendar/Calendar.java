package fr.iutvalence.info.dut.m2107.Calendar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.iutvalence.info.dut.m2107.Room.Room;

/**
 * Represents the common calendar
 * @author Projet Resto
 *
 */
public class Calendar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The list who contains the weeks identified by their numbers for the current year
	 */
	Map<Integer, Week> weeks;
	
	/**
	 * Generates an empty calendar
	 */
	public Calendar() {
		this.weeks = new HashMap<Integer, Week>();
	}

	/**
	 * Get a week from the calendar
	 * @param weekNum the number of the week from the year
	 * @return a Week
	 * @throws WeekNotExistsException
	 */
	public Week getWeekCalendar(int weekNum) throws WeekNotExistsException
	{
		if(!this.weeks.containsKey(weekNum)) throw new WeekNotExistsException();
		return this.weeks.get(weekNum);
	}

	/**
	 * Add an empty week to the calendar 
	 * @param weekNum the number of the week from the year
	 * @throws WeekAlreadyExistsException 
	 */
	public void addWeekCalendar(int weekNum) throws WeekAlreadyExistsException
	{
		if(this.weeks.containsKey(weekNum)) throw new WeekAlreadyExistsException();
		this.weeks.put(weekNum, new Week(weekNum));
	}
	
	/**
	 * Add a pre-defined week to the calendar
	 * @param weekNum the number of the week from the year
	 * @param aWeek a Week
	 * @throws WeekAlreadyExistsException 
	 */
	public void addWeekCalendar(Week aWeek) throws WeekAlreadyExistsException
	{
		if(this.weeks.containsValue(aWeek)) throw new WeekAlreadyExistsException();
		this.weeks.put(aWeek.getWeekNum(), aWeek);
	}
	
	/**
	 * Get all the weeks of the calendar
	 * @return weeks Map<Integer, Week>
	 */
	public Map<Integer, Week> getAllWeeks(){
		return this.weeks;
	}
	
	/**
	 * Save the current calendar to the file savingCalendar.save
	 */
	public void saveCalendar() {
		saveCalendar("savingCalendar.save");
	}
	
	/**
	 * Save the current calendar to a given file
	 * @param fileName 
	 */
	public void saveCalendar(String fileName) {
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
	 * Load a calendar from savingCalendar.save
	 * @return calendarReaded
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ObjectReadedIsNotACalendarException
	 */
	public static Calendar loadCalendar() throws FileNotFoundException, IOException, ClassNotFoundException, ObjectReadedIsNotACalendarException {
		return loadCalendar("savingCalendar.save");
	}
	
	/**
	 * Load a calendar from a given file (creates an empty calendar if the file isn't existing)
	 * @param givenFile 
	 * @return calendarReaded
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ObjectReadedIsNotACalendarException
	 */
	public static Calendar loadCalendar(String givenFile) throws FileNotFoundException, IOException, ClassNotFoundException, ObjectReadedIsNotACalendarException {
		File saveFile = new File(givenFile);
		if(!saveFile.exists())
		{
			saveFile.createNewFile();
			Calendar newCalendar = new Calendar();
			newCalendar.saveCalendar();
			saveFile = new File(givenFile);
		}
		
		FileInputStream loadStream = new FileInputStream(saveFile);
		
		ObjectInputStream ois = new ObjectInputStream(loadStream);
		
		Object readObject = ois.readObject();
		
		ois.close();
		
		Calendar calendarReaded = null;
		if(readObject instanceof Calendar)
		{
			calendarReaded = (Calendar)readObject;
		}
		else
		{
			throw new ObjectReadedIsNotACalendarException();
		}
		
		return calendarReaded;
	}
}
