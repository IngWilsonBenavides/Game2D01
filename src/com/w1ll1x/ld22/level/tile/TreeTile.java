package com.w1ll1x.ld22.level.tile;

import com.w1ll1x.ld22.entity.Entity;
import com.w1ll1x.ld22.entity.Mob;
import com.w1ll1x.ld22.entity.particle.TextParticle;
import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.level.Level;

public class TreeTile extends Tile {

	public TreeTile(int id) {
		super(id);
	}

	public void render(Screen screen, Level level, int x, int y) {
		int col = Color.get(10, 50, 252, level.grassColor);
		int barkCol1 = Color.get(10, 50, 430, level.grassColor);
		int barkCol2 = Color.get(10, 50, 320, level.grassColor);
		screen.render(x * 16 + 0, y * 16 + 0, 9 + 0 * 32, col, 0);
		screen.render(x * 16 + 8, y * 16 + 0, 10 + 0 * 32, col, 0);
		screen.render(x * 16 + 0, y * 16 + 8, 9 + 3 * 32, barkCol1, 0);
		screen.render(x * 16 + 8, y * 16 + 8, 10 + 3 * 32, barkCol2, 0);
	}

	public boolean mayPass(Level level, int x, int y, Entity e) {
		return false;
	}

	public void hurt(Level level, int x, int y, Mob source, int dmg, int attackDir) {
		int damage = level.getData(x, y) + dmg;
		level.add(new TextParticle("" + dmg, x * 16 + 8, y * 16 + 8, Color.get(-1, 500, 500, 500)));
		if (damage > 32) {
			level.setTile(x, y, Tile.grass, 0);
		} else {
			level.setData(x, y, damage);
		}
	}
}
