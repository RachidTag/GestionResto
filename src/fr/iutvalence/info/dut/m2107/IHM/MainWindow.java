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
	
				/**
				 * General informations and settings of the window...
				 * 
				 */
		
		/**
		 * Set the title of the window
		 */
		this.setTitle("Gestion Resto");
		
		/**
		 * Set size of the window
		 */
		this.setSize(1200, 720);
		
		/**
		 * End window process when red-cross get clicked on
		 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * Set the window centered on the screen
		 */
		this.setLocationRelativeTo(null);
		
		
		
				/**
				 * Left Panel informations and settings...
				 * 
				 */
		
		/**
		 * Create left panel for left area of the splitpanel
		 */
		JPanel leftArea = new JPanel();
		
		/**
		 * Add label of project
		 * TODO: add image, and try/catch if not found, put label instead of image
		 */
		JLabel LOGO = new JLabel("GESTION RESTO'");
		
		/**
		 * Add logo label
		 */
		leftArea.add(LOGO);

		/**
		 * Create the gridlayout where are contained all buttons and control actions
		 */
		GridLayout controlGrid = new GridLayout(7,1);
		
		/**
		 * Create a horizontal and vertical gap of 5 pixels between panel and gridlayout
		 */
		controlGrid.setHgap(5);
		controlGrid.setVgap(5);
		
		/**
		 * Set gridlayout on the panel "leftArea"
		 */
		leftArea.setLayout(controlGrid);
		
		/**
		 * Add "Edition de table" button
		 * TODO: transform into menu
		 */
		leftArea.add(new JButton("Edition de table"));
		
		/**
		 * Add "Edition de secteur" menu
		 * TODO: transform into menu
		 */
		leftArea.add(new JButton("Edition de secteur"));
		
		/**
		 * Add "Consulter salle" button
		 */
		leftArea.add(new JButton("Consulter salle"));
		
		/**
		 * Add "Consulter emploi du temps" button
		 */
		leftArea.add(new JButton("Consulter emploi du temps"));
		
		/**
		 * Add "Mode chef de salle" button
		 */
		leftArea.add(new JButton("Mode chef de salle"));
		
		/**
		 * Add quit button
		 */
		leftArea.add(new JButton("Quitter"));
		
		

				/**
				 * Right Panel informations and settings...
				 * 
				 */

		/**
		 * Create right panel for right area of the splitpanel
		 */
		JPanel rightArea = new JPanel();
		
		/**
		 * Grid of right area that contains the 4 panels
		 */
		GridLayout leftGrid = new GridLayout(2,2);
		
		/**
		 * Create a horizontal and vertical gap of 20 pixels between panel and gridlayout
		 */
		leftGrid.setHgap(20);
		leftGrid.setVgap(20);
		
		
		
		
			/**
			 * Splitpane informations and settings...
			 * 
			 */
	
		/**
		 * Create the splitpane with vertical divider
		 */
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, leftArea, rightArea);
		
		/**
		 * Must be true for SplitPanes
		 */
		splitPane.setOneTouchExpandable(true);
		
		/**
		 * Add splitpane to basic Pane
		 */
		getContentPane().add(splitPane);
		
		/**
		 * Set divider location to 300px, 1/4 of the screen
		 */
		splitPane.setDividerLocation(300);
		
		/**
		 * Disable divider control
		 */
		splitPane.setEnabled(false);
		
		/**
		 * Set divider size to 1 px
		 */
		splitPane.setDividerSize(1);
		
		/**
		 * Set all components and window visibles on screen
		 */
		this.setVisible(true);
	}
	
}
