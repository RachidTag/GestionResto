package fr.iutvalence.info.dut.m2107.IHM.EditTableWindow;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import fr.iutvalence.info.dut.m2107.IHM.CustomButton.CustomButton;
import fr.iutvalence.info.dut.m2107.Room.ATableIsAlreadyInThisPositionException;
import fr.iutvalence.info.dut.m2107.Room.ClientNameRequiredException;
import fr.iutvalence.info.dut.m2107.Room.Position;
import fr.iutvalence.info.dut.m2107.Room.Progress;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Room.State;
import fr.iutvalence.info.dut.m2107.Room.Table;
import fr.iutvalence.info.dut.m2107.Room.TableAlreadyExistsException;

/**
 * Represents the add area of the edit table window
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class EditTableWindowAddArea extends JPanel implements ActionListener{
	/**
	 * The main window
	 */
	public EditTableWindow editTableWindow;
	
	/**
	 * Table Num spinner
	 */
	public JLabel tableNum; 
	
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
	 * Process add table button
	 */
	private CustomButton processAddTable;

	/**
	 * Generates the add area of the edit table window
	 * @param editTableWindow 
	 */
	public EditTableWindowAddArea(EditTableWindow editTableWindow){
		/*
		 * Save the reference to the sector edition window
		 */
		this.editTableWindow = editTableWindow;
		
		/*
		 * Set the layout
		 */
		GridLayout controlPanel = new GridLayout(8,1);
		this.editTableWindow.R_Area.setLayout(controlPanel);
		
		/*
		 * Set the title of the category
		 */
		JLabel title = new JLabel("Table adding", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 20.f));
		this.editTableWindow.R_Area.add(title);
		
		/*
		 * Creates the line layout
		 */
		GridLayout lineLayout = new GridLayout(1, 2);
		
		/*
		 * Set the first line (table num)
		 */
		// TODO make a list of all availables nums
		JPanel line1 = new JPanel();
		line1.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line1);
		line1.add(new JLabel("Table num:"));
		try {
			this.tableNum = new JLabel(String.valueOf(this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector(1).findFirstFreeIndex()));
		} catch (SectorNotExistsException e) {
			// impossible
		}
		line1.add(this.tableNum);
		
		/*
		 * Set the second line (num of places)
		 */
		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line2);
		line2.add(new JLabel("Num of places:"));
		this.numOfPlaces = new JSpinner(new SpinnerNumberModel(2, 2, 6, 2));
		line2.add(this.numOfPlaces);
		
		/*
		 * Set the third line (pos X)
		 */
		JPanel line3 = new JPanel();
		line3.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line3);
		line3.add(new JLabel("X position:"));
		this.posX = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		line3.add(this.posX);
		
		/*
		 * Set the 4th line (pos Y)
		 */
		JPanel line4 = new JPanel();
		line4.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line4);
		line4.add(new JLabel("Y position:"));
		this.posY = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		line4.add(this.posY);
		
		/*
		 * Set the 5th line (rotation)
		 */
		JPanel line5 = new JPanel();
		line5.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line5);
		line5.add(new JLabel("Rotation:"));
		this.rotation = new JSpinner(new SpinnerNumberModel(1, 1, 2, 1));
		line5.add(this.rotation);
		
		/*
		 * Set the 6th line (Sector)
		 */
		JPanel line6 = new JPanel();
		line6.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line6);
		line6.add(new JLabel("Sector:"));
		Set<Integer> sectorsNums = this.editTableWindow.mainWindow.restaurant.getTheRoom().getSectors().keySet();
		this.comboSectors = new JComboBox<Object>(sectorsNums.toArray());
		this.comboSectors.addActionListener(this);
		line6.add(this.comboSectors);
		/*
		 * Set the 7th line (Send button)
		 */
		JPanel line7 = new JPanel();
		line7.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line7);
		line7.add(new JLabel());
		this.processAddTable = new CustomButton("Send", new Dimension(150, 45));
		this.processAddTable.addActionListener(this);
		JPanel buttonJPanel = new JPanel();
		buttonJPanel.add(this.processAddTable);
		line7.add(buttonJPanel);
		
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		JComponent source = (JComponent) arg0.getSource();
		
		if(source == this.processAddTable)
		{
			int tableNum = 0;
			try {
				tableNum = this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector((int) this.comboSectors.getSelectedItem()).findFirstFreeIndex();
			} catch (SectorNotExistsException e2) {
				// impossible
			}
			int numOfPlaces = (int) this.numOfPlaces.getValue();
			int posX = (int) this.posX.getValue();
			int posY = (int) this.posY.getValue();
			int rotation = (int) this.rotation.getValue();
			int sectorNum = (int) this.comboSectors.getSelectedItem();
			Table theTable = null;
			try {
				theTable = new Table(tableNum, numOfPlaces, new Position(posX, posY, rotation), Progress.NO_PROGRESS, State.FREE);
			} catch (ClientNameRequiredException e1) {
					// never happens
			}
			try {
				this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector(sectorNum).addTable(theTable);
				this.editTableWindow.mainWindow.rightArea.refreshSectors();
				
				// put in the add form the next table id
				this.tableNum.setText(String.valueOf(this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector((int)this.comboSectors.getSelectedItem()).findFirstFreeIndex()));

				JOptionPane.showMessageDialog(null,"The table has been correctly added");
			} catch (TableAlreadyExistsException | SectorNotExistsException e1) {
				JOptionPane.showMessageDialog(null,"The table already exits in this sector");
			} catch (ATableIsAlreadyInThisPositionException e) {
				JOptionPane.showMessageDialog(null,"A table is already in this position");
			}
		}
		else if(source == this.comboSectors){
			try {
				this.tableNum.setText(String.valueOf(this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector((int)this.comboSectors.getSelectedItem()).findFirstFreeIndex()));
			} catch (SectorNotExistsException e) {
				// impossible
			}
		}
	}
}
