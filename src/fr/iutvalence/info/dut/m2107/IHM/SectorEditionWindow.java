package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

class EditSectorWindowEventHandler extends WindowAdapter {
	public void windowClosing(WindowEvent evt) {
//		MainWindow.editSector.setEnabled(true);
//		MainWindow.editTable.setEnabled(true);
//		MainWindow.checkRoom.setEnabled(true);
//		MainWindow.checkSchedule.setEnabled(true);
//		MainWindow.roomManager.setEnabled(true);
//		MainWindow.close.setEnabled(true);
//	    MainWindow.editSectorWindow.setVisible(false);
//	    MainWindow.editSectorWindow.R_Area.removeAll();
	}
}

public class SectorEditionWindow extends JFrame implements ActionListener {
		
	public JPanel L_Area = new JPanel();
	
	public JPanel R_Area = new JPanel();
	
	public JButton edit;
	
	public JButton close;
	
	public JLabel defaultText;

	public MainWindow theMainWindow;
	
	public SectorEditionWindow(MainWindow theMainWindow)
	{	
		this.defaultText = new JLabel("Menu d'édition des secteurs");
		this.theMainWindow = theMainWindow;
		this.addWindowListener(new WindowEventHandler(this.theMainWindow));
		this.setTitle("Edit Sector");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, this.L_Area, this.R_Area);
		split.setOneTouchExpandable(true);
		getContentPane().add(split);
		split.setDividerLocation(120);
		split.setEnabled(false);
		split.setDividerSize(1);

		GridLayout controlPanel = new GridLayout(4,1);
		this.L_Area.setLayout(controlPanel);
		
		this.edit = new JButton("Edit Sector");
		this.L_Area.add(edit);
		
		this.close = new JButton("close");
		this.close.addActionListener(this);
		this.L_Area.add(close);
		
		this.R_Area.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.R_Area.add(defaultText, gbc);
		defaultText.setFont(defaultText.getFont().deriveFont(Font.ITALIC, 24.f));
		
		this.setVisible(true);
	}
	
	/**
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent) e.getSource();
		if(source == this.close)
		{
			this.theMainWindow.editSector.setEnabled(true);
		    this.theMainWindow.editTable.setEnabled(true);
		    this.theMainWindow.checkRoom.setEnabled(true);
		    this.theMainWindow.checkSchedule.setEnabled(true);
		    this.theMainWindow.roomManager.setEnabled(true);
		    this.theMainWindow.close.setEnabled(true);
		    this.setVisible(false);
		    this.R_Area.removeAll();
		}
		else if(source == this.edit)
		{
			
		}
		else
		{
			// TODO
		}	
	}
}
