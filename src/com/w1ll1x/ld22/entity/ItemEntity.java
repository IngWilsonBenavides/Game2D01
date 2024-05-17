package com.w1ll1x.ld22.entity;

import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.item.Item;

public class ItemEntity extends Entity {

	protected int walkDist = 0;
	protected int dir = 0;
	public int hurtTime = 0;
	protected int xKnockback, yKnockback;
	public double zz, za;
	private Item item;

	public ItemEntity(Item item, int x, int y) {
		this.item = item;
		x = y = 8;
		xr = 4;
		yr = 3;

		zz = 2;
		za = random.nextFloat() * 0.7 + 2;
	}

	public void tick() {
		zz += za;
		if (zz < 0) {
			zz = 0;
			za *= -0.5;
		}
		za -= 0.15;
		if (hurtTime > 0)
			hurtTime--;
	}

	public void render(Screen screen) {

		int col = item.getColor();
		if (hurtTime > 0) {
			col = Color.get(-1, 555, 555, 555);
		}

		screen.render(x - 4, y - 4, item.getSprite(), Color.get(-1, 555, 555, 555), 0);
		screen.render(x - 4, y - 4 - (int) (zz), item.getSprite(), col, 0);
	}

	public void hurt(Mob mob, int damage, int attackDir) {
		if (attackDir == 0)
			yKnockback = +6;
		if (attackDir == 1)
			yKnockback = -6;
		if (attackDir == 2)
			xKnockback = -6;
		if (attackDir == 3)
			xKnockback = +6;
		hurtTime = 10;
	}

}
