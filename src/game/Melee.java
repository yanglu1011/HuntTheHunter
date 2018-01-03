package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import entity.Entity;

public class Melee extends Entity {

	private Handler handler;
	private int timeout = 60; // in frames
	private int timeCount = 0;

	public Melee(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		if (timeCount >= timeout) {
			timeCount = 0;
			handler.removeEntity(this);
		}
		timeCount++;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 40, 40);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 40, 40);
	}

	@Override
	protected void changePos(int xAmt, int yAmt) {

	}

}
