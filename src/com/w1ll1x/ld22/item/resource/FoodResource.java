package com.w1ll1x.ld22.item.resource;

import com.w1ll1x.ld22.entity.Player;
import com.w1ll1x.ld22.level.Level;
import com.w1ll1x.ld22.level.tile.Tile;

public class FoodResource extends Resource {
	private int heal;

	public FoodResource(String name, int sprite, int color, int heal) {
		super(name, sprite, color);
		this.heal = heal;
	}

	@Override
	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
		if (player.health < player.maxHealth) {
			player.heal(heal);
			return true;
		}
		return false;
	}

}
