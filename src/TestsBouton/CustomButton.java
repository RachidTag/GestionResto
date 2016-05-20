package TestsBouton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomButton extends JButton implements MouseListener {
	private JLabel name;
	private Image buttonBg;
	 
	public CustomButton(String name){
		ImageIcon bgImage = new ImageIcon(getClass().getResource("ButtonBackground.png"));
		this.setIcon(bgImage);
		
		
		
		this.add(this.name);
		name.setName("name"); /* jsais plus comment on met un name a un label) */
		
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.addMouseListener(this);
		this.setPreferredSize(new Dimension(190, 70));
	}
	
	
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setTitle("Test des boutons");
		window.setSize(1200, 720);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setSize(1200, 720);
		
		JPanel pan = new JPanel();
		pan.setBackground(Color.WHITE);
		
		/*
		 * Création du bouton, application d'une taille par défault pour ce bouton
		 */
		
		CustomButton bouton = new CustomButton("bouton");
		pan.add(bouton);
		
		
		window.setContentPane(pan);
		window.setVisible(true);
		

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
			
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		ImageIcon bgImage = new ImageIcon(getClass().getResource("ButtonBackgroundReleased.png"));
		this.setIcon(bgImage);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		ImageIcon bgImage = new ImageIcon(getClass().getResource("ButtonBackground.png"));
		this.setIcon(bgImage);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		ImageIcon bgImage = new ImageIcon(getClass().getResource("ButtonBackgroundPressed.png"));
		this.setIcon(bgImage);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		ImageIcon bgImage = new ImageIcon(getClass().getResource("ButtonBackgroundReleased.png"));
		this.setIcon(bgImage);
		
	}

}
