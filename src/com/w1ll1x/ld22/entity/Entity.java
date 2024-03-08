package com.w1ll1x.ld22.entity;

import java.util.Random;

import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.level.Level;

public class Entity {
	protected final Random random = new Random();
	public int x, y;
	public boolean removed;
	public Level level;
	
	public void render(Screen screen) {
		
	}
	
	public void tick() {
	}

	public void remove() {
		removed = true;
	}

	public final void init(Level level) {
		this.level = level;
	}
}