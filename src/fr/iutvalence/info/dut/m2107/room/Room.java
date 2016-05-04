package fr.iutvalence.info.dut.m2107.room;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a restaurant's room
 * @author Projet Resto
 *
 */
public class Room {
	/**
	 * Set of sectors
	 */
	private List<Sector> sectors = new LinkedList<Sector>();
	
	/**
	 * Get all the sectors
	 * @return sectors List<Sector>
	 */
	public List<Sector> getSectors()
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
		Sector sector = new Sector(numSector, null);
		if(!this.sectors.contains(sector)) throw new SectorNotExistsException();
		return this.sectors.get(numSector);
	}
	
	/**
	 * Edit list of sectors 
	 * @param sectors
	 */
	public void setSectors(List<Sector> sectors)
	{
		this.sectors = sectors;
	}
	
	/**
	 * add an unique sector
	 * @param sector Sector
	 * @throws SectorAlreadyExistsException 
	 */
	public void addSector(Sector sector) throws SectorAlreadyExistsException{
		if(this.sectors.contains(sector)) throw new SectorAlreadyExistsException();
		this.sectors.add(sector);
	}
	
	/**
	 * edit an unique sector
	 * @param numSector a num of Sector
	 * @param sector Sector
	 * @throws SectorNotExistsException 
	 */
	public void editSector(int numSector, Sector sector) throws SectorNotExistsException{
		if(!this.sectors.contains(sector)) throw new SectorNotExistsException();
		this.sectors.set(numSector, sector);
	}

	/**
	 * delete a sector
	 * @param numSector int
	 * @throws SectorNotExistsException 
	 */
	public void deleteSector(int numSector) throws SectorNotExistsException{
		Sector sector = new Sector(numSector, null);
		if(!this.sectors.contains(sector)) throw new SectorNotExistsException();
		this.sectors.remove(numSector);
	}
}