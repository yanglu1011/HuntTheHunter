package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import entity.Entity;

public class Bullet extends Entity {

	private Handler handler;

	public Bullet(int x, int y, ID id, Handler handler, int mx, int my) {
		super(x, y, id);
		this.handler = handler;
		
		velX = (mx - x) / 10;
		velY = (my - y) / 10;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		// Bullet collision
		for(int i = 0; i < handler.e.size(); i++) {
			Entity en = handler.e.get(i);
			if(en.getId() == ID.Block) {
				if(getBounds().intersects(en.getBounds())){
					handler.removeEntity(this);
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x, y, 8, 8);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

	@Override
	protected void changePos(int xAmt, int yAmt) {

	}

}
