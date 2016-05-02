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
	private Day days[] = new Day[7];
	
	/**
	 * Generates a week with 7 days
	 */
	public Week() {
		for(int i = 1; i <= 7; i++)
			days[i] = new Day();
	}
	
	/**
	 * @param dayNum the num of the day (between 1 and 7)
	 * @return the selected day
	 * @throws DayNotExistsException
	 */
	public Day getDay(int dayNum)
	{
		return this.days[dayNum];
	}
	
	/**
	 * @param dayNum weekNum the number of the week from the year
	 * @param Day a Day
	 * @throws DayNotExistsException
	 */
	public void editDayCalendar(int dayNum, Day Day)
	{
		this.days[dayNum] = Day;
	}
}
