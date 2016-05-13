package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import fr.iutvalence.info.dut.m2107.room.ClientNameRequiredException;
import fr.iutvalence.info.dut.m2107.room.Position;
import fr.iutvalence.info.dut.m2107.room.Progress;
import fr.iutvalence.info.dut.m2107.room.Sector;
import fr.iutvalence.info.dut.m2107.room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.room.State;
import fr.iutvalence.info.dut.m2107.room.Table;
import fr.iutvalence.info.dut.m2107.room.TableAlreadyExistsException;
import fr.iutvalence.info.dut.m2107.room.TableNotExistsException;

/**
 * @author TODO
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
	private JButton processEditTable;	

	/**
	 * TODO
	 * @param editTableWindow 
	 */
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
		Set<Integer> sectors = new TreeSet<Integer>(this.editTableWindow.mainWindow.theRoom.getSectors().keySet());
		comboSectors = new JComboBox<Object>(sectors.toArray());
		comboSectors.addActionListener(this);
		line1.add(comboSectors);
		
		/*
		 * Set the second line (combo tables)
		 */
		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line2);
		line2.add(new JLabel("Table:"));
		Sector theSector = null;
		try {
			theSector = this.editTableWindow.mainWindow.theRoom.getSector((int)comboSectors.getSelectedItem());
		} catch (SectorNotExistsException e) {
			// TODO
		}
		Set<Integer> tables = new TreeSet<Integer>(theSector.getTables().keySet());
		comboTables = new JComboBox<Object>(tables.toArray());
		comboTables.addActionListener(this);
		line2.add(comboTables);
		
		/*
		 * Set the third line (num of places)
		 */
		JPanel line3 = new JPanel();
		line3.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line3);
		line3.add(new JLabel("Num of places:"));
		numOfPlaces = new JSpinner(new SpinnerNumberModel(2, 2, 6, 2));
		line3.add(numOfPlaces);
		
		/*
		 * Set the 4th line (pos X)
		 */
		JPanel line4 = new JPanel();
		line4.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line4);
		line4.add(new JLabel("X position:"));
		posX = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		line4.add(posX);
		
		/*
		 * Set the 5th line (pos Y)
		 */
		JPanel line5 = new JPanel();
		line5.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line5);
		line5.add(new JLabel("Y position:"));
		posY = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		line5.add(posY);
		
		/*
		 * Set the 6th line (rotation)
		 */
		JPanel line6 = new JPanel();
		line6.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line6);
		line6.add(new JLabel("Rotation:"));
		rotation = new JSpinner(new SpinnerNumberModel(1, 1, 2, 1));
		line6.add(rotation);
		
		/*
		 * Set the 7th line (state)
		 */
		JPanel line7 = new JPanel();
		line7.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line7);
		line7.add(new JLabel("State"));
		this.state = new JComboBox<Object>(State.values());
		this.state.addActionListener(this);
		line7.add(state);
		
		/*
		 * Set the 8th line (client name)
		 */
		JPanel line8 = new JPanel();
		line8.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line8);
		line8.add(new JLabel("Client Name"));
		this.clientName = new JTextField();
		this.clientName.disable();
		line8.add(clientName);
		
		/*
		 * Set the 9th line (progress)
		 */
		JPanel line9 = new JPanel();
		line9.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line9);
		line9.add(new JLabel("Progress"));
		progress = new JComboBox<Object>(Progress.values());
		line9.add(progress);
		
		/*
		 * Set the 10th line (send button)
		 */
		JPanel line10 = new JPanel();
		line10.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line10);
		line10.add(new JLabel());
		processEditTable = new JButton("Send");
		processEditTable.addActionListener(this);
		line10.add(processEditTable);
		// TODO : add default configuration of the first table
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComponent source = (JComponent) arg0.getSource();
		if(source == this.comboSectors)
		{
			Sector theSector = null;
			try {
				theSector = this.editTableWindow.mainWindow.theRoom.getSector((int)comboSectors.getSelectedItem());
			} catch (SectorNotExistsException e1) {
				// ...
			}
			DefaultComboBoxModel model = new DefaultComboBoxModel(new TreeSet<Integer>(theSector.getTables().keySet()).toArray());
			this.comboTables.setModel(model);
		}
		else if(source == this.comboTables)
		{
			Sector theSector = null;
			try {
				theSector = this.editTableWindow.mainWindow.theRoom.getSector((int)this.comboSectors.getSelectedItem());
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
			numOfPlaces.setValue(theTable.getNumberPlaces());
			posX.setValue(theTable.getPosition().getX());
			posY.setValue(theTable.getPosition().getY());
			rotation.setValue(theTable.getPosition().getRotation());
			state.setSelectedItem(theTable.getState());
			progress.setSelectedItem(theTable.getProgress());
			if(theTable.getState() == State.RESERVED)
				this.clientName.enable();
			else
				this.clientName.disable();
		}
		else if(source == this.state)
		{
			if(this.state.getSelectedItem() == State.RESERVED)
				this.clientName.enable();
			else
				this.clientName.disable();
			
			if(this.state.getSelectedItem() == State.BUSY)
				this.progress.enable();
			else
				this.progress.disable();
		}
		else if(source == processEditTable)
		{
			int numSector = (int) this.comboSectors.getSelectedItem();
			int numTable = (int) this.comboTables.getSelectedItem();
			int numOfPlaces = (int) 4;
			int posX = (int) this.posX.getValue();
			int posY = (int) this.posY.getValue();
			int rotation = (int) this.rotation.getValue();
			Position positionTable = new Position(posX,posY,rotation);
			State tableState = (State) this.state.getSelectedItem();
			String clientName = (String) this.clientName.getSelectedText();
			Progress tableProgress = (Progress) this.progress.getSelectedItem();
			
			Sector theSector = null;
			Table theTable = null;
			try {
				theSector = this.editTableWindow.mainWindow.theRoom.getSector(numSector);
				theTable = theSector.getTable(numTable);
				theSector.removeTable(theTable.getNumTable());
			} catch (SectorNotExistsException | TableNotExistsException e1) {
				// TODO retourner erreur
			}
			
			if(tableState != State.RESERVED)
			{
				try {
					theTable = new Table(numTable, numOfPlaces, positionTable, tableProgress, tableState);
				} catch (ClientNameRequiredException e1) {
					// TODO retourner erreur
				}
			}
			else 
			{
				theTable = new Table(numTable, numOfPlaces, positionTable, clientName);
			}
			
			try {
				theSector.addTable(theTable);
			} catch (TableAlreadyExistsException e1) {
				// TODO retourner erreur
			}
			
			JOptionPane.showMessageDialog(null, "The table has been correctly edited");
			this.editTableWindow.mainWindow.rightArea.refreshSectors();
			
			this.editTableWindow.R_Area.removeAll();
			this.editTableWindow.R_Area = new EditTableWindowEditArea(this.editTableWindow);
			SwingUtilities.updateComponentTreeUI(this.editTableWindow.R_Area);

			this.editTableWindow.R_Area.removeAll();
			new EditTableWindowEditArea(this.editTableWindow);
			SwingUtilities.updateComponentTreeUI(this.editTableWindow);
		}
	}
}
