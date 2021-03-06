package fr.iutvalence.info.dut.m2107.Calendar;

import java.io.Serializable;

/**
 * Represents a week from the calendar
 * @author Projet Resto
 *
 */
public class Week implements Serializable {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Num of the week in the year
	 */
	private final int weekNum;
	
	/**
	 * List of the days identified from 1 to 7
	 */
	private Day[] days;
	
	/**
	 * Generates a week with 7 days 
	 * @param weekNum in the year
	 * @throws InvalidWeekException 
	 */
	public Week(int weekNum) throws InvalidWeekException {
		if(weekNum < 1) throw new InvalidWeekException();
		this.weekNum = weekNum;
		this.days = new Day[7];
		for(int i = 0; i < 7; i++)
			this.days[i] = new Day();
	}
	
	/**
	 * @param dayNum the num of the day (between 1 and 7)
	 * @return the selected day
	 * @throws DayNotExistsException 
	 */
	public Day getDay(int dayNum) throws DayNotExistsException
	{
		if(dayNum < 0 || dayNum >= 7) throw new DayNotExistsException();
		return this.days[dayNum];
	}
	
	/**
	 * @return the days tables
	 */
	public Day[] getDays(){
		return this.days;
	}
	
	/**
	 * @param dayNum weekNum the number of the week from the year
	 * @param day a Day
	 * @throws DayNotExistsException
	 */
	public void editDayCalendar(int dayNum, Day day) throws DayNotExistsException
	{
		if(dayNum < 0 || dayNum >= 7) throw new DayNotExistsException();
		this.days[dayNum] = day;
	}

	/**
	 * Get the num of the week in the year
	 * @return the weekNum
	 */
	public int getWeekNum() {
		return this.weekNum;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.weekNum;
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Week other = (Week) obj;
		if (this.weekNum != other.weekNum)
			return false;
		return true;
	}
}
