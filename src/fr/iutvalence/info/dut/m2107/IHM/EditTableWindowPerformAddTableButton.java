package fr.iutvalence.info.dut.m2107.IHM;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;

import fr.iutvalence.info.dut.m2107.room.ClientNameRequiredException;
import fr.iutvalence.info.dut.m2107.room.ObjectReadedIsNotARoomException;
import fr.iutvalence.info.dut.m2107.room.Position;
import fr.iutvalence.info.dut.m2107.room.Progress;
import fr.iutvalence.info.dut.m2107.room.Room;
import fr.iutvalence.info.dut.m2107.room.SectorNotExistsException;
import fr.iutvalence.info.dut.m2107.room.State;
import fr.iutvalence.info.dut.m2107.room.Table;
import fr.iutvalence.info.dut.m2107.room.TableAlreadyExistsException;

/**
 * @author 
 *
 */
public class EditTableWindowPerformAddTableButton extends JButton implements MouseListener{
  private String name;

public EditTableWindowPerformAddTableButton(String str){
    super(str);
    this.name = str;
    this.addMouseListener(this);
  }
  
  public void mouseClicked(MouseEvent event) { 
	  int tableNum = (int) EditTableWindow.tableNum.getValue();
	  int numOfPlaces = (int) EditTableWindow.numOfPlaces.getValue();
	  int posX = (int) EditTableWindow.posX.getValue();
	  int posY = (int) EditTableWindow.posY.getValue();
	  int rotation = (int) EditTableWindow.rotation.getValue();
	  int sectorNum = (int) EditTableWindow.sectorNum.getSelectedItem();
	  Table theTable = null;
	  try {
		theTable = new Table(tableNum, numOfPlaces, new Position(posX, posY, rotation), Progress.NO_PROGRESS, State.FREE);
	  } catch (ClientNameRequiredException e) {
			// ...
	  }
	  Room theRoom = null;
	  try {
		theRoom = Room.loadRoom();
	  } catch (ClassNotFoundException | IOException | ObjectReadedIsNotARoomException e) {
		e.printStackTrace();
	  }
	  try {
		theRoom.getSector(sectorNum).addTable(theTable);
		theRoom.saveRoom();
	} catch (TableAlreadyExistsException | SectorNotExistsException e) {
		// TODO 
	}
  }

  public void mouseEntered(MouseEvent event) { }

  public void mouseExited(MouseEvent event) { }

  public void mousePressed(MouseEvent event) { }

  public void mouseReleased(MouseEvent event) { }       
}