package fr.iutvalence.info.dut.m2107.IHM.RMModEditScheduleWindow;



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
import javax.swing.SwingUtilities;

import fr.iutvalence.info.dut.m2107.Calendar.Week;
import fr.iutvalence.info.dut.m2107.Calendar.WeekNotExistsException;
import fr.iutvalence.info.dut.m2107.Staff.Waiter;
import fr.iutvalence.info.dut.m2107.Staff.WaiterDoesNotExistException;

public class RMModEditScheduleWindowDeleteArea extends JPanel implements ActionListener{

	/**
	 * The Window
	 */
	public RMModEditScheduleWindow rmModEditScheduleWindow;
	/**
	 * The Combo box for waiters
	 */
	public JComboBox<?> comboWeek;
	
	/**
	 * the button process delete week
	 */
	public JButton processDeleteWeek;

	
	public RMModEditScheduleWindowDeleteArea(RMModEditScheduleWindow rmModEditScheduleWindow){
		this.rmModEditScheduleWindow = rmModEditScheduleWindow;
		
		/*
		 * Set the grid layout
		 */
		GridLayout controlPanel = new GridLayout(5,1);
		controlPanel.setHgap(10);
		controlPanel.setVgap(5);
		this.rmModEditScheduleWindow.R_Area.setLayout(controlPanel);
		
		/*
		 * Set the title of the panel
		 */
		 JLabel title = new JLabel("Remove week", SwingConstants.CENTER);
		 title.setFont(title.getFont().deriveFont(Font.BOLD,20.f));
		 this.rmModEditScheduleWindow.R_Area.add(title);
		 
		 /*
		  * Set the layout
		  */
		 GridLayout lineLayout = new GridLayout(1,2);
		 
		 /*
		  * Set the first line (Waiter num)
		  */
		 JPanel line1 = new JPanel();
		 line1.setLayout(lineLayout);
		 this.rmModEditScheduleWindow.R_Area.add(line1);
		 line1.add(new JLabel("Num week"));
		 Set<Integer> weeksNum = this.rmModEditScheduleWindow.mainWindow.restaurant.getTheCalendar().getAllWeeks().keySet();
		 this.comboWeek = new JComboBox<Object>(weeksNum.toArray());
		 this.comboWeek.addActionListener(this);
		 line1.add(this.comboWeek);

		 /*
		  * Set the forth line (remove button)
		  */
		 JPanel line4 = new JPanel();
		 line4.setLayout(lineLayout);
		 this.rmModEditScheduleWindow.R_Area.add(line4);
		 line4.add(new JLabel());
		 this.processDeleteWeek = new JButton("Delete");
		 line4.add(this.processDeleteWeek);
		 this.processDeleteWeek.addActionListener(this);
		 
		 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComponent source = (JComponent) arg0.getSource();
		
		if (source == this.comboWeek){

		}
		else if (source == this.processDeleteWeek){
			int numWeek = (int) this.comboWeek.getSelectedItem();
			int action =0;
			Week theWeek = null;

			try
			{
				this.rmModEditScheduleWindow.mainWindow.restaurant.getTheCalendar().deleteWeekCalendar(numWeek);
				action++;
			}
			catch (WeekNotExistsException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (action !=0)
				JOptionPane.showMessageDialog(null, "The week has been correctly deleted");
			else 
				JOptionPane.showMessageDialog(null, "The week can't be deleted");
				
				this.rmModEditScheduleWindow.R_Area.removeAll();
				new RMModEditScheduleWindowDeleteArea(this.rmModEditScheduleWindow);
				SwingUtilities.updateComponentTreeUI(this.rmModEditScheduleWindow);
			}
			
		}
	}


