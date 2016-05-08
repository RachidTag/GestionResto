package fr.iutvalence.info.dut.m2107.room;

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

/**
 * Represents a restaurant's room
 * @author Projet Resto
 *
 */
public class Room implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Set of sectors
	 */
	private Map<Integer, Sector> sectors;
	
	/**
	 * Generates an empty room
	 */
	public Room()
	{
		this.sectors = new HashMap<Integer, Sector>();
	}
	
	/**
	 * Get all the sectors
	 * @return sectors Map<Integer, Sector>
	 */
	public Map<Integer, Sector> getSectors()
	{
		return this.sectors;
	}
	
	/**
	 * Get an unique sector
	 * @param numSector int
	 * @return a Sector
	 * @throws SectorNotExistsException 
	 */
	public Sector getSector(int numSector) throws SectorNotExistsException{
		if(!this.sectors.containsKey(numSector)) throw new SectorNotExistsException();
		return this.sectors.get(numSector);
	}
	
	/**
	 * Edit list of sectors 
	 * @param sectors
	 */
	public void setSectors(HashMap<Integer, Sector> sectors)
	{
		this.sectors = sectors;
	}
	
	/**
	 * add an unique sector
	 * @param sector Sector
	 * @throws SectorAlreadyExistsException 
	 */
	public void addSector(Sector sector) throws SectorAlreadyExistsException{
		if(this.sectors.containsValue(sector)) throw new SectorAlreadyExistsException();
		this.sectors.put(sector.getNumSector(), sector);
	}
	
	/**
	 * edit an unique sector
	 * @param numSector a num of Sector
	 * @param sector Sector
	 * @throws SectorNotExistsException 
	 */
	public void editSector(int numSector, Sector sector) throws SectorNotExistsException{
		if(!this.sectors.containsKey(numSector)) throw new SectorNotExistsException();
		this.sectors.put(numSector, sector);
	}

	/**
	 * delete a sector
	 * @param numSector int
	 * @throws SectorNotExistsException 
	 */
	public void deleteSector(int numSector) throws SectorNotExistsException{
		if(!this.sectors.containsKey(numSector)) throw new SectorNotExistsException();
		this.sectors.remove(numSector);
	}
	
	/**
	 * Save the current room to the file savingRoom.save
	 */
	public void saveRoom() {
		saveRoom("savingRoom.save");
	}
	
	/**
	 * Save the current room to a given file
	 * @param fileName 
	 */
	public void saveRoom(String fileName) {
		File saveFile = new File(fileName);
		if(saveFile.exists())
			saveFile.delete();
		try {
			saveFile.createNewFile();
		} catch (IOException e) {
			// impossible
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
	 * Load a room from savingRoom.save
	 * @return roomReaded
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ObjectReadedIsNotARoomException
	 */
	public static Room loadRoom() throws FileNotFoundException, IOException, ClassNotFoundException, ObjectReadedIsNotARoomException {
		return loadRoom("savingRoom.save");
	}
	
	/**
	 * Load a room from a given file
	 * @param givenFile 
	 * @return roomReaded
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ObjectReadedIsNotARoomException
	 */
	public static Room loadRoom(String givenFile) throws FileNotFoundException, IOException, ClassNotFoundException, ObjectReadedIsNotARoomException {
		File saveFile = new File(givenFile);
		if(!saveFile.exists())
			throw new FileNotFoundException();
		
		FileInputStream loadStream = new FileInputStream(saveFile);
		
		ObjectInputStream ois = new ObjectInputStream(loadStream);
		
		Object readObject = ois.readObject();
		
		ois.close();
		
		Room roomReaded = null;
		if(readObject instanceof Room)
		{
			roomReaded = (Room)readObject;
		}
		else
		{
			throw new ObjectReadedIsNotARoomException();
		}
		
		return roomReaded;
	}
}