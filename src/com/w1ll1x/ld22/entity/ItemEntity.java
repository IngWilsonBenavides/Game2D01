package com.w1ll1x.ld22.entity;

import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.item.Item;

public class ItemEntity extends Entity {

	protected int walkDist = 0;
	protected int dir = 0;
	public int hurtTime = 0;
	protected int xKnockback, yKnockback;
	public double xa, ya, za;
	public double xx, yy, zz;
	private Item item;
	private int time = 0;

	public ItemEntity(Item item, int x, int y) {
		this.item = item;
		xx = this.x = x;
		yy = this.y = y;
		xr = 2;
		yr = 2;

		zz = 2;
		xa = random.nextGaussian() * 0.3;
		ya = random.nextGaussian() * 0.2;
		za = random.nextFloat() * 0.7 + 1;
	}

	public void tick() {
		time++;
		xx += xa;
		yy += ya;
		zz += za;
		if (zz < 0) {
			zz = 0;
			za *= -0.5;
			xa *= 0.6;
			ya *= 0.6;
		}
		za -= 0.15;
		int nx = (int) xx;
		int ny = (int) yy;
		move(nx - x, ny - y);

		if (hurtTime > 0)
			hurtTime--;
	}
	
	public boolean isBlockableBy(Mob mob) {
		return false;
	}

	public void render(Screen screen) {
		screen.render(x - 4, y - 4, item.getSprite(), Color.get(-1, 0, 0, 0), 0);
		screen.render(x - 4, y - 4 - (int) (zz), item.getSprite(), item.getColor(), 0);
	}

	protected void touchedBy(Entity entity) {
		if (time > 30) {
			entity.touchItem(this);
		}
	}

	public void take() {
		item.onTake(this);
		remove();
	}
}
