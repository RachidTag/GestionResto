package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainWindowDisplayTable extends JPanel{
	
	 public void paintComponent(Graphics g){
		    try {
		      Image img = ImageIO.read(new File("tableVerteProjet.jpg"));
		      g.drawImage(img, 0, 0, this);
		      
		    } 
		    catch (IOException e) {
		      e.printStackTrace();
		    }                
		  }

}
