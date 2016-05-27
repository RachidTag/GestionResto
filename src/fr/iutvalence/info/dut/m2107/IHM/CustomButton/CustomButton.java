package fr.iutvalence.info.dut.m2107.IHM.CustomButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomButton extends JButton implements MouseListener {
	private ImageIcon buttonBg;
	
		 
	public CustomButton(String name, Dimension dimension){
		Font customFont = null;
		try {
		    //create the font to use. Specify the size!
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("KeepCalm.ttf")).deriveFont(12f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("KeepCalm.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		buttonBg = new ImageIcon(getClass().getResource("ButtonBackground.png"));
		this.setIcon(buttonBg);
		
		JLabel jLabelName = new JLabel(name, JLabel.CENTER);
		jLabelName.setFont(customFont);
		jLabelName.setForeground(Color.BLACK);
		
		this.add(jLabelName);

		
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.addMouseListener(this);
		this.setPreferredSize(dimension);
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
		
		CustomButton bouton = new CustomButton("Edit Table", new Dimension(90,150));
		CustomButton bouton2 = new CustomButton("Edit TRUC", new Dimension(200,70));
		CustomButton bouton3 = new CustomButton("GOD MOD", new Dimension(20,80));
		
		pan.add(bouton);
		pan.add(bouton2);
		pan.add(bouton3);
		
		
		window.setContentPane(pan);
		window.setVisible(true);
		

	}
	
	public static BufferedImage load9Patch(String path, int reqWidth, int reqHeight)
    {
        int x1=0,x2,y1=0,y2,w,h;
        BufferedImage sourceImage=null;
        BufferedImage img[][];
        img = new BufferedImage[3][3];
         
        try {
            sourceImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } 
         
         
        w=sourceImage.getWidth();
        h=sourceImage.getHeight();
        x2=w-1;
        y2=h-1;
         
        while((((sourceImage.getRGB(x1, 0)) >>24) & 0xff) == 0 && x1<x2)//on cherche le 1er pixel non transparent
        {
            x1++;
        }
         
        if(x1!=x2)
        {
            while((((sourceImage.getRGB(x2, 0)) >>24) & 0xff) == 0)
            {
                x2--;
            }
        }
         
        while((((sourceImage.getRGB(0, y1)) >>24) & 0xff) == 0 && y1<y2)
        {
            y1++;
        }
         
        if(y1!=y2)
        {
            while((((sourceImage.getRGB(0, y2)) >>24) & 0xff) == 0)
            {
                y2--;
            }
        }
         
        if(x1==x2 && y1==y2)return sourceImage;//aucune ligne trouvée
         
        img[0][0]=sourceImage.getSubimage(1, 1, x1, y1);
        img[1][0]=sourceImage.getSubimage(1+x1, 1, x2-x1-1, y1);  
        img[2][0]=sourceImage.getSubimage(1+x2, 1, w-x2-1, y1);
        img[0][1]=sourceImage.getSubimage(1, 1+y1, x1, y2-y1);  
        img[1][1]=sourceImage.getSubimage(1+x1, 1+y1, x2-x1-1, y2-y1);  
        img[2][1]=sourceImage.getSubimage(1+x2, 1+y1, w-x2-1, y2-y1);
        img[0][2]=sourceImage.getSubimage(1, 1+y2, x1, h-y2-1);
        img[1][2]=sourceImage.getSubimage(1+x1, 1+y2, x2-x1-1, h-y2-1);
        img[2][2]=sourceImage.getSubimage(1+x2, 1+y2, w-x2-1, h-y2-1);
         
        int verW = reqWidth - img[0][0].getWidth() - img[2][0].getWidth() +1;
        int horH = reqHeight - img[0][0].getHeight() - img[0][2].getHeight();
         
        // Create new (blank) image of required (scaled) size
 
        BufferedImage scaledImage = new BufferedImage(reqWidth, reqHeight, BufferedImage.TYPE_INT_ARGB);
 
        // Paint scaled version of image to new image
        Graphics2D graphics2D = scaledImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         
        graphics2D.drawImage(img[0][0], 0, 0, img[0][0].getWidth(), img[0][0].getHeight(), null);
        graphics2D.drawImage(img[1][0], img[0][0].getWidth(), 0, verW, img[0][0].getHeight(), null);
        graphics2D.drawImage(img[2][0], img[0][0].getWidth()+verW, 0, img[0][2].getWidth(), img[0][0].getHeight(), null);
         
        graphics2D.drawImage(img[0][1], 0, img[0][0].getHeight(), img[0][0].getWidth(), horH, null);
        graphics2D.drawImage(img[1][1], img[0][0].getWidth(), img[0][0].getHeight(), verW, horH, null);
        graphics2D.drawImage(img[2][1], img[0][0].getWidth()+verW, img[0][0].getHeight(), img[0][2].getWidth(), horH, null);
         
        graphics2D.drawImage(img[0][2], 0, img[0][0].getHeight()+horH, img[0][0].getWidth(), img[2][0].getHeight(), null);
        graphics2D.drawImage(img[1][2], img[0][0].getWidth(), img[0][0].getHeight()+horH, verW, img[2][0].getHeight(), null);
        graphics2D.drawImage(img[2][2], img[0][0].getWidth()+verW, img[0][0].getHeight()+horH, img[0][2].getWidth(), img[2][0].getHeight(), null);
 
        // clean up
        graphics2D.dispose();
         
        return scaledImage;
    }
	
	@Override
	public void setPreferredSize(Dimension dimension) {
		super.setPreferredSize(dimension);
		this.buttonBg = new ImageIcon(load9Patch("ButtonBackground.png", (int)dimension.getWidth(), (int)dimension.getHeight()));
		this.setIcon(this.buttonBg);
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
