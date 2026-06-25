package com.w1ll1x.ld22.entity;

import com.w1ll1x.ld22.crafting.Crafting;
import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.screen.CraftingMenu;

public class Oven extends Furniture {

	public Oven(int x, int y) {
		super("Oven", x, y);
		col = Color.get(-1, 000, 333, 442);
		sprite = 2;
		xr = 3;
		yr = 2;
	}

	public boolean use(Player player, int attackDir) {
		player.game.setMenu(new CraftingMenu(Crafting.ovenRecipes, player));
		return true;
	}
}