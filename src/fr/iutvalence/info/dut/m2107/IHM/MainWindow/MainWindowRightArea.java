package fr.iutvalence.info.dut.m2107.IHM.MainWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import fr.iutvalence.info.dut.m2107.Room.Position;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Room.State;
import fr.iutvalence.info.dut.m2107.Room.Table;

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
					
					String numTable = ""+theTable.getNumTable();
					
					JLabel TVerte = new JLabel(returnImage("img/tableVerte4Projet.png", 84 , 64, numTable));
					JLabel TVerteRot = new JLabel(returnImage("img/tableVerte4ProjetRot2.png", 64 , 74, numTable));
					JLabel TVerte2 = new JLabel(returnImage("img/tableVerte2Projet.png", 42 , 64, numTable));
					JLabel TVerte2Rot = new JLabel(returnImage("img/tableVerte2ProjetRot2.png", 64 , 42, numTable));
					JLabel TVerte6 = new JLabel(returnImage("img/tableVerte6Projet.png", 84 , 74, numTable));
					JLabel TVerte6Rot = new JLabel(returnImage("img/tableVerte6ProjetRot2.png", 74 , 74, numTable));
					
					JLabel TRouge = new JLabel(returnImage("img/tableRouge4Projet.png", 84, 64, numTable));
					JLabel TRougeRot = new JLabel(returnImage("img/tableRouge4ProjetRot2.png", 64, 74, numTable));
					JLabel TRouge2 = new JLabel(returnImage("img/tableRouge2Projet.png", 42, 64, numTable));
					JLabel TRouge2Rot = new JLabel(returnImage("img/tableRouge2ProjetRot2.png", 64, 42, numTable));
					JLabel TRouge6 = new JLabel(returnImage("img/tableRouge6Projet.png", 84, 74, numTable));
					JLabel TRouge6Rot = new JLabel(returnImage("img/tableRouge6ProjetRot2.png", 74, 74, numTable));
					
					JLabel TBleu = new JLabel(returnImage("img/tableBLeu4Projet.png", 84, 64, numTable));
					JLabel TBleuRot = new JLabel(returnImage("img/tableBleu4ProjetRot2.png", 64, 74, numTable));
					JLabel TBleu2 = new JLabel(returnImage("img/tableBleu2Projet.png", 42, 64, numTable));
					JLabel TBleu2Rot = new JLabel(returnImage("img/tableBleu2ProjetRot2.png", 64, 42, numTable));
					JLabel TBleu6 = new JLabel(returnImage("img/tableBleu6Projet.png", 84, 74, numTable));
					JLabel TBleu6Rot = new JLabel(returnImage("img/tableBleu6ProjetRot2.png", 74, 74, numTable));	
					
					JLabel TOrange = new JLabel(returnImage("img/tableOrange4Projet.png", 84, 64, numTable));
					JLabel TOrangeRot = new JLabel(returnImage("img/tableOrange4ProjetRot2.png", 64, 74, numTable));
					JLabel TOrange2 = new JLabel(returnImage("img/tableOrange2Projet.png", 42, 64, numTable));
					JLabel TOrange2Rot = new JLabel(returnImage("img/tableOrange2ProjetRot2.png", 64, 42, numTable));
					JLabel TOrange6 = new JLabel(returnImage("img/tableOrange6Projet.png", 84, 74, numTable));
					JLabel TOrange6Rot = new JLabel(returnImage("img/tableOrange6ProjetRot2.png", 74, 74, numTable));
					
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
					JLabel tbis = new JLabel(returnImage("img/labelBlanc.png", 84, 64, ""));
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
	public ImageIcon returnImage(String image, int h , int l, String numTable)
	{
		/*
		 * Resizes the image
		 */
		BufferedImage bufferedBackgroundImage = null;
		try
		{
			bufferedBackgroundImage = ImageIO.read(new File(image));
		}
		catch (IOException e)
		{
			System.err.println("Table background image missing !");
		}
		
		Image resizedBackgroundImage = new ImageIcon(bufferedBackgroundImage).getImage();
		resizedBackgroundImage = resizedBackgroundImage.getScaledInstance(h, l, Image.SCALE_SMOOTH);
		
		/*
		 * Make the buffered background image from the resized image
		 */
		bufferedBackgroundImage = new BufferedImage(resizedBackgroundImage.getWidth(null), resizedBackgroundImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D bGr = bufferedBackgroundImage.createGraphics();
	    bGr.drawImage(resizedBackgroundImage, 0, 0, null);
	    
	    /*
	     * Set the good font to the Graphics
	     */
		Font theFont = new Font("TimesRoman", Font.PLAIN, 18);
		bGr.setFont(theFont);
		
		/*
		 * If the image is not a White label, put the table num with a background
		 */
		if(!image.equals("img/labelBlanc.png"))
		{
			/*
			 * Get the metrics from the font to know where to put the text
			 */
    	    FontMetrics metrics = bGr.getFontMetrics(theFont);
    	    
    	    /*
    	     * Get the text's coordinates
    	     */
    	    int x = (bufferedBackgroundImage.getWidth()-metrics.stringWidth(numTable))/2;
    	    int y = ((bufferedBackgroundImage.getHeight()-metrics.getHeight())/2) + metrics.getAscent();

            Rectangle2D rect = metrics.getStringBounds(numTable, bGr);
            
            /*
             * Draw the rect
             */
            bGr.setColor(Color.BLACK);
            bGr.fillRect(x-1, ((bufferedBackgroundImage.getHeight()-metrics.getHeight())/2)+4,
                       (int) rect.getWidth()+1,
                       (int) rect.getHeight()-4);
    		
            /*
             * Drax the num
             */
            bGr.setColor(Color.white);
            bGr.drawString(numTable, x, y);
		}
		
		bGr.dispose();
		
		return new ImageIcon(bufferedBackgroundImage);
	}
}
