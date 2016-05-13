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
public class EditSectorWindowRightArea extends JPanel{
	/**
	 * The main window
	 */
	@SuppressWarnings("unused")
	private EditSectorWindow sectorEditionWindow;

	/**
	 * TODO
	 * @param sectorEditionWindow
	 */
	public EditSectorWindowRightArea(EditSectorWindow sectorEditionWindow){
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
