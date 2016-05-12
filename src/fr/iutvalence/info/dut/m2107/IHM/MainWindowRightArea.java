package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import fr.iutvalence.info.dut.m2107.room.Position;
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
	}
	
	public void refreshSectors() {
		GridLayout sectorsGrid = new GridLayout(2,2);

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
		
		ImageIcon imgT = new ImageIcon("img/tableVerteProjet.png");
		Image img1 = imgT.getImage();
		img1 = img1.getScaledInstance(100, 75, Image.SCALE_SMOOTH);
		imgT= new ImageIcon(img1);
		
		JLabel t = new JLabel(imgT);
		t.setSize(10, 10);	
		
		Table t1 = new Table(1 , 4 , new Position(1,1, 2), "Claude");
		Table t2 = new Table(2 , 4 , new Position(1,2, 2), "Micka");
		Table t3 = new Table(3 , 4 , new Position(2,1, 2), "Alfred");
		Table t4 = new Table(4 , 4 , new Position(2,2, 2), "Florent");
		
		Set<Position> table = new TreeSet<Position>();
		 
		table.add(t1.getPosition());
		table.add(t2.getPosition());
		table.add(t3.getPosition());
		table.add(t4.getPosition());
		
		Position[] positions = table.toArray(new Position[1]);
		
		Position first = positions[0];
		
		
		this.sectorOne.add(t);
		
	}
}
