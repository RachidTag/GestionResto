package fr.iutvalence.info.dut.m2017.IHM.RMModEditScheduleWindow;


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
		 * The edit button
		 */
		public JButton edit;
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
			this.add(add);
			
			/*
			 * Set the edit waiter button
			 */
			this.edit = new JButton("Edit schedule");
			this.edit.addActionListener(this);
			this.add(edit);

			/*
			 * Set the remove waiter button
			 */
			this.remove = new JButton("Remove week");
			this.remove.addActionListener(this);
			this.add(remove);
			
			/*
			 * Set the close button
			 */
			this.close = new JButton("close");
			this.close.addActionListener(this);
			this.add(close);
			
		}

		/**
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			this.rmModEditScheduleWindow.mainWindow.leftArea.editWaiter.setEnabled(true);
		    this.rmModEditScheduleWindow.mainWindow.leftArea.editTable.setEnabled(true);
		    this.rmModEditScheduleWindow.mainWindow.leftArea.checkRoom.setEnabled(true);
		    this.rmModEditScheduleWindow.mainWindow.leftArea.checkSchedule.setEnabled(true);
		    this.rmModEditScheduleWindow.mainWindow.leftArea.roomManager.setEnabled(true);
		    this.rmModEditScheduleWindow.mainWindow.leftArea.close.setEnabled(true);
		    this.rmModEditScheduleWindow.setVisible(false);
		    this.rmModEditScheduleWindow.R_Area.removeAll();
		}
		else if(source == this.add)
		{
			this.rmModEditScheduleWindow.R_Area.removeAll();
			new RMModEditScheduleWindowAddArea(this.rmModEditScheduleWindow);
			SwingUtilities.updateComponentTreeUI(this.rmModEditScheduleWindow);
		}
		else if (source == this.edit)
		{
			this.rmModEditScheduleWindow.R_Area.removeAll();
			new RMModEditScheduleWindowEditArea(this.rmModEditScheduleWindow);
			SwingUtilities.updateComponentTreeUI(this.rmModEditScheduleWindow);
		}
		else if (source == this.remove){
			this.rmModEditScheduleWindow.R_Area.removeAll();
			new RMModEditScheduleWindowRemoveArea(this.rmModEditScheduleWindow);
			SwingUtilities.updateComponentTreeUI(this.rmModEditScheduleWindow);
		}
	}
}

