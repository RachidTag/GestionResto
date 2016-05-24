package fr.iutvalence.info.dut.m2107.IHM.EditTableWindow;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import fr.iutvalence.info.dut.m2107.Room.Sector;
import fr.iutvalence.info.dut.m2107.Room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.Room.Table;
import fr.iutvalence.info.dut.m2107.Room.TableNotExistsException;

/**
 * Represents the delete area of the edit table window
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class EditTableWindowDeleteArea extends JPanel implements ActionListener {
	/**
	 * The main window
	 */
	public EditTableWindow editTableWindow;
	
	/**
	 * Sectors combo
	 */
	public JComboBox<?> comboSectors;
	
	/**
	 * Tables combo
	 */
	public JComboBox<Object> comboTables;
	
	/**
	 * Process button
	 */
	private JButton processDeleteTable;
	
	/**
	 * Generates the delete area of the edit table window
	 * @param editTableWindow 
	 */
	public EditTableWindowDeleteArea(EditTableWindow editTableWindow){
		/*
		 * Save the reference to the sector edition window
		 */
		this.editTableWindow = editTableWindow;
		
		/*
		 * Set the layout
		 */
		GridLayout controlPanel = new GridLayout(4,1);
		controlPanel.setHgap(10);
		controlPanel.setVgap(5);
		this.editTableWindow.R_Area.setLayout(controlPanel);
		
		/*
		 * Set the title of the category
		 */
		JLabel title = new JLabel("Table deleting", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 20.f));
		this.editTableWindow.R_Area.add(title);
		
		/*
		 * Make the line layout
		 */
		GridLayout lineLayout = new GridLayout(1,2);
		
		/*
		 * Set the 1st line (combo Sector)
		 */
		JPanel line1 = new JPanel();
		line1.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line1); 
		line1.add(new JLabel("Sector"));
		this.comboSectors = new JComboBox<Object>(new TreeSet<Integer>(this.editTableWindow.mainWindow.restaurant.getTheRoom().getSectors().keySet()).toArray());
		this.comboSectors.addActionListener(this);
		line1.add(this.comboSectors);
		
		/*
		 * Set the 2nd line (combo tables)
		 */
		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line2);
		line2.add(new JLabel("Table"));
		Sector theSector = null;
		try {
			theSector = this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector((int)this.comboSectors.getSelectedItem());
		} catch (SectorNotExistsException e) {
			// ... impossible
		}
		this.comboTables = new JComboBox<Object>(new TreeSet<Integer>(theSector.getTables().keySet()).toArray());
		this.comboTables.addActionListener(this);
		line2.add(this.comboTables);
		
		/*
		 * Set the 3rd line (process button)
		 */
		JPanel line3 = new JPanel();
		line3.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line3);
		line3.add(new JLabel());
		this.processDeleteTable = new JButton("Delete");
		this.processDeleteTable.addActionListener(this);
		line3.add(this.processDeleteTable);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.comboSectors)
		{
			// update the tables list when you select a sector in the sectors list
			Sector theSector = null;
			try {
				theSector = this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector((int)this.comboSectors.getSelectedItem());
			} catch (SectorNotExistsException e1) {
				// ... impossible
			}
			DefaultComboBoxModel model = new DefaultComboBoxModel(new TreeSet<Integer>(theSector.getTables().keySet()).toArray());
			this.comboTables.setModel( model );
			
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
					theSector = this.editTableWindow.mainWindow.restaurant.getTheRoom().getSector((int)this.comboSectors.getSelectedItem());
					action++;
				} catch (SectorNotExistsException e1) {
					// impossible
				}
				try {
					theTable = theSector.getTable((int)this.comboTables.getSelectedItem());
					theSector.removeTable(theTable.getNumTable());
					action++;
				} catch (TableNotExistsException e1) {
					// impossible
				}
				if(action == 2) 
				{
					JOptionPane.showMessageDialog(null, "The table has been correctly deleted");
					this.editTableWindow.mainWindow.rightArea.refreshSectors();
				}
				else JOptionPane.showMessageDialog(null, "The table can't be deleted");
				
				// Refresh the page
				this.editTableWindow.R_Area.removeAll();
				new EditTableWindowDeleteArea(this.editTableWindow);
				SwingUtilities.updateComponentTreeUI(this.editTableWindow.R_Area);
			}
		}
	}
}
