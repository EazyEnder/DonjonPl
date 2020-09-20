package fr.eazyender.donjon.donjon;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RessourceUtils {
	
	public static ItemStack getRessourceById(int id) {
		ItemStack item = null;
		switch(id) {
		case 1: item = getRessource(Material.STICK, "§fPetite fiole basique", false, 1, "§fUne petite fiole crée à partir de cristaux de terre", "Commun");
			break;
		case 2: item = getRessource(Material.STICK, "§fMoyenne fiole basique", false, 1, "§fUne moyenne fiole crée à partir de cristaux de terre", "Commun");
			break;
		}
		
		return item;
	}
	
	public static int getIdByRessource(ItemStack item) {
		int id = 0;
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(getRessource(Material.STICK, "§fPetite fiole basique", false, 1, "§fUne petite fiole crée à partir de cristaux de terre", "Commun"));
		items.add(getRessource(Material.STICK, "§fMoyenne fiole basique", false, 1, "§fUne moyenne fiole crée à partir de cristaux de terre", "Commun"));
		
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i).equals(item)) {
				id = i+1;
			}
		}
		
		return id;
	}
	
	public static ItemStack getRessource(Material material, String customName, boolean EnchantEffect, int nbr, String description, String rarety) {
		
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

}
