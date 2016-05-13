package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import fr.iutvalence.info.dut.m2107.room.*;

/**
 * TODO
 * @author Projet Resto
 *
 */
@SuppressWarnings("serial")
public class EditTableWindow extends JFrame {
	/**
	 * Main Window
	 */
	public MainWindow mainWindow;
	
	/**
	 * Left Area
	 */
	public JPanel L_Area;
	
	/**
	 * Right Area
	 */
	public JPanel R_Area;
	
	/**
	 * @param mainWindow 
	 * 
	 */
	public EditTableWindow(MainWindow mainWindow)
	{
		/*
		 * Save the reference to the main window
		 */
		this.mainWindow = mainWindow;
		
		/*
		 * Init the window
		 */
		this.addWindowListener(new WindowEventHandler(this.mainWindow));
		this.setTitle("Edit Table");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		/*
		 * Init the two areas
		 */
		this.L_Area = new EditTableWindowLeftArea(this);
		this.R_Area = new EditTableWindowLeftArea(this);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, this.L_Area, this.R_Area);
		split.setOneTouchExpandable(true);
		split.setDividerLocation(120);
		split.setEnabled(false);
		split.setDividerSize(1);
		this.getContentPane().add(split);
		
		/*
		 * Set the result visible		
		 */
		this.setVisible(true);
	}
	
	/**
	  * Delete a table
	  * @author Théo
	  */
	 public void deleteTableArea(){
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
	  
	  comboSectorsDelete = new JComboBox<Object>(sectors.toArray());
	  comboSectorsDelete.addActionListener(this);
	  line1.add(comboSectorsDelete);
	  
	  JPanel line2 = new JPanel();
	  line2.setLayout(lineLayout);
	  this.R_Area.add(line2);
	  
	  line2.add(new JLabel("Table"));
	  
	  Sector theSector = null;
	  try {
	   theSector = this.mainWindow.theRoom.getSector((int)comboSectorsDelete.getSelectedItem());
	  } catch (SectorNotExistsException e) {
	   // ...
	  }
	  Set<Integer> tables = new TreeSet<Integer>(theSector.getTables().keySet());
	  
	  comboTablesDelete = new JComboBox<Object>(tables.toArray());
	  
	  comboTablesDelete.addActionListener(this);
	  
	  line2.add(comboTablesDelete);
	  
	  JPanel line3 = new JPanel();
	  GridLayout buttonLayout = new GridLayout(1, 2);
	  line3.setLayout(buttonLayout);
	  this.R_Area.add(line3);

	  line3.add(new JLabel());
	  line3.add(new JLabel());
	  processDeleteTable = new JButton("Delete");
	  processDeleteTable.addActionListener(this);
	  line3.add(processDeleteTable);
	  
	  SwingUtilities.updateComponentTreeUI(this);
	 }

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		
		else 
		else 
		else if(source == this.comboSectorsDelete)
		{
			Sector theSector = null;
			try {
				theSector = this.mainWindow.theRoom.getSector((int)comboSectorsDelete.getSelectedItem());
			} catch (SectorNotExistsException e1) {
				// ...
			}
			Set<Integer> tables = new TreeSet<Integer>(theSector.getTables().keySet());
			DefaultComboBoxModel model = new DefaultComboBoxModel(tables.toArray());
			this.comboTablesDelete.setModel( model );
			
		}
		else if(source == this.comboTablesDelete)
		{
			Sector theSector = null;
			try {
				theSector = this.mainWindow.theRoom.getSector((int)this.comboSectorsDelete.getSelectedItem());
			} catch (SectorNotExistsException e1) {
				// ...
			}
			Table theTable = null;
			try
			{
				theTable = theSector.getTable((int)this.comboTablesDelete.getSelectedItem());
			}
			catch (TableNotExistsException e1)
			{
				// ... impossible
			}
		}
		else if(source == this.comboTablesEdit)
		{
			Sector theSector = null;
			try {
				theSector = this.mainWindow.theRoom.getSector((int)this.comboSectorsEdit.getSelectedItem());
			} catch (SectorNotExistsException e1) {
				// ...
			}
			Table theTable = null;
			try
			{
				theTable = theSector.getTable((int)this.comboTablesEdit.getSelectedItem());
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
		else if(source == this.comboTablesAdd)
		{
			Sector theSector = null;
			try {
				theSector = this.mainWindow.theRoom.getSector((int)this.comboSectorsAdd.getSelectedItem());
			} catch (SectorNotExistsException e1) {
				// ...
			}
			Table theTable = null;
			try
			{
				theTable = theSector.getTable((int)this.comboTablesAdd.getSelectedItem());
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
		else if(source == this.processDeleteTable)
		{
			// Prevent Message
			int response = JOptionPane.showConfirmDialog(null, "Do you wish to delete this table?", "Confirm",
			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
			int action =0;
				// Deleting
				Sector theSector = null;
				Table theTable = null;
				try {
					theSector = this.mainWindow.theRoom.getSector((int)this.comboSectorsDelete.getSelectedItem());
					action++;
				} catch (SectorNotExistsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					theTable = theSector.getTable((int)this.comboTablesDelete.getSelectedItem());
					action++;
				} catch (TableNotExistsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					theSector.removeTable(theTable.getNumTable());
					action++;
				} catch (TableNotExistsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(action == 3) 
				{
					JOptionPane.showMessageDialog(null, "The table has been correctly deleted");
					this.mainWindow.rightArea.refreshSectors();
				}
				else JOptionPane.showMessageDialog(null, "The table has not been correctly deleted!");
				this.deleteTableArea();
			}
		}
		else if(source == processEditTable)
		{
			int numSector = (int) this.comboSectorsEdit.getSelectedItem();
			int numTable = (int) this.comboTablesEdit.getSelectedItem();
			int numOfPlaces = (int) this.numOfPlaces.getValue();
			int posX = (int) this.posX.getValue();
			int posY = (int) this.posY.getValue();
			int rotation = (int) this.rotation.getValue();
			Position positionTable = new Position(posX,posY,rotation);
			State tableState = (State) this.state.getSelectedItem();
			String clientName = (String) this.clientName.getSelectedText();
			Progress tableProgress = (Progress) this.progress.getSelectedItem();
			
			int action = 0;
			
			Sector theSector = null;
			Table theTable = null;
			try {
				theSector = this.mainWindow.theRoom.getSector(numSector);
				action++;
			} catch (SectorNotExistsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				theTable = theSector.getTable(numTable);
				action++;
			} catch (TableNotExistsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				theSector.removeTable(theTable.getNumTable());
				action++;
			} catch (TableNotExistsException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			if(tableState != State.RESERVED)
			{
				try {
					theTable = new Table(numTable, numOfPlaces, positionTable, tableProgress, tableState);
					action++;
				} catch (ClientNameRequiredException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else 
			{
				theTable = new Table(numTable, numOfPlaces, positionTable, clientName);
				action++;
			}
			
			try {
				theSector.addTable(theTable);
				action++;
			} catch (TableAlreadyExistsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(action==5){
				JOptionPane.showMessageDialog(null, "The table has been correctly edited");
				this.mainWindow.rightArea.refreshSectors();
			}
			this.editTableArea();
		}
		else
		{
			//smth
		}
	}
}