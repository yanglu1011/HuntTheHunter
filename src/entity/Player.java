package entity;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Vector;

import game.Handler;
import game.ID;

/**
 * @author Yang Yang Lu, John Bui, Jordan Siaha, Jero
 */

public class Player extends Entity {
	Handler handler;
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}

	protected Vector<Item> inventory = new Vector<>();
	
	protected void changeHealth(int amount) {
		// TODO Auto-generated method stub

	}

	protected void changePos(int xAmt, int yAmt) {
		// TODO Auto-generated method stub

	}

	public void tick() {
		x += velX;
		y += velY;
		
		// Movement
		if(handler.isUp()) velY = -5;
		else if(!handler.isDown()) velY = 0;
		
		if(handler.isDown()) velY = 5;
		else if(!handler.isUp()) velY = 0;
		
		if(handler.isRight()) velX = 5;
		else if(!handler.isLeft()) velX = 0;
		
		if(handler.isLeft()) velX = -5;
		else if(!handler.isRight()) velX = 0;
		
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 48);
		
	}

	public Rectangle getBounds() {
		// Bounding box, used for collision
		return new Rectangle(x, y, 32, 48);
	}

}
