package fr.iutvalence.info.dut.m2107.Room;

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
	 * Serial ID
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
	 * @return sectors Map of sectors (integer, sector)
	 */
	public Map<Integer, Sector> getSectors()
	{
		return this.sectors;
	}
	
	/**
	 * Get an unique sector
	 * @param numSector int
	 * @return a Sector
	 * @throws SectorNotExistsException exception
	 */
	public Sector getSector(int numSector) throws SectorNotExistsException{
		if(!this.sectors.containsKey(numSector)) throw new SectorNotExistsException();
		return this.sectors.get(numSector);
	}
	
	/**
	 * Edit list of sectors 
	 * @param sectors Sectors hashmap (integer, sector)
	 */
	public void setSectors(HashMap<Integer, Sector> sectors)
	{
		this.sectors = sectors;
	}
	
	/**
	 * add an unique sector
	 * @param sector Sector
	 * @throws SectorAlreadyExistsException exception
	 */
	public void addSector(Sector sector) throws SectorAlreadyExistsException{
		if(this.sectors.containsValue(sector)) throw new SectorAlreadyExistsException();
		this.sectors.put(sector.getNumSector(), sector);
	}
	
	/**
	 * edit an unique sector
	 * @param numSector a num of Sector
	 * @param sector Sector
	 * @throws SectorNotExistsException exception
	 */
	public void editSector(int numSector, Sector sector) throws SectorNotExistsException{
		if(!this.sectors.containsKey(numSector)) throw new SectorNotExistsException();
		this.sectors.put(numSector, sector);
	}

	/**
	 * delete a sector
	 * @param numSector int num of sector
	 * @throws SectorNotExistsException exception
	 */
	public void deleteSector(int numSector) throws SectorNotExistsException{
		if(!this.sectors.containsKey(numSector)) throw new SectorNotExistsException();
		this.sectors.remove(numSector);
	}
}