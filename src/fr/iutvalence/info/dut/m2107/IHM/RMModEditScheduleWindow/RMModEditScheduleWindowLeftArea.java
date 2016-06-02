package fr.iutvalence.info.dut.m2107.IHM.RMModEditScheduleWindow;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 * @author projet Resto'
 *
 */
public class RMModEditScheduleWindowLeftArea extends JPanel implements ActionListener {

		/**
		 * The main window
		 */
		public RMModEditScheduleWindow rmModEditScheduleWindow;
		
		/**
		 * The add button
		 */
		public JButton add;
		/**
		 * The add waiter button
		 */
		public JButton addWaiter;
		/**
		 * The remove waiter button
		 */
		public JButton removeWaiter;
		/**
		 * The remove button
		 */
		public JButton remove;
		/**
		 * The close button
		 */
		public JButton close;

		/**
		 * TODO
		 * @param sectorEditionWindow
		 */
		public RMModEditScheduleWindowLeftArea(RMModEditScheduleWindow rmModEditScheduleWindow){
			/*
			 * Save the reference to the sectorEditionWindo
			 */
			this.rmModEditScheduleWindow = rmModEditScheduleWindow;
			
			/*
			 * Set the layout
			 */
			GridLayout controlPanel = new GridLayout(5,1);
			this.setLayout(controlPanel);
			
			/*
			 * Set the add waiter button
			 */
			this.add = new JButton("Add week");
			this.add.addActionListener(this);
			this.add(this.add);
			
			/*
			 * Set the add waiter button
			 */
			this.addWaiter = new JButton("Add Waiter");
			this.addWaiter.addActionListener(this);
			this.add(this.addWaiter);
			
			/*
			 * Set the remove waiter button
			 */
			this.removeWaiter = new JButton("Remove Waiter");
			this.removeWaiter.addActionListener(this);
			this.add(this.removeWaiter);

			/*
			 * Set the remove waiter button
			 */
			this.remove = new JButton("Remove week");
			this.remove.addActionListener(this);
			this.add(this.remove);
			
			/*
			 * Set the close button
			 */
			this.close = new JButton("close");
			this.close.addActionListener(this);
			this.add(this.close);
			
		}

		/**
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			this.rmModEditScheduleWindow.mainWindow.enable();
		    this.rmModEditScheduleWindow.dispose();
		    this.rmModEditScheduleWindow.R_Area.removeAll();
		}
		else if(source == this.add)
		{
			this.rmModEditScheduleWindow.R_Area.removeAll();
			new RMModEditScheduleWindowAddArea(this.rmModEditScheduleWindow);
			SwingUtilities.updateComponentTreeUI(this.rmModEditScheduleWindow);
		}
		else if (source == this.addWaiter)
		{
			this.rmModEditScheduleWindow.R_Area.removeAll();
			new RMModEditScheduleWindowEditAreaAddWaiter(this.rmModEditScheduleWindow);
			SwingUtilities.updateComponentTreeUI(this.rmModEditScheduleWindow);
		}
		else if (source == this.removeWaiter){
			//TODO RACHID!!!
		}
		else if (source == this.remove){
			this.rmModEditScheduleWindow.R_Area.removeAll();
			new RMModEditScheduleWindowDeleteArea(this.rmModEditScheduleWindow);
			SwingUtilities.updateComponentTreeUI(this.rmModEditScheduleWindow);
		}
	}
}

