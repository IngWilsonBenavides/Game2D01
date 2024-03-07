package com.w1ll1x.ld22.entity;

public class Player extends Mob {

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		int xr = 4;
		int yr = 2;
		boolean mayPass = true;
		for (int c = 0; c < 4 && mayPass; c++) {
			int xt = ((x + xa) + (c % 2 * 2 - 1) * xr) >> 4;
			int yt = ((y + ya) + (c / 2 * 2 - 1) * yr) >> 4;
			if (!level.getTile(xt, yt).mayPass(level, xt, yt, this)) {
				mayPass = false;
			}
		}
		if (mayPass) {
			x += xa;
			y += ya;
		}
	}
}