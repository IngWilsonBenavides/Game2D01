package com.w1ll1x.ld22.level.tile;

import com.w1ll1x.ld22.entity.Entity;
import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.level.Level;

public class WaterTile extends Tile {

	public WaterTile(int id) {
		super(id);
	}

	public void render(Screen screen, Level level, int x, int y) {
		int col = Color.get(4, 4, 335, 335);
		int transitionColor = Color.get(100, 4, 211, level.grassColor);

		boolean u = level.getTile(x, y - 1) != this;
		boolean d = level.getTile(x, y + 1) != this;
		boolean l = level.getTile(x - 1, y) != this;
		boolean r = level.getTile(x + 1, y) != this;

		if (!u && !l) {
			screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
		} else {
			screen.render(x * 16 + 0, y * 16 + 0, (l ? 4 : 5) + (1 - (u ? 0 : 1)) * 32, transitionColor, 0);
		}
		if (!u && !r) {
			screen.render(x * 16 + 8, y * 16 + 0, 0, col, 0);
		} else {
			screen.render(x * 16 + 0, y * 16 + 0, (r ? 6 : 5) + (1 - (u ? 0 : 1)) * 32, transitionColor, 0);
		}
		if (!d && !l) {
			screen.render(x * 16 + 0, y * 16 + 8, 0, col, 0);
		}
		if (!d && !r) {
			screen.render(x * 16 + 8, y * 16 + 8, 0, col, 0);
		}
	}

	public boolean mayPass(Level level, int x, int y, Entity e) {
		return false;
	}
}
