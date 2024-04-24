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
		screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
		screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
		screen.render(x * 16 + 8, y * 16 + 0, 0, col, 0);
		screen.render(x * 16 + 0, y * 16 + 8, 0, col, 0);
		screen.render(x * 16 + 8, y * 16 + 8, 0, col, 0);
	}
	
	public boolean mayPass(Level level, int x, int y, Entity e) {
		return false;
	}
}
