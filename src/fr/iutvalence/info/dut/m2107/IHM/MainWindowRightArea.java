package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import fr.iutvalence.info.dut.m2107.room.Position;
import fr.iutvalence.info.dut.m2107.room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.room.State;
import fr.iutvalence.info.dut.m2107.room.Table;

/**
 * @author TODO
 *
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
	
	/**
	 * TODO
	 * @param numSector
	 * @param theSector
	 */
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
		
		for(Iterator<Table> tablesIterator = tables.iterator(); tablesIterator.hasNext();)
		{
			Table theTable = (Table) tablesIterator.next();
			tablesPositions.put(theTable.getPosition(), theTable);
		}
			
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(tablesPositions.containsKey(new Position(j, i, 1)))
				{
					Table theTable = tablesPositions.get(new Position(j, i, 1));

					JLabel TVerte = new JLabel(returnImage("img/tableVerte4Projet.png", 84 , 64));
					JLabel TVerteRot = new JLabel(returnImage("img/tableVerte4ProjetRot2.png", 64 , 74));
					JLabel TVerte2 = new JLabel(returnImage("img/tableVerte2Projet.png", 42 , 64));
					JLabel TVerte2Rot = new JLabel(returnImage("img/tableVerte2ProjetRot2.png", 64 , 42));
					JLabel TVerte6 = new JLabel(returnImage("img/tableVerte6Projet.png", 84 , 74));
					JLabel TVerte6Rot = new JLabel(returnImage("img/tableVerte6ProjetRot2.png", 74 , 74));
					
					JLabel TRouge = new JLabel(returnImage("img/tableRouge4Projet.png", 84, 64));
					JLabel TRougeRot = new JLabel(returnImage("img/tableRouge4ProjetRot2.png", 64, 74));
					JLabel TRouge2 = new JLabel(returnImage("img/tableRougeProjet.png", 42, 64));
					JLabel TRouge2Rot = new JLabel(returnImage("img/tableRouge2ProjetRot2.png", 64, 42));
					JLabel TRouge6 = new JLabel(returnImage("img/tableRouge6Projet.png", 84, 74));
					JLabel TRouge6Rot = new JLabel(returnImage("img/tableRouge6ProjetRot2.png", 74, 74));
					
					JLabel TBleu = new JLabel(returnImage("img/tableBLeu4Projet.png", 84, 64));
					JLabel TBleuRot = new JLabel(returnImage("img/tableBleu4ProjetRot2.png", 64, 74));
					JLabel TBleu2 = new JLabel(returnImage("img/tableBleu2Projet.png", 42, 64));
					JLabel TBleu2Rot = new JLabel(returnImage("img/tableBleu2ProjetRot2.png", 64, 42));
					JLabel TBleu6 = new JLabel(returnImage("img/tableBleu6Projet.png", 84, 74));
					JLabel TBleu6Rot = new JLabel(returnImage("img/tableBleu6ProjetRot2.png", 74, 74));	
					
					JLabel TOrange = new JLabel(returnImage("img/tableOrange4Projet.png", 84, 64));
					JLabel TOrangeRot = new JLabel(returnImage("img/tableOrange4ProjetRot2.png", 64, 74));
					JLabel TOrange2 = new JLabel(returnImage("img/tableOrangeProjet.png", 42, 64));
					JLabel TOrange2Rot = new JLabel(returnImage("img/tableOrange2ProjetRot2.png", 64, 42));
					JLabel TOrange6 = new JLabel(returnImage("img/tableOrange6Projet.png", 84, 74));
					JLabel TOrange6Rot = new JLabel(returnImage("img/tableOrange6ProjetRot2.png", 74, 74));
					
					int rot = theTable.getPosition().getRotation();
					int nbPlace = theTable.getNumberPlaces();
					State state = theTable.getState();
					
					if(rot == 1 && nbPlace == 4 && state == State.FREE)
					{
						theSector.add(TVerte);
					}
					if(rot == 2 && nbPlace == 4 && state == State.FREE)
					{
						theSector.add(TVerteRot);
					}
					if(rot == 1 && nbPlace == 2 && state == State.FREE)
					{
						theSector.add(TVerte2);
					}
					if(rot == 2 && nbPlace == 2 && state == State.FREE)
					{
						theSector.add(TVerte2Rot);
					}
					if(rot == 1 && nbPlace == 6 && state == State.FREE)
					{
						theSector.add(TVerte6);
					}
					if(rot == 2 && nbPlace == 6 && state == State.FREE)
					{
						theSector.add(TVerte6Rot);
					}
					
					
					if(rot == 1 && nbPlace == 4 && state == State.BUSY)
					{
						theSector.add(TRouge);
					}
					if(rot == 2 && nbPlace == 4 && state == State.BUSY)
					{
						theSector.add(TRougeRot);
					}
					if(rot == 1 && nbPlace == 2 && state == State.BUSY)
					{
						theSector.add(TRouge2);
					}
					if(rot == 2 && nbPlace == 2 && state == State.BUSY)
					{
						theSector.add(TRouge2Rot);
					}
					if(rot == 1 && nbPlace == 6 && state == State.BUSY)
					{
						theSector.add(TRouge6);
					}
					if(rot == 1 && nbPlace == 6 && state == State.BUSY)
					{
						theSector.add(TRouge6Rot);
					}
					
					
					if(rot == 1 && nbPlace == 4 && state == State.RESERVED)
					{
						theSector.add(TBleu);
					}
					if(rot == 2 && nbPlace == 4 && state == State.RESERVED)
					{
						theSector.add(TBleuRot);
					}
					if(rot == 1 && nbPlace == 2 && state == State.RESERVED)
					{
						theSector.add(TBleu2);
					}
					if(rot == 2 && nbPlace == 2 && state == State.RESERVED)
					{
						theSector.add(TBleu2Rot);
					}
					if(rot == 1 && nbPlace == 6 && state == State.RESERVED)
					{
						theSector.add(TBleu6);
					}
					if(rot == 2 && nbPlace == 6 && state == State.RESERVED)
					{
						theSector.add(TBleu6Rot);
					}
					
					
					if(rot == 1 && nbPlace == 4 && state == State.GRIMY)
					{
						theSector.add(TOrange);
					}
					if(rot == 2 && nbPlace == 4 && state == State.GRIMY)
					{
						theSector.add(TOrangeRot);
					}
					if(rot == 1 && nbPlace == 2 && state == State.GRIMY)
					{
						theSector.add(TOrange2);
					}
					if(rot == 2 && nbPlace == 2 && state == State.GRIMY)
					{
						theSector.add(TOrange2Rot);
					}
					if(rot == 1 && nbPlace == 6 && state == State.GRIMY)
					{
						theSector.add(TOrange6);
					}
					if(rot == 2 && nbPlace == 6 && state == State.GRIMY)
					{
						theSector.add(TOrange6Rot);
					}
						
				}
				else
				{
					JLabel tbis = new JLabel(returnImage("img/labelBlanc.png", 84, 64));
					theSector.add(tbis);
				}
			}
		}
	}
	
	/**
	 * TODO
	 * @param image
	 * @param h
	 * @param l
	 * @return ImageIcon
	 */
	public ImageIcon returnImage(String image, int h , int l)
	{
		ImageIcon image1 = new ImageIcon(image);
		Image image2 = image1.getImage();
		image2 = image2.getScaledInstance(h, l, Image.SCALE_SMOOTH);
		image1= new ImageIcon(image2);
		return image1;
	}
}
