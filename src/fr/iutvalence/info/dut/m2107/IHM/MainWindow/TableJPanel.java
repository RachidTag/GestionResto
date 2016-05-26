package fr.iutvalence.info.dut.m2107.IHM.MainWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.iutvalence.info.dut.m2107.IHM.EditTableWindow.EditTableWindow;
import fr.iutvalence.info.dut.m2107.IHM.EditTableWindow.EditTableWindowEditArea;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Room.State;
import fr.iutvalence.info.dut.m2107.Room.Table;
import fr.iutvalence.info.dut.m2107.Room.TableNotExistsException;

/**
 * This class represents the Table's jlabel (Image)
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class TableJPanel extends JPanel implements MouseListener
{	
	/**
	 * TODO
	 */
	private Table theTable;
	
	/**
	 * TODO
	 */
	private MainWindowRightArea mainWindowRightArea;

	/**
	 * TODO
	 */
	private int numSector;

	/**
	 * Generates the table jpanel
	 * @param theTable (Table)
	 * @param numSector (int)
	 * @param mainWindowRightArea  (MainWindowRightArea)
	 */
	public TableJPanel(Table theTable, int numSector, MainWindowRightArea mainWindowRightArea)
	{
		/*
		 * TODO
		 */
		this.theTable = theTable;
		
		/*
		 * TODO
		 */
		this.numSector = numSector;
		
		/*
		 * TODO
		 */
		this.mainWindowRightArea = mainWindowRightArea;
		
		String tableLink = "img/table";
		
		int rot = theTable.getPosition().getRotation();
		int nbPlace = theTable.getNumberPlaces();
		State state = theTable.getState();
		String numTable = String.valueOf(theTable.getNumTable());
		
		int sizeX = 0;
		int sizeY = 0;
		
		// Add the table color to the link
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
		
		// Add the nb of places to the link + the table size
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
		
		// Add the table rotation to the link (+ exchange the table size if it rotates)
		switch(rot)
		{
			case 2:
				tableLink += "Rot2";
				int provisoire = sizeX;
				sizeX = sizeY;
				sizeY = provisoire;
				break;
		}
		
		// Add the image of the table + the num of the table to the JPanel
		this.addMouseListener(this);
		this.add(new JLabel(returnImage(tableLink+".png", sizeX , sizeY, numTable)));
		
	
		
		// TODO : make that when we click on the table, it opens the edit table window 
	}

	/**
	 * Returns the table ImageIcon with its number in the middle
	 * @param image link
	 * @param h height
	 * @param l widht
	 * @param numTable int
	 * @return ImageIcon
	 */
	public ImageIcon returnImage(String image, int h , int l, String numTable)
	{
		/*
		 * Get the image
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
		
		/*
		 * Resizes the image
		 */
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
		 * Put the table num with a background
		 */
		
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
		
		bGr.dispose();
		
		return new ImageIcon(bufferedBackgroundImage);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		/*
		 * Opens the edit table window edit area with the selected table's form
		 */
		this.mainWindowRightArea.mainWindow.editTableWindow = new EditTableWindow(this.mainWindowRightArea.mainWindow);
		this.mainWindowRightArea.mainWindow.editTableWindow.R_Area.removeAll();
		EditTableWindowEditArea editTableWindowEditArea = new EditTableWindowEditArea(this.mainWindowRightArea.mainWindow.editTableWindow);
		try {
			editTableWindowEditArea.selectTheTable(this.theTable.getNumTable(), this.numSector);
		} catch (SectorNotExistsException | TableNotExistsException e) {
			System.err.println("Error, the sector or the table doesn't exist!");
		}
		SwingUtilities.updateComponentTreeUI(this.mainWindowRightArea.mainWindow.editTableWindow);
		this.mainWindowRightArea.mainWindow.disable();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
}
