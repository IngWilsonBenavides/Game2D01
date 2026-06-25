package com.w1ll1x.ld22.screen;

import java.util.List;

import com.w1ll1x.ld22.crafting.Recipe;
import com.w1ll1x.ld22.entity.Player;
import com.w1ll1x.ld22.gfx.Font;
import com.w1ll1x.ld22.gfx.Screen;

public class CraftingMenu extends Menu {
	private Player player;
	private int selected = 0;
	private List<Recipe> recipes;

	public CraftingMenu(List<Recipe> recipes, Player player) {
		this.recipes = recipes;
		this.player = player;
		
		for (int i = 0; i < recipes.size(); i++) {
			recipes.get(i).checkCanCraft(player);
		}
	}

	@Override
	public void tick() {
		if (input.menu.clicked)
			game.setMenu(null);

		if (input.up.clicked)
			selected--;
		if (input.down.clicked)
			selected++;

		int len = recipes.size();
		if (len == 0)
			selected = 0;
		if (selected < 0)
			selected += len;
		if (selected >= len)
			selected -= len;
	}

	public void render(Screen screen) {
		Font.renderFrame(screen, "crafting", 1, 1, 18, 11);
		
		renderItemList(screen, 1, 1, 18, 11, recipes, selected);
	}
}