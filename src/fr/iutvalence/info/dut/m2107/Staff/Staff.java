package fr.iutvalence.info.dut.m2107.Staff;

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

import fr.iutvalence.info.dut.m2107.Room.ObjectReadedIsNotARoomException;
import fr.iutvalence.info.dut.m2107.Room.Room;
import fr.iutvalence.info.dut.m2107.Room.Sector;
import fr.iutvalence.info.dut.m2107.Room.SectorAlreadyExistsException;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;


/**
 * Rpresent all the staff of the restaurant
 * @author Théo
 *
 */
public class Staff implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Set of waiter : the staff
	 */
	private Map<Integer, Waiter> waiters;
	
	
	/**
	 * Generate an empty staff
	 */
	public Staff(){
		this.waiters = new HashMap<Integer, Waiter>();
	}
	
	/**
	 * Get all the waiters
	 * @return
	 */
	public Map<Integer, Waiter> getStaff(){
		return this.waiters;
	}
	
	/**
	 * Get a unique waiter
	 * @param numWaiter
	 * @return a waiter
	 * @throws WaiterDoesNotExistException
	 */
	public Waiter getWaiter(int numWaiter) throws WaiterDoesNotExistException{
		if(!this.waiters.containsKey(numWaiter)) throw new WaiterDoesNotExistException();
		return this.waiters.get(numWaiter);
	}
	
	/**
	 * Edit list of waiters
	 * @param waiters
	 */
	public void setWaiters(Map<Integer, Waiter> waiters) {
		this.waiters = waiters;
	}
	
	/**
	 * add an unique waiter
	 * @param waiter Waiter
	 * @throws SectorAlreadyExistsException 
	 */
	public void addWaiter(Waiter waiter) throws WaiterAlreadyExistsException{
		if(this.waiters.containsValue(waiter)) throw new WaiterAlreadyExistsException();
		if(this.waiters.containsKey(waiter.getNumWaiter())) throw new WaiterAlreadyExistsException();
		this.waiters.put(waiter.getNumWaiter(), waiter);
	}
	
	/**
	 * edit an unique Waiter
	 * @param numWaiter a num of Sector
	 * @param waiter Waiter
	 * @throws WaiterDoesNotExistException 
	 */
	public void editWaiter(int numWaiter, Waiter waiter) throws WaiterDoesNotExistException{
		if(!this.waiters.containsKey(numWaiter)) throw new WaiterDoesNotExistException();
		this.waiters.put(numWaiter, waiter);
	}

	/**
	 * delete a waiters
	 * @param numWaiter int
	 * @throws WaiterDoesNotExistException 
	 */
	public void deleteWaiter(int numWaiter) throws WaiterDoesNotExistException{
		if(!this.waiters.containsKey(numWaiter)) throw new WaiterDoesNotExistException();
		this.waiters.remove(numWaiter);
	}
	
	/**
	 * Return the 1st free index of the list of waiter
	 * @return int the 1st free index
	 */
	public int findFirstFreeIndex(){
		if(this.waiters == null) return 0;
		int index = 1;
		while(index <= this.waiters.size()){
			if(!this.waiters.containsKey(index))break;
			index++;
		}
		return index;
		
	}
	
	/**
	 * Redefine equals method for containsValue method
	 * @param 
	 * @return bool
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		return true;
	}	
	
	/**
	 * Save the current staff to the file savingStaff.save
	 */
	public void saveStaff() {
		saveStaff("savingStaff.save");
	}

	private void saveStaff(String fileName) {
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
	 * Load a staff from savingStaff.save
	 * @return staffReaded
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ObjectReadedIsNotARoomException
	 * @throws WaiterAlreadyExistsException 
	 */
	public static Staff loadStaff() throws FileNotFoundException, IOException, ClassNotFoundException, ObjectReadedIsNotARoomException, WaiterAlreadyExistsException {
		return loadStaff("savingStaff.save");
	}

	/**
	 * Load or create a new Staff
	 * @param givenFile
	 * @return the staff loaded or created
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ObjectReadedIsNotARoomException
	 * @throws WaiterAlreadyExistsException
	 */
	private static Staff loadStaff(String givenFile) throws IOException, ClassNotFoundException, ObjectReadedIsNotARoomException, WaiterAlreadyExistsException {
		File saveFile = new File(givenFile);
		if(!saveFile.exists())
		{
			saveFile.createNewFile();
			Staff newStaff = new Staff();
			newStaff.addWaiter(new Waiter(1, "LORETTE", "Théo", Rank.PADDER));
			newStaff.addWaiter(new Waiter(2, "TAGHAT", "Rachid", Rank.PADDER));
			newStaff.addWaiter(new Waiter(3, "PALMIER", "Benjamin", Rank.PADDER));
			newStaff.addWaiter(new Waiter(4, "AUBÉ", "Mathieu", Rank.PADDER));
			newStaff.addWaiter(new Waiter(5, "FAYANT", "Dylan", Rank.CHIEF));
			newStaff.addWaiter(new Waiter(6, "PRADES", "Mickaël", Rank.RUNNER));
			newStaff.addWaiter(new Waiter(7, "BRIZAC", "Alfred", Rank.RUNNER));
			newStaff.addWaiter(new Waiter(8, "DI VALENTIN", "Olivia", Rank.RUNNER));
			newStaff.addWaiter(new Waiter(9, "JEAN", "Sébastien", Rank.RUNNER));
			newStaff.addWaiter(new Waiter(10, "ROTTELEUR", "Pierre", Rank.RUNNER));
			//TODO continue
			newStaff.saveStaff();
			saveFile = new File(givenFile);
		}
		FileInputStream loadStream = new FileInputStream(saveFile);
		
		ObjectInputStream ois = new ObjectInputStream(loadStream);
		
		Object readObject = ois.readObject();
		
		ois.close();
		
		Staff staffReaded = null;
		if(readObject instanceof Staff)
		{
			staffReaded = (Staff)readObject;
		}
		else
		{
			throw new ObjectReadedIsNotARoomException();
		}
		
		return staffReaded;
	}
	
	
}
