package fr.iutvalence.info.dut.m2107.IHM.RMModEditScheduleWindow;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.iutvalence.info.dut.m2107.IHM.CustomButton.CustomButton;


/**
 * Represents the default left area of the edit schedule window
 * @author projet Resto'
 *
 */
@SuppressWarnings("serial")
public class RMModEditScheduleWindowLeftArea extends JPanel implements ActionListener {

		/**
		 * The main window
		 */
		public RMModEditScheduleWindow rmModEditScheduleWindow;
		
		/**
		 * The add button
		 */
		public CustomButton add;
		/**
		 * The add waiter button
		 */
		public CustomButton addWaiter;
		/**
		 * The remove waiter button
		 */
		public CustomButton removeWaiter;
		/**
		 * The remove button
		 */
		public CustomButton remove;
		/**
		 * The close button
		 */
		public CustomButton close;

		/**
		 * Generates the left area of the rmmod edit schedule window
		 * @param rmModEditScheduleWindow
		 */
		public RMModEditScheduleWindowLeftArea(RMModEditScheduleWindow rmModEditScheduleWindow){
			/*
			 * Save the reference to the sectorEditionWindo
			 */
			this.rmModEditScheduleWindow = rmModEditScheduleWindow;
			
			/*
			 * Set the layout
			 */
			GridLayout controlPanel = new GridLayout(7,1);
			this.setLayout(controlPanel);
			
			/*
			 * Set the add waiter button
			 */
			this.add = new CustomButton("Add week", new Dimension(150,45));
			this.add.addActionListener(this);
			this.add(this.add);
			
			/*
			 * Set the add waiter button
			 */
			this.addWaiter = new CustomButton("Add Waiter", new Dimension(150,45));
			this.addWaiter.addActionListener(this);
			this.add(this.addWaiter);
			
			/*
			 * Set the remove waiter button
			 */
			this.removeWaiter = new CustomButton("Remove Waiter", new Dimension(150,45));
			this.removeWaiter.addActionListener(this);
			this.add(this.removeWaiter);

			/*
			 * Set the remove waiter button
			 */
			this.remove = new CustomButton("Remove week", new Dimension(150,45));
			this.remove.addActionListener(this);
			this.add(this.remove);
			
			/*
			 * Set the close button
			 */
			this.close = new CustomButton("close", new Dimension(150,45));
			this.close.addActionListener(this);
			this.add(this.close);

			JPanel buttonJPanel1 = new JPanel();
			JPanel buttonJPanel2 = new JPanel();
			JPanel buttonJPanel3 = new JPanel();
			JPanel buttonJPanel4 = new JPanel();
			JPanel buttonJPanel5 = new JPanel();
			JPanel buttonJPanel6 = new JPanel();
			JPanel buttonJPanel7 = new JPanel();
			
			buttonJPanel1.add(this.add);
			buttonJPanel2.add(this.addWaiter);
			buttonJPanel3.add(this.removeWaiter);
			buttonJPanel4.add(this.remove);
			buttonJPanel7.add(this.close);
			
			this.add(buttonJPanel1);
			this.add(buttonJPanel2);
			this.add(buttonJPanel3);
			this.add(buttonJPanel4);
			this.add(buttonJPanel5);
			this.add(buttonJPanel6);
			this.add(buttonJPanel7);
			
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
			this.rmModEditScheduleWindow.R_Area.removeAll();
			new RMModEditScheduleWindowEditAreaRemoveWaiter(this.rmModEditScheduleWindow);
			SwingUtilities.updateComponentTreeUI(this.rmModEditScheduleWindow);
		}
		else if (source == this.remove){
			this.rmModEditScheduleWindow.R_Area.removeAll();
			new RMModEditScheduleWindowDeleteArea(this.rmModEditScheduleWindow);
			SwingUtilities.updateComponentTreeUI(this.rmModEditScheduleWindow);
		}
	}
}

