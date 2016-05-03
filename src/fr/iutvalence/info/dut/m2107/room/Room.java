package fr.iutvalence.info.dut.m2107.room;

import java.util.ArrayList;
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
	private List<Sector> sectors = new ArrayList<Sector>();
	
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
	 * @throws SectorNotExistsException 
	 */
	public Sector getSector(int numSector) throws SectorNotExistsException{
		if(this.sectors.get(numSector) == null) throw new SectorNotExistsException();
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
		if(this.sectors.get(sector.getNumSector()) != null) throw new SectorAlreadyExistsException();
		this.sectors.add(sector.getNumSector(), sector);
	}
	
	/**
	 * edit an unique sector
	 * @param sector Sector
	 * @throws SectorNotExistsException 
	 */
	public void editSector(int numSector, Sector sector) throws SectorNotExistsException{
		if(this.sectors.get(numSector) == null) throw new SectorNotExistsException();
		this.sectors.set(numSector, sector);
	}

	/**
	 * delete a sector
	 * @param numSector int
	 * @throws SectorNotExistsException 
	 */
	public void deleteSector(int numSector) throws SectorNotExistsException{
		if(this.sectors.get(numSector) == null) throw new SectorNotExistsException();
		this.sectors.remove(numSector);
	}
}