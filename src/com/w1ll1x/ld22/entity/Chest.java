package com.w1ll1x.ld22.entity;

import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.item.FurnitureItem;
import com.w1ll1x.ld22.item.ResourceItem;
import com.w1ll1x.ld22.item.ToolItem;
import com.w1ll1x.ld22.item.ToolType;
import com.w1ll1x.ld22.item.resource.Resource;
import com.w1ll1x.ld22.screen.ContainerMenu;

public class Chest extends Furniture {
	public Inventory inventory = new Inventory();
	
	public Chest(int x, int y) {
		super("Chest", x, y);
		col = Color.get(-1, 110, 331, 552);
		sprite = 1;
		
		inventory.add(new FurnitureItem(new Anvil(0, 0)));
		inventory.add(new ResourceItem(Resource.wheat, 64));
		for (int i = 0; i < 5; i++) {
			inventory.add(new ToolItem(ToolType.axe, i));
			inventory.add(new ToolItem(ToolType.hoe, i));
			inventory.add(new ToolItem(ToolType.pickaxe, i));
			inventory.add(new ToolItem(ToolType.shovel, i));
			inventory.add(new ToolItem(ToolType.sword, i));
		}
	}

	public boolean use(Player player, int attackDir) {
		player.game.setMenu(new ContainerMenu(player, "Chest", inventory));
		return true;
	}
}