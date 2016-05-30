package fr.iutvalence.info.dut.m2107.IHM.CustomButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Represents the customized buttons
 * @author Projet Resto
 */
@SuppressWarnings("serial")
public class CustomButton extends JButton implements MouseListener {
	/**
	 * The button's background
	 */
	private ImageIcon buttonBg;
		 
	/**
	 * Generates the custom button with the given dimension
	 * @param name
	 * @param dimension
	 */
	public CustomButton(String name, Dimension dimension){
		
		/*
		 * Load the font
		 */
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
		
		/*
		 * Set the button's background
		 */
		this.buttonBg = new ImageIcon("/img/ButtonBackground.png");
		this.setIcon(this.buttonBg);
		
		/*
		 * Set the label with the good font
		 */
		JLabel jLabelName = new JLabel(name, JLabel.CENTER);
		jLabelName.setFont(customFont);
		jLabelName.setForeground(Color.BLACK);
		this.add(jLabelName);
		
		/*
		 * Customize the button
		 */
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.addMouseListener(this);
		this.setPreferredSize(dimension);
	}
	
	/**
	 * Resizes the image
	 * @param path
	 * @param reqWidth
	 * @param reqHeight
	 * @return scaledImage (BufferedImage)
	 */
	public static BufferedImage load9Patch(String path, int reqWidth, int reqHeight)
    {
        int x1=0,x2,y1=0,y2,w,h;
        BufferedImage sourceImage=null;
        BufferedImage img[][];
        img = new BufferedImage[3][3];

        try {
            sourceImage = ImageIO.read(new File("img/"+path));
        } catch (IOException e) {
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
	
    /**
     * @see javax.swing.JComponent#setPreferredSize(java.awt.Dimension)
     */
	public void setPreferredSize(Dimension dimension) {
		super.setPreferredSize(dimension);
		this.buttonBg = new ImageIcon(load9Patch("ButtonBackground.png", (int)dimension.getWidth(), (int)dimension.getHeight()));
		this.setIcon(this.buttonBg);
	}

    /**
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent arg0) {
			
	}

    /**
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@SuppressWarnings("deprecation")
	public void mouseEntered(MouseEvent arg0) {
		ImageIcon bgImage = new ImageIcon(load9Patch("ButtonBackgroundReleased.png", (int)this.size().getWidth(), (int)this.size().getHeight()));
		this.setIcon(bgImage);
		
	}

    /**
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@SuppressWarnings("deprecation")
	public void mouseExited(MouseEvent arg0) {
		ImageIcon bgImage = new ImageIcon(load9Patch("ButtonBackground.png", (int)this.size().getWidth(), (int)this.size().getHeight()));
		this.setIcon(bgImage);
		
	}

    /**
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@SuppressWarnings("deprecation")
	public void mousePressed(MouseEvent arg0) {
		ImageIcon bgImage = new ImageIcon(load9Patch("ButtonBackgroundPressed.png", (int)this.size().getWidth(), (int)this.size().getHeight()));
		this.setIcon(bgImage);
		
	}

    /**
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@SuppressWarnings("deprecation")
	public void mouseReleased(MouseEvent arg0) {
		ImageIcon bgImage = new ImageIcon(load9Patch("ButtonBackgroundReleased.png", (int)this.size().getWidth(), (int)this.size().getHeight()));
		this.setIcon(bgImage);
		
	}

}
