package fr.iutvalence.info.dut.m2107.IHM.RMModWindow;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.iutvalence.info.dut.m2107.IHM.EditWaiterWindow.EditWaiterWindow;

/**
 * @author TODO
 *
 */
@SuppressWarnings("serial")
public class RMModWindowRightArea extends JPanel implements ActionListener
{
	/**
	 * The main window
	 */
	@SuppressWarnings("unused")
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
	public JButton processLogin;	
	
	/**
	 * Edit the schedule button
	 */
	public JButton editSch;

	/**
	 * TODO
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
		GridLayout controlPanel = new GridLayout(11,1);
		controlPanel.setHgap(10);
		controlPanel.setVgap(5);
		this.setLayout(controlPanel);
		
		/*
		 * Set the title of the category
		 */
		JLabel title = new JLabel("Connection", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 20.f));
		this.add(title);
		
		/*
		 * Creates the line layout
		 */
		GridLayout lineLayout = new GridLayout(1, 2);
		
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
		this.processLogin = new JButton("Send");
		this.processLogin.addActionListener(this);
		line3.add(this.processLogin);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(this.username.getText().equals("admin")
				&& this.password.getText().equals("admin"))
		{
			editSch = new JButton("Edit the schedule");
			editSch.addActionListener(this.rMModWindow.mainWindow.leftArea);
			
			this.rMModWindow.mainWindow.leftArea.add(editSch);
			this.rMModWindow.mainWindow.leftArea.validate();
		}		
	}
}
