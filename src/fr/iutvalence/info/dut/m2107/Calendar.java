package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the common calendar
 * @author Projet Resto
 *
 */
public class Calendar {
	/**
	 * The list who contains the weeks identified by their numbers for the current year
	 */
	List<Week> weeks = new ArrayList<Week>();

	/**
	 * Get a week from the calendar
	 * @param weekNum the number of the week from the year
	 * @return a Week
	 * @throws WeekNotExistsException
	 */
	public Week getWeekCalendar(int weekNum) throws WeekNotExistsException
	{
		if(this.weeks.get(weekNum) == null) throw new WeekNotExistsException();
		return this.weeks.get(weekNum);
	}

	/**
	 * Add an empty week to the calendar
	 * @param weekNum the number of the week from the year
	 * @throws WeekAlreadyExistsException 
	 */
	public void addWeekCalendar(int weekNum) throws WeekAlreadyExistsException
	{
		if(this.weeks.get(weekNum) != null) throw new WeekAlreadyExistsException();
		this.weeks.add(weekNum, new Week());
	}
	
	/**
	 * Add a pre-defined week to the calendar
	 * @param weekNum the number of the week from the year
	 * @param aWeek a Week
	 * @throws WeekAlreadyExistsException 
	 */
	public void addWeekCalendar(int weekNum, Week aWeek) throws WeekAlreadyExistsException
	{
		if(this.weeks.get(weekNum) != null) throw new WeekAlreadyExistsException();
		this.weeks.add(weekNum, aWeek);
	}
}
