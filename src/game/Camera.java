package game;

import entity.Entity;

public class Camera {
	private float x, y;

	public Camera(float x, float y) {
		this.x = x;
		this.y = y;

	}
	
	public void tick(Entity en) {
		
		x += ((en.getX() - x) - 1000/2) * 0.05f;
		y += ((en.getY() - y) - 563/2) * 0.05f;
		
		if(x <= 0) {
			x = 0;
		}
		if(x >= 1032) {
			x = 1032;
		}
		if(y >= 563 + 48) {
			y = 563 + 48;
		}
		if(y <= 0) {
			y = 0;
		}
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
