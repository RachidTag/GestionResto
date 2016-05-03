package fr.iutvalence.info.dut.m2107.IHM;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;

/**
 * TODO
 * @author Projet Resto
 *
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	/**
	 * TODO
	 */
	public static JPanel leftArea = new JPanel();
	
	public MainWindow()
	{
	
				/**
				 * General informations and settings of the window...
				 * 
				 */
		
		/**
		 * Set the title of the window
		 */
		this.setTitle("Gestion Resto");
		
		/**
		 * Set size of the window
		 */
		this.setSize(1200, 720);
		
		/**
		 * End window process when red-cross get clicked on
		 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * Set the window centered on the screen
		 */
		this.setLocationRelativeTo(null);
		
		
		
				/**
				 * Left Panel informations and settings...
				 * 
				 */
		
		/**
		 * Create left panel for left area of the splitpanel
		 */
		//TODO: comment for test
		//JPanel leftArea = new JPanel();
		
		/**
		 * Add label of project
		 * TODO: add image, and try/catch if not found, put label instead of image
		 */
		
		ImageIcon icon = new ImageIcon("img/logo.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(143, 90, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		
		JLabel lab = new JLabel(icon);
		
		/**
		 * Add logo label
		 */
		leftArea.add(lab);

		/**
		 * Create the gridlayout where are contained all buttons and control actions
		 */
		GridLayout controlGrid = new GridLayout(8,1);
		
		/**
		 * Create a horizontal and vertical gap of 5 pixels between panel and gridlayout
		 */
		controlGrid.setHgap(5);
		controlGrid.setVgap(5);
		
		/**
		 * Set gridlayout on the panel "leftArea"
		 */
		leftArea.setLayout(controlGrid);
		
		/**
		 * Add "table edition" button
		 * TODO: transform into menu
		 */
		
		ButtonCustomTest editTable = new ButtonCustomTest();
		leftArea.add(editTable);
		
		/**
		 * Add "sector edition" menu
		 * TODO: transform into menu
		 */
		JButton editSector = new JButton("Sector edition");
		leftArea.add(editSector);
		
		/**
		 * Add "check a room" button
		 */
		JButton checkRoom = new JButton("Check a room");
		leftArea.add(checkRoom);
		
		/**
		 * Add "check a schedule" button
		 */
		JButton checkSchedule = new JButton("Check a schedule");
		leftArea.add(checkSchedule);
		
		/**
		 * Add "room manager mod" button
		 */
		JButton roomManager = new JButton("Room manager mod");
		leftArea.add(roomManager);
		
		/**
		 * Add "quit" button
		 */
		JButton exit = new JButton("Close");
		leftArea.add(exit);
		exit.addActionListener(e -> this.dispose());
		
		
		
				/**
				 * Right Panel informations and settings...
				 * 
				 */

		/**
		 * Create right panel for right area of the splitpanel
		 */
		JPanel rightArea = new JPanel();
		
		/**
		 * Grid of right area that contains the 4 panels
		 */
		GridLayout roomGrid = new GridLayout(2,2);
		
		/**
		 * Create a horizontal and vertical gap of x pixels between panel and gridlayout
		 */
		roomGrid.setHgap(20);
		roomGrid.setVgap(10);
		
		/**
		 * Set roomgrid layout on the panel "rightArea"
		 */
		rightArea.setLayout(roomGrid);
		
		/**
		 * Add 4 panels that are the 4 sectors that create one room
		 */
		JPanel sectorOne = new JPanel();
		JPanel sectorTwo = new JPanel();
		JPanel sectorThree = new JPanel();
		JPanel sectorFour = new JPanel();
		
		/**
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		sectorOne.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 1"));
		
		/**
		 * Add sector one to rightArea panel
		 */
		rightArea.add(sectorOne);
		
		/**
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		sectorTwo.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 2"));
		
		/**
		 * Add sector two to rightArea panel
		 */
		rightArea.add(sectorTwo);
		
		/**
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		sectorThree.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 3"));
		
		/**
		 * Add sector three to rightArea panel
		 */
		rightArea.add(sectorThree);
		
		/**
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		sectorFour.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 4"));
		
		/**
		 * Add sector four to rightArea panel
		 */
		rightArea.add(sectorFour);
		
		
		
			/**
			 * Splitpane informations and settings...
			 * 
			 */
	
		/**
		 * Create the splitpane with vertical divider
		 */
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, leftArea, rightArea);
		
		/**
		 * Must be true for SplitPanes
		 */
		splitPane.setOneTouchExpandable(true);
		
		/**
		 * Add splitpane to basic Pane
		 */
		getContentPane().add(splitPane);
		
		/**
		 * Set divider location to 300px, 1/4 of the screen
		 */
		splitPane.setDividerLocation(300);
		
		/**
		 * Disable divider control
		 */
		splitPane.setEnabled(false);
		
		/**
		 * Set divider size to 1 px
		 */
		splitPane.setDividerSize(1);
		
		/**
		 * Set all components and window visibles on screen
		 */
		this.setVisible(true);
		

	}

	

	
}
