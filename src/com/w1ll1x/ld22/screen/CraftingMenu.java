package com.w1ll1x.ld22.screen;

import java.util.ArrayList;
import java.util.List;

import com.w1ll1x.ld22.entity.Anvil;
import com.w1ll1x.ld22.entity.Furniture;
import com.w1ll1x.ld22.entity.Player;
import com.w1ll1x.ld22.gfx.Font;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.item.resource.Resource;

public class CraftingMenu extends Menu {
	private Furniture furniture;
	private Player player;
	private int selected = 0;
	private List<CraftOption> craftables = new ArrayList<CraftOption>();

	public CraftingMenu(Furniture furniture, Player player) {
		this.furniture = furniture;
		this.player = player;
		craftables.add(new CraftOption("Upgrade anvil 1").addRequirement(Resource.wood, 16));
		craftables.add(new CraftOption("Upgrade anvil 2 "));
		craftables.add(new CraftOption("Upgrade anvil 3 "));
		craftables.add(new CraftOption("Upgrade anvil 4"));
		craftables.add(new CraftOption("Upgrade anvil 5"));
		craftables.add(new CraftOption("Upgrade anvil 6"));
		craftables.add(new CraftOption("Upgrade anvil 7"));
		craftables.add(new CraftOption("Upgrade anvil 8"));
		craftables.add(new CraftOption("Upgrade anvil 9"));
		craftables.add(new CraftOption("Upgrade anvil 10"));
		craftables.add(new CraftOption("Upgrade anvil 11"));
		craftables.add(new CraftOption("Upgrade anvil 12"));
		craftables.add(new CraftOption("Upgrade anvil 13"));
		
		for (int i = 0; i < craftables.size(); i++) {
			craftables.get(i).checkCanCraft(player);
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

		int len = craftables.size();
		if (len == 0)
			selected = 0;
		if (selected < 0)
			selected += len;
		if (selected >= len)
			selected -= len;
	}

	public void render(Screen screen) {
		Font.renderFrame(screen, "crafting", 1, 1, 18, 11);
		
		renderItemList(screen, 1, 1, 18, 11, craftables, selected);
	}
}