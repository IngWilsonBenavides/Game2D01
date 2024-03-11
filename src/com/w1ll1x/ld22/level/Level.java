package com.w1ll1x.ld22.level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.w1ll1x.ld22.entity.Entity;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.level.tile.Tile;

public class Level {
	public int w, h;

	public byte[] tiles;
	public byte[] data;
	public List<Entity>[] entitiesInTiles;

	public int grassColor = 141;

	public List<Entity> entities = new ArrayList<Entity>();
	private Comparator<Entity> spriteSorter = new Comparator<Entity>() {

		public int compare(Entity e0, Entity e1) {
			if (e1.y < e0.y)return +1; 
			if (e1.y > e0.y)return -1; 
			return 0;
		}
		
	};

	@SuppressWarnings("unchecked")
	public Level(int w, int h) {
		this.w = w;
		this.h = h;
		tiles = new byte[w * h];
		data = new byte[w * h];
		entitiesInTiles = new ArrayList[w * h];
		for (int i = 0; i < w * h; i++) {
			entitiesInTiles[i] = new ArrayList<Entity>();
		}

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
		int xo = xScroll >> 4;
		int yo = yScroll >> 4;
		int w = (screen.w + 15) >> 4;
		int h = (screen.h + 15) >> 4;
		screen.setOffset(xScroll, yScroll);
		for (int y = yo; y <= h + yo; y++) {
			for (int x = xo; x <= w + xo; x++) {
				if (x < 0 || y < 0 || x >= this.w || y >= this.h)
					continue;
				if (entities.size() > 0) {
					List<Entity> entities = entitiesInTiles[x + y * this.w];
					sortAndRender(screen, entities);
				}
			}
		}
		screen.setOffset(0, 0);
	}

	private void sortAndRender(Screen screen, List<Entity> list) {
		Collections.sort(list, spriteSorter);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).render(screen);
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= w || y >= h)
			return Tile.rock;
		return Tile.tiles[tiles[x + y * w]];
	}

	public void add(Entity entity) {
		entities.add(entity);
		entity.init(this);
		insertEntity(entity.x >> 4, entity.y >> 4, entity);
	}

	private void insertEntity(int x, int y, Entity e) {
		if (x < 0 || y < 0 || x >= w || y >= h)
			return;
		entitiesInTiles[x + y * w].add(e);
	}

	private void removeEntity(int x, int y, Entity e) {
		if (x < 0 || y < 0 || x >= w || y >= h)
			return;
		entitiesInTiles[x + y * w].remove(e);
	}

	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			int xto = e.x >> 4;
			int yto = e.y >> 4;
			e.tick();
			if (e.removed) {
				entities.remove(i--);
				removeEntity(xto, yto, e);
			} else {
				int xt = e.x >> 4;
				int yt = e.y >> 4;

				if (xto != xt || yto != yt) {
					removeEntity(xto, yto, e);
					insertEntity(xt, yt, e);
				}
			}
		}
	}
}