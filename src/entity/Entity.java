package entity;

import java.awt.Image;
import java.awt.Point;

/**
 * @author Yang Yang Lu, John Bui, Jordan Siaha, Jero
 */

public abstract class Entity {
	private int health;
	// remembered position of entity on map
	private Point pos;
	// unique id of entity
	private int id;
	private String name;
	// sprite of the entity?
	private Image img;
	// rank used as render order
	private int rank;
	
	// change health base off amount
	protected abstract void changeHealth(int amount);
	
	// change position of x amount and y amount
	protected abstract void changePos(int xAmt, int yAmt);
}
