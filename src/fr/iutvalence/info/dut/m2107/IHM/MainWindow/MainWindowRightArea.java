package fr.iutvalence.info.dut.m2107.IHM.MainWindow;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import fr.iutvalence.info.dut.m2107.Room.Position;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Room.Table;

/**
 * Represents the right area of the main window
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class MainWindowRightArea extends JPanel{
	/**
	 * The main window
	 */
	private MainWindow mainWindow;
	
	/**
	 * Sector one (right panel)
	 */
	public JPanel sectorOne;
	
	/**
	 * Sector two (right panel)
	 */
	public JPanel sectorTwo;
	
	/**
	 * Sector three (right panel)
	 */
	public JPanel sectorThree;
	
	/**
	 * Sector four (right panel)
	 */
	public JPanel sectorFour;
	
	/**
	 * TitledBorders
	 */
	public TitledBorder[] borders;

	/**
	 * Generates the right area of the main window
	 * @param mainWindow
	 */
	public MainWindowRightArea(MainWindow mainWindow){
		/*
		 * Save the reference to the main window
		 */
		this.mainWindow = mainWindow;

		/*
		 * Creates the layout
		 */
		GridLayout roomGrid = new GridLayout(2,2);
		
		/*
		 * Create a horizontal and vertical gap of x pixels between panel and gridlayout
		 */
		roomGrid.setHgap(20);
		roomGrid.setVgap(10);
		
		/*
		 * Set the layout
		 */
		this.setLayout(roomGrid);
		
		/*
		 * Add 4 panels that are the 4 sectors that create one room
		 */
		this.sectorOne = new JPanel();
		this.sectorTwo = new JPanel();
		this.sectorThree = new JPanel();
		this.sectorFour = new JPanel();
		
		/*
		 * get the name of all the padders to the borders
		 */
		this.borders = new TitledBorder[this.mainWindow.restaurant.getTheRoom().getSectors().size()];
		
		for(int sectorNum : this.mainWindow.restaurant.getTheRoom().getSectors().keySet())
		{
			try {
				if(this.mainWindow.restaurant.getTheRoom().getSector(sectorNum).getPadder() != null)
				{
					String padderName = this.mainWindow.restaurant.getTheRoom().getSector(sectorNum).getPadder().getFirstName() + " " + this.mainWindow.restaurant.getTheRoom().getSector(sectorNum).getPadder().getLastName();
					this.borders[sectorNum-1] = new TitledBorder(new LineBorder(Color.black, 5), "Sector "+sectorNum+" : "+padderName);
				}
				else
				{
					this.borders[sectorNum-1] = new TitledBorder(new LineBorder(Color.black, 5), "Sector "+sectorNum);
				}
			} catch (SectorNotExistsException e) {
				// impossible
			}
		}
		
		/*
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorOne.setBorder(this.borders[0]);
		
		/*
		 * Add sector one to rightArea panel
		 */
		this.add(this.sectorOne);
		
		/*
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorTwo.setBorder(this.borders[1]);
		
		/*
		 * Add sector two to rightArea panel
		 */
		this.add(this.sectorTwo);
		
		/*
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorThree.setBorder(this.borders[2]);
		
		/*
		 * Add sector three to rightArea panel
		 */
		this.add(this.sectorThree);
		
		/*
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorFour.setBorder(this.borders[3]);
		
		/*
		 * Add sector four to rightArea panel
		 */
		this.add(this.sectorFour);
		
		this.refreshSectors();
	}
	
	/**
	 * Set a padder's name to a sector
	 * @param numSector int
	 * @param padderName String
	 */
	public void setPadderName(int numSector, String padderName)
	{
		if(padderName == null)
			this.borders[numSector-1].setTitle("Sector "+numSector);
		else
			this.borders[numSector-1].setTitle("Sector "+numSector+" : " +padderName);
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	/**
	 * Refresh and show the content of the 4 sectors
	 */
	public void refreshSectors() {
		
		this.sectorOne.removeAll();
		this.sectorTwo.removeAll();
		this.sectorThree.removeAll();
		this.sectorFour.removeAll();
		
		/*
		 * Creates the layout of the sectors
		 */
		GridLayout sectorsGrid = new GridLayout(4,4);
		
		/*
		 * Apply the layout
		 */
		this.sectorOne.setLayout(sectorsGrid);
		this.sectorTwo.setLayout(sectorsGrid);
		this.sectorThree.setLayout(sectorsGrid);
		this.sectorFour.setLayout(sectorsGrid);
		
		/*
		 * Generates the sectors
		 */
		this.generatesSector(1, this.sectorOne);
		this.generatesSector(2, this.sectorTwo);
		this.generatesSector(3, this.sectorThree);
		this.generatesSector(4, this.sectorFour);
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	/**
	 * Generates the given sector
	 * @param numSector
	 * @param theSector Jpanel
	 */
	public void generatesSector(int numSector, JPanel theSector)
	{
		/*
		 *  Make the tables list
		 */
		Collection<Table> tables = null;
		try
		{
			tables = this.mainWindow.restaurant.getTheRoom().getSector(numSector).getTables().values();
		}
		catch (SectorNotExistsException e)
		{
			// impossible
		}
		
		/*
		 * Make a map with the table and its position
		 */
		Map<Position, Table> tablesPositions = new HashMap<Position, Table>();
		
		for(Iterator<Table> tablesIterator = tables.iterator(); tablesIterator.hasNext();)
		{
			Table theTable = (Table) tablesIterator.next();
			tablesPositions.put(theTable.getPosition(), theTable);
		}
		
		/*
		 * Draw the tables in their places in the sector (4x4)
		 */
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(tablesPositions.containsKey(new Position(j, i, 1)))
				{
					Table theTable = tablesPositions.get(new Position(j, i, 1));

					theSector.add(new TableJPanel(theTable));
				}
				else
				{
					theSector.add(new JPanel());
				}
			}
		}
	}
}
