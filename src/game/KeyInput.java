package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import entity.Entity;

public class KeyInput extends KeyAdapter {
	Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.e.size(); i++) {
			Entity en = handler.e.get(i);

			if (en.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) {
					handler.setUp(true);
					handler.setDown(false);
					handler.setLeft(false);
					handler.setRight(false);
				}
				if (key == KeyEvent.VK_S) {
					handler.setDown(true);
					handler.setUp(false);
					handler.setLeft(false);
					handler.setRight(false);
				}
				if (key == KeyEvent.VK_A) {
					handler.setLeft(true);
					handler.setDown(false);
					handler.setUp(false);
					handler.setRight(false);
				}
				if (key == KeyEvent.VK_D) {
					handler.setRight(true);
					handler.setDown(false);
					handler.setLeft(false);
					handler.setUp(false);
				}

				if (key == KeyEvent.VK_SPACE) {
					if (handler.isUp()) {
						handler.addEntity(new Melee(en.getX(), en.getY() - 48, ID.Melee, handler));
					} else if (handler.isDown()) {
						handler.addEntity(new Melee(en.getX(), en.getY() + 48, ID.Melee, handler));
					} else if (handler.isLeft()) {
						handler.addEntity(new Melee(en.getX() - 32, en.getY(), ID.Melee, handler));
					} else if (handler.isRight()) {
						handler.addEntity(new Melee(en.getX() + 32, en.getY(), ID.Melee, handler));
					}
				}

			}
		}
	}

}
