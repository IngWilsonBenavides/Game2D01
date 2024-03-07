package com.w1ll1x.ld22.level.tile;

import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.level.Level;

public class Tile {
	public static Tile[] tiles = new Tile[256];
	public static Tile grass = new GrassTile(0);
	
	public final byte id;
	
	public Tile(int id) {
		this.id = (byte)id;
		tiles[id] = this;
	}

	public void render(Screen screen, Level level, int x, int y) {
	}
}