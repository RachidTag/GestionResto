package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class EditTableWindow extends JFrame {
	
	public static JPanel L_Area = new JPanel();
	public static JPanel R_Area = new JPanel();
	
	private JButton edit = new JButton("Edit Table");
	private JButton delete = new JButton("Delete Table");
	private JButton add = new JButton("Add Table");
	private JButton close = new JButton("close");
	
	private GridLayout controlPanel = new GridLayout(4,1);
	
	private JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, L_Area, R_Area);
	
	public EditTableWindow()
	{
		this.setTitle("Edit Table");
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		
		split.setOneTouchExpandable(true);
		
		getContentPane().add(split);
		
		split.setDividerLocation(120);
		
		split.setEnabled(false);
		
		split.setDividerSize(1);
		
		EditTableWindow.L_Area.setLayout(this.controlPanel);
		
		EditTableWindow.L_Area.add(edit);
		EditTableWindow.L_Area.add(delete);
		EditTableWindow.L_Area.add(add);
		
		EditTableWindow.L_Area.add(close);
		close.addActionListener(e -> this.dispose());	
	}
}
