package com.w1ll1x.ld22.gfx;

import java.applet.Applet;
import java.awt.BorderLayout;

import com.w1ll1x.ld22.Game;

public class GameApplet extends Applet {
	private static final long serialVersionUID = 1L;

	private Game game = new Game();

	public void init() {
		setLayout(new BorderLayout());
		add(game, BorderLayout.CENTER);
	}

	public void start() {
		game.start();
	}

	public void stop() {
		game.stop();
	}
}