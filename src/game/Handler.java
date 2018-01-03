package game;

import java.awt.Graphics;
import java.util.ArrayList;

import entity.Entity;

/**
 * @author Yang Yang Lu, John Bui, Jordan Siaha, Jero
 */
public class Handler {
	public ArrayList<Entity> e = new ArrayList<Entity>();
	private boolean up = false, down = false, right = false, left = false, space = false;
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}
	
//	public boolean isSpace() {
//		return space;
//	}
//	
//	public void setSpace(boolean space) {
//		this.space = space;
//	}

	public void tick() {
		for (int i = 0; i < e.size(); i++) {
			Entity en = e.get(i);

			en.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < e.size(); i++) {
			Entity en = e.get(i);

			en.render(g);
		}
	}
	
	public void addEntity(Entity en) {
		e.add(en);
	}
	
	public void removeEntity(Entity en) {
		e.remove(en);
	}

	
}
