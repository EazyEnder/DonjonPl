package fr.eazyender.donjon.potion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.donjon.LootUtils;
import fr.eazyender.donjon.files.PlayerEconomy;
import fr.eazyender.donjon.files.PlayerEquipment;
import fr.eazyender.donjon.gui.CraftPotionsGui;

public class PotionUtils {
	
	/** POTION ENTITY FRIENDLY : 
	 * -NOTHING*/
	public static int potionsNumber = 4;
	private static Map<Player, Integer> timer = new HashMap<Player, Integer>();
	
	public static int getCraftCooldown(Player player) {
		if(timer.containsKey(player)) {
			return timer.get(player);
		}else {
			return 0;
		}
	}
	
	public static void givePotion(Player player, int id, int quantity) {
		List<String> potions = PlayerEquipment.getPlayerEquipment().getPotions(player);
		if(!potions.isEmpty()) {
			boolean contain = false;
		for (int i1 = 0; i1 < potions.size(); i1++) {
			String str = potions.get(i1);
			String[] parts = str.split("\\:");
			int unite = Integer.parseInt(parts[0]);
			int decimal = Integer.parseInt(parts[1]);
			
			//IS POTION?
			if(unite == id) {
				decimal += quantity;
				//RECONSTRUCT
				String dbl = unite +":"+ decimal;
				potions.set(i1,dbl);
				contain = true;
			}	
		}
		if(!contain)potions.add(id+":"+quantity);
		}else {potions.add(id+":"+quantity);}
		
		PlayerEquipment.getPlayerEquipment().setPotions(player,potions);
	}
	
	public static boolean launchCraft(Player player, IPotionRecipe recipe) {
		
		if(getCraftCooldown(player) <= 0 && PlayerEconomy.getEconomy().getMoney(player) >= recipe.getCost()) {
			
			if(!timer.containsKey(player))timer.put(player, recipe.getTime());
			else timer.replace(player, recipe.getTime());
			
			new BukkitRunnable() {

				@Override
				public void run() {
					
					if(getCraftCooldown(player) <= 0) {
						
						if(recipe.getCost() > 0) {PlayerEconomy.getEconomy().setMoney(player, PlayerEconomy.getEconomy().getMoney(player)-recipe.getCost());}
						
						//la recette est une potion
						if(!recipe.getCraft().getItemMeta().getDisplayName().contains("fiole")) {
						
						List<String> potions = PlayerEquipment.getPlayerEquipment().getPotions(player);
						
						if(!potions.isEmpty()) {
							boolean contain = false;
						for (int i = 0; i < potions.size(); i++) {
							String str = potions.get(i);
							String[] parts = str.split("\\:");
							int unite = Integer.parseInt(parts[0]);
							int decimal = Integer.parseInt(parts[1]);
							
							//IS POTION?
							if(unite == Integer.parseInt(getIdPotionByItem(recipe.getCraft()))) {
								decimal++;
								//RECONSTRUCT
								String dbl = unite +":"+ decimal;
								potions.set(i,dbl);
								contain = true;
							}
							
						}
						if(!contain)potions.add(getIdPotionByItem(recipe.getCraft())+":1");
						}else {potions.add(getIdPotionByItem(recipe.getCraft())+":1");}
						
						PlayerEquipment.getPlayerEquipment().setPotions(player, potions);
						//La recette est une fiole
						}else {
						List<ItemStack> fioles = new ArrayList<ItemStack>();
						fioles.add(recipe.getCraft());
						LootUtils.addItemsToRessources(player, fioles);
						}
						
						LootUtils.removeItemsOfRessources(player, recipe.getIngredients());
						
						player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
						player.sendMessage("§f[§7Craft§f] : " + "Vous avez fini de fabriquer §7" + recipe.getCraft().getItemMeta().getDisplayName());
						
						timer.remove(player);
						this.cancel();
					}else {
						timer.replace(player, getCraftCooldown(player)-1);
					}
					
					if(timer.containsKey(player))
					CraftPotionsGui.launchCraft(player, timer.get(player), recipe.getTime());
					
				}
				
			}.runTaskTimer(DonjonMain.instance, 20, 20);
			return true;
			
		}else {
			return false;
		}
		
	}
	
	public static String getIdPotionByItem(ItemStack item) {
		
		String id = "0";
		List<ItemStack> all = new ArrayList<ItemStack>();
		
		List<String> str = new ArrayList<String>();
		str.add("§fPetite potion vous régénérant un peu de vie");
		str.add("§4§lType§r§7 : " + "§4§lSoin");
		str.add("§4§lTemps de recharge§r§7 : " +( PotionSmallHeal.basicCooldown/1000));
		ItemStack item1 = getCustomItemWithLore(Material.FEATHER, "§4Petite potion de Vie", false, 1, str);
		all.add(item1);
		List<String> str1 = new ArrayList<String>();
		str1.add("§fPetite potion vous régénérant un peu de mana");
		str1.add("§9§lType§r§7 : " + "§9§lMana");
		str1.add("§9§lTemps de recharge§r§7 : " +( PotionSmallMana.basicCooldown/1000));
		ItemStack item2 = getCustomItemWithLore(Material.FEATHER, "§9Petite potion de Mana", false, 1, str1);
		all.add(item2);
		List<String> str2 = new ArrayList<String>();
		str2.add("§fPetite potion accélérant vos pas pour une courte durée");
		str2.add("§2§lType§r§7 : " + "§7§lBoost");
		str2.add("§2§lTemps de recharge§r§7 : " +( PotionSmallSpeed.basicCooldown/1000));
		ItemStack item3 = getCustomItemWithLore(Material.FEATHER, "§2Petite potion de Vigueur", false, 1, str2);
		all.add(item3);
		List<String> str3 = new ArrayList<String>();
		str3.add("§fMoyenne potion vous régénérant un peu de vie");
		str3.add("§4§lType§r§7 : " + "§4§lSoin");
		str3.add("§4§lTemps de recharge§r§7 : " +( PotionMediumHeal.basicCooldown/1000));
		ItemStack item4 = getCustomItemWithLore(Material.FEATHER, "§4Moyenne potion de Vie", false, 1, str3);
		all.add(item4);
		
		for (int i = 0; i < all.size(); i++) {
			if(item.getItemMeta().getDisplayName().equals(all.get(i).getItemMeta().getDisplayName())) {
				id = String.valueOf(i+1);
			}
		}
		
		return id;
	}
	
	public static ItemStack getItemPotionById(String id) {
		
		ItemStack item = null;
		
		id = id.split("\\:")[0];
		int value = Integer.parseInt(id);
		
		switch(value) {
		case 1: 
			List<String> str = new ArrayList<String>();
			str.add("§fPetite potion vous régénérant un peu de vie");
			str.add("§4§lType§r§7 : " + "§4§lSoin");
			str.add("§4§lTemps de recharge§r§7 : " +( PotionSmallHeal.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "§4Petite potion de Vie", false, 1, str);
			break;
		case 2:
			List<String> str1 = new ArrayList<String>();
			str1.add("§fPetite potion vous régénérant un peu de mana");
			str1.add("§9§lType§r§7 : " + "§9§lMana");
			str1.add("§9§lTemps de recharge§r§7 : " +( PotionSmallMana.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "§9Petite potion de Mana", false, 1, str1);
			break;
		case 3:
			List<String> str2 = new ArrayList<String>();
			str2.add("§fPetite potion accélérant vos pas pour une courte durée");
			str2.add("§2§lType§r§7 : " + "§7§lBoost");
			str2.add("§2§lTemps de recharge§r§7 : " +( PotionSmallSpeed.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "§2Petite potion de Vigueur", false, 1, str2);
			break;
		case 4:
			List<String> str3 = new ArrayList<String>();
			str3.add("§fMoyenne potion vous régénérant un peu de vie");
			str3.add("§4§lType§r§7 : " + "§4§lSoin");
			str3.add("§4§lTemps de recharge§r§7 : " +( PotionMediumHeal.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "§4Moyenne potion de Vie", false, 1, str3);
			break;
		}
		
		return item;
		
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
