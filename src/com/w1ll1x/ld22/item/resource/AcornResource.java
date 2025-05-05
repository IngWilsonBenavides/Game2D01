package com.w1ll1x.ld22.item.resource;

import com.w1ll1x.ld22.entity.Player;
import com.w1ll1x.ld22.level.Level;
import com.w1ll1x.ld22.level.tile.Tile;

public class AcornResource extends Resource {
	public AcornResource(String name, int sprite, int color) {
		super(name, sprite, color);
	}
	
	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
		if (tile == Tile.grass) {
			level.setTile(xt, yt, Tile.tree, 0);
			return true;
		}
		return false;
	}
}
