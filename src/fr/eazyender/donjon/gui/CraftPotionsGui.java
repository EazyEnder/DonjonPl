package fr.eazyender.donjon.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.eazyender.donjon.donjon.LootUtils;
import fr.eazyender.donjon.files.PlayerEconomy;
import fr.eazyender.donjon.files.PlayerLevelStats;
import fr.eazyender.donjon.potion.IPotionRecipe;
import fr.eazyender.donjon.potion.PotionUtils;
import fr.eazyender.donjon.potion.RecipePotions;

public class CraftPotionsGui implements Listener{
	
	public static void createMainGui(Player player){
		
		Inventory inv = Bukkit.createInventory(null, 54 , "�f�lAlchimie : �8" + player.getDisplayName());
		
		for (int i = 0; i < RecipePotions.getRecipesUnlock(PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(player)).size(); i++) {
			
			IPotionRecipe recipe = RecipePotions.getRecipesUnlock(PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(player)).get(i);
			
			ItemStack logo = recipe.getCraft().clone();
			ItemMeta im = logo.getItemMeta();
			List<String> lore = new ArrayList<String>();
			lore.add("�fRang : " + RecipePotions.getDifficultyOfRecipe(recipe));
			lore.add("Temps n�cessaire : " + recipe.getTime() + "s");
			im.setLore(lore);	
			logo.setItemMeta(im);
			
			inv.setItem(i, logo);
			
		}
		
		for (int i = inv.getSize()-9; i < inv.getSize(); i++) {
			if(i != inv.getSize()-5) {
			inv.setItem(i, getCustomItemWithLore(Material.BLACK_STAINED_GLASS_PANE, "�8�l", false, 1, null));
			}
		}

		player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
		player.openInventory(inv);
	}
	
	public static void createRecipeGui(Player player, IPotionRecipe recipe) {
		
		Inventory inv = null;
		if(!recipe.getCraft().getItemMeta().getDisplayName().contains("fiole")) 
		 inv = Bukkit.createInventory(null, 27 , "�f�lAlchimie[CR:!"+ PotionUtils.getIdPotionByItem(recipe.getCraft()) +"!]:�8" + player.getDisplayName());
		else {
			String id = "";
			switch(LootUtils.getIdByLoot(recipe.getCraft())) {
			case 8: id = "A";
				break;
			case 9: id = "B";
				break;
			}
			inv = Bukkit.createInventory(null, 27 , "�f�lAlchimie[CR:!"+ id +"!]:�8" + player.getDisplayName());
		}
		 
		for (int i = 0; i < 9; i++) {
			if(i != 4 && i != 3 && i != 5) {
			inv.setItem(i, getCustomItemWithLore(Material.BLACK_STAINED_GLASS_PANE, "�8�l", false, 1, null));
			}else if(i == 3 || i == 5) {
			inv.setItem(i, recipe.getCraft());	
			}
			else {
			inv.setItem(i, getCustomItemWithLore(Material.STICK, "�2�lCRAFT", false, 1, null));	
			}
		}
		
		for (int i = 0; i < recipe.getIngredients().size(); i++) {
			inv.setItem(9 + i, recipe.getIngredients().get(i));
		}
		
		
		for (int i = inv.getSize()-9; i < inv.getSize(); i++) {
			if(i != inv.getSize()-5) {
			inv.setItem(i, getCustomItemWithLore(Material.BLACK_STAINED_GLASS_PANE, "�8�l", false, 1, null));
			}
			else {
			inv.setItem(i, getCustomItemWithLore(Material.BARRIER, "�2�lANNULER", false, 1, null));	
			}
		}

		player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
		player.openInventory(inv);
		
	}
	
	public static void launchCraft(Player player, int timer, int maxTimer) {
		
		if(maxTimer < 54) {
			int size = 9;
		if(maxTimer <= 9) size = 9;
		else if(maxTimer <= 18) size = 18;
		else if(maxTimer <= 27) size = 27;
		else if(maxTimer <= 36) size = 36;
		else if(maxTimer <= 45) size = 45;
		else if(maxTimer <= 54) size = 54;
		Inventory inv = Bukkit.createInventory(null, size , "�f�lAlchimie[CRAFTING]:�8" + player.getDisplayName());
		
		int progression = maxTimer - timer;
		
		for (int i = 0; i < maxTimer; i++) {
			if(i <= progression) {
				inv.setItem(i, getCustomItemWithLore(Material.GREEN_STAINED_GLASS_PANE, "", false, 1, null));
			}else {
				inv.setItem(i, getCustomItemWithLore(Material.RED_STAINED_GLASS_PANE, "", false, 1, null));
			}
		}
		
		if(timer <= 0) {
			player.closeInventory();
		}else {
			player.openInventory(inv);
		}
		
		}
		
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		if(current != null) {
			
			if(event.getView().getTitle().equals("�f�lAlchimie : �8" + player.getDisplayName())) {
				for (int i = 0; i < RecipePotions.getRecipesUnlock(PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(player)).size(); i++) {
					
					IPotionRecipe recipe = RecipePotions.getRecipesUnlock(PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(player)).get(i);
					
					ItemStack logo = recipe.getCraft().clone();
					ItemMeta im = logo.getItemMeta();
					List<String> lore = new ArrayList<String>();
					lore.add("�fRang : " + RecipePotions.getDifficultyOfRecipe(recipe));
					lore.add("Temps n�cessaire : " + recipe.getTime() + "s");
					im.setLore(lore);	
					logo.setItemMeta(im);
					
					if(current.equals(logo)) {
						createRecipeGui(player, recipe);
					}
					
				}
				event.setCancelled(true);
			}
			else if(event.getView().getTitle().contains("�f�lAlchimie[CR:!")) {
				
				ItemStack craft = getCustomItemWithLore(Material.STICK, "�2�lCRAFT", false, 1, null);
				ItemStack cancel = getCustomItemWithLore(Material.BARRIER, "�2�lANNULER", false, 1, null);
				if(current.equals(craft)) {
					
					String id = event.getView().getTitle();
					id = id.split("!")[1];
					ItemStack item;
					if(!id.contains("A") && !id.contains("B") && !id.contains("C") && !id.contains("D")) {
						item = PotionUtils.getItemPotionById(id);
					}else {
						switch(id) {
							case "A": id = ""+8;
								break;
							case "B": id = ""+9;
								break;
						}
						item = LootUtils.getLootById(Integer.parseInt(id));
					}
					IPotionRecipe recipe = RecipePotions.getRecipeByCraft(item);
					
					boolean canCraft = PotionUtils.getCraftCooldown(player) <= 0 
							&& PlayerEconomy.getEconomy().getMoney(player) >= recipe.getCost()
							&& LootUtils.hasRessources(player, recipe.getIngredients());
							
					if(canCraft) {
						PotionUtils.launchCraft(player, recipe);
						launchCraft(player, recipe.getTime(), recipe.getTime());
					}else {
						player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1, 1);
					}
					
				}else if(current.equals(cancel)) {
					
					createMainGui(player);
					
				}else {
					
				}
				
				event.setCancelled(true);
				
			}else if(event.getView().getTitle().equals("�f�lAlchimie[CRAFTING]:�8" + player.getDisplayName())) {
				event.setCancelled(true);
			}
			
		}
		
	}
	
	public static ItemStack getCustomItemWithLore(Material material, String customName, boolean EnchantEffect, int nbr, List<String> lore) {
		
		ItemStack item = new ItemStack(material, nbr);
		ItemMeta itemMeta = item.getItemMeta();
		if(lore != null) {
		itemMeta.setLore(lore);
		}
		if(customName != null) {itemMeta.setDisplayName(customName);}
		if(EnchantEffect) {itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 200, true);itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);}
		item.setItemMeta(itemMeta);
		
		
		return item;
		
	}

}
