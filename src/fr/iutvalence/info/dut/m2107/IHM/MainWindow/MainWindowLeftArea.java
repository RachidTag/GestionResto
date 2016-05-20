package fr.iutvalence.info.dut.m2107.IHM.MainWindow;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.iutvalence.info.dut.m2107.IHM.ScheduleWindow;
import fr.iutvalence.info.dut.m2107.IHM.EditTableWindow.EditTableWindow;
import fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow.EditWaiterWindow;
import fr.iutvalence.info.dut.m2107.IHM.RMModWindow.RMModWindow;

/**
 * @author TODO
 *
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
	public JButton editTable;
	
	/**
	 * Edit sector button (left panel)
	 */
	public JButton editSector;

	/**
	 * Check the room button (left panel)
	 */
	public JButton checkRoom;

	/**
	 * Check the schedule button (left panel)
	 */
	public JButton checkSchedule;

	/**
	 * Room manager button (left panel)
	 */
	public JButton roomManager;
	
	/**
	 * Close button (left panel)
	 */
	public JButton close;
	
	/**
	 * Logo Icon
	 */
	public ImageIcon logoIcon;
	
	/**
	 * Logo Image
	 */
	public Image logo;

	/**
	 * TODO
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
		this.editTable = new JButton("Edit Table");
		this.editTable.addActionListener(this);
		this.add(this.editTable);		

		/*
		 * Add "sector edition" menu
		 */
		this.editSector = new JButton("Edit Sector");
		this.editSector.addActionListener(this);
		this.add(this.editSector);
		
		/*
		 * Add "check a room" button
		 */
		this.checkRoom = new JButton("Check the room");
		this.checkRoom.addActionListener(this);
		this.add(this.checkRoom);
		
		/*
		 * Add "check a schedule" button
		 */
		this.checkSchedule = new JButton("Check the Schedule");
		this.checkSchedule.addActionListener(this);
		this.add(this.checkSchedule);
		
		/*
		 * Add "room manager mod" button
		 */
		this.roomManager = new JButton("Room Manager mod");
		this.roomManager.addActionListener(this);
		this.add(this.roomManager);
		
		/*
		 * Add "quit" button
		 */
		this.close = new JButton("Close");
		this.close.addActionListener(this);
		this.add(this.close);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			int response = JOptionPane.showConfirmDialog(null, "Do you wish to close the application?", "Confirm",
			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				this.mainWindow.theRoom.saveRoom();
				// TODO this.mainWindow.theCalendar.saveCalendar();
		    	System.exit(0);
		    }
		}
		else if(source == this.editTable)
		{
			if(this.editTable.isEnabled())
			{
				this.mainWindow.editTableWindow = new EditTableWindow(this.mainWindow);
				this.mainWindow.editTableWindow.setIconImage(this.logo);
			
				this.editTable.setEnabled(false);
				this.editSector.setEnabled(false);
				this.checkRoom.setEnabled(false);
				this.checkSchedule.setEnabled(false);
				this.roomManager.setEnabled(false);
				this.close.setEnabled(false);
			}	
		}
		else if(source == this.editSector)
		{
			if(this.editSector.isEnabled())
			{
				this.mainWindow.editSectorWindow = new EditWaiterWindow(this.mainWindow);
				this.mainWindow.editSectorWindow.setIconImage(this.logo);
				
				this.editTable.setEnabled(false);
				this.editSector.setEnabled(false);
				this.checkRoom.setEnabled(false);
				this.checkSchedule.setEnabled(false);
				this.roomManager.setEnabled(false);
				this.close.setEnabled(false);
			}				
		}
		else if(source == this.roomManager)
		{
			if(this.roomManager.isEnabled())
			{
				this.mainWindow.rMModWindow = new RMModWindow(this.mainWindow);
				this.mainWindow.rMModWindow.setIconImage(this.logo);
				
				this.editTable.setEnabled(false);
				this.editSector.setEnabled(false);
				this.checkRoom.setEnabled(false);
				this.checkSchedule.setEnabled(false);
				this.roomManager.setEnabled(false);
				this.close.setEnabled(false);
			}				
		}
		else if(source == this.checkSchedule)
		{
			if(this.checkSchedule.isEnabled())
			{
				this.mainWindow.scheduleWindow = new ScheduleWindow(this.mainWindow);
				this.mainWindow.scheduleWindow.setIconImage(this.logo);
				
				this.editTable.setEnabled(false);
				this.editSector.setEnabled(false);
				this.checkRoom.setEnabled(false);
				this.checkSchedule.setEnabled(false);
				this.roomManager.setEnabled(false);
				this.close.setEnabled(false);
			}				
		}
		else if(source == this.mainWindow.rMModWindow.R_Area.editSch)
		{
			if(this.mainWindow.rMModWindow.R_Area.editSch.isEnabled())
			{
				this.mainWindow.scheduleWindow = new ScheduleWindow(this.mainWindow);
				this.mainWindow.scheduleWindow.setIconImage(this.logo);
				
				this.editTable.setEnabled(false);
				this.editSector.setEnabled(false);
				this.checkRoom.setEnabled(false);
				this.checkSchedule.setEnabled(false);
				this.roomManager.setEnabled(false);
				this.close.setEnabled(false);
			}				
		}
		else
		{
			// TODO for others buttons
		}
	}
}
