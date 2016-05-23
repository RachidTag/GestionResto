package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.iutvalence.info.dut.m2107.Room.ObjectReadedIsNotARoomException;
import fr.iutvalence.info.dut.m2107.Staff.Rank;
import fr.iutvalence.info.dut.m2107.Staff.Staff;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;
import fr.iutvalence.info.dut.m2107.Staff.WaiterAlreadyExistsException;

/**
 * Show all the staff
 * @author lorettet
 */
public class EditWaiterWindowShowStaffArea extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The window
	 */
	public EditWaiterWindow editWaiterWindow; 
	
	/**
	 * create a table wich show the staff
	 * @param editWaiterWindow
	 */
	public EditWaiterWindowShowStaffArea(EditWaiterWindow editWaiterWindow) {
		
		this.editWaiterWindow = editWaiterWindow;
		
		JPanel showPanel = new JPanel();
		this.editWaiterWindow.R_Area.setLayout(new GridLayout(1,1));
		this.editWaiterWindow.R_Area.add(showPanel);
		
		Map<Integer, Waiter> staff = this.editWaiterWindow.mainWindow.theStaff.getStaff();
		
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
			
			JTable employes = new JTable(ws, titles);
			employes.disable();
					
			showPanel.add(new JScrollPane(employes), BorderLayout.CENTER);
		
	}



	
}
