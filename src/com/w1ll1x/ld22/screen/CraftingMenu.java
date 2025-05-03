package com.w1ll1x.ld22.screen;

import java.util.ArrayList;
import java.util.List;

import com.w1ll1x.ld22.entity.Anvil;
import com.w1ll1x.ld22.entity.Player;
import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.gfx.Font;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.item.Item;
import com.w1ll1x.ld22.item.Resource;
import com.w1ll1x.ld22.item.ResourceItem;

public class CraftingMenu extends Menu {
	private Anvil anvil;
	private Player player;
	private int selected = 0;
	private List<Item> craftables = new ArrayList<Item>();

	public CraftingMenu(Anvil anvil, Player player) {
		this.anvil = anvil;
		this.player = player;
		craftables.add(new ResourceItem(Resource.stone));
		craftables.add(new ResourceItem(Resource.stone));
		craftables.add(new ResourceItem(Resource.wood));
		craftables.add(new ResourceItem(Resource.stone));
		craftables.add(new ResourceItem(Resource.stone));
		craftables.add(new ResourceItem(Resource.stone));
		craftables.add(new ResourceItem(Resource.wood));
		craftables.add(new ResourceItem(Resource.wood));
		craftables.add(new ResourceItem(Resource.wood));
		craftables.add(new ResourceItem(Resource.wood));
		craftables.add(new ResourceItem(Resource.stone));
		craftables.add(new ResourceItem(Resource.stone));
		craftables.add(new ResourceItem(Resource.stone));
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
		if (selected < 0)
			selected += len;
		if (selected >= len)
			selected -= len;
	}

	public void render(Screen screen) {
		Font.renderFrame(screen, "crafting", 1, 1, 12, 11);
		Font.renderFrame(screen, "upgrade", 13, 1, 13 + 12, 11);
		
		int i0 = 0;
		int i1 = craftables.size();
		if (i1 > 11) 
			i1 = 9;
		int io = selected - 4;
		if (io > craftables.size() - 9)
			io = craftables.size() - 9;
		if (io < 0)
			io = 0;
		for (int i = i0; i < i1; i++) {
			craftables.get(i + io).renderInventory(screen, 8 * 2, (i + 2) * 8);
		}
		
		int yy = selected + 2 - io;
		Font.draw(">", screen, 1 * 8, yy * 8, Color.get(5, 555, 555, 555));
		Font.draw("<", screen, 12 * 8, yy * 8, Color.get(5, 555, 555, 555));
	}
}