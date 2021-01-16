package fr.eazyender.donjon.forge;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

import fr.eazyender.donjon.donjon.LootUtils;
import fr.eazyender.donjon.forge.IWeaponRecipe;

public class RecipeForge {
	
private static List<IWeaponRecipe> recipes = new ArrayList<IWeaponRecipe>();
	
	public static void initRecipes() {
		
		List<ItemStack> granite_sword_ingredients = new ArrayList<ItemStack>();
		ItemStack granite_sword_ingredients_1 = LootUtils.getLootById(6).clone();
		granite_sword_ingredients_1.setAmount(3);
		granite_sword_ingredients.add(granite_sword_ingredients_1);
		ItemStack granite_sword_ingredients_2 = LootUtils.getLootById(7).clone();
		granite_sword_ingredients_2.setAmount(2);
		granite_sword_ingredients.add(granite_sword_ingredients_2);
		IWeaponRecipe granite_sword = new IWeaponRecipe(granite_sword_ingredients,
				LootUtils.getWeaponById(1), 0, 20, 1, 1);
		recipes.add(granite_sword);
		
		List<ItemStack> beginner_orb_ingredients = new ArrayList<ItemStack>();
		ItemStack beginner_orb_ingredients_1 = LootUtils.getLootById(5).clone();
		beginner_orb_ingredients_1.setAmount(5);
		beginner_orb_ingredients.add(beginner_orb_ingredients_1);
		ItemStack beginner_orb_ingredients_2 = LootUtils.getLootById(1).clone();
		beginner_orb_ingredients_2.setAmount(5);
		beginner_orb_ingredients.add(beginner_orb_ingredients_2);
		IWeaponRecipe beginner_orb = new IWeaponRecipe(beginner_orb_ingredients,
				LootUtils.getWeaponById(7), 0, 20, 3, 1);
		recipes.add(beginner_orb);
		
		List<ItemStack> wood_wand_ingredients = new ArrayList<ItemStack>();
		ItemStack wood_wand_ingredients_1 = LootUtils.getLootById(5).clone();
		wood_wand_ingredients_1.setAmount(5);
		wood_wand_ingredients.add(wood_wand_ingredients_1);
		ItemStack wood_wand_ingredients_2 = LootUtils.getLootById(6).clone();
		wood_wand_ingredients_2.setAmount(5);
		wood_wand_ingredients.add(wood_wand_ingredients_2);
		IWeaponRecipe wood_wand = new IWeaponRecipe(wood_wand_ingredients,
				LootUtils.getWeaponById(2), 0, 20, 3, 1);
		recipes.add(wood_wand);
		
	}
	
	public static IWeaponRecipe getRecipeById(int id) {
		
		if(recipes.size() >= id) {
			return recipes.get(id-1);
		}else return null;
		
	}
	
	public static String getDifficultyOfRecipe(IWeaponRecipe recipe) {
		
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
	
	public static IWeaponRecipe getRecipeByCraft(ItemStack item) {
		for (int i = 0; i < recipes.size(); i++) {
			IWeaponRecipe recipe = recipes.get(i);
			if(recipe.getCraft().getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName()))
			return recipe;
		}
		return null;
	}
	
	public static List<IWeaponRecipe> getRecipesUnlock(int level) {
		List<IWeaponRecipe> levelrecipes = new ArrayList<IWeaponRecipe>();
		
		for (int i = 0; i < recipes.size(); i++) {
			if(recipes.get(i).getLevel() <= level) {
				levelrecipes.add(recipes.get(i));
			}
			
		}
		
		return levelrecipes;
		
	}

}
