package com.w1ll1x.ld22.entity;

public class Mob extends Entity {

	protected int walkDist = 0;
	protected int dir = 0;

	public Mob() {
		x = y = 8;
	}

	public boolean move(int xa, int ya) {
		if (xa != 0 || ya != 0) {
			walkDist++;
			if (xa < 0)
				dir = 2;
			if (xa > 0)
				dir = 3;
			if (ya < 0)
				dir = 1;
			if (ya > 0)
				dir = 0;
			boolean stopped = true;
			if (xa != 0 && move2(xa, 0))
				stopped = false;
			if (ya != 0 && move2(0, ya))
				stopped = false;
			return !stopped;
		}
		return true;
	}

	private boolean move2(int xa, int ya) {
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
			return true;
		}
		return false;
	}
}
