package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import entity.Enemy;
import entity.Player;

/**
 * @author Yang Yang Lu, John Bui, Jordan Siaha, Jero
 */
public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private boolean isRunning = false;
	private Thread thread;
	private Handler handler;

	private BufferedImage level = null;

	private Camera camera;

	public Game() {
		new Window(1000, 563, "Hunt the Hunter", this);
		start();

		handler = new Handler();
		camera = new Camera(0, 0);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput(handler, camera));

		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/Level1.png");

		loadLevel(level);

	}

	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	private void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
				updates++;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.printf("FPS: %d. TICKS: %d%n", frames, updates);
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}

	public void tick() {

		for (int i = 0; i < handler.e.size(); i++) {
			if (handler.e.get(i).getId() == ID.Player) {
				camera.tick(handler.e.get(i));
			}
		}
		handler.tick();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2 = (Graphics2D) g;
		
		g.setColor(Color.red);
		g.fillRect(0, 0, 1000, 563);

		//////////////////////////////////////
		// ----Draw things for game here-----//
		
		g2.translate(-camera.getX(), -camera.getY());
		// Background
		
		// All other objects
		handler.render(g);
		g2.translate(camera.getX(), camera.getY());
		//////////////////////////////////////
		g.dispose();
		bs.show();
	}

	// Loading the level
	private void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		System.out.println("WIDTH: " + w);
		System.out.println("HEIGHT: " + h);

		for (int xx = 0; xx < w; xx++) {
			for (int yy = 0; yy < h; yy++) {
				int pixel = image.getRGB(xx, yy);
				int alpha = (pixel >> 24) & 0xff;
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				// System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " +
				// blue);

				if (red == 237) {
					handler.addEntity(new Block(xx * 32, yy * 32, ID.Block));
				}

				if (blue == 232) {
					handler.addEntity(new Player(xx * 32, yy * 32, ID.Player, handler));
				}
				
				if(green == 255) {
					handler.addEntity(new Enemy(xx * 32, yy * 32, ID.Enemy, handler));
				}
			}
		}
	}

	public static void main(String args[]) {
		new Game();
	}
}
