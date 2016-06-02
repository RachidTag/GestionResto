package fr.iutvalence.info.dut.m2107;

import fr.iutvalence.info.dut.m2107.Staff.Rank;
import fr.iutvalence.info.dut.m2107.Staff.Staff;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;
import fr.iutvalence.info.dut.m2107.Staff.WaiterAlreadyExistsException;
import fr.iutvalence.info.dut.m2107.Staff.WaiterDoesNotExistException;
import junit.framework.TestCase;

/**
 * Test of the staff's class
 * @author Projet Resto
 */
public class TestStaff extends TestCase {
	
	/**
	 * Generates the test of the staff
	 * @param name
	 */
	public TestStaff(String name)
	{
		super(name);
	}
	
	/**
	 * Test firstFreeIndex 
	 */
	public void testFirstFreeIndex()
	{
		Staff staff = new Staff();
		assertEquals(1, staff.findFirstFreeIndex());
		Waiter waiter1 = new Waiter(1, "Dupond", "Dupont", Rank.RUNNER);
		
		try {
			staff.addWaiter(waiter1);
		} catch (WaiterAlreadyExistsException e) {
			fail("problem not tested in this case");
		}
		
		assertEquals(2, staff.findFirstFreeIndex());
		
		try {
			staff.deleteWaiter(1);
		} catch (WaiterDoesNotExistException e) {
			fail("problem not tested in this case");
		}
		
		assertEquals(1, staff.findFirstFreeIndex());
	}
	
	/**
	 * Test addWaiter
	 */
	public void testAddWaiter()
	{
		Staff staff = new Staff();
		
		try {
			staff.addWaiter(null);
			fail("It shouldn't be possible !");
		} catch (WaiterAlreadyExistsException | NullPointerException e1) {
			// true
		}

		Waiter waiter1 = new Waiter(1, "Dupond", "Dupont", Rank.RUNNER);
		Waiter waiter2 = new Waiter(1, "Dupont", "Dupond", Rank.RUNNER); // the same num

		try {
			staff.addWaiter(waiter1);
		} catch (WaiterAlreadyExistsException e1) {
			fail("Waiter shouldn't allready exists");
		}
		
		try {
			staff.addWaiter(waiter2);
			fail("Waiter should allready exists");
		} catch (WaiterAlreadyExistsException e1) {
			// true
		}
		
		try {
			staff.addWaiter(waiter1);
			fail("Waiter should allready exists");
		} catch (WaiterAlreadyExistsException e1) {
			// true
		}
		
		try {
			staff.deleteWaiter(1);
		} catch (WaiterDoesNotExistException e) {
			fail("Problem not tested here");
		}	
		
		try {
			staff.addWaiter(waiter2);
		} catch (WaiterAlreadyExistsException e) {
			fail("Waiter shouldn't allready exists");
		}
	}
	
	/**
	 * Test deleteWaiter
	 */
	public void testDeleteWaiter()
	{
		Staff staff = new Staff();
		
		try {
			staff.deleteWaiter(0);
			fail("Waiter shouldn't exists");
		} catch (WaiterDoesNotExistException e1) {
			// true
		}
		
		Waiter waiter1 = new Waiter(1, "Dupond", "Dupont", Rank.RUNNER);
		
		try {
			staff.addWaiter(waiter1);
		} catch (WaiterAlreadyExistsException e) {
			fail("problem not tested in this case");
		}
		
		try {
			staff.deleteWaiter(0);
			fail("Waiter shouldn't exists");
		} catch (WaiterDoesNotExistException e) {
			// true
		}	
		
		try {
			staff.deleteWaiter(1);
		} catch (WaiterDoesNotExistException e) {
			fail("Waiter should exists");
		}
	}
	
	/**
	 * Test editWaiter
	 */
	public void testEditWaiter()
	{
		Staff staff = new Staff();

		Waiter waiter1 = new Waiter(1, "Dupond", "Dupont", Rank.RUNNER);
		Waiter waiter2 = new Waiter(1, "Dupont", "Dupond", Rank.RUNNER);
		
		try {
			staff.editWaiter(1, waiter1);
			fail("Waiter shouldn't exists");
		} catch (WaiterDoesNotExistException e2) {
			// true
		}
		
		try {
			staff.addWaiter(waiter1);
		} catch (WaiterAlreadyExistsException e) {
			fail("problem not tested in this case");
		}
		
		try {
			staff.editWaiter(0, waiter1);
			fail("Waiter shouldn't exists");
		} catch (WaiterDoesNotExistException e2) {
			// true
		}
		
		try {
			staff.editWaiter(1, null);
		} catch (WaiterDoesNotExistException e2) {
			fail("Waiter should exists");
		}
		
		try {
			staff.editWaiter(1, waiter2);
		} catch (WaiterDoesNotExistException e2) {
			fail("Waiter should exists");
		}
		
		try {
			staff.deleteWaiter(1);
		} catch (WaiterDoesNotExistException e) {
			fail("error not tested in this case.");
		}
		
		try {
			staff.editWaiter(1, waiter1);
			fail("Waiter shouldn't exists");
		} catch (WaiterDoesNotExistException e2) {
			// true
		}	
	}
	
	/**
	 * Test getWaiter
	 */
	public void testGetWaiter()
	{
		Staff staff = new Staff();

		Waiter waiter1 = new Waiter(1, "Dupond", "Dupont", Rank.RUNNER);
		
		try {
			staff.getWaiter(1);
			fail("Waiter shouldn't exists");
		} catch (WaiterDoesNotExistException e2) {
			// true
		}
		
		try {
			staff.addWaiter(waiter1);
		} catch (WaiterAlreadyExistsException e) {
			fail("problem not tested in this case");
		}
		
		try {
			staff.getWaiter(0);
			fail("Waiter shouldn't exists");
		} catch (WaiterDoesNotExistException e2) {
			// true
		}
		
		try {
			staff.getWaiter(1);
		} catch (WaiterDoesNotExistException e2) {
			fail("Waiter should exists");
		}
		
		try {
			staff.deleteWaiter(1);
		} catch (WaiterDoesNotExistException e) {
			fail("error not tested in this case.");
		}
		
		try {
			staff.getWaiter(1);
			fail("Waiter shouldn't exists");
		} catch (WaiterDoesNotExistException e2) {
			// true
		}	
	}
}
