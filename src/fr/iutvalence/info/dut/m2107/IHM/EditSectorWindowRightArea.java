package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * @author TODO
 *
 */
public class EditSectorWindowRightArea extends JPanel{
	/**
	 * The main window
	 */
	private SectorEditionWindow sectorEditionWindow;

	/**
	 * TODO
	 * @param mainWindow
	 */
	public EditSectorWindowRightArea(SectorEditionWindow sectorEditionWindow){
		/*
		 * Save the reference to the sector edition window
		 */
		this.sectorEditionWindow = sectorEditionWindow;
		
		/*
		 * Set the default text
		 */
		JLabel defaultText = new JLabel("Menu d'édition des secteurs");
		
		/*
		 * Set the layout
		 */
		this.setLayout(new GridBagLayout());
		
		/*
		 * Set the default text
		 */
		GridBagConstraints gbc = new GridBagConstraints();
		this.add(defaultText, gbc);
		defaultText.setFont(defaultText.getFont().deriveFont(Font.ITALIC, 24.f));
	}
}
