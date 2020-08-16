package fr.eazyender.donjon.potion;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

import fr.eazyender.donjon.donjon.LootUtils;

public class RecipePotions {
	
	private static List<IPotionRecipe> recipes = new ArrayList<IPotionRecipe>();
	
	public static void initRecipes() {
		
		List<ItemStack> small_heal_ingredients = new ArrayList<ItemStack>();
		small_heal_ingredients.add(LootUtils.getLootById(3));
		IPotionRecipe small_heal_potion = new IPotionRecipe(small_heal_ingredients,
				PotionUtils.getItemPotionById("1"), 0, 5, 2, 1);
		recipes.add(small_heal_potion);
		
		List<ItemStack> small_speed_ingredients = new ArrayList<ItemStack>();
		ItemStack ingredient = LootUtils.getLootById(1);
		ingredient.setAmount(3);
		small_speed_ingredients.add(LootUtils.getLootById(1));
		IPotionRecipe small_speed_potion = new IPotionRecipe(small_speed_ingredients,
				PotionUtils.getItemPotionById("3"), 0, 5, 3, 1);
		recipes.add(small_speed_potion);
		
	}
	
	public static IPotionRecipe getRecipeById(int id) {
		
		if(recipes.size() >= id) {
			return recipes.get(id-1);
		}else return null;
		
	}
	
	public static String getDifficultyOfRecipe(IPotionRecipe recipe) {
		
		int id = recipe.getDifficulty();
		
		switch(id) {
		case 1: return "F";
		case 2: return "E";
		case 3: return "D";
		case 4: return "C";
		case 5: return "B";
		case 6: return "A";
		case 7: return "S";
		default: return "F";
		}
		
	}
	
	public static IPotionRecipe getRecipeByCraft(ItemStack item) {
		for (int i = 0; i < recipes.size(); i++) {
			IPotionRecipe recipe = recipes.get(i);
			if(recipe.getCraft().getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName()))
			return recipe;
		}
		return null;
	}
	
	public static List<IPotionRecipe> getRecipesUnlock(int level) {
		List<IPotionRecipe> levelrecipes = new ArrayList<IPotionRecipe>();
		
		for (int i = 0; i < recipes.size(); i++) {
			if(recipes.get(i).getLevel() <= level) {
				levelrecipes.add(recipes.get(i));
			}
			
		}
		
		return levelrecipes;
		
	}
	

}
