package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import game.Handler;
import game.ID;

public class Enemy extends Entity {

	private Handler handler;
	Random r = new Random();
	int choose = 0;
	int hp = 100;

	public Enemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		choose = r.nextInt(10);

		for (int i = 0; i < handler.e.size(); i++) {
			Entity en = handler.e.get(i);

			// If colliding with a box
			if (en.getId() == ID.Block) {
				if (getBoundsBig().intersects(en.getBounds())) {
					x += (velX * 5 * -1);
					y += (velY * 5 * -1);
					velX *= -1;
					velY *= -1;
				} else if (choose == 0) {
					// Random number between (-4, 4)
					velX = (r.nextInt(4 - -4) + -4);
					velY = (r.nextInt(4 - -4) + -4);
				}
			}
			if (en.getId() == ID.Bullet) {
				if (getBounds().intersects(en.getBounds())) {
					hp -= 50;
					handler.removeEntity(en);
				}
			}
		}
		
		if(hp <= 0) {
			handler.removeEntity(this);
		}

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, 32, 32);

		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.green);
		g2.draw(getBoundsBig());

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	// More space between the enemy and the block.
	public Rectangle getBoundsBig() {
		return new Rectangle(x - 16, y - 16, 64, 64);
	}

	@Override
	protected void changePos(int xAmt, int yAmt) {
		// TODO Auto-generated method stub

	}

}
