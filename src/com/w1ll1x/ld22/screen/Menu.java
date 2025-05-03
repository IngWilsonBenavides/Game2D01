package com.w1ll1x.ld22.screen;

import com.w1ll1x.ld22.Game;
import com.w1ll1x.ld22.InputHandler;
import com.w1ll1x.ld22.gfx.Screen;

public class Menu {
	protected Game game;
	protected InputHandler input;
	
	public void init(Game game, InputHandler input) {
		this.input = input;
		this.game = game;
	}

	public void tick() {
	}
	
	public void render(Screen screen) {
	}
}
