package fr.iutvalence.info.dut.m2107.calendar;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the common calendar
 * @author Projet Resto
 *
 */
public class Calendar {
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
		if(this.weeks.containsKey(weekNum)) throw new WeekNotExistsException();
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
}
