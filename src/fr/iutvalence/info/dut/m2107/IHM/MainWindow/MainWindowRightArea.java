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
import fr.iutvalence.info.dut.m2107.Staff.WaiterDoesNotExistException;
import fr.iutvalence.info.dut.m2107.Staff.WaiterIsNotAPadderException;

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
	 * Generates the right area of the main window
	 * @param mainWindow
	 */
	public MainWindowRightArea(MainWindow mainWindow){
		/*
		 * Save the reference to the main window
		 */
		this.mainWindow = mainWindow;
		
		/*
		 * get the name of all the padder
		 */
		String namePadder1 = "";
		String namePadder2 = "";
		String namePadder3 = "";
		String namePadder4 = "";

		try {
			namePadder1 = this.mainWindow.restaurant.getTheRoom().getSector(1).getPadder().getLastName();
			namePadder2 = this.mainWindow.restaurant.getTheRoom().getSector(2).getPadder().getFirstName() + " " + this.mainWindow.restaurant.getTheRoom().getSector(2).getPadder().getLastName();
			namePadder3 = this.mainWindow.restaurant.getTheRoom().getSector(3).getPadder().getFirstName() + " " + this.mainWindow.restaurant.getTheRoom().getSector(3).getPadder().getLastName();
			namePadder4 = this.mainWindow.restaurant.getTheRoom().getSector(4).getPadder().getFirstName() + " " + this.mainWindow.restaurant.getTheRoom().getSector(4).getPadder().getLastName();
		} catch (SectorNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		
		// TODO : Put the padder's name in the sector's name
		
		/*
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorOne.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 1 : "+ namePadder1));
		
		/*
		 * Add sector one to rightArea panel
		 */
		this.add(this.sectorOne);
		
		/*
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorTwo.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 2 : "+namePadder2));
		
		/*
		 * Add sector two to rightArea panel
		 */
		this.add(this.sectorTwo);
		
		/*
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorThree.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 3"+namePadder3));
		
		/*
		 * Add sector three to rightArea panel
		 */
		this.add(this.sectorThree);
		
		/*
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorFour.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 4 : "+namePadder4));
		
		/*
		 * Add sector four to rightArea panel
		 */
		this.add(this.sectorFour);
		
		this.refreshSectors();
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
