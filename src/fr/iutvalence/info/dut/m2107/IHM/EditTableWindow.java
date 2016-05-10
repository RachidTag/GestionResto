package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import fr.iutvalence.info.dut.m2107.room.ObjectReadedIsNotARoomException;
import fr.iutvalence.info.dut.m2107.room.Room;
import fr.iutvalence.info.dut.m2107.room.Sector;

class EditTableWindowEventHandler extends WindowAdapter {
	public void windowClosing(WindowEvent evt) {
		MainWindow.editSector.setEnabled(true);
		MainWindow.editTable.setEnabled(true);
		MainWindow.checkRoom.setEnabled(true);
		MainWindow.checkSchedule.setEnabled(true);
		MainWindow.roomManager.setEnabled(true);
		MainWindow.close.setEnabled(true);
	    MainWindow.editTableWindow.setVisible(false);
	    MainWindow.editTableWindow.R_Area.removeAll();
	}
}

/**
 * TODO
 * @author Projet Resto
 *
 */
@SuppressWarnings("serial")
public class EditTableWindow extends JFrame {
	
	/**
	 * Left Area
	 */
	public static JPanel L_Area = new JPanel();
	/**
	 * Right Area
	 */
	public static JPanel R_Area = new JPanel();
	
	/**
	 * Buttons
	 */
	private static JButton edit = new JButton("Edit Table");
	private static JButton delete = new JButton("Delete Table");
	private static JButton add = new JButton("Add Table");
	private static JButton close = new JButton("close");
	
	/**
	 * Default menu text
	 */
	private static JLabel defaultText = new JLabel("Menu d'édition des tables");
	
	/**
	 * Add table form
	 */
	public static JSpinner tableNum; 
	public static JSpinner numOfPlaces; 
	public static JSpinner posX; 
	public static JSpinner posY; 
	public static JSpinner rotation; 
	public static JComboBox<?> sectorNum;
	
	/**
	 * 
	 */
	public EditTableWindow()
	{		
		this.addWindowListener(new EditTableWindowEventHandler());
		this.setTitle("Edit Table");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, EditTableWindow.L_Area, EditTableWindow.R_Area);
		split.setOneTouchExpandable(true);
		getContentPane().add(split);
		split.setDividerLocation(120);
		split.setEnabled(false);
		split.setDividerSize(1);

		GridLayout controlPanel = new GridLayout(4,1);
		EditTableWindow.L_Area.setLayout(controlPanel);
		
		EditTableWindow.L_Area.add(edit);
		EditTableWindow.L_Area.add(delete);
		EditTableWindow.L_Area.add(add);
		EditTableWindow.L_Area.add(close);
		
		close.addMouseListener(new EditTableWindowCloseButton());
		add.addMouseListener(new EditTableWindowAddButton());
		
		EditTableWindow.R_Area.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		EditTableWindow.R_Area.add(defaultText, gbc);
		defaultText.setFont(defaultText.getFont().deriveFont(Font.ITALIC, 24.f));
		
		this.setVisible(true);
	}
	
	/**
	 * 
	 */
	public static void addTableArea() {
		EditTableWindow.R_Area.removeAll();
		
		GridLayout controlPanel = new GridLayout(8,1);
		EditTableWindow.R_Area.setLayout(controlPanel);
		
		JLabel title = new JLabel("Table adding", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 20.f));
		
		EditTableWindow.R_Area.add(title);
		
		JPanel line = new JPanel();
		GridLayout lineLayout = new GridLayout(1, 2);
		line.setLayout(lineLayout);
		EditTableWindow.R_Area.add(line);
		
		line.add(new JLabel("Table num:"));
		SpinnerModel spinnerModel =	new SpinnerNumberModel(0, 0, 1000, 1);
		tableNum = new JSpinner(spinnerModel);
		line.add(tableNum);

		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		EditTableWindow.R_Area.add(line2);
		
		line2.add(new JLabel("Num of places:"));
		spinnerModel =	new SpinnerNumberModel(2, 2, 4, 2);
		numOfPlaces = new JSpinner(spinnerModel);
		line2.add(numOfPlaces);

		JPanel line3 = new JPanel();
		line3.setLayout(lineLayout);
		EditTableWindow.R_Area.add(line3);
		
		line3.add(new JLabel("X position:"));
		spinnerModel =	new SpinnerNumberModel(0, 0, 100, 1);
		posX = new JSpinner(spinnerModel);
		line3.add(posX);

		JPanel line4 = new JPanel();
		line4.setLayout(lineLayout);
		EditTableWindow.R_Area.add(line4);
		
		line4.add(new JLabel("Y position:"));
		spinnerModel =	new SpinnerNumberModel(0, 0, 100, 1);
		posY = new JSpinner(spinnerModel);
		line4.add(posY);

		JPanel line5 = new JPanel();
		line5.setLayout(lineLayout);
		EditTableWindow.R_Area.add(line5);
		
		line5.add(new JLabel("Rotation:"));
		spinnerModel =	new SpinnerNumberModel(0, 0, 3, 1);
		rotation = new JSpinner(spinnerModel);
		line5.add(rotation);

		JPanel line6 = new JPanel();
		line6.setLayout(lineLayout);
		EditTableWindow.R_Area.add(line6);

		line6.add(new JLabel("Sector:"));
		Room theRoom = null;
		try {
			theRoom = Room.loadRoom();
		} catch (ClassNotFoundException | IOException | ObjectReadedIsNotARoomException e) {
			System.err.println("Error during loading the room from the last save.");
		}
		Map<Integer, Sector> sectors = theRoom.getSectors();
		Set<Integer> keySet = sectors.keySet();
		sectorNum = new JComboBox<Object>(keySet.toArray());
		line6.add(sectorNum);

		JPanel line7 = new JPanel();
		GridLayout buttonLayout = new GridLayout(1, 2);
		line7.setLayout(buttonLayout);
		EditTableWindow.R_Area.add(line7);

		line7.add(new JLabel());
		line7.add(new JLabel());
		EditTableWindowPerformAddTableButton theButton = new EditTableWindowPerformAddTableButton("Send");
		line7.add(theButton);
		
		SwingUtilities.updateComponentTreeUI(MainWindow.editTableWindow);
		
	}
}
