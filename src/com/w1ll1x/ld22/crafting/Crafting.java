package com.w1ll1x.ld22.crafting;

import java.util.ArrayList;
import java.util.List;

import com.w1ll1x.ld22.item.resource.Resource;

public class Crafting {
	public static final List<Recipe> anvilRecipes = new ArrayList<Recipe>();
	public static final List<Recipe> chestRecipes = new ArrayList<Recipe>();
	public static final List<Recipe> ovenRecipes = new ArrayList<Recipe>();
	public static final List<Recipe> furnaceRecipes = new ArrayList<Recipe>();

	static {
		ovenRecipes.add(new ResourceRecipe(Resource.bread).addCost(Resource.wheat, 4));
	}
}
