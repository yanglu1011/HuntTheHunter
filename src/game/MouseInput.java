package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entity.Entity;


public class MouseInput extends MouseAdapter{
	
	private Handler handler;
	private Camera camera;
	
	private Game game;
	
	public MouseInput(Handler handler, Camera camera, Game game) {
		this.handler = handler;
		this.camera = camera;
		this.game = game;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = (int) (e.getX() + camera.getX());
		int my = (int) (e.getY() + camera.getY());
		
		for (int i = 0; i < handler.e.size(); i++) {
			Entity en = handler.e.get(i);
			if (en.getId() == ID.Player && game.ammo >= 1) {
				handler.addEntity(new Bullet(en.getX() + 16, en.getY() + 24, ID.Bullet, handler, mx, my));
				game.ammo--;
			}
		}
	}
}
