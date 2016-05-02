package fr.iutvalence.info.dut.m2107.IHM;
import javax.swing.*;
import java.awt.GridLayout;

/**
 * TODO
 * @author Projet Resto
 *
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	/**
	 * TODO
	 */
	public MainWindow()
	{
		this.setTitle("Gestion Resto");
		this.setSize(1200, 720);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JPanel rightArea = new JPanel();
		JPanel leftArea = new JPanel();
		
		JLabel j1 = new JLabel("Right Area");
		
		JLabel j2 = new JLabel("Left Area");
		JButton b1 = new JButton("B1");
		
		GridLayout controlGrid = new GridLayout(6,1,5,5);
		
		this.setLayout(controlGrid);	
		
		this.getContentPane().add(new JButton("Edition de table"));
		this.getContentPane().add(new JButton("Edition de secteur"));
		this.getContentPane().add(new JButton("Consulter salle"));
		this.getContentPane().add(new JButton("Consulter emploi du temps"));
		this.getContentPane().add(new JButton("Mode chef de salle"));
		this.getContentPane().add(new JButton("Quitter"));

		
		// TODO: ajouter le layout (grid) dans la splitpane droite 
		
		rightArea.add(j1);
		leftArea.add(j2);
		rightArea.add(b1);
		/*rightArea.add(controlGrid);*/
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, rightArea, leftArea);
		
		splitPane.setOneTouchExpandable(true);
		getContentPane().add(splitPane);
		
		
		splitPane.setDividerLocation(300);
		this.setVisible(true);
	}
	
}
