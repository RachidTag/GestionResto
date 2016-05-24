package fr.iutvalence.info.dut.m2017.IHM.RMModEditScheduleWindow;

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
	public class RMModEditScheduleWindowRightArea extends JPanel{
		/**
		 * The main window
		 */
		@SuppressWarnings("unused")
		private RMModEditScheduleWindow rmModEditScheduleWindow;

		/**
		 * TODO
		 * @param sectorEditionWindow
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

