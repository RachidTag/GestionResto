package fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.iutvalence.info.dut.m2107.Staff.Waiter;
import fr.iutvalence.info.dut.m2107.Staff.WaiterDoesNotExistException;

/**
 * Represent the remove waiter right area
 * @author lorettet
 */
public class EditWaiterWindowRemoveArea extends JPanel implements ActionListener{

	/**
	 * The Window
	 */
	public EditWaiterWindow editWaiterWindow;
	/**
	 * The Combo box for waiters
	 */
	public JComboBox<?> comboWaiter;
	/**
	 * the first name of the waiter
	 */
	public String firstName;
	/**
	 * the last name of the waiter
	 */
	public String lastName;
	/**
	 * The remove button
	 */
	public JButton processRemoveWaiter;
	/**
	 * The label for the first name
	 */
	public JLabel labelFirstName;
	/**
	 * The label for the last name
	 */
	public JLabel labelLastName;
	
	public EditWaiterWindowRemoveArea(EditWaiterWindow editWaiterWindow){
		this.editWaiterWindow = editWaiterWindow;
		this.lastName = null;
		this.firstName = null;
		this.labelLastName = new JLabel(this.lastName);
		this.labelFirstName = new JLabel(this.firstName);
		
		/*
		 * Set the grid layout
		 */
		GridLayout controlPanel = new GridLayout(4,1);
		controlPanel.setHgap(10);
		controlPanel.setVgap(5);
		this.editWaiterWindow.R_Area.setLayout(controlPanel);
		
		/*
		 * Set the title of the panel
		 */
		 JLabel title = new JLabel("Remove waiter", SwingConstants.CENTER);
		 title.setFont(title.getFont().deriveFont(Font.BOLD,20.f));
		 this.editWaiterWindow.R_Area.add(title);
		 
		 /*
		  * Set the layout
		  */
		 GridLayout lineLayout = new GridLayout(1,2);
		 
		 /*
		  * Set the first line (Waiter num)
		  */
		 JPanel line1 = new JPanel();
		 line1.setLayout(lineLayout);
		 this.editWaiterWindow.R_Area.add(line1);
		 line1.add(new JLabel("Num waiters"));
		 Set<Integer> waitersNum = this.editWaiterWindow.mainWindow.theStaff.getStaff().keySet();
		 this.comboWaiter = new JComboBox<Object>(waitersNum.toArray());
		 this.comboWaiter.addActionListener(this);
		 line1.add(this.comboWaiter);
		 
		 /*
		  * Set the second line (last name)
		  */
		 JPanel line2 = new JPanel();
		 line2.setLayout(lineLayout);
		 this.editWaiterWindow.R_Area.add(line2);
		 line2.add(new JLabel("Last name :"));
		 line2.add(this.labelLastName);
		 
		 /*
		  * Set the third line (first name)
		  */
		 JPanel line3 = new JPanel();
		 line3.setLayout(lineLayout);
		 this.editWaiterWindow.R_Area.add(line3);
		 line3.add(new JLabel("First name :"));
		 line3.add(this.labelFirstName);
		 
		 /*
		  * Set the forth line (remove button)
		  */
		 JPanel line4 = new JPanel();
		 line4.setLayout(lineLayout);
		 this.editWaiterWindow.R_Area.add(line4);
		 line4.add(new JLabel());
		 this.processRemoveWaiter = new JButton("Remove");
		 line4.add(this.processRemoveWaiter);
		 this.processRemoveWaiter.addActionListener(this);
		 
		 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComponent source = (JComponent) arg0.getSource();
		
		if (source == this.comboWaiter){
			try {
				Waiter theWaiter = this.editWaiterWindow.mainWindow.theStaff.getWaiter((int) this.comboWaiter.getSelectedItem());
				this.lastName = theWaiter.getLastName();
				this.firstName = theWaiter.getFirstName();
				this.labelLastName.setText(this.lastName);
				this.labelFirstName.setText(this.firstName);
			} catch (WaiterDoesNotExistException e) {
				this.lastName = null;
				this.firstName = null;
				e.printStackTrace();
			}
		}
		else if (source == this.processRemoveWaiter){
			int numWaiter = (int) this.comboWaiter.getSelectedItem();
			int action =0;
			try {
				this.editWaiterWindow.mainWindow.theStaff.deleteWaiter(numWaiter);
				action++;
			} catch (WaiterDoesNotExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (action !=0)
				JOptionPane.showMessageDialog(null, "The waiter has been correctly edited");
			else 
				JOptionPane.showMessageDialog(null, "The waiter can't be edited");
		}
		
	}
}
