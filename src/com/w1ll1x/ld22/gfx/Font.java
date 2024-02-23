package com.w1ll1x.ld22.gfx;

public class Font {
	private static String chars = "" + //
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ      " + //
			"0123456789.,!?'\"-+=/\\%()<>:;     " + //
			"";

	public void draw(String msg, Screen screen, int x, int y) {
		msg = msg.toUpperCase();
		for (int i = 0; i < msg.length(); i++) {
			int ix = chars.indexOf(msg.charAt(i));
			if (ix >= 0) {
				screen.setTile(x + i, y, ix + 29 * 32, 5, 0);
			}
		}
	}
}