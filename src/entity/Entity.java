package entity;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import game.ID;

/**
 * @author Yang Yang Lu, John Bui, Jordan Siaha, Jero
 */

public abstract class Entity {

	protected int x, y;
	protected float velX = 0, velY = 0;
	protected ID id;

	public Entity(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	// Every object needs to update
	public abstract void tick();

	// Every object needs to draw something/appear to be something.
	public abstract void render(Graphics g);
	
	// Gonna be helpful for collision purposes. Helps define hitbox.
	public abstract Rectangle getBounds();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	// change position of x amount and y amount
	protected abstract void changePos(int xAmt, int yAmt);

}
