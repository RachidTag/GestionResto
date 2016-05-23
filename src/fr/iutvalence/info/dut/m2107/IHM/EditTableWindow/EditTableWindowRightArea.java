package fr.iutvalence.info.dut.m2107.IHM.EditTableWindow;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents the default right area of the edit table window
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class EditTableWindowRightArea extends JPanel{
	/**
	 * The main window
	 */
	public EditTableWindow editTableWindow;

	/**
	 * Generates the right area of the edit table window
	 * @param editTableWindow
	 */
	public EditTableWindowRightArea(EditTableWindow editTableWindow){
		/*
		 * Save the reference to the sector edition window
		 */
		this.editTableWindow = editTableWindow;
		
		/*
		 * Set the default text
		 */
		JLabel defaultText = new JLabel("Table edition menu");
		
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
