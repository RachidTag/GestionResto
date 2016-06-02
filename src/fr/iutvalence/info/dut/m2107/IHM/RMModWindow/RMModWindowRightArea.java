package fr.iutvalence.info.dut.m2107.IHM.RMModWindow;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.iutvalence.info.dut.m2107.IHM.CustomButton.CustomButton;

/**
 * Represents the right area of the room manager window
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class RMModWindowRightArea extends JPanel implements ActionListener
{
	/**
	 * Reference to the main window
	 */
	private RMModWindow rMModWindow;
	
	/**
	 * Username
	 */
	public JTextField username;
	
	/**
	 * Password
	 */
	public JPasswordField password;
	
	/**
-	 * Process login
	 */
	public CustomButton processLogin;	
	
	/**
	 * Edit the schedule button
	 */
	public JButton editSch;

	/**
	 * Generates the right area of the room manager mod window
	 * @param rMModWindow
	 */
	public RMModWindowRightArea(RMModWindow rMModWindow){
		/*
		 * Save the reference to the sector edition window
		 */
		this.rMModWindow = rMModWindow;
		
		/*
		 * Set the layout
		 */
		GridLayout controlPanel = new GridLayout(7,1);
		controlPanel.setHgap(10);
		controlPanel.setVgap(5);
		this.setLayout(controlPanel);
		
		/*
		 * Set the title of the category
		 */
		JLabel title = new JLabel("Connexion", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 20.f));
		this.add(title);
		
		/*
		 * Creates the line layout
		 */
		GridLayout lineLayout = new GridLayout(1, 2);
		lineLayout.setVgap(5);
		lineLayout.setHgap(5);
		
		/*
		 * Set the 1st line (rm username)
		 */
		JPanel line1 = new JPanel();
		line1.setLayout(lineLayout);
		this.add(line1);
		line1.add(new JLabel("Username"));
		this.username = new JTextField();
		line1.add(this.username);
		
		/*
		 * Set the 2nd line (rm password)
		 */
		JPanel line2 = new JPanel();
		line2.setLayout(lineLayout);
		this.add(line2);
		line2.add(new JLabel("Password"));
		this.password = new JPasswordField();
		line2.add(this.password);
		
		/*
		 * Set the 3rd line (submit button)
		 */
		JPanel line3 = new JPanel();
		line3.setLayout(lineLayout);
		this.add(line3);
		line3.add(new JLabel());
		this.processLogin = new CustomButton("Connection", new Dimension(238,57));
		this.processLogin.addActionListener(this);


		line3.add(this.processLogin);

	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent arg0) {
		if(this.username.getText().equals("admin")
				&& this.password.getText().equals("admin"))
		{
			this.rMModWindow.mainWindow.leftArea.editSchedule.setVisible(true);
			this.rMModWindow.mainWindow.leftArea.editWaiter.setVisible(true);
			this.rMModWindow.mainWindow.leftArea.disconnection.setVisible(true);
			this.rMModWindow.mainWindow.leftArea.roomManager.setVisible(false);
			this.rMModWindow.mainWindow.leftArea.validate();
			JOptionPane.showMessageDialog(null, "You've been correctly logged on Room Manager mode");
			this.rMModWindow.mainWindow.enable();
		    this.rMModWindow.dispose();
		    this.rMModWindow.R_Area.removeAll();
		}	
		else
			JOptionPane.showMessageDialog(null, "Wrong username / password");
	}
}
