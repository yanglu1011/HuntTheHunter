package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import entity.Entity;

public class Crate extends Entity {

	public Crate(int x, int y, ID id) {
		super(x, y, id);

	}

	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y, 32, 32);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	@Override
	protected void changePos(int xAmt, int yAmt) {

	}

}
