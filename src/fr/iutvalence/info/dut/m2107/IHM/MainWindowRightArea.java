package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import fr.iutvalence.info.dut.m2107.room.Position;
import fr.iutvalence.info.dut.m2107.room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.room.Table;

/**
 * @author TODO
 *
 */
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
	 * TODO
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
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorOne.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 1"));
		
		/*
		 * Add sector one to rightArea panel
		 */
		this.add(sectorOne);
		
		/*
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorTwo.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 2"));
		
		/*
		 * Add sector two to rightArea panel
		 */
		this.add(sectorTwo);
		
		/*
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorThree.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 3"));
		
		/*
		 * Add sector three to rightArea panel
		 */
		this.add(sectorThree);
		
		/*
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorFour.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 4"));
		
		/*
		 * Add sector four to rightArea panel
		 */
		this.add(sectorFour);
		
		this.refreshSectors();
	}
	
	/**
	 * TODO
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
	
	public void generatesSector(int numSector, JPanel theSector)
	{
		Collection<Table> tables = null;
		try
		{
			tables = this.mainWindow.theRoom.getSector(numSector).getTables().values();
		}
		catch (SectorNotExistsException e)
		{
			// impossible
		}
		
		Map<Position, Table> tablesPositions = new HashMap<Position, Table>();
		
		for(Iterator tablesIterator = tables.iterator(); tablesIterator.hasNext();)
		{
			Table theTable = (Table) tablesIterator.next();
			tablesPositions.put(theTable.getPosition(), theTable);
		}
		
		ImageIcon tableVerte4 = new ImageIcon("img/tableVerte4Projet.png");
		Image tableVerte4Rot1 = tableVerte4.getImage();
		tableVerte4Rot1 = tableVerte4Rot1.getScaledInstance(84, 64, Image.SCALE_SMOOTH);
		tableVerte4 = new ImageIcon(tableVerte4Rot1);
		
		ImageIcon tableVerte4Rot = new ImageIcon("img/tableVerte4ProjetRot2.png");
		Image tableVerte4Rot2 = tableVerte4Rot.getImage();
		tableVerte4Rot2 = tableVerte4Rot2.getScaledInstance(64, 74, Image.SCALE_SMOOTH);
		tableVerte4Rot = new ImageIcon(tableVerte4Rot2);
		
		ImageIcon tableVerte2 = new ImageIcon("img/tableVerte2Projet.png");
		Image tableVerte2Rot1 = tableVerte2.getImage();
		tableVerte2Rot1 = tableVerte2Rot1.getScaledInstance(42, 64, Image.SCALE_SMOOTH);
		tableVerte2 = new ImageIcon(tableVerte2Rot1);
		
		ImageIcon tableVerte2Rot = new ImageIcon("img/tableVerte2ProjetRot2.png");
		Image tableVerte2Rot2 = tableVerte2Rot.getImage();
		tableVerte2Rot2 = tableVerte2Rot2.getScaledInstance(64, 42, Image.SCALE_SMOOTH);
		tableVerte2Rot = new ImageIcon(tableVerte2Rot2);
		
		//To resize
		ImageIcon tableVerte6 = new ImageIcon("img/tableVerte6ProjetRot2.png");
		Image tableVerte6Rot1 = tableVerte6.getImage();
		tableVerte6Rot1 = tableVerte6Rot1.getScaledInstance(84, 64, Image.SCALE_SMOOTH);
		tableVerte6 = new ImageIcon(tableVerte6Rot1);
		//To resize
		ImageIcon tableVerte6Rot = new ImageIcon("img/tableVerte6Projet.png");
		Image tableVerte6Rot2 = tableVerte6Rot.getImage();
		tableVerte6Rot2 = tableVerte6Rot2.getScaledInstance(64, 84, Image.SCALE_SMOOTH);
		tableVerte6Rot = new ImageIcon(tableVerte6Rot2);
		
		
		
		ImageIcon imgB = new ImageIcon("img/labelBlanc.png");
		Image img2 = imgB.getImage();
		img2 = img2.getScaledInstance(84, 64, Image.SCALE_SMOOTH);
		imgB= new ImageIcon(img2);
		
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(tablesPositions.containsKey(new Position(j, i, 1)))
				{
					Table theTable = tablesPositions.get(new Position(j, i, 1));
					JLabel TVerte = new JLabel(tableVerte4);
					JLabel TVerteRot = new JLabel(tableVerte4Rot);
					JLabel TVerte2 = new JLabel(tableVerte2);
					JLabel TVerte2Rot = new JLabel(tableVerte2Rot);
					JLabel TVerte6 = new JLabel(tableVerte6);
					JLabel TVerte6Rot = new JLabel(tableVerte6Rot);
					int rot = theTable.getPosition().getRotation();
					int nbPlace = theTable.getNumberPlaces();
					
					if(rot == 1 && nbPlace == 4)
					{
						theSector.add(TVerte);
					}
					if(rot == 1 && nbPlace == 2)
					{
						theSector.add(TVerte2);
					}
					if(rot == 1 && nbPlace == 6)
					{
						theSector.add(TVerte6);
					}
					if(rot == 2 && nbPlace == 4)
					{
						theSector.add(TVerteRot);
					}
					if(rot == 2 && nbPlace == 2)
					{
						theSector.add(TVerte2Rot);
					}
					if(rot == 2 && nbPlace == 6)
					{
						theSector.add(TVerte6Rot);
					}
					
					
				}
				else
				{
					JLabel tbis = new JLabel(imgB);
					theSector.add(tbis);
				}
			}
		}
	}
}
