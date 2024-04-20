package com.w1ll1x.ld22.entity.particle;

import com.w1ll1x.ld22.entity.Entity;
import com.w1ll1x.ld22.gfx.Font;
import com.w1ll1x.ld22.gfx.Screen;

public class TextParticle extends Entity {
	private String msg;
	private int col;
	private int time = 0;
	public double xa, ya, za;
	public double xx, yy, zz;
	
	public TextParticle(String msg, int x, int y, int col) {
		this.msg = msg;
		this.x = x;
		this.y = y;
		this.col = col;
		xx = x;
		yy = y;
		zz = 8;
		xa = random.nextGaussian();
		ya = random.nextGaussian();
		za = random.nextFloat();
	}

	public void tick() {
		time++;
		if (time > 30) {
			remove();
		}
		xx += xa;
		yy += ya;
		zz += za;
		za -= 0.1;
		x = (int) xx;
		y = (int) yy;
	}
	
	public void render(Screen screen) {
		Font.draw(msg, screen, x - msg.length() * 4 + 4, y - (int)(zz), col);
	}

}
