package com.w1ll1x.ld22;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 240;
	public static final int WIDTH = HEIGHT * 16 / 9;
	private boolean running = false;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	public void start() {
		new Thread(this).start();
	}

	public void stop() {
		running = false;
	}

	public void run() {
		while (running) {
			runStep();
		}
	}

	private void runStep() {
		tick();
		render();
	}

	public void tick() {

	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		System.out.println("hello world");
	}
	 

}