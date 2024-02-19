package com.w1ll1x.ld22.gfx;

import java.util.ArrayList;
import java.util.List;

public class Screen {
	private List<Sprite> sprites = new ArrayList<Sprite>();

	private static final int MAP_WIDTH = 64;
	private static final int MAP_WIDTH_MASK = MAP_WIDTH - 1;

	public int[] tiles = new int[MAP_WIDTH * MAP_WIDTH * 2];
	public int[] colors = new int[MAP_WIDTH * MAP_WIDTH * 4];
	public int[] databits = new int[MAP_WIDTH * MAP_WIDTH];
	public int xScroll;
	public int yScroll;

	public static final int BIT_MIRROR_X = 0x01;
	public static final int BIT_MIRROR_Y = 0x02;

	public final int w, h;

	private SpriteSheet sheet;

	public Screen(int w, int h, SpriteSheet sheet) {
		this.sheet = sheet;
		this.w = w;
		this.h = h;

		for (int i = 0; i < MAP_WIDTH * MAP_WIDTH; i++) {
			colors[i * 4 + 0] = 0xff00ff;
			colors[i * 4 + 1] = 0x00ffff;
			colors[i * 4 + 2] = 0xffff00;
			colors[i * 4 + 3] = 0xffffff;

			if (i % 2 == 0)
				databits[i] += 1;
			if (i / MAP_WIDTH % 2 == 0)
				databits[i] += 2;
		}

	}

	public void render(int[] pixels, int offs, int row) {
		for (int yt = yScroll >> 3; yt <= (yScroll + h) >> 3; yt++) {
			int y0 = yt * 8 - yScroll;
			int y1 = y0 + 8;
			if (y0 < 0)
				y0 = 0;
			if (y1 > h)
				y1 = h;
			for (int xt = xScroll >> 3; xt <= (xScroll + w) >> 3; xt++) {
				int x0 = xt * 8 - xScroll;
				int x1 = x0 + 8;
				if (x0 < 0)
					x0 = 0;
				if (x1 > w)
					x1 = w;

				int tileIndex = (xt & (MAP_WIDTH_MASK)) + (yt & (MAP_WIDTH_MASK)) * MAP_WIDTH;
				int bits = databits[tileIndex] & 3;

				int spa = 1;
				if ((bits & BIT_MIRROR_X) > 0)
					spa = -1;
				for (int y = y0; y < y1; y++) {
					int sp = ((y + yScroll) & 7) * sheet.width + ((x0 + xScroll) & 7);
					int tp = offs + x0 + y * row;
					if ((bits & BIT_MIRROR_X) > 0)
						sp += 8;
					else
						sp -= 1;
					for (int x = x0; x < x1; x++) {
						int col = tileIndex * 4 + sheet.pixels[sp += spa];
						pixels[tp++] = colors[col];
					}
				}

			}
		}
	}
}