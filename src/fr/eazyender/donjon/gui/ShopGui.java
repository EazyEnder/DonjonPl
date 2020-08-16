package fr.eazyender.donjon.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopGui implements Listener{
	
	public static void createGui(Player player) {
		
		Inventory inv = Bukkit.createInventory(null, 27 , "§f§lChromas : §8" + player.getDisplayName());
		
		List<String> str_essence = new ArrayList<String>();
		str_essence.add("§fRegardez les prix afin d'acheter la monnaie payante");
		str_essence.add("§fAchat sur le discord via ticket");
		ItemStack essence = getCustomItemWithLore(Material.STICK,"§f§lEssences",false,1,str_essence);
		inv.setItem(4, essence);
		
		List<String> str_grades = new ArrayList<String>();
		str_grades.add("§fAchetez un grade par mois ou à vie");
		str_grades.add("§fafin de profiter de cosmétiques");
		ItemStack grades = getCustomItemWithLore(Material.STICK,"§f§lGrades",false,1,str_grades);
		inv.setItem(22, grades);
		
		List<String> str_chroma = new ArrayList<String>();
		str_chroma.add("§fProcurez vous de quoi changer la couleur");
		str_chroma.add("§fd'un type de sort");
		ItemStack chroma = getCustomItemWithLore(Material.STICK,"§f§lChromatique",false,1,str_chroma);
		inv.setItem(13, chroma);
		
		List<String> str_boostxp = new ArrayList<String>();
		str_boostxp.add("§fAmeliorez votre gain d'expérience");
		str_boostxp.add("§fpendant un laps de temps");
		ItemStack boostxp = getCustomItemWithLore(Material.STICK,"§f§lBoost Xp",false,1,str_boostxp);
		inv.setItem(14, boostxp);
		
		List<String> str_cosplays = new ArrayList<String>();
		str_cosplays.add("§fEquippez vous d'effets cosmétiques");
		ItemStack cosplays = getCustomItemWithLore(Material.STICK,"§f§lCosmetiques",false,1,str_cosplays);
		inv.setItem(12, cosplays);
		
		player.openInventory(inv);
		
	}
	
	public static void openEssenceShop(Player player) {
		
		Inventory inv = Bukkit.createInventory(null, 18 , "§f§lShop Essence : §8" + player.getDisplayName());
		
		List<String> str_essence = new ArrayList<String>();
		str_essence.add("§fRegardez les prix afin d'acheter la monnaie payante");
		str_essence.add("§fAchat sur le discord via ticket");
		ItemStack essence = getCustomItemWithLore(Material.STICK,"§f§lEssences",false,1,str_essence);
		inv.setItem(4, essence);
	
		
		for (int i = inv.getSize()-9; i < inv.getSize(); i++) {
			if(i != inv.getSize()-5) {
			inv.setItem(i, getCustomItemWithLore(Material.BLACK_STAINED_GLASS_PANE, "§8§l", false, 1, null));
			}
			else {
			inv.setItem(i, getCustomItemWithLore(Material.BARRIER, "§4§lREVENIR AU MENU", false, 1, null));	
			}
		}
		
		player.openInventory(inv);
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		if(current != null) {
			
			if(event.getView().getTitle().equals("§f§lChromas : §8" + player.getDisplayName())) {
				
				List<String> str_essence = new ArrayList<String>();
				str_essence.add("§fRegardez les prix afin d'acheter la monnaie payante");
				str_essence.add("§fAchat sur le discord via ticket");
				ItemStack essence = getCustomItemWithLore(Material.STICK,"§f§lEssences",false,1,str_essence);
				List<String> str_grades = new ArrayList<String>();
				str_grades.add("§fAchetez un grade par mois ou à vie");
				str_grades.add("§fafin de profiter de cosmétiques");
				ItemStack grades = getCustomItemWithLore(Material.STICK,"§f§lGrades",false,1,str_grades);
				List<String> str_chroma = new ArrayList<String>();
				str_chroma.add("§fProcurez vous de quoi changer la couleur");
				str_chroma.add("§fd'un type de sort");
				ItemStack chroma = getCustomItemWithLore(Material.STICK,"§f§lChromatique",false,1,str_chroma);
				List<String> str_boostxp = new ArrayList<String>();
				str_boostxp.add("§fAmeliorez votre gain d'expérience");
				str_boostxp.add("§fpendant un laps de temps");
				ItemStack boostxp = getCustomItemWithLore(Material.STICK,"§f§lBoost Xp",false,1,str_boostxp);
				List<String> str_cosplays = new ArrayList<String>();
				str_cosplays.add("§fEquippez vous d'effets cosmétiques");
				ItemStack cosplays = getCustomItemWithLore(Material.STICK,"§f§lCosmetiques",false,1,str_cosplays);
				
				if(current.equals(essence)) {
					openEssenceShop(player);
				}else if(current.equals(grades)) {
					
				}else if(current.equals(chroma)) {
					ShopSpellChromaGui.openMain(player);
				}else if(current.equals(boostxp)) {
					
				}else if(current.equals(cosplays)) {
					
				}
				
				event.setCancelled(true);
			}else if(event.getView().getTitle().equals("§f§lShop Essence : §8" + player.getDisplayName())){
				
				if(current.getType().equals(Material.BARRIER)) createGui(player);
				
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
