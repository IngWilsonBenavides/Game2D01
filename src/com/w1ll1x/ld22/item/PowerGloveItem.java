package com.w1ll1x.ld22.item;

import com.w1ll1x.ld22.entity.Entity;
import com.w1ll1x.ld22.entity.Furniture;
import com.w1ll1x.ld22.entity.Player;
import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.gfx.Font;
import com.w1ll1x.ld22.gfx.Screen;

public class PowerGloveItem extends Item {

	public int getColor() {
		return Color.get(-1, 100, 320, 430);
	}

	public int getSprite() {
		return 7 + 4 * 32;
	}

	public void renderIcon(Screen screen, int x, int y) {
		screen.render(x, y, getSprite(), getColor(), 0);
	}

	public void renderInventory(Screen screen, int x, int y) {
		screen.render(x, y, getSprite(), getColor(), 0);
		Font.draw("Power glove", screen, x + 8, y, Color.get(-1, 555, 555, 555));
	}

	public boolean interact(Player player, Entity entity, int attackDir) {
		if (entity instanceof Furniture) {
			Furniture f = (Furniture)entity;
			f.take(player);
			return true;
		}
		return false;
	}
}