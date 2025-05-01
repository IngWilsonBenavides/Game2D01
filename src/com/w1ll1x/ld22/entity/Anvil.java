package com.w1ll1x.ld22.entity;

import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.gfx.Screen;

public class Anvil extends Entity {
	private int pushTime = 0;
	private int pushDir = -1;
	
	public Anvil(int x, int y) {
		this.x = x;
		this.y = y;
		xr = 3;
		yr = 2;
	}
	
	public void tick() {
		if (pushDir == 0) 
			move(0, +1);
		if (pushDir == 1) 
			move(0, -1);
		if (pushDir == 2) 
			move(-1, 0);
		if (pushDir == 3) 
			move(+1, 0);
		pushDir = -1;
		if (pushTime > 0) 
			pushTime--;
	}
	
	public void render(Screen screen) {
		int col = Color.get(-1, 000, 111, 222);
		screen.render(x - 8, y - 8, 0 + 2 * 32, col, 0);
		screen.render(x - 0, y - 8, 1 + 2 * 32, col, 0);
		screen.render(x - 8, y - 0, 0 + 3 * 32, col, 0);
		screen.render(x - 0, y - 0, 1 + 3 * 32, col, 0);
	}
	
	public boolean blocks(Entity e) {
		return true;
	}
	
	protected void touchedBy(Entity entity) {
		if (entity instanceof Player && pushTime == 0) {
			pushDir = ((Player)entity).dir;
			pushTime = 10;
		}
	}
}