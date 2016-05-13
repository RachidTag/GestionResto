package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import fr.iutvalence.info.dut.m2107.room.Progress;
import fr.iutvalence.info.dut.m2107.room.State;

/**
 * @author TODO
 *
 */
public class EditTableWindowDeleteArea extends JPanel{
	/**
	 * The main window
	 */
	private EditTableWindow editTableWindow;
	
	/**
	 * Table Num spinner
	 */
	public JSpinner tableNum; 
	
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
	public JComboBox<?> comboSectorsAdd;
	
	/**
	 * Sectors combo
	 */
	public JComboBox<?> comboSectorsDelete;
	
	/**
	 * Sectors combo
	 */
	public JComboBox<?> comboSectorsEdit;
	
	/**
	 * Tables combo
	 */
	public JComboBox<Object> comboTablesAdd;
	
	/**
	 * Tables combo
	 */
	public JComboBox<Object> comboTablesDelete;
	
	/**
	 * Tables combo
	 */
	public JComboBox<Object> comboTablesEdit;
	
	/**
	 * State combo
	 */
	public JComboBox<State> state;
	
	/**
	 * Progress combo
	 */
	public JComboBox<Progress> progress;
	
	/**
	 * Client Name text field
	 */
	public JTextField clientName;	

	/**
	 * TODO
	 * @param mainWindow
	 */
	public EditTableWindowDeleteArea(EditTableWindow editTableWindow){
		/*
		 * Save the reference to the sector edition window
		 */
		this.editTableWindow = editTableWindow;
		
		/*
		 * Set the default text
		 */
		JLabel defaultText = new JLabel("Menu d'édition des tables");
		
		/*
		 * Set the layout
		 */
		this.setLayout(new GridBagLayout());
		
		/*
		 * Add the default text
		 */
		GridBagConstraints gbc = new GridBagConstraints();
		defaultText.setFont(defaultText.getFont().deriveFont(Font.ITALIC, 24.f));
		this.add(defaultText, gbc);
	}
}
