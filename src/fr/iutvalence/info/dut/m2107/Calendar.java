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
	 * The map who contains the weeks indentified by their numbers for the current year
	 */
	List<Week> weeks = new ArrayList<Week>();

	/**
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
	 * @param weekNum the number of the week from the year
	 * @throws WeekAlreadyExistsException 
	 */
	public void addWeekCalendar(int weekNum) throws WeekAlreadyExistsException
	{
		if(this.weeks.get(weekNum) != null) throw new WeekAlreadyExistsException();
		this.weeks.add(weekNum, new Week());
	}
	
	/**
	 * @param weekNum the number of the week from the year
	 * @param aWeek a Week
	 * @throws WeekAlreadyExistsException 
	 */
	public void addWeekCalendar(int weekNum, Week aWeek) throws WeekAlreadyExistsException
	{
		if(this.weeks.get(weekNum) != null) throw new WeekAlreadyExistsException();
		this.weeks.add(weekNum, aWeek);
	}
	
	/**
	 * @param weekNum weekNum the number of the week from the year
	 * @param newWeek a Week
	 * @throws WeekNotExistsException
	 */
	public void editWeekCalendar(int weekNum, Week newWeek) throws WeekNotExistsException
	{
		if(this.weeks.get(weekNum) == null) throw new WeekNotExistsException();
		this.weeks.set(weekNum, newWeek);
	}
}
