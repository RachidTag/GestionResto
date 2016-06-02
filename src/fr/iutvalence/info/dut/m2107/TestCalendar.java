package fr.iutvalence.info.dut.m2107;

import fr.iutvalence.info.dut.m2107.Calendar.Calendar;
import fr.iutvalence.info.dut.m2107.Calendar.InvalidWeekException;
import fr.iutvalence.info.dut.m2107.Calendar.Week;
import fr.iutvalence.info.dut.m2107.Calendar.WeekAlreadyExistsException;
import fr.iutvalence.info.dut.m2107.Calendar.WeekNotExistsException;
import junit.framework.TestCase;

/**
 * Test of the calendar's class
 * @author Projet Resto
 */
public class TestCalendar extends TestCase {
	
	/**
	 * Generates the test of the calendar
	 * @param name
	 */
	public TestCalendar(String name)
	{
		super(name);
	}
	
	/**
	 * Test adding week
	 */
	public void testAddingWeek()
	{
		/*
		 * Test creating an invalid week
		 */
		try {
			new Week(-1);
			fail("The week should be invalid !");
		} catch (InvalidWeekException e) {
			// true
		}

		/*
		 * Test creating an invalid week
		 */
		try {
			new Week(0);
			fail("The week should be invalid !");
		} catch (InvalidWeekException e) {
			// true
		}
		
		/*
		 * Test creating two valid weeks
		 */
		Week trueWeek = null;
		Week trueWeek2 = null;
		try {
			trueWeek = new Week(1);
			trueWeek2 = new Week(2);
		} catch (InvalidWeekException e) {
			fail("The weeks should be valid !");
		}
		
		/*
		 * Creation of the calendar
		 */
		Calendar theCalendar = new Calendar();
		
		/*
		 * Adding a valid week in the calendar
		 */
		try {
			theCalendar.addWeekCalendar(1);
		} catch (WeekAlreadyExistsException e) {
			fail("The week is not allready in the calendar.");
		} catch (InvalidWeekException e) {
			fail("The week is valid !");
		}

		/*
		 * Adding an invalid week in the calendar
		 */
		try {
			theCalendar.addWeekCalendar(-1);
			fail("The week should be invalid !");
		} catch (WeekAlreadyExistsException e) {
			fail("The week isn't allready in the calendar !");
		} catch (InvalidWeekException e) {
			// true
		}

		/*
		 * Adding a week allready in the calendar
		 */
		try {
			theCalendar.addWeekCalendar(1);
			fail("The week allready exist !");
		} catch (WeekAlreadyExistsException e) {
			// true
		} catch (InvalidWeekException e) {
			fail("The week is valid !");
		}

		/*
		 * Adding a week allready in the calendar
		 */
		try {
			theCalendar.addWeekCalendar(trueWeek);
			fail("The week allready exist !");
		} catch (WeekAlreadyExistsException e) {
			// true
		}	

		/*
		 * Adding a correct week in the calendar
		 */
		try {
			theCalendar.addWeekCalendar(trueWeek2);
		} catch (WeekAlreadyExistsException e) {
			fail("The week isn't allready in the calendar.");
		}		
	}
	
	/**
	 * Test deleting week
	 */
	public void testDeletingWeek()
	{
		Calendar calendar = new Calendar();
		
		/*
		 * Deleting from empty calendar
		 */
		try {
			calendar.deleteWeekCalendar(1);
			fail("The calendar is empty, we can't delete a week !");
		} catch (WeekNotExistsException e) {
			// true
		}
		
		try {
			calendar.addWeekCalendar(1);
		} catch (WeekAlreadyExistsException | InvalidWeekException e) {
			// impossible
			fail("error not concerned by this test");
		}
		
		/*
		 * Deleting a not-existing week from the calendar
		 */
		try {
			calendar.deleteWeekCalendar(2);
			fail("The week don't exit");
		} catch (WeekNotExistsException e) {
			// true
		}
		
		/*
		 * Deleting an existing week from the calendar
		 */
		try {
			calendar.deleteWeekCalendar(1);
		} catch (WeekNotExistsException e) {
			fail("The week should exist !");
		}
	}
}
