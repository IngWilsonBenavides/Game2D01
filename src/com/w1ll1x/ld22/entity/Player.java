package com.w1ll1x.ld22.entity;

import com.w1ll1x.ld22.InputHandler;
import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.gfx.Screen;

public class Player extends Mob {

	private InputHandler input;
	
	public Player(InputHandler input) {
		this.input = input;
	}

	public void tick() {
		int xa = 0;
		int ya = 0;

		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;
		move(xa, ya);
	}

	public void render(Screen screen) {
		int xt = 0;
		int yt = 14;

		int flip1 = (walkDist >> 3) & 1;
		int flip2 = (walkDist >> 3) & 1;

		if (dir == 1) {
			xt += 2;
		}
		if (dir > 1) {
			flip1 = 0;
			flip2 = (walkDist >> 5) & 1;
			if (dir == 2) {
				flip1 = 1;
			}
			xt = 4 + ((walkDist >> 3) & 1) * 2;
		}

		int xo = x - 8;
		int yo = y - 12;

		screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, Color.get(-1, 100, 220, 532), flip1);
		screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, Color.get(-1, 100, 220, 532), flip1);
		screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, Color.get(-1, 100, 220, 532), flip2);
		screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, Color.get(-1, 100, 220, 532), flip2);
	}

}