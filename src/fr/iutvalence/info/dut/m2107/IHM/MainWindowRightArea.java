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
		 * *Mode fran�ais activ�*
		 * Elle parcours les tables, les met dans un tableau 2D tableTable[10][10]; en fonction de leurs coordonn�es
		 * Ensuite on parcours ces tableaux dans l'ordre des coordonn�es et si pour les coordonn�es donn�es il y a une table on l'ajoute au pannel
		 * si non on ajoute le vide #le n�antBgJtm
		 */
		
		Table t1 = new Table(1 , 4 , new Position(1,1, 2), "Claude");
		Table t2 = new Table(2 , 4 , new Position(1,3, 2), "Micka");
		Table t3 = new Table(3 , 4 , new Position(2,2, 2), "Alfred");
		Table t4 = new Table(4 , 4 , new Position(3,2, 2), "Florent");
		
		Set<Position> tablePos = new TreeSet<Position>();
		 
		tablePos.add(t1.getPosition());
		tablePos.add(t2.getPosition());
		tablePos.add(t3.getPosition());
		tablePos.add(t4.getPosition());
		
		Position[] positions = tablePos.toArray(new Position[0]);
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				ImageIcon imgT = new ImageIcon("img/tableVerteProjet.png");
				Image img1 = imgT.getImage();
				img1 = img1.getScaledInstance(100, 75, Image.SCALE_SMOOTH);
				imgT= new ImageIcon(img1);
				
				JLabel t = new JLabel(imgT);
				t.setSize(10, 10);
				
				ImageIcon imgB = new ImageIcon("img/labelBlanc.jpg");
				Image img2 = imgB.getImage();
				img2 = img2.getScaledInstance(100, 75, Image.SCALE_SMOOTH);
				imgB= new ImageIcon(img2);
				
				JLabel tbis = new JLabel(imgB);
				tbis.setSize(10, 10);
				
				for(int k = 0; k < tablePos.size(); k++)
				{
					if(positions[k].hasSamePosition(j,i))
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
		
		//this.sectorOne.add(t);
		
	}
}
