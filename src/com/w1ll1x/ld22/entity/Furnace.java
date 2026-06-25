package com.w1ll1x.ld22.entity;

import com.w1ll1x.ld22.crafting.Crafting;
import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.screen.CraftingMenu;

public class Furnace extends Furniture {

	public Furnace(int x, int y) {
		super("Furnace", x, y);
		col = Color.get(-1, 000, 222, 333);
		sprite = 3;
		xr = 3;
		yr = 2;
	}

	public boolean use(Player player, int attackDir) {
		player.game.setMenu(new CraftingMenu(Crafting.furnaceRecipes, player));
		return true;
	}
}