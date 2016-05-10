package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
	
	class WindowEventHandler extends WindowAdapter {
		public void windowClosing(WindowEvent evt) {
			MainWindow.editSector.setEnabled(true);
			MainWindow.editTable.setEnabled(true);
			MainWindow.checkRoom.setEnabled(true);
			MainWindow.checkSchedule.setEnabled(true);
			MainWindow.roomManager.setEnabled(true);
			MainWindow.close.setEnabled(true);
		    MainWindow.win.setVisible(false);
		    MainWindow.win.R_Area.removeAll();
		}
	}

	public class SectorEditionWindow extends JFrame{
		
		public static JPanel L_Area = new JPanel();
		
		public static JPanel R_Area = new JPanel();
		
		private static JButton edit = new JButton("Edit Sector");
		/*private static JButton delete = new JButton("Delete Table");
		private static JButton add = new JButton("Add Table");
		private static JButton close = new JButton("close");*/
		
		private static JLabel defaultText = new JLabel("Menu d'édition des secteurs");
	
	public SectorEditionWindow()
	{		
		this.addWindowListener(new WindowEventHandler());
		this.setTitle("Edit Sector");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, EditTableWindow.L_Area, EditTableWindow.R_Area);
		split.setOneTouchExpandable(true);
		getContentPane().add(split);
		split.setDividerLocation(120);
		split.setEnabled(false);
		split.setDividerSize(1);

		GridLayout controlPanel = new GridLayout(4,1);
		EditTableWindow.L_Area.setLayout(controlPanel);
		
		EditTableWindow.L_Area.add(edit);
		
		EditTableWindow.R_Area.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		EditTableWindow.R_Area.add(defaultText, gbc);
		defaultText.setFont(defaultText.getFont().deriveFont(Font.ITALIC, 24.f));
		
		this.setVisible(true);
	}

}
