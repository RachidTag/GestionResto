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
					String tableLink = "img/table";
					
					Table theTable = tablesPositions.get(new Position(j, i, 1));
					
					int rot = theTable.getPosition().getRotation();
					int nbPlace = theTable.getNumberPlaces();
					State state = theTable.getState();
					String numTable = String.valueOf(theTable.getNumTable());
					
					int sizeX = 0;
					int sizeY = 0;
					
					switch(state)
					{
						case FREE:
							tableLink += "Verte";
							break;
						case BUSY:
							tableLink += "Rouge";
							break;
						case RESERVED:
							tableLink += "Bleu";
							break;
						case GRIMY:
							tableLink += "Orange";
							break;
					}
					
					switch(nbPlace)
					{
						case 2:
							tableLink += "2Projet";
							sizeX = 40;
							sizeY = 60;
							break;
						case 4:
							tableLink += "4Projet";
							sizeX = 75;
							sizeY = 60;
							break;
						case 6:
							tableLink += "6Projet";
							sizeX = 75;
							sizeY = 70;
							break;
					}
					
					switch(rot)
					{
						case 2:
							tableLink += "Rot2";
							int provisoire = sizeX;
							sizeX = sizeY;
							sizeY = provisoire;
							break;
					}

					theSector.add(new JLabel(returnImage(tableLink+".png", sizeX , sizeY, numTable)));
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
