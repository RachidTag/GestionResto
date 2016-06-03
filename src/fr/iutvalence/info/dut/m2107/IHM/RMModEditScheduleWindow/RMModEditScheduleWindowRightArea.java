package fr.iutvalence.info.dut.m2107.IHM.RMModEditScheduleWindow;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

	/**
	 * Represents the default right area of the edit waiter window
	 * @author Projet Resto
	 *
	 */
	@SuppressWarnings("serial")
	public class RMModEditScheduleWindowRightArea extends JPanel{
		/**
		 * The main window
		 */
		@SuppressWarnings("unused")
		private RMModEditScheduleWindow rmModEditScheduleWindow;

		/**
		 * Generates the right area of the edit schedule window
		 * @param rmModEditScheduleWindow
		 */
		public RMModEditScheduleWindowRightArea(RMModEditScheduleWindow rmModEditScheduleWindow){
			/*
			 * Save the reference to the sector edition window
			 */
			this.rmModEditScheduleWindow = rmModEditScheduleWindow;
			
			/*
			 * Set the default text
			 */
			JLabel defaultText = new JLabel("Waiter edition menu");
			
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

