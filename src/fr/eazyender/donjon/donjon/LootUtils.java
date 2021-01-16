package fr.eazyender.donjon.donjon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.eazyender.donjon.donjon.weapons.ItemBeginnerOrb;
import fr.eazyender.donjon.donjon.weapons.ItemDawnSword;
import fr.eazyender.donjon.donjon.weapons.ItemPoisonousSword;
import fr.eazyender.donjon.files.PlayerEquipment;

public class LootUtils {
	
	public static ItemStack getLootById(int id) {
		ItemStack item = null;
		switch(id) {
		case 1: item = getDrop(Material.STICK, "§2Essence de la foret", false, 1, "§fEtrange substance mouvante remplis d'§2énergie", "Commun");
			break;
		case 2: item = getDrop(Material.STICK, "§6Cristal de Roche", false, 1, "§fCristal faisant de la lumière", "Commun");
			break;
		case 3: item = getDrop(Material.STICK, "§4Fruit Rouge", false, 1, "§fFruit pouvant servir aux potions", "Non Commun");
			break;
		case 4: item = getDrop(Material.STICK, "§7Essence d'air", false, 1, "§fEtrange substance mouvante remplis d'§7énergie", "Non Commun");
			break;
		case 5: item = getDrop(Material.STICK, "§9Residu de Mana", false, 1, "§fDe l'énergie concentré libéré après un évènement magique", "Non Commun");
			break;
		case 6: item = getDrop(Material.STICK, "§6Bois", false, 1, "§f", "Commun");
			break;
		case 7: item = getDrop(Material.GRANITE, "§cGranite", false, 1, "§f", "Commun");
			break;
		case 8: item = getDrop(Material.STICK, "§fPetite fiole basique", false, 1, "§fUne petite fiole crée à partir de cristaux de terre", "Commun");
			break;
		case 9: item = getDrop(Material.STICK, "§fMoyenne fiole basique", false, 1, "§fUne moyenne fiole crée à partir de cristaux de terre", "Commun");
			break;
		}
		
		return item;
	}
	
	public static int getIdByLoot(ItemStack item) {
		int id = 0;
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(getDrop(Material.STICK, "§2Essence de la foret", false, 1, "§fEtrange substance mouvante remplis d'§2énergie", "Commun"));
		items.add(getDrop(Material.STICK, "§6Cristal de Roche", false, 1, "§fCristal faisant de la lumière", "Commun"));
		items.add(getDrop(Material.STICK, "§4Fruit Rouge", false, 1, "§fFruit pouvant servir aux potions", "Non Commun"));
		items.add(getDrop(Material.STICK, "§7Essence d'air", false, 1, "§fEtrange substance mouvante remplis d'§7énergie", "Non Commun"));
		items.add(getDrop(Material.STICK, "§9Residu de Mana", false, 1, "§fDe l'énergie concentré libéré après un évènement magique", "Non Commun"));
		items.add(getDrop(Material.STICK, "§6Bois", false, 1, "§f", "Commun"));
		items.add(getDrop(Material.GRANITE, "§cGranite", false, 1, "§f", "Commun"));
		items.add(getDrop(Material.STICK, "§fPetite fiole basique", false, 1, "§fUne petite fiole crée à partir de cristaux de terre", "Commun"));
		items.add(getDrop(Material.STICK, "§fMoyenne fiole basique", false, 1, "§fUne moyenne fiole crée à partir de cristaux de terre", "Commun"));
		
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName())) {
				id = i+1;
			}
		}
		
		return id;
	}
	
	public static ItemStack getWeaponById(int id) {
		ItemStack item = null;
		switch(id) {
		case 1: item = getWeaponDrop(Material.STONE_SWORD, "§cEpee en Granite", false, 1, "§fArme faite à partir d'un certain type de roche", "E");
			break;
		case 2: item = getWeaponDrop(Material.WOODEN_SWORD, "§6Baton magique en bois simple", false, 1, "§fUn simple baton infusé de magie", "F");
			break;
		case 3: item = getWeaponDrop(Material.STONE_AXE, "§bEpee des Glaces", false, 1, "§fUn bout de glace solidifié par la magie ambiante", "E");
			break;
		case 4: item = getWeaponDrop(Material.WOODEN_SWORD, "§7Epee de Voyageur", false, 1, "§fUn simple manche bois à laquel est accroché de la pierre taillé", "F");
			break;
		case 5: item = getWeaponDrop(Material.WOODEN_AXE, "§cEpee fracture en Granite", false, 1, "§fL'épée en granite mais en moins bien", "F");
			break;
		case 6: item = getWeaponDrop(Material.WOODEN_SWORD, "§bBaton de l Eau pur", false, 1, "§fBâton crystallisé par le mana humide ambiant avec le temps", "C");
			break;
		case 7: item = ItemBeginnerOrb.getWeapon();
			break;
		case 8: item = ItemPoisonousSword.getWeapon();
			break;
		case 9: item = ItemDawnSword.getWeapon();
			break;
		}
		
		return item;
	}
	
	public static ItemStack getArmorById(int id, int part, String material) {
		ItemStack item = null;
		String name = "";
		
		if(material.equals("IRON"));
		switch(part) {
		case 1: name = "Casque"; item = new ItemStack(Material.IRON_HELMET);
			break;
		case 2: name = "Plastron"; item = new ItemStack(Material.IRON_CHESTPLATE);
			break;
		case 3: name = "Jambiere"; item = new ItemStack(Material.IRON_LEGGINGS);
			break;
		case 4: name = "Bottes"; item = new ItemStack(Material.IRON_BOOTS);
			break;
		}
		
		switch(id) {
		case 1:
			ItemMeta im = item.getItemMeta();
			im.setDisplayName("§7§l" + name + " en §2§lGranite");
			item.setItemMeta(im);
			break;
		case 2:
			break;
		}
		
		return item;
	}
	
	public static int getIDWeaponByItem(ItemStack item) {
		if(item.equals(getWeaponDrop(Material.STONE_SWORD, "§cEpee en Granite", false, 1, "§fArme faite à partir d'un certain type de roche", "E"))) {
			return 1;
		}else if(item.equals(getWeaponDrop(Material.WOODEN_SWORD, "§6Baton magique en bois simple", false, 1, "§fUn simple baton infusé de magie", "F"))) {
			return 2;
		}else if(item.equals(getWeaponDrop(Material.STONE_AXE, "§bEpee des Glaces", false, 1, "§fUn bout de glace solidifié par la magie ambiante", "E"))) {
			return 3;
		}else if(item.equals(getWeaponDrop(Material.WOODEN_SWORD, "§7Epee de Voyageur", false, 1, "§fUn simple manche bois à laquel est accroché de la pierre taillé", "F"))) {
			return 4;
		}else if(item.equals(getWeaponDrop(Material.WOODEN_AXE, "§cEpee fracture en Granite", false, 1, "§fL'épée en granite mais en moins bien", "F"))) {
			return 5;
		}else if(item.equals(getWeaponDrop(Material.WOODEN_SWORD, "§bBaton de l Eau pur", false, 1, "§fBâton crystallisé par le mana humide ambiant avec le temps", "C"))) {
			return 6;
		}else if(item.getItemMeta().getDisplayName().equals(ItemBeginnerOrb.getWeapon().getItemMeta().getDisplayName())) {
			return 7;
		}else if(item.getItemMeta().getDisplayName().equals(ItemPoisonousSword.getWeapon().getItemMeta().getDisplayName())) {
			return 8;}
		else if(item.getItemMeta().getDisplayName().equals(ItemDawnSword.getWeapon().getItemMeta().getDisplayName())) {
			return 9;}
		return 0;
	}
	
	public static List<Integer> getSpellLootOfMob(String name, int difficulty){
		List<Integer> loots = new ArrayList<Integer>();
		
		double m = 1;
		switch(difficulty) {
		case 1:  m = 0.5;
			break;
		case 2: m = 1;
			break;
		case 3: m = 1.25;
			break;
		case 4: m = 1.75;
			break;
		}
		
		switch(name) {	
		case "GRANITE_KING_SQUELETON":
			if(RandomNumber(1,1000) <= 10) {loots.add(4);}
			break;
		case "BUSH_GOLEM":
			if(RandomNumber(1,1000) <= 10) {loots.add(4);}
			break;
		}
		
		return loots;
	}
	
	public static List<ItemStack> getWeaponLootOfMob(String name, int difficulty) {
		
		List<ItemStack> loots = new ArrayList<ItemStack>();
		
		double m = 1;
		switch(difficulty) {
		case 1:  m = 0.5;
			break;
		case 2: m = 1;
			break;
		case 3: m = 1.25;
			break;
		case 4: m = 1.75;
			break;
		}
		
		switch(name) {
		case "GRANITE_KNIGHT_SQUELETON":
			if(RandomNumber(1,1000) <= 5*m) {loots.add(LootUtils.getWeaponById(1));}
			break;	
		case "GRANITE_KING_SQUELETON":
			if(RandomNumber(1,100) <= 10*m) {loots.add(LootUtils.getWeaponById(1));}
			break;
		case "BUSH_ZOMBIE":
			if(RandomNumber(1,1000) <= 10*m) {loots.add(LootUtils.getWeaponById(8));}
			break;
		case "BUSH_SQUELETON":
			if(RandomNumber(1,1000) <= 10*m) {loots.add(LootUtils.getWeaponById(8));}
			break;
		case "BUSH_GOLEM":
			if(RandomNumber(1,1000) <= 15) {loots.add(LootUtils.getWeaponById(9));}
			break;
		}
		
		return loots;
	}
	
	public static List<ItemStack> getLootOfMob(String name, int difficulty) {
		
		List<ItemStack> loots = new ArrayList<ItemStack>();
		
		double m = 1;
		switch(difficulty) {
		case 1:  m = 0.5;
			break;
		case 2: m = 1;
			break;
		case 3: m = 1.25;
			break;
		case 4: m = 1.75;
			break;
		}
		
		switch(name) {
		case "BUSH_ZOMBIE":
			if(RandomNumber(1,100) <= 50 * m) {loots.add(LootUtils.getLootById(1));}
			if(RandomNumber(1,100) <= 10 * m) {loots.add(LootUtils.getLootById(3));}
			if(RandomNumber(1,100) <= 30 * m) {loots.add(LootUtils.getLootById(5));}
			break;
		case "BUSH_SQUELETON":
			if(RandomNumber(1,100) <= 50 * m) {loots.add(LootUtils.getLootById(1));}
			if(RandomNumber(1,100) <= 10 * m) {loots.add(LootUtils.getLootById(3));}
			if(RandomNumber(1,100) <= 30 * m) {loots.add(LootUtils.getLootById(5));}
			break;
		case "GRANITE_KNIGHT_SQUELETON":
			if(RandomNumber(1,100) <= 50 * m) {loots.add(LootUtils.getLootById(2));}
			break;	
		case "GRANITE_ARCHER_SQUELETON":
			if(RandomNumber(1,100) <= 50 * m) {loots.add(LootUtils.getLootById(2));}
			break;
		case "GRANITE_KING_SQUELETON":
			if(RandomNumber(1,100) <= 100 * m) {loots.add(LootUtils.getLootById(2));}
			if(RandomNumber(1,100) <= 70 * m) {loots.add(LootUtils.getLootById(5));}
			break;
		case "BUSH_PHANTOM":
			if(RandomNumber(1,100) <= 50 * m) {loots.add(LootUtils.getLootById(1));}
			if(RandomNumber(1,100) <= 15 * m) {loots.add(LootUtils.getLootById(4));}
			break;
		case "BUSH_GOLEM":
			if(RandomNumber(1,100) <= 70 * m) {loots.add(LootUtils.getLootById(5));}
			if(RandomNumber(1,100) <= 75 * m) {loots.add(LootUtils.getLootById(3));}
			break;
		}
		
		
		
		return loots;
	}
	
	public static int getLootAmplifier(int difficulty) {
		
		return difficulty;
	}
	
	
	public static ItemStack getDrop(Material material, String customName, boolean EnchantEffect, int nbr, String description, String rarety) {
		
		ItemStack item = new ItemStack(material, nbr);
		ItemMeta itemMeta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(description);
		lore.add("§fRareté : " + rarety);
		itemMeta.setLore(lore);
		if(customName != null) {itemMeta.setDisplayName(customName);}
		if(EnchantEffect) {itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 200, true);itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);}
		item.setItemMeta(itemMeta);
		
		
		return item;
		
	}
	
	public static ItemStack getWeaponDrop(Material material, String customName, boolean EnchantEffect, int nbr, String description, String rarety) {
		
		ItemStack item = new ItemStack(material, nbr);
		ItemMeta itemMeta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(description);
		lore.add("§fRank : " + rarety);
		itemMeta.setLore(lore);
		if(customName != null) {itemMeta.setDisplayName(customName);}
		if(EnchantEffect) {itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 200, true);itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);}
		itemMeta.setUnbreakable(true);
		item.setItemMeta(itemMeta);
		
		
		return item;
		
	}
	
	private static int RandomNumber(int Min , int Max)
    {
		if(Min == Max) {return Max;}
		Min = Min-1;
    	Random rand = new Random();
    	int randomNbr = rand.nextInt(Max - Min) + Min;
    	
    	if(randomNbr > Max){randomNbr = Max;}
    	if(randomNbr <= Min){randomNbr = Max;}
    return randomNbr;}
	
	public static void addItemsToRessources(Player player, List<ItemStack> items) {
		
		List<String> ids = PlayerEquipment.getPlayerEquipment().getRessources(player);
		
		for (int j = 0; j < items.size(); j++) {
			boolean contain = false;
			for (int i = 0; i < ids.size(); i++) {
				
				String build = getIdByLoot(items.get(j)) + ":";
				if(ids.get(i).contains(build)) {
					
					int decimal = Integer.parseInt(ids.get(i).split("\\:")[1]);
					decimal = decimal + items.get(j).getAmount();
					build = build + decimal;
					ids.set(i, build);
					contain = true;
				}
					
			}
			if(!contain) {
				ids.add(getIdByLoot(items.get(j)) + ":" + items.get(j).getAmount());
			}
		}
		
		PlayerEquipment.getPlayerEquipment().setRessources(player, ids);
		
	}
	
	public static void removeItemsOfRessources(Player player, List<ItemStack> items) {
		
		List<String> ids = PlayerEquipment.getPlayerEquipment().getRessources(player);
		
		for (int j = 0; j < items.size(); j++) {
			for (int i = 0; i < ids.size(); i++) {
				
				String build = getIdByLoot(items.get(j)) + ":";
				if(ids.get(i).contains(build)) {
					
					int decimal = Integer.parseInt(ids.get(i).split("\\:")[1]);
					if(decimal > items.get(j).getAmount()) {
						decimal = decimal - items.get(j).getAmount();
						build = build + decimal;
						ids.set(i, build);
					}else {
						ids.remove(i);
					}
						
				}
					
			}
		}
		
		PlayerEquipment.getPlayerEquipment().setRessources(player, ids);
		
	}
	
	public static boolean hasRessource(Player player, ItemStack ressource) {
		
		boolean has = false;
		List<String> ids = PlayerEquipment.getPlayerEquipment().getRessources(player);
		
			for (int i = 0; i < ids.size(); i++) {
				
				String build = getIdByLoot(ressource) + ":";
				if(ids.get(i).contains(build)) {
					int decimal = Integer.parseInt(ids.get(i).split("\\:")[1]);
					if(decimal >= ressource.getAmount()) 
					has = true;
				}
					
			}
		
		return has;
	}
	
	public static boolean hasRessources(Player player, List<ItemStack> ressources) {
		
		boolean has = true;
		
		for (ItemStack item : ressources) {
			if(!hasRessource(player,item)) has = false;
		}
		
		return has;
		
	}

}
