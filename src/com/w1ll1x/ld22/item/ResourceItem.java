package com.w1ll1x.ld22.item;

import com.w1ll1x.ld22.entity.ItemEntity;
import com.w1ll1x.ld22.entity.particle.TextParticle;
import com.w1ll1x.ld22.gfx.Color;

public class ResourceItem extends Item {
	public Resource resource;

	public ResourceItem(Resource resource) {
		this.resource = resource;
	}

	public int getColor() {
		return resource.color;
	}

	public int getSprite() {
		return resource.sprite;
	}

	public void onTake(ItemEntity itemEntity) {
		itemEntity.level
				.add(new TextParticle("+" + resource.name, itemEntity.x, itemEntity.y, Color.get(-1, 555, 555, 555)));
	}
}