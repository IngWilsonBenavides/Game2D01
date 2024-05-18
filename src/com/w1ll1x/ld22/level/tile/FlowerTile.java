package com.w1ll1x.ld22.level.tile;

import com.w1ll1x.ld22.entity.ItemEntity;
import com.w1ll1x.ld22.entity.Mob;
import com.w1ll1x.ld22.gfx.Color;
import com.w1ll1x.ld22.gfx.Screen;
import com.w1ll1x.ld22.item.Resource;
import com.w1ll1x.ld22.item.ResourceItem;
import com.w1ll1x.ld22.level.Level;

public class FlowerTile extends GrassTile {

	public FlowerTile(int id) {
		super(id);
		tiles[id] = this;
	}

	public void render(Screen screen, Level level, int x, int y) {
		super.render(screen, level, x, y);
		int data = level.getData(x, y);
		int color = data % 16;
		int shape = data / 16;

		int flowerCol = 0;
		if (color == 0)
			flowerCol = Color.get(10, level.grassColor, 555, 440);
		if (color == 1)
			flowerCol = Color.get(10, level.grassColor, 533, 400);
		if (color == 2)
			flowerCol = Color.get(10, level.grassColor, 115, 445);
		if (color == 3)
			flowerCol = Color.get(10, level.grassColor, 111, 000);

		if (shape == 0)
			screen.render(x * 16 + 0, y * 16 + 0, 1 + 1 * 32, flowerCol, 0);
		if (shape == 1)
			screen.render(x * 16 + 8, y * 16 + 0, 1 + 1 * 32, flowerCol, 0);
		if (shape == 2)
			screen.render(x * 16 + 0, y * 16 + 8, 1 + 1 * 32, flowerCol, 0);
		if (shape == 3)
			screen.render(x * 16 + 8, y * 16 + 8, 1 + 1 * 32, flowerCol, 0);
	}
	
	public void hurt(Level level, int x, int y, Mob source, int dmg, int attackDir) {
		level.add(new ItemEntity(new ResourceItem(Resource.flower), x * 16 + random.nextInt(10) + 3, y * 16  + random.nextInt(10) + 3));
		level.setTile(x, y, Tile.grass, 0);
	}

}