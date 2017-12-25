package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import entity.Entity;

public class Block extends Entity {

	public Block(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	protected void changePos(int xAmt, int yAmt) {

	}

}
