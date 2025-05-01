package com.w1ll1x.ld22.entity;

import com.w1ll1x.ld22.gfx.Color;

public class Chest extends Furniture {
	public Inventory inventory;
	
	public Chest(int x, int y) {
		super(x, y);
		col = Color.get(-1, 110, 331, 552);
		sprite = 2 + 2 * 32;
	}
	
}