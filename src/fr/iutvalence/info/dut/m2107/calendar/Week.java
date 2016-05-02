package fr.iutvalence.info.dut.m2107.calendar;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a week from the calendar
 * @author Projet Resto
 *
 */
public class Week {
	
	/**
	 * List of the days identified from 1 to 7
	 */
	private List<Day> days = new ArrayList<Day>();
	
	/**
	 * Generates a week with 7 days
	 */
	public Week() {
		for(int i = 1; i <= 7; i++)
			days.set(i, new Day());
	}
	
	/**
	 * @param dayNum the num of the day (between 1 and 7)
	 * @return the selected day
	 * @throws DayNotExistsException
	 */
	public Day getDay(int dayNum) throws DayNotExistsException
	{
		if(this.days.get(dayNum) == null) throw new DayNotExistsException();
		return this.days.get(dayNum);
	}
	
	/**
	 * @param dayNum weekNum the number of the week from the year
	 * @param Day a Day
	 * @throws DayNotExistsException
	 */
	public void editDayCalendar(int dayNum, Day Day) throws DayNotExistsException
	{
		if(this.days.get(dayNum) == null) throw new DayNotExistsException();
		this.days.set(dayNum, Day);
	}
}
