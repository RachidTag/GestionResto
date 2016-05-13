package fr.iutvalence.info.dut.m2107.IHM;

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
import fr.iutvalence.info.dut.m2107.room.Sector;
import fr.iutvalence.info.dut.m2107.room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.room.Table;
import fr.iutvalence.info.dut.m2107.room.TableNotExistsException;

/**
 * @author TODO
 *
 */
@SuppressWarnings("serial")
public class EditTableWindowDeleteArea extends JPanel implements ActionListener{
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
	 * TODO
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
		comboSectors = new JComboBox<Object>(new TreeSet<Integer>(this.editTableWindow.mainWindow.theRoom.getSectors().keySet()).toArray());
		comboSectors.addActionListener(this);
		line1.add(comboSectors);
		
		/*
		 * Set the 2nd line (combo tables)
		 */
		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line2);
		line2.add(new JLabel("Table"));
		Sector theSector = null;
		try {
			theSector = this.editTableWindow.mainWindow.theRoom.getSector((int)comboSectors.getSelectedItem());
		} catch (SectorNotExistsException e) {
			// ... impossible
		}
		comboTables = new JComboBox<Object>(new TreeSet<Integer>(theSector.getTables().keySet()).toArray());
		comboTables.addActionListener(this);
		line2.add(comboTables);
		
		/*
		 * Set the 3rd line (process button)
		 */
		JPanel line3 = new JPanel();
		line3.setLayout(lineLayout);
		this.editTableWindow.R_Area.add(line3);
		line3.add(new JLabel());
		processDeleteTable = new JButton("Delete");
		processDeleteTable.addActionListener(this);
		line3.add(processDeleteTable);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.comboSectors)
		{
			Sector theSector = null;
			try {
				theSector = this.editTableWindow.mainWindow.theRoom.getSector((int)comboSectors.getSelectedItem());
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
					theSector = this.editTableWindow.mainWindow.theRoom.getSector((int)this.comboSectors.getSelectedItem());
					action++;
				} catch (SectorNotExistsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					theTable = theSector.getTable((int)this.comboTables.getSelectedItem());
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
					this.editTableWindow.mainWindow.rightArea.refreshSectors();
				}
				else JOptionPane.showMessageDialog(null, "The table has not been correctly deleted!");
				
				// verify if it's useless
//				this.editTableWindow.R_Area.removeAll();
//				this.editTableWindow.R_Area = new EditTableWindowDeleteArea(this.editTableWindow);
//				SwingUtilities.updateComponentTreeUI(this.editTableWindow.R_Area);
			}
		}
	}
}
