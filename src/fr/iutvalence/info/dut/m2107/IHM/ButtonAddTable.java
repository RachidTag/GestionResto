package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 * @author 
 *
 */
public class ButtonAddTable extends JButton implements MouseListener{
  private String name;

public ButtonAddTable(String str){
    super(str);
    this.name = str;
    this.addMouseListener(this);
  }
  
  public void mouseClicked(MouseEvent event) { 
	  //System.out.println(EditTableWindow.);
  }

  public void mouseEntered(MouseEvent event) { }

  public void mouseExited(MouseEvent event) { }

  public void mousePressed(MouseEvent event) { }

  public void mouseReleased(MouseEvent event) { }       
}