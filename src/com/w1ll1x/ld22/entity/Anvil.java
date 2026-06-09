package com.w1ll1x.ld22.entity;

import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.screen.CraftingMenu;

public class Anvil extends Furniture {

	public Anvil(int x, int y) {
		super("Anvil", x, y);
		col = Color.get(-1, 000, 111, 222);
		sprite = 0;
		xr = 3;
		yr = 2;
	}

	public boolean use(Player player, int attackDir) {
		player.game.setMenu(new CraftingMenu(this, player));
		return true;
	}
}