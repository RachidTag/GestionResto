package fr.iutvalence.info.dut.m2107.IHM.MainWindow;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.iutvalence.info.dut.m2017.IHM.RMModEditScheduleWindow.RMModEditScheduleWindow;
import fr.iutvalence.info.dut.m2107.IHM.CustomButton.CustomButton;
import fr.iutvalence.info.dut.m2107.IHM.EditTableWindow.EditTableWindow;
import fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow.EditWaiterWindow;
import fr.iutvalence.info.dut.m2107.IHM.RMModWindow.RMModWindow;
import fr.iutvalence.info.dut.m2107.IHM.Schedule.ScheduleWindow;

/**
 * Represents the left area of the main window
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class MainWindowLeftArea extends JPanel implements ActionListener{
	/**
	 * The main window
	 */
	private MainWindow mainWindow;

	/**
	 * Edit Table button (left panel)
	 */
	public CustomButton editTable;
	
	/**
	 * Edit waiter button (left panel)
	 */
	public CustomButton editWaiter;

	/**
	 * Check the schedule button (left panel)
	 */
	public CustomButton checkSchedule;

	/**
	 * Room manager button (left panel)
	 */
	public CustomButton roomManager;

	/**
	 * Edit schedule button (left panel)
	 */
	public CustomButton editSchedule;
	
	/**
	 * Close button (left panel)
	 */
	public CustomButton close;
	
	/**
	 * Logo Icon
	 */
	public ImageIcon logoIcon;
	
	/**
	 * Logo Image
	 */
	public Image logo;

	/**
	 * Generates the left area of the main window
	 * @param mainWindow
	 */
	public MainWindowLeftArea(MainWindow mainWindow){
		/*
		 * Save the reference to the mainWindow
		 */
		this.mainWindow = mainWindow;
		
		/*
		 * Make the layout of the panel
		 */
		GridLayout leftPanelControlGrid = new GridLayout(8,1);

		/*
		 * Create an horizontal and vertical gap of 5 pixels between panel and gridlayout
		 */
		leftPanelControlGrid.setHgap(5);
		leftPanelControlGrid.setVgap(5);
		
		/*
		 * Set the layout
		 */
		this.setLayout(leftPanelControlGrid);
		
		/*
		 * Add the logo
		 */
		ImageIcon icon = new ImageIcon("img/logo.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(143, 90, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		
		JLabel lab = new JLabel(icon);
		this.add(lab);
		
		/*
		 * Set the icon
		 */
		this.logoIcon = new ImageIcon("img/logoIcon.png");
		this.logo = this.logoIcon.getImage();
		
		/*
		 * Add "table edition" button
		 */
		this.editTable = new CustomButton("Edit Table");
		this.editTable.addActionListener(this);
		JPanel editTablePanel = new JPanel();
		editTablePanel.add(this.editTable);
		this.add(editTablePanel);
		
		/*
		 * Add "check a schedule" button
		 */
		this.checkSchedule = new CustomButton("Check the Schedule");
		this.checkSchedule.addActionListener(this);
		JPanel checkSchedulePanel = new JPanel();
		checkSchedulePanel.add(this.checkSchedule);
		this.add(checkSchedulePanel);
		
		/*
		 * Add "room manager mod" button
		 */
		this.roomManager = new CustomButton("Room Manager mod");
		this.roomManager.addActionListener(this);
		JPanel roomManagerPanel = new JPanel();
		roomManagerPanel.add(this.roomManager);
		this.add(roomManagerPanel);	

		/*
		 * Add "edit waiter" menu
		 */
		this.editWaiter = new CustomButton("Edit Waiter");
		this.editWaiter.addActionListener(this);
		JPanel editWaiterPanel = new JPanel();
		editWaiterPanel.add(this.editWaiter);
		this.add(editWaiterPanel);
		this.editWaiter.setVisible(false);
		
		/*
		 * Add "edit schedule" button
		 */
		this.editSchedule = new CustomButton("Edit Schedule");
		this.editSchedule.addActionListener(this);
		JPanel editSchedulePanel = new JPanel();
		editSchedulePanel.add(this.editSchedule);
		this.add(editSchedulePanel);
		this.editSchedule.setVisible(false);
		
		/*
		 * Add "quit" button
		 */
		this.close = new CustomButton("Close");
		this.close.addActionListener(this);
		JPanel closePanel = new JPanel();
		closePanel.add(this.close);
		this.add(closePanel);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			int response = JOptionPane.showConfirmDialog(null, "Do you wish to close the application?", "Confirm",
			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				this.mainWindow.restaurant.saveRestaurant();
		    	System.exit(0);
		    }
		}
		else
		{
			if(source == this.editTable)
			{
				this.mainWindow.editTableWindow = new EditTableWindow(this.mainWindow);
				this.mainWindow.editTableWindow.setIconImage(this.logo);	
			}
			else if(source == this.editWaiter)
			{
				this.mainWindow.editSectorWindow = new EditWaiterWindow(this.mainWindow);
				this.mainWindow.editSectorWindow.setIconImage(this.logo);		
			}
			else if(source == this.roomManager)
			{
				this.mainWindow.rMModWindow = new RMModWindow(this.mainWindow);
				this.mainWindow.rMModWindow.setIconImage(this.logo);			
			}
			else if(source == this.checkSchedule)
			{
				this.mainWindow.scheduleWindow = new ScheduleWindow(this.mainWindow);
				this.mainWindow.scheduleWindow.setIconImage(this.logo);
			}
			else if(source == this.editSchedule)
			{
				this.mainWindow.editScheduleWindow = new RMModEditScheduleWindow(this.mainWindow);
				this.mainWindow.editScheduleWindow.setIconImage(this.logo);
			}
			
			// Put the buttons disabled
			this.mainWindow.disable();
		}
	}
}
