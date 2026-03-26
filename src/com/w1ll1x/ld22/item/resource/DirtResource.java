package com.w1ll1x.ld22.item.resource;

import com.w1ll1x.ld22.entity.Player;
import com.w1ll1x.ld22.level.Level;
import com.w1ll1x.ld22.level.tile.Tile;

public class DirtResource extends Resource {
	public DirtResource(String name, int sprite, int color) {
		super(name, sprite, color);
	}

	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
		if (tile == Tile.hole || tile == Tile.water) {
			level.setTile(xt, yt, Tile.dirt, 0);
			return true;
		}
		return false;
	}
}
