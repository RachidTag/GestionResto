package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author TODO
 *
 */
@SuppressWarnings("serial")
public class EditTableWindowRightArea extends JPanel{
	/**
	 * The main window
	 */
	public EditTableWindow editTableWindow;

	/**
	 * TODO
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
