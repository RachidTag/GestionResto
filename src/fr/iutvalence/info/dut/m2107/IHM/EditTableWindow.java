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
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class WindowEventHandler extends WindowAdapter {
	public void windowClosing(WindowEvent evt) {
		MainWindow.editSector.setEnabled(true);
		MainWindow.editTable.setEnabled(true);
		MainWindow.checkRoom.setEnabled(true);
		MainWindow.checkSchedule.setEnabled(true);
		MainWindow.roomManager.setEnabled(true);
	    MainWindow.win.setVisible(false);
	    MainWindow.win.R_Area.removeAll();
	}
}

/**
 * TODO
 * @author Projet Resto
 *
 */
@SuppressWarnings("serial")
public class EditTableWindow extends JFrame {
	
	/**
	 * Left Area
	 */
	public static JPanel L_Area = new JPanel();
	/**
	 * Right Area
	 */
	public static JPanel R_Area = new JPanel();
	
	/**
	 * Buttons
	 */
	private static JButton edit = new JButton("Edit Table");
	private static JButton delete = new JButton("Delete Table");
	private static JButton add = new JButton("Add Table");
	private static JButton close = new JButton("close");
	
	/**
	 * Default menu text
	 */
	private static JLabel defaultText = new JLabel("Menu d'édition des tables");
	
	/**
	 * 
	 */
	public EditTableWindow()
	{		
		this.addWindowListener(new WindowEventHandler());
		this.setTitle("Edit Table");
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
		EditTableWindow.L_Area.add(delete);
		EditTableWindow.L_Area.add(add);
		EditTableWindow.L_Area.add(close);
		
		close.addMouseListener(new TableEditionClosingButton());
		add.addMouseListener(new TableEditionAddButton());
		
		EditTableWindow.R_Area.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		EditTableWindow.R_Area.add(defaultText, gbc);
		defaultText.setFont(defaultText.getFont().deriveFont(Font.ITALIC, 24.f));
		
		this.setVisible(true);
	}
	
	/**
	 * 
	 */
	public static void addTableArea() {
		EditTableWindow.R_Area.removeAll();
		GridLayout controlPanel = new GridLayout(7,1);
		EditTableWindow.R_Area.setLayout(controlPanel);
		EditTableWindow.R_Area.add(new JLabel("Table adding:"));
		EditTableWindow.R_Area.add(new JTextField());
		EditTableWindow.R_Area.add(new JSlider(2, 4));
		
		SwingUtilities.updateComponentTreeUI(MainWindow.win);
		
	}
}
