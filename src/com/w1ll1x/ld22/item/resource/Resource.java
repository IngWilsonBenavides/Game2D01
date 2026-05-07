package com.w1ll1x.ld22.item.resource;

import com.w1ll1x.ld22.entity.Player;
import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.level.Level;
import com.w1ll1x.ld22.level.tile.Tile;

public class Resource {

	public static Resource wood = new Resource("Wood", 1 + 4 * 32, Color.get(-1, 200, 531, 430));
	public static Resource stone = new Resource("Stone", 2 + 4 * 32, Color.get(-1, 111, 333, 555));
	public static Resource flower = new Resource("Flower", 0 + 4 * 32, Color.get(-1, 10, 444, 330));
	public static Resource acorn = new PlantableResource("Acorn", 3 + 4 * 32, Color.get(-1, 100, 531, 320), Tile.treeSapling, Tile.grass);
	public static Resource dirt = new PlantableResource("Dirt", 2 + 4 * 32, Color.get(-1, 100, 322, 432), Tile.dirt, Tile.hole, Tile.water);
	public static Resource sand = new PlantableResource("Sand", 2 + 4 * 32, Color.get(-1, 110, 440, 550), Tile.sand, Tile.grass, Tile.dirt);
	public static Resource cactusFlower = new PlantableResource("Cactus", 2 + 4 * 32, Color.get(-1, 110, 40, 50), Tile.cactusSapling, Tile.sand);

	public final String name;
	public final int sprite;
	public final int color;

	public Resource(String name, int sprite, int color) {
		if (name.length() > 6) throw new RuntimeException("Name cannot be longer than six characters!");
		this.name = name;
		this.sprite = sprite;
		this.color = color;
	}

	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
		return false;
	}
}