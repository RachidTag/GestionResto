package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.iutvalence.info.dut.m2107.Staff.Waiter;

/**
 * Represents the show staff area of the edit waiter window
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class EditWaiterWindowShowStaffArea extends JFrame{ 
	/**
	 * Reference to the edit waiter window
	 */
	public EditWaiterWindow editWaiterWindow; 
	
	/**
	 * Generates the show staff area of the edit waiter window
	 * @param editWaiterWindow
	 */
	@SuppressWarnings("deprecation")
	public EditWaiterWindowShowStaffArea(EditWaiterWindow editWaiterWindow) {
		/*
		 * Save the reference to the edit waiter window
		 */
		this.editWaiterWindow = editWaiterWindow;
		
		/*
		 * Set the layout
		 */
		this.editWaiterWindow.R_Area.setLayout(new GridLayout(1,1));
		
		/*
		 * Add the show panel
		 */
		JPanel showPanel = new JPanel();
		this.editWaiterWindow.R_Area.add(showPanel);
		
		/*
		 * Get the staff list
		 */
		Map<Integer, Waiter> staff = this.editWaiterWindow.mainWindow.restaurant.getTheStaff().getWaiters();
		
		/*
		 * Make an array with the desired datas
		 */
		Object[][] ws = new Object[staff.size()][4];
		int j = 0;
		for (Waiter waiter : staff.values()) {
			ws[j][0] = waiter.getNumWaiter();
			ws[j][1] = waiter.getLastName();
			ws[j][2] = waiter.getFirstName();
			ws[j][3] = waiter.getRank();
			j++;
		}

		String[] titles = {"numbers","First Name", "Last Name", "Rank"};
		
		/*
		 * Make the jtable with the collected datas
		 */
		JTable employes = new JTable(ws, titles);
		employes.getTableHeader().setReorderingAllowed(false);
		employes.getTableHeader().setResizingAllowed(false);
		employes.disable();
				
		showPanel.add(new JScrollPane(employes), BorderLayout.CENTER);
	}
}
