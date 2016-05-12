package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

import fr.iutvalence.info.dut.m2107.room.*;

/**
 * TODO
 * @author Projet Resto
 *
 */
@SuppressWarnings("serial")
public class EditTableWindow extends JFrame implements ActionListener {
	
	/**
	 * Left Area
	 */
	public JPanel L_Area;
	/**
	 * Right Area
	 */
	public JPanel R_Area;
	
	/**
	 * Buttons
	 */
	public JButton edit;
	public JButton delete;
	public JButton add;
	public JButton close;
	
	public JButton processAddTable;
	public JButton processEditTable;
	
	/**
	 * Default menu text
	 */
	public JLabel defaultText;
	
	/**
	 * forms
	 */
	public JSpinner tableNum; 
	public JSpinner numOfPlaces; 
	public JSpinner posX; 
	public JSpinner posY; 
	public JSpinner rotation; 
	public JComboBox<?> comboSectors;
	public JComboBox<Object> comboTables;
	public JComboBox<?> state;
	public JComboBox<?> progress;

	public MainWindow mainWindow;
	private JButton processDeleteTable;
	
	/**
	 * @param mainWindow 
	 * 
	 */
	public EditTableWindow(MainWindow mainWindow)
	{		
		this.mainWindow = mainWindow;
		this.addWindowListener(new WindowEventHandler(this.mainWindow));
		this.setTitle("Edit Table");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		

		this.L_Area = new JPanel();
		this.R_Area = new JPanel();
		
		this.defaultText = new JLabel("Menu d'édition des tables");
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, this.L_Area, this.R_Area);
		split.setOneTouchExpandable(true);
		getContentPane().add(split);
		split.setDividerLocation(120);
		split.setEnabled(false);
		split.setDividerSize(1);

		GridLayout controlPanel = new GridLayout(4,1);
		this.L_Area.setLayout(controlPanel);

		this.edit = new JButton("Edit");
		this.delete = new JButton("Delete");
		this.add = new JButton("Add");
		this.close = new JButton("Close");
		
		this.edit.addActionListener(this);
		this.delete.addActionListener(this);
		this.add.addActionListener(this);
		this.close.addActionListener(this);
		
		this.L_Area.add(edit);
		this.L_Area.add(delete);
		this.L_Area.add(add);
		this.L_Area.add(close);
		
		this.R_Area.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.R_Area.add(defaultText, gbc);
		defaultText.setFont(defaultText.getFont().deriveFont(Font.ITALIC, 24.f));
		
		this.setVisible(true);
	}
	
	/**
	 * 
	 */
	public void addTableArea() {
		this.R_Area.removeAll();
		
		GridLayout controlPanel = new GridLayout(8,1);
		this.R_Area.setLayout(controlPanel);
		
		JLabel title = new JLabel("Table adding", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 20.f));
		
		this.R_Area.add(title);
		
		JPanel line = new JPanel();
		GridLayout lineLayout = new GridLayout(1, 2);
		line.setLayout(lineLayout);
		this.R_Area.add(line);
		
		line.add(new JLabel("Table num:"));
		SpinnerModel spinnerModel =	new SpinnerNumberModel(0, 0, 1000, 1);
		tableNum = new JSpinner(spinnerModel);
		line.add(tableNum);

		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		this.R_Area.add(line2);
		
		line2.add(new JLabel("Num of places:"));
		spinnerModel =	new SpinnerNumberModel(2, 2, 4, 2);
		numOfPlaces = new JSpinner(spinnerModel);
		line2.add(numOfPlaces);

		JPanel line3 = new JPanel();
		line3.setLayout(lineLayout);
		this.R_Area.add(line3);
		
		line3.add(new JLabel("X position:"));
		spinnerModel =	new SpinnerNumberModel(0, 0, 100, 1);
		posX = new JSpinner(spinnerModel);
		line3.add(posX);

		JPanel line4 = new JPanel();
		line4.setLayout(lineLayout);
		this.R_Area.add(line4);
		
		line4.add(new JLabel("Y position:"));
		spinnerModel =	new SpinnerNumberModel(0, 0, 100, 1);
		posY = new JSpinner(spinnerModel);
		line4.add(posY);

		JPanel line5 = new JPanel();
		line5.setLayout(lineLayout);
		this.R_Area.add(line5);
		
		line5.add(new JLabel("Rotation:"));
		spinnerModel =	new SpinnerNumberModel(0, 0, 3, 1);
		rotation = new JSpinner(spinnerModel);
		line5.add(rotation);

		JPanel line6 = new JPanel();
		line6.setLayout(lineLayout);
		this.R_Area.add(line6);

		line6.add(new JLabel("Sector:"));
		Map<Integer, Sector> sectors = this.mainWindow.theRoom.getSectors();
		Set<Integer> keySet = sectors.keySet();
		comboSectors = new JComboBox<Object>(keySet.toArray());
		line6.add(comboSectors);

		JPanel line7 = new JPanel();
		GridLayout buttonLayout = new GridLayout(1, 2);
		line7.setLayout(buttonLayout);
		this.R_Area.add(line7);

		line7.add(new JLabel());
		line7.add(new JLabel());
		processAddTable = new JButton("Send");
		processAddTable.addActionListener(this);
		line7.add(processAddTable);
		
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	
	/**
	 * 
	 */
	public void editTableArea() {
		this.R_Area.removeAll();
		
		GridLayout controlPanel = new GridLayout(11,1);
		controlPanel.setHgap(10);
		controlPanel.setVgap(5);
		this.R_Area.setLayout(controlPanel);
		
		JLabel title = new JLabel("Table editing", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 20.f));
		
		this.R_Area.add(title);

		JPanel line1 = new JPanel();
		GridLayout lineLayout = new GridLayout(1, 2);
		line1.setLayout(lineLayout);
		this.R_Area.add(line1);

		line1.add(new JLabel("Sector:"));
		
		Map<Integer, Sector> theSectors = this.mainWindow.theRoom.getSectors();
		Set<Integer> sectors = new TreeSet<Integer>(this.mainWindow.theRoom.getSectors().keySet());
		
		comboSectors = new JComboBox<Object>(sectors.toArray());
		/*
		 * When you select a sector, it updates automatically the tables list
		 */
		comboSectors.addActionListener(this); 
		line1.add(comboSectors);

		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		this.R_Area.add(line2);

		line2.add(new JLabel("Table:"));
		
		Sector theSector = null;
		try {
			theSector = this.mainWindow.theRoom.getSector((int)comboSectors.getSelectedItem());
		} catch (SectorNotExistsException e) {
			// ...
		}
		Set<Integer> tables = new TreeSet<Integer>(theSector.getTables().keySet());
		
		comboTables = new JComboBox<Object>(tables.toArray());
		
		comboTables.addActionListener(this);
		
		line2.add(comboTables);
		
		JPanel line3 = new JPanel();
		line3.setLayout(lineLayout);
		this.R_Area.add(line3);
		
		line3.add(new JLabel("Num of places:"));
		SpinnerNumberModel spinnerModel =	new SpinnerNumberModel(2, 2, 6, 2);
		numOfPlaces = new JSpinner(spinnerModel);
		line3.add(numOfPlaces);

		JPanel line4 = new JPanel();
		line4.setLayout(lineLayout);
		this.R_Area.add(line4);
		
		line4.add(new JLabel("X position:"));
		spinnerModel =	new SpinnerNumberModel(0, 0, 100, 1);
		posX = new JSpinner(spinnerModel);
		line4.add(posX);

		JPanel line5 = new JPanel();
		line5.setLayout(lineLayout);
		this.R_Area.add(line5);
		
		line5.add(new JLabel("Y position:"));
		spinnerModel =	new SpinnerNumberModel(0, 0, 100, 1);
		posY = new JSpinner(spinnerModel);
		line5.add(posY);

		JPanel line6 = new JPanel();
		line6.setLayout(lineLayout);
		this.R_Area.add(line6);
		
		line6.add(new JLabel("Rotation:"));
		spinnerModel =	new SpinnerNumberModel(0, 0, 3, 1);
		rotation = new JSpinner(spinnerModel);
		line6.add(rotation);

		JPanel line7 = new JPanel();
		line7.setLayout(lineLayout);
		this.R_Area.add(line7);
		
		line7.add(new JLabel("State"));
		spinnerModel =	new SpinnerNumberModel(0, 0, 100, 1);
		this.state = new JComboBox<Object>(State.values());
		line7.add(state);

		JPanel line9 = new JPanel();
		line9.setLayout(lineLayout);
		this.R_Area.add(line9);
		
		line9.add(new JLabel("Progress"));
		spinnerModel =	new SpinnerNumberModel(0, 0, 100, 1);
		progress = new JComboBox<Object>(Progress.values());
		line9.add(progress);

		JPanel line10 = new JPanel();
		GridLayout buttonLayout = new GridLayout(1, 2);
		line10.setLayout(buttonLayout);
		this.R_Area.add(line10);

		line10.add(new JLabel());
		line10.add(new JLabel());
		processEditTable = new JButton("Send");
		line10.add(processEditTable);
		
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	
	/**
	  * Delete a table
	  * @author Théo
	  */
	 public void deleteTable(){
	  this.R_Area.removeAll();
	  
	  GridLayout controlPanel = new GridLayout(4,1);
	  controlPanel.setHgap(10);
	  controlPanel.setVgap(5);
	  this.R_Area.setLayout(controlPanel);
	  
	  JLabel title = new JLabel("Table deleting", SwingConstants.CENTER);
	  title.setFont(title.getFont().deriveFont(Font.BOLD, 20.f));
	  
	  this.R_Area.add(title);
	 
	  JPanel line1 = new JPanel();
	  GridLayout lineLayout = new GridLayout(1,2);
	  line1.setLayout(lineLayout);
	  this.R_Area.add(line1);
	  
	  line1.add(new JLabel("Sector"));
	  
	  Map<Integer, Sector> theSectors = this.mainWindow.theRoom.getSectors();
	  Set<Integer> sectors = new TreeSet<Integer>(this.mainWindow.theRoom.getSectors().keySet());
	  
	  comboSectors = new JComboBox<Object>(sectors.toArray());
	  comboSectors.addActionListener(this);
	  line1.add(comboSectors);
	  
	  JPanel line2 = new JPanel();
	  line2.setLayout(lineLayout);
	  this.R_Area.add(line2);
	  
	  line2.add(new JLabel("Table"));
	  
	  Sector theSector = null;
	  try {
	   theSector = this.mainWindow.theRoom.getSector((int)comboSectors.getSelectedItem());
	  } catch (SectorNotExistsException e) {
	   // ...
	  }
	  Set<Integer> tables = new TreeSet<Integer>(theSector.getTables().keySet());
	  
	  comboTables = new JComboBox<Object>(tables.toArray());
	  
	  comboTables.addActionListener(this);
	  
	  line2.add(comboTables);
	  
	  JPanel line3 = new JPanel();
	  GridLayout buttonLayout = new GridLayout(1, 2);
	  line3.setLayout(buttonLayout);
	  this.R_Area.add(line3);

	  line3.add(new JLabel());
	  line3.add(new JLabel());
	  processDeleteTable = new JButton("Delete");
	  line3.add(processDeleteTable);
	  
	  SwingUtilities.updateComponentTreeUI(this);
	 }

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			this.mainWindow.leftArea.editSector.setEnabled(true);
		    this.mainWindow.leftArea.editTable.setEnabled(true);
		    this.mainWindow.leftArea.checkRoom.setEnabled(true);
		    this.mainWindow.leftArea.checkSchedule.setEnabled(true);
		    this.mainWindow.leftArea.roomManager.setEnabled(true);
		    this.mainWindow.leftArea.close.setEnabled(true);
		    this.setVisible(false);
		    this.R_Area.removeAll();
		}
		else if(source == this.add)
		{
			this.addTableArea();
		}
		else if(source == this.edit)
		{
			this.editTableArea();
		}
		else if(source == this.delete)
		{
			this.deleteTable();
		}
		else if(source == this.processAddTable)
		{
			int tableNum = (int) this.tableNum.getValue();
			int numOfPlaces = (int) this.numOfPlaces.getValue();
			int posX = (int) this.posX.getValue();
			int posY = (int) this.posY.getValue();
			int rotation = (int) this.rotation.getValue();
			int sectorNum = (int) this.comboSectors.getSelectedItem();
			Table theTable = null;
			try {
				theTable = new Table(tableNum, numOfPlaces, new Position(posX, posY, rotation), Progress.NO_PROGRESS, State.FREE);
			} catch (ClientNameRequiredException e1) {
					// ...
			}
			Room theRoom = null;
			try {
				theRoom = Room.loadRoom();
			} catch (ClassNotFoundException | IOException | ObjectReadedIsNotARoomException e1) {
				e1.printStackTrace();
			}
			try {
				theRoom.getSector(sectorNum).addTable(theTable);
				theRoom.saveRoom();
			} catch (TableAlreadyExistsException | SectorNotExistsException e1) {
				// TODO 
			}
		}
		else if(source == this.comboSectors)
		{
			Sector theSector = null;
			try {
				theSector = this.mainWindow.theRoom.getSector((int)comboSectors.getSelectedItem());
			} catch (SectorNotExistsException e1) {
				// ...
			}
			Set<Integer> tables = new TreeSet<Integer>(theSector.getTables().keySet());
			DefaultComboBoxModel model = new DefaultComboBoxModel(tables.toArray());
			this.comboTables.setModel( model );
		}
		else if(source == this.comboTables)
		{
			Sector theSector = null;
			try {
				theSector = this.mainWindow.theRoom.getSector((int)this.comboSectors.getSelectedItem());
			} catch (SectorNotExistsException e1) {
				// ...
			}
			Table theTable = null;
			try
			{
				theTable = theSector.getTable((int)this.comboTables.getSelectedItem());
			}
			catch (TableNotExistsException e1)
			{
				// ... impossible
			}
			numOfPlaces.setValue(theTable.getNumberPlaces());
			posX.setValue(theTable.getPosition().getX());
			posY.setValue(theTable.getPosition().getY());
			rotation.setValue(theTable.getPosition().getRotation());
			state.setSelectedItem(theTable.getState());
			progress.setSelectedItem(theTable.getProgress());
		}
		else
		{
			// nothing
		}		
	}
}