package fr.iutvalence.info.dut.m2107.Calendar;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the common calendar
 * @author Projet Resto
 *
 */
public class Calendar implements Serializable {
	/**
	 * Serial ID
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
	 * @throws InvalidWeekException 
	 */
	public void addWeekCalendar(int weekNum) throws WeekAlreadyExistsException, InvalidWeekException
	{
		if(this.weeks.containsKey(weekNum)) throw new WeekAlreadyExistsException();
		if(weekNum < 1) throw new InvalidWeekException();
		this.weeks.put(weekNum, new Week(weekNum));
	}
	
	/**
	 * Add a pre-defined week to the calendar
	 * @param aWeek a Week
	 * @throws WeekAlreadyExistsException 
	 */
	public void addWeekCalendar(Week aWeek) throws WeekAlreadyExistsException
	{
		if(this.weeks.containsValue(aWeek)) throw new WeekAlreadyExistsException();
		this.weeks.put(aWeek.getWeekNum(), aWeek);
	}
	/**
	 * delete a week from the calendar
	 * @param numWeek
	 * @throws WeekNotExistsException
	 */
	public void deleteWeekCalendar(int numWeek) throws WeekNotExistsException 
	{
		if(!this.weeks.containsKey(numWeek)) throw new WeekNotExistsException();
		this.weeks.remove(numWeek, this.weeks.get(numWeek));
	}
	
	/**
	 * Get all the weeks of the calendar
	 * @return weeks Map<Integer, Week>
	 */
	public Map<Integer, Week> getAllWeeks(){
		return this.weeks;
	}
}
