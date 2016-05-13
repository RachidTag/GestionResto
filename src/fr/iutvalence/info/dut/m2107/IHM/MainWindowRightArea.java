package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Collection;
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
		 * Make a loop for each sectors
		 * *Mode français activé*
		 * Elle parcours les tables, les met dans un tableau 2D tableTable[10][10]; en fonction de leurs coordonnées
		 * Ensuite on parcours ces tableaux dans l'ordre des coordonnées et si pour les coordonnées données il y a une table on l'ajoute au pannel
		 * si non on ajoute le vide #le néantBgJtm
		 */
		
		Set<Position> tablePos = new TreeSet<Position>();

		Collection<Table> tables = null;
		try
		{
			tables = this.mainWindow.theRoom.getSector(1).getTables().values();
		}
		catch (SectorNotExistsException e)
		{
			// impossible
		}
		
		for(Iterator tablesIterator = tables.iterator();tablesIterator.hasNext();)
		{
			Table currentTable = (Table) tablesIterator.next();
			tablePos.add(currentTable.getPosition());
		}
		
		ImageIcon imgT = new ImageIcon("img/tableVerteProjet.png");
		Image img1 = imgT.getImage();
		img1 = img1.getScaledInstance(105, 77, Image.SCALE_SMOOTH);
		imgT= new ImageIcon(img1);
		
		ImageIcon imgB = new ImageIcon("img/labelBlanc.jpg");
		Image img2 = imgB.getImage();
		img2 = img2.getScaledInstance(105, 77, Image.SCALE_SMOOTH);
		imgB= new ImageIcon(img2);
		
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				JLabel t = new JLabel(imgT);
				t.setBorder(BorderFactory.createLineBorder(Color.black));
				JLabel tbis = new JLabel(imgB);
				tbis.setBorder(BorderFactory.createLineBorder(Color.black));
				
				if(tablePos.contains(new Position(j, i, 1)))
				{
					this.sectorOne.add(t);
				}
				else
				{
					this.sectorOne.add(tbis);
				}
			}
		}
		
	}
}
