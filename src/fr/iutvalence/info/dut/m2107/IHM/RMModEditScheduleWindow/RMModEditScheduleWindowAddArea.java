package fr.iutvalence.info.dut.m2107.IHM.RMModEditScheduleWindow;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import fr.iutvalence.info.dut.m2107.Calendar.InvalidWeekException;
import fr.iutvalence.info.dut.m2107.Calendar.WeekAlreadyExistsException;

/**
 * represent the add week area
 * @author projet Resto'
 *
 */
@SuppressWarnings("serial")
public class RMModEditScheduleWindowAddArea extends JFrame implements ActionListener{

	/**
	 * The main window
	 */
	public RMModEditScheduleWindow rmModEditScheduleWindow;

	/**
	 * The text field for the last name
	 */
	public JSpinner numWeek;
	/**
	 * The send button
	 */
	public JButton processAddWeek;
	
	/**
	 * TODO
	 * @param editWaiterWindow
	 */
	public RMModEditScheduleWindowAddArea(RMModEditScheduleWindow rmModEditScheduleWindow) {

		this.rmModEditScheduleWindow = rmModEditScheduleWindow;
		
		/*
		 * Set the GridLayout
		 */
		GridLayout controlPanel = new GridLayout(8,1);
		controlPanel.setHgap(10);
		controlPanel.setVgap(5);
		this.rmModEditScheduleWindow.R_Area.setLayout(controlPanel);

		
		/*
		 * Set the title of the panel
		 */
		JLabel title = new JLabel("Add Week",SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 20.f));
		this.rmModEditScheduleWindow.R_Area.add(title);
		
		/*
		 * Create a line layout
		 */
		GridLayout lineLayout = new GridLayout(1,2);
		
		/*
		 * Set the first line (last name)
		 */
		JPanel line1 = new JPanel();
		line1.setLayout(lineLayout);
		this.rmModEditScheduleWindow.R_Area.add(line1);
		line1.add(new JLabel("Week Number"));
		this.numWeek = new JSpinner(new SpinnerNumberModel(1, 1, 52, 1));
		line1.add(this.numWeek);
		
		/*
		 * Set the second line (process add week)
		 */
		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		this.rmModEditScheduleWindow.R_Area.add(line2);
		line2.add(new JLabel());
		this.processAddWeek = new JButton("send");
		this.processAddWeek.addActionListener(this);
		line2.add(this.processAddWeek);

	
		
	}
	
	public void actionPerformed(ActionEvent arg0){
		JComponent source = (JComponent) arg0.getSource();
	
		if(source == this.processAddWeek)
		{
			int theNumWeek = (int)this.numWeek.getValue();
			int action = 0;
			
			try
			{
				this.rmModEditScheduleWindow.mainWindow.restaurant.getTheCalendar().addWeekCalendar(theNumWeek);
				action++;
			}
			catch (WeekAlreadyExistsException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidWeekException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(action != 0)
				JOptionPane.showMessageDialog(null, "The week has been correctly added");
			else
				JOptionPane.showMessageDialog(null, "Can't be added");
		}
		
	}
		
}
