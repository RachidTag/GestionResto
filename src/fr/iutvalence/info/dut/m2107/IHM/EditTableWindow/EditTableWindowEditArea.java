package fr.iutvalence.info.dut.m2107.IHM.EditTableWindow;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import fr.iutvalence.info.dut.m2107.IHM.CustomButton.CustomButton;
import fr.iutvalence.info.dut.m2107.Room.ATableIsAlreadyInThisPositionException;
import fr.iutvalence.info.dut.m2107.Room.ClientNameRequiredException;
import fr.iutvalence.info.dut.m2107.Room.Position;
import fr.iutvalence.info.dut.m2107.Room.Progress;
import fr.iutvalence.info.dut.m2107.Room.Sector;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Room.State;
import fr.iutvalence.info.dut.m2107.Room.Table;
import fr.iutvalence.info.dut.m2107.Room.TableAlreadyExistsException;
import fr.iutvalence.info.dut.m2107.Room.TableNotExistsException;

/**
 * Represents the edit area of the edit table window
 * @author Projet Resto
 *
 */
@SuppressWarnings("serial")
public class EditTableWindowEditArea extends JPanel implements ActionListener{
	/**
	 * The main window
	 */
	public EditTableWindow editTableWindow;
	
	/**
	 * Num Of Places spinner
	 */
	public JSpinner numOfPlaces; 
	
	/**
	 * Pos X spinner
	 */
	public JSpinner posX; 
	
	/**
	 * Pos Y spinner
	 */
	public JSpinner posY; 
	
	/**
	 * Rotation spinner
	 */
	public JSpinner rotation;
	
	/**
	 * Sectors combo
	 */
	public JComboBox<?> comboSectors;
	
	/**
	 * Tables combo
	 */
	public JComboBox<?> comboTables;
	
	/**
	 * State combo
	 */
	public JComboBox<?> state;
	
	/**
	 * Progress combo
	 */
	public JComboBox<?> progress;
	
	/**
	 * Client Name text field
	 */
	public JTextField clientName;
	
	/**
	 * Process edit table button
	 */
	private CustomButton processEditTable;	

	/**
	 * Generates the edit area of the edit table window
	 * @param editTableWindow 
	 */
	@SuppressWarnings("deprecation")
	public EditTableWindowEditArea(EditTableWindow editTableWindow){
		/*
		 * Save the reference to the sector edition window
		 */
		this.editTableWindow = editTableWindow;
		
		/*
		 * Set the layout
		 */
		GridLayout controlPanel = new GridLayout(11,1);
		controlPanel.setHgap(10);
		controlPanel.setVgap(5);
		this.editTableWindow.R_Area.setLayout(controlPanel);
		
		/*
		 * Set the title of the category
		 */
		JLabel title = new JLabel("Table editing", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 20.f));
		this.editTableWindow.R_Area.add(title);
		
		/*
		 * Creates the line layout
		 */
		GridLayout lineLayout = new GridLayout(1, 2);

		/*
		 * Set the first line (comboSectors)
		 */
		JPanel line1 = new JPanel();
		line1.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line1);
		line1.add(new JLabel("Sector:"));
		Set<Integer> sectors = new TreeSet<Integer>(this.editTableWindow.mainWindow.restaurant.getTheRoom().getSectors().keySet());
		this.comboSectors = new JComboBox<Object>(sectors.toArray());
		this.comboSectors.addActionListener(this);
		line1.add(this.comboSectors);
		
		/*
		 * Set the second line (combo tables)
		 */
		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line2);
		line2.add(new JLabel("Table:"));
		Sector theSector = null;
		try {
			theSector = this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector((int)this.comboSectors.getSelectedItem());
		} catch (SectorNotExistsException e) {
			// impossible
		}
		Set<Integer> tables = new TreeSet<Integer>(theSector.getTables().keySet());
		this.comboTables = new JComboBox<Object>(tables.toArray());
		this.comboTables.addActionListener(this);
		line2.add(this.comboTables);
		
		/*
		 * Default table informations
		 */
		Table defaultTable = null;
		try
		{
			defaultTable = this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector((int)this.comboSectors.getSelectedItem()).getTable((int)this.comboTables.getSelectedItem());
		}
		catch (TableNotExistsException | SectorNotExistsException | NullPointerException e)
		{
			try
			{
				defaultTable = new Table(0, 2, new Position(0, 0, 1), Progress.NO_PROGRESS, State.FREE);
			}
			catch (ClientNameRequiredException e1)
			{
				// impossible
			}
		}
		
		/*
		 * Set the third line (num of places) 
		 */
		JPanel line3 = new JPanel();
		line3.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line3);
		line3.add(new JLabel("Num of places:"));
		this.numOfPlaces = new JSpinner(new SpinnerNumberModel(defaultTable.getNumberPlaces(), 2, 6, 2));
		line3.add(this.numOfPlaces);
		
		/*
		 * Set the 4th line (pos X)
		 */
		JPanel line4 = new JPanel();
		line4.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line4);
		line4.add(new JLabel("X position:"));
		this.posX = new JSpinner(new SpinnerNumberModel(defaultTable.getPosition().getX(), 0, 3, 1));
		line4.add(this.posX);
		
		/*
		 * Set the 5th line (pos Y)
		 */
		JPanel line5 = new JPanel();
		line5.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line5);
		line5.add(new JLabel("Y position:"));
		this.posY = new JSpinner(new SpinnerNumberModel(defaultTable.getPosition().getY(), 0, 3, 1));
		line5.add(this.posY);
		
		/*
		 * Set the 6th line (rotation)
		 */
		JPanel line6 = new JPanel();
		line6.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line6);
		line6.add(new JLabel("Rotation:"));
		this.rotation = new JSpinner(new SpinnerNumberModel(defaultTable.getPosition().getRotation(), 1, 2, 1));
		line6.add(this.rotation);
		
		/*
		 * Set the 7th line (state)
		 */
		JPanel line7 = new JPanel();
		line7.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line7);
		line7.add(new JLabel("State"));
		this.state = new JComboBox<Object>(State.values());
		this.state.setSelectedItem(defaultTable.getState());
		this.state.addActionListener(this);
		line7.add(this.state);
		
		/*
		 * Set the 8th line (client name)
		 */
		JPanel line8 = new JPanel();
		line8.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line8);
		line8.add(new JLabel("Client Name"));
		this.clientName = new JTextField();
		this.clientName.setText(defaultTable.getClientName());
		this.clientName.disable();
		line8.add(this.clientName);
		
		/*
		 * Set the 9th line (progress)
		 */
		JPanel line9 = new JPanel();
		line9.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line9);
		line9.add(new JLabel("Progress"));
		this.progress = new JComboBox<Object>(Progress.values());
		this.progress.setSelectedItem(defaultTable.getProgress());
		if(defaultTable.getState() == State.BUSY)
			this.progress.enable();
		else
			this.progress.disable();
		line9.add(this.progress);
		
		/*
		 * Set the 10th line (send button)
		 */
		JPanel line10 = new JPanel();
		line10.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line10);
		line10.add(new JLabel());
		this.processEditTable = new CustomButton("Send", new Dimension(240, 33));
		this.processEditTable.addActionListener(this);
		line10.add(this.processEditTable);

	}
	
	/**
	 * Set the form with the selected table values
	 * @param numTable
	 * @param numSector
	 * @throws SectorNotExistsException 
	 * @throws TableNotExistsException 
	 */
	@SuppressWarnings("deprecation")
	public void selectTheTable(int numTable, int numSector) throws SectorNotExistsException, TableNotExistsException
	{
		this.comboSectors.setSelectedItem(numSector);
		this.comboTables.setSelectedItem(numTable);
		
		Sector theSector = this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector(numSector);
		Table theTable = theSector.getTable(numTable);
		
		this.numOfPlaces.setValue(theTable.getNumberPlaces());
		this.posX.setValue(theTable.getPosition().getX());
		this.posY.setValue(theTable.getPosition().getY());
		this.rotation.setValue(theTable.getPosition().getRotation());
		this.state.setSelectedItem(theTable.getState());
		this.progress.setSelectedItem(theTable.getProgress());
		
		if(theTable.getState() == State.RESERVED)
			this.clientName.enable();
		else
			this.clientName.disable();
		
		if(theTable.getState() == State.BUSY)
			this.progress.setEnabled(true);
		else
			this.progress.setEnabled(false);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public void actionPerformed(ActionEvent arg0) {
		JComponent source = (JComponent) arg0.getSource();
		if(source == this.comboSectors)
		{
			// Get the sectors list
			Sector theSector = null;
			try {
				theSector = this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector((int)this.comboSectors.getSelectedItem());
			} catch (SectorNotExistsException e1) {
				// ...
			}
			DefaultComboBoxModel model = new DefaultComboBoxModel(new TreeSet<Integer>(theSector.getTables().keySet()).toArray());
			this.comboTables.setModel(model);
		}
		else if(source == this.comboTables)
		{
			// Get the tables list from the given sector
			Sector theSector = null;
			try {
				theSector = this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector((int)this.comboSectors.getSelectedItem());
			} catch (SectorNotExistsException e1) {
				// ... impossible
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
			this.numOfPlaces.setValue(theTable.getNumberPlaces());
			this.posX.setValue(theTable.getPosition().getX());
			this.posY.setValue(theTable.getPosition().getY());
			this.rotation.setValue(theTable.getPosition().getRotation());
			this.state.setSelectedItem(theTable.getState());
			this.progress.setSelectedItem(theTable.getProgress());
			if(theTable.getState() == State.RESERVED)
				this.clientName.enable();
			else
				this.clientName.disable();
			
			if(theTable.getState() == State.BUSY)
				this.progress.setEnabled(true);
			else
				this.progress.setEnabled(false);
			
		}
		else if(source == this.state)
		{
			if(this.state.getSelectedItem() == State.RESERVED)
				this.clientName.enable();
			else
				this.clientName.disable();
			
			if(this.state.getSelectedItem() == State.BUSY)
				this.progress.setEnabled(true);
			else
				this.progress.setEnabled(false);
		}
		else if(source == this.processEditTable)
		{
			// process the edit table
			int numSector = (int) this.comboSectors.getSelectedItem();
			int numTable = (int) this.comboTables.getSelectedItem();
			int numOfPlaces = (int) this.numOfPlaces.getValue();
			int posX = (int) this.posX.getValue();
			int posY = (int) this.posY.getValue();
			int rotation = (int) this.rotation.getValue();
			Position positionTable = new Position(posX,posY,rotation);
			State tableState = (State) this.state.getSelectedItem();
			String clientName = (String) this.clientName.getText();
			Progress tableProgress = (Progress) this.progress.getSelectedItem();
			
			Sector theSector = null;
			Table theTable = null;
			try {
				theSector = this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector(numSector);
				theTable = theSector.getTable(numTable);
				theSector.removeTable(theTable.getNumTable());
			} catch (SectorNotExistsException | TableNotExistsException e1) {
				// impossible
			}
			
			try
			{
				switch(tableState)
				{
					case RESERVED:
						theTable = new Table(numTable, numOfPlaces, positionTable, clientName);
						break;
					case BUSY:
						theTable = new Table(numTable, numOfPlaces, positionTable, tableProgress, tableState);
						break;
					default:
						theTable = new Table(numTable, numOfPlaces, positionTable, tableProgress, tableState);
						break;
				}
			}
			catch (ClientNameRequiredException e2)
			{
				// impossible
			}
			
			try {
				theSector.addTable(theTable);
			} catch (TableAlreadyExistsException e1) {
				// impossible
			} catch (ATableIsAlreadyInThisPositionException e) {
				JOptionPane.showMessageDialog(null,"The table already exits in this position");
			}
			
			JOptionPane.showMessageDialog(null, "The table has been correctly edited");
			this.editTableWindow.mainWindow.rightArea.refreshSectors();
		}
	}
}
