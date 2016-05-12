package fr.iutvalence.info.dut.m2107.IHM;
import javax.swing.*;
import javax.swing.border.*;

import fr.iutvalence.info.dut.m2107.calendar.Calendar;
import fr.iutvalence.info.dut.m2107.room.Room;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TODO
 * @author Projet Resto
 *
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame implements ActionListener {
	
	/**
	 * Create left panel for left area of the splitpanel
	 */
	public JPanel leftArea;
	
	/**
	 * Create left panel for left area of the splitpanel
	 */
	public JPanel rightArea;	

	/**
	 * 
	 */
	public JButton editTable;
	
	/**
	 * 
	 */
	public JButton editSector;

	/**
	 * 
	 */
	public JButton checkRoom;

	/**
	 * 
	 */
	public JButton checkSchedule;

	/**
	 * 
	 */
	public JButton roomManager;
	
	/**
	 * 
	 */
	public JButton close;
	
	/**
	 * 
	 */
	public EditTableWindow editTableWindow;
	
	/**
	 * 
	 */
	public SectorEditionWindow editSectorWindow;
	
	/**
	 * 
	 */
	
	public Room theRoom;

	public Calendar theCalendar;

	public JPanel sectorOne;

	public JPanel sectorTwo;

	public JPanel sectorThree;

	public JPanel sectorFour;
		
	/**
	 * 
	 */
	public MainWindow(Room theRoom, Calendar theCalendar)
	{		
		this.theRoom = theRoom;
		this.theCalendar = theCalendar;
		
		/**
		 * Set the title of the window
		 */
		this.setTitle("Gestion Resto");
		
		/**
		 * The window isn't resizable
		 */
		this.setResizable(false);
		
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
		 * Init 
		 */
		this.leftArea = new JPanel();
		this.rightArea = new JPanel();
		
		/**
		 * left panel edit
		 */
		
		/**
		 * 
		 */
		GridLayout leftPanelControlGrid = new GridLayout(8,1);

		/**
		 * Create an horizontal and vertical gap of 5 pixels between panel and gridlayout
		 */
		leftPanelControlGrid.setHgap(5);
		leftPanelControlGrid.setVgap(5);
		
		/**
		 * Set gridlayout on the panel "leftArea"
		 */
		this.leftArea.setLayout(leftPanelControlGrid);
		
		/**
		 * Left Panel informations and settings...
		 */
		
		/**
		 * Add the logo
		 */
		ImageIcon icon = new ImageIcon("img/logo.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(143, 90, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		
		JLabel lab = new JLabel(icon);
		this.leftArea.add(lab);
		
		/**
		 * Add "table edition" button
		 */
		this.editTable = new JButton("Edit Table");
		this.editTable.addActionListener(this);
		this.leftArea.add(this.editTable);		

		/**
		 * Add "sector edition" menu
		 */
		this.editSector = new JButton("Edit Sector");
		this.editSector.addActionListener(this);
		this.leftArea.add(this.editSector);
		
		/**
		 * Add "check a room" button
		 */
		this.checkRoom = new JButton("Check the room");
		this.checkRoom.addActionListener(this);
		this.leftArea.add(this.checkRoom);
		
		/**
		 * Add "check a schedule" button
		 */
		this.checkSchedule = new JButton("Check the Schedule");
		this.checkSchedule.addActionListener(this);
		this.leftArea.add(this.checkSchedule);
		
		/**
		 * Add "room manager mod" button
		 */
		this.roomManager = new JButton("Room Manager mod");
		this.roomManager.addActionListener(this);
		this.leftArea.add(this.roomManager);
		
		/**
		 * Add "quit" button
		 */
		this.close = new JButton("Close");
		this.close.addActionListener(this);
		this.leftArea.add(this.close);
		
		
		/**
		 * Right Panel informations and settings...
		 * 
		 */
		
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
		this.rightArea.setLayout(roomGrid);
		
		/**
		 * Add 4 panels that are the 4 sectors that create one room
		 */
		this.sectorOne = new JPanel();
		this.sectorTwo = new JPanel();
		this.sectorThree = new JPanel();
		this.sectorFour = new JPanel();
		
		/**
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorOne.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 1"));
		
		/**
		 * Add sector one to rightArea panel
		 */
		this.rightArea.add(sectorOne);
		
		/**
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorTwo.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 2"));
		
		/**
		 * Add sector two to rightArea panel
		 */
		this.rightArea.add(sectorTwo);
		
		/**
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorThree.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 3"));
		
		/**
		 * Add sector three to rightArea panel
		 */
		this.rightArea.add(sectorThree);
		
		/**
		 * Create new border Titled with sector name, 5 black pixel wide
		 */
		this.sectorFour.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Sector 4"));
		
		/**
		 * Add sector four to rightArea panel
		 */
		this.rightArea.add(sectorFour);
		
		
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

		GridLayout sectorOneGrid = new GridLayout(1,3);
		
		this.sectorOne.setLayout(sectorOneGrid);
		
		ImageIcon table = new ImageIcon("img/tableVerteProjet.png");
		Image img1 = table.getImage();
		img1 = img1.getScaledInstance(100, 75, Image.SCALE_SMOOTH);
		table = new ImageIcon(img1);
		
		JLabel t = new JLabel(table);
		t.setSize(10, 10);
		
		this.sectorOne.add(t);
		
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			int response = JOptionPane.showConfirmDialog(null, "Do you wish to close the application?", "Confirm",
			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
			    	System.exit(0);
			    }
			
		}
		else if(source == this.editTable)
		{
			if(this.editTable.isEnabled())
			{
				this.editTableWindow = new EditTableWindow(this);
				this.editTable.setEnabled(false);
				this.editSector.setEnabled(false);
				this.checkRoom.setEnabled(false);
				this.checkSchedule.setEnabled(false);
				this.roomManager.setEnabled(false);
				this.close.setEnabled(false);
			}	
		}
		else if(source == this.editSector)
		{
			if(this.editSector.isEnabled())
			{
				this.editSectorWindow = new SectorEditionWindow(this);
				this.editTable.setEnabled(false);
				this.editSector.setEnabled(false);
				this.checkRoom.setEnabled(false);
				this.checkSchedule.setEnabled(false);
				this.roomManager.setEnabled(false);
				this.close.setEnabled(false);
			}				
		}
		else
		{
			// TODO
		}
		
	}
}
