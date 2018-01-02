package entity;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Vector;

import game.Game;
import game.Handler;
import game.ID;

/**
 * @author Yang Yang Lu, John Bui, Jordan Siaha, Jero
 */

public class Player extends Entity {
	Handler handler;
	private Game game;
	public Player(int x, int y, ID id, Handler handler, Game game) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;

	}

	protected Vector<Item> inventory = new Vector<>();

	protected void changeHealth(int amount) {
		
	}

	protected void changePos(int xAmt, int yAmt) {
		// TODO Auto-generated method stub

	}

	public void tick() {
		collision();
		x += velX;
		y += velY;

		// Movement
		if (handler.isUp())
			velY = -5;
		else if (!handler.isDown())
			velY = 0;

		if (handler.isDown())
			velY = 5;
		else if (!handler.isUp())
			velY = 0;

		if (handler.isRight())
			velX = 5;
		else if (!handler.isLeft())
			velX = 0;

		if (handler.isLeft())
			velX = -5;
		else if (!handler.isRight())
			velX = 0;

	}

	private void collision() {
		for (int i = 0; i < handler.e.size(); i++) {
			Entity en = handler.e.get(i);

			if (en.getId() == ID.Block) {
				if (!placeFree((int) (x + velX), y, getBounds(), en.getBounds())) {
					velX = 0;
				}

				if (!placeFree(x, (int) (y + velY), getBounds(), en.getBounds())) {
					velY = 0;
				}
			}
			
			if (en.getId() == ID.Crate) {
				if (!placeFree((int) (x + velX), y, getBounds(), en.getBounds())) {
					game.ammo += 10;
					handler.removeEntity(en);
				}

				if (!placeFree(x, (int) (y + velY), getBounds(), en.getBounds())) {
					game.ammo += 10;
					handler.removeEntity(en);
				}
			}
		}
	}

	public boolean placeFree(int x, int y, Rectangle r, Rectangle r2) {
		r.x = x;
		r.y = y;
		if (r.intersects(r2)) {
			return false;
		}
		return true;
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
