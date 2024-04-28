package com.w1ll1x.ld22.level.tile;

import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.level.Level;

public class FlowerTile extends GrassTile {
	
	public FlowerTile(int id) {
		super(id);
		tiles[id] = this;
	}
	
	public void render(Screen screen, Level level, int x, int y) {
		int flowerCol = Color.get(10, level.grassColor, 555, 550);
		int col = Color.get(level.grassColor, level.grassColor, level.grassColor + 111, level.grassColor + 111);
		screen.render(x * 16 + 0, y * 16 + 0, 1+1*32, flowerCol, 0);
		screen.render(x * 16 + 8, y * 16 + 0, 1, col, 0);
		screen.render(x * 16 + 0, y * 16 + 8, 2, col, 0);
		screen.render(x * 16 + 8, y * 16 + 8, 1+1*32, flowerCol, 0);
	}

}