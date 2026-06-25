package com.w1ll1x.ld22.crafting;

import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.gfx.Font;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.item.resource.Resource;

public class ResourceRecipe extends Recipe {
	private Resource resource;

	public ResourceRecipe(Resource resource) {
		this.resource = resource;
	}

	public void renderInventory(Screen screen, int x, int y) {
		screen.render(x, y, resource.sprite, resource.color, 0);
		int textColor = canCraft ? Color.get(-1, 555, 555, 555) : Color.get(-1, 333, 333, 333);
		Font.draw(resource.name, screen, x + 8, y, textColor);
	}
}
