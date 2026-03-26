package com.w1ll1x.ld22.item.resource;

import com.w1ll1x.ld22.entity.Player;
import com.w1ll1x.ld22.level.Level;
import com.w1ll1x.ld22.level.tile.Tile;

public class SandResource extends Resource {
	public SandResource(String name, int sprite, int color) {
		super(name, sprite, color);
	}

	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
		if (tile == Tile.dirt || tile == Tile.grass) {
			level.setTile(xt, yt, Tile.sand, 0);
			return true;
		}
		return false;
	}
}
