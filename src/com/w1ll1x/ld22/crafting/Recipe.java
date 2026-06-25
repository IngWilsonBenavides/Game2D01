package com.w1ll1x.ld22.crafting;

import java.util.ArrayList;
import java.util.List;

import com.w1ll1x.ld22.entity.Player;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.item.Item;
import com.w1ll1x.ld22.item.ResourceItem;
import com.w1ll1x.ld22.item.resource.Resource;
import com.w1ll1x.ld22.screen.ListItem;

public abstract class Recipe implements ListItem {
	private List<Item> costs = new ArrayList<Item>();
	public boolean canCraft = false;

	public Recipe addCost(Resource resource, int count) {
		costs.add(new ResourceItem(resource, count));
		return this;
	}

	public void checkCanCraft(Player player) {
		for (int i = 0; i < costs.size(); i++) {
			Item item = costs.get(i);
			if (item instanceof ResourceItem) {
				ResourceItem ri = (ResourceItem) item;
				if (!player.inventory.hasResources(ri.resource, ri.count)) {
					canCraft = false;
					return;
				}
			}
		}
		canCraft = true;
	}

	@Override
	public abstract void renderInventory(Screen screen, int x, int y);
}
