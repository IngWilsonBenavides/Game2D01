package com.w1ll1x.ld22.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.w1ll1x.ld22.entity.Entity;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.level.tile.Tile;

public class Level {
	public int w, h;

	public byte[] tiles;
	public byte[] data;

	public int grassColor = 141;

	public List<Entity> entities = new ArrayList<Entity>();

	public Level(int w, int h) {
		this.w = w;
		this.h = h;
		tiles = new byte[w * h];
		data = new byte[w * h];

		Random random = new Random();

		for (int i = 0; i < w * h; i++) {
			tiles[i] = Tile.grass.id;
			if (random.nextInt(20) == 0) {
				tiles[i] = Tile.rock.id;
			}
		}
	}

	public void renderBackground(Screen screen, int xScroll, int yScroll) {
		int xo = xScroll >> 4;
		int yo = yScroll >> 4;
		int w = (screen.w + 15) >> 4;
		int h = (screen.h + 15) >> 4;
		screen.setOffset(xScroll, yScroll);
		for (int y = yo; y <= h + yo; y++) {
			for (int x = xo; x <= w + xo; x++) {
				getTile(x, y).render(screen, this, x, y);
			}
		}
		screen.setOffset(0, 0);
	}
	
	public void renderSprites(Screen screen, int xScroll, int yScroll) {
		screen.setOffset(xScroll, yScroll);
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		screen.setOffset(0, 0);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= w || y >= h)
			return Tile.grass;
		return Tile.tiles[tiles[x + y * w]];
	}

	public void add(Entity entity) {
		entities.add(entity);
		entity.init(this);
	}

	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
		
	}
}