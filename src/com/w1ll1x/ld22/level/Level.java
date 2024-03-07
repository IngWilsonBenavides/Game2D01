package com.w1ll1x.ld22.level;

import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.level.tile.Tile;

public class Level {
	public int w, h;

	public byte[] tiles;
	public byte[] data;

	public int grassColor = 141;

	public Level(int w, int h) {
		this.w = w;
		this.h = h;
		tiles = new byte[w * h];
		data = new byte[w * h];

		for (int i = 0; i < w * h; i++) {
			tiles[i] = Tile.grass.id;
		}
	}

	public void render(Screen screen, int xScroll, int yScroll) {
		int xo = xScroll >> 4;
		int yo = yScroll >> 4;
		int w = (screen.w + 15) >> 4;
		int h = (screen.h + 15) >> 4;
		screen.setOffset(xScroll, yScroll);
		for (int y = yo; y + yo < h; y++) {
			for (int x = xo; x + xo < w; x++) {
				getTile(x, y).render(screen, this, x, y);
			}
		}
		screen.setOffset(0, 0);
	}

	private Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= w || y>= h) return Tile.grass;
		return Tile.tiles[tiles[x + y * w]];
	}
}