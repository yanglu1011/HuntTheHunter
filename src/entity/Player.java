package entity;

import java.util.Vector;

/**
 * @author Yang Yang Lu, John Bui, Jordan Siaha, Jero
 */

public class Player extends Entity {

	protected Vector<Item> inventory = new Vector<>();
	
	@Override
	protected void changeHealth(int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void changePos(int xAmt, int yAmt) {
		// TODO Auto-generated method stub

	}

}
