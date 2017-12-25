package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import entity.Entity;

public class KeyInput extends KeyAdapter{
	Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.e.size(); i++){
			Entity en = handler.e.get(i);
			
			if(en.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) handler.setUp(true);
				if(key == KeyEvent.VK_S) handler.setDown(true);
				if(key == KeyEvent.VK_A) handler.setLeft(true);
				if(key == KeyEvent.VK_D) handler.setRight(true);
				
			}
		}
	}
	
	public void KeyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.e.size(); i++){
			Entity en = handler.e.get(i);
			
			if(en.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) handler.setUp(false);
				if(key == KeyEvent.VK_S) handler.setDown(false);
				if(key == KeyEvent.VK_A) handler.setLeft(false);
				if(key == KeyEvent.VK_D) handler.setRight(false);
				
			}
		}
	}
}
