package fr.eazyender.donjon.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import fr.eazyender.donjon.files.PlayerChromatiques;
import fr.eazyender.donjon.files.PlayerEconomy;
import fr.eazyender.donjon.spells.ColorUtils;

public class ShopSpellChromaGui implements Listener{
	
	public static Map<Player, List<Integer>> chromas_choose = new HashMap<Player, List<Integer>>();
	
	public static void openMain(Player player) {
		
		Inventory inv = Bukkit.createInventory(null, 18 , "§f§lChromas : §8" + player.getDisplayName());
		
		List<String> lore = new ArrayList<String>();
		//lore.add("§fChromas disponible : " + ColorUtils.earthskins.size());
		ItemStack chroma = getCustomItemWithLore(Material.STICK, "§6§lTerre", false, 1, lore);
		inv.setItem(1, chroma);
		
		List<String> lore1 = new ArrayList<String>();
		lore1.add("§fChromas disponibles : " + ColorUtils.fireskins.size());
		ItemStack chroma1 = getCustomItemWithLore(Material.STICK, "§4§lFeu", false, 1, lore1);
		inv.setItem(2, chroma1);
		
		List<String> lore2 = new ArrayList<String>();
		//lore2.add("§fChromas disponibles : " + ColorUtils.waterskins.size());
		ItemStack chroma2 = getCustomItemWithLore(Material.STICK, "§3§lEau", false, 1, lore2);
		inv.setItem(3, chroma2);
		
		List<String> lore3 = new ArrayList<String>();
		//lore3.add("§fChromas disponibles : " + ColorUtils.windskins.size());
		ItemStack chroma3 = getCustomItemWithLore(Material.STICK, "§7§lVent", false, 1, lore3);
		inv.setItem(4, chroma3);
		
		List<String> lore4 = new ArrayList<String>();
		//lore4.add("§fChromas disponibles : " + ColorUtils.poisonskins.size());
		ItemStack chroma4 = getCustomItemWithLore(Material.STICK, "§2§lPoison", false, 1, lore4);
		inv.setItem(5, chroma4);
		
		List<String> lore5 = new ArrayList<String>();
		//lore5.add("§fChromas disponibles : " + ColorUtils.shadowskins.size());
		ItemStack chroma5 = getCustomItemWithLore(Material.STICK, "§5§lTenebre", false, 1, lore5);
		inv.setItem(6, chroma5);
		
		List<String> lore6 = new ArrayList<String>();
		//lore6.add("§fChromas disponibles : " + ColorUtils.lightskins.size());
		ItemStack chroma6 = getCustomItemWithLore(Material.STICK, "§e§lLumiere", false, 1, lore6);
		inv.setItem(7, chroma6);
		
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
	
	public static void openFireGui(Player player){
		
		Inventory inv = Bukkit.createInventory(null, 27 , "§f§lChromas(Feu) : §8" + player.getDisplayName());
		
		for (int i = 0; i < ColorUtils.fireskins.size(); i++) {
			
			List<String> lore = new ArrayList<String>();
			lore.add("§fPrix : " + ColorUtils.fireprice.get(i) + "§bE");
			
			if(PlayerChromatiques.getPlayerChromatiques().getFireChromas(player).size() > i) {
				if(PlayerChromatiques.getPlayerChromatiques().getFireChromas(player).get(i)) {
					List<String> loreacquis = new ArrayList<String>();
					lore.add("§fVous §2possédez§f le chromatique");
					loreacquis.add("§fCliquez sur la feuille de papier pour l'équiper");
					ItemStack acquis = getCustomItemWithLore(Material.STICK, "§2§lAcquis", false, 1, loreacquis);
					inv.setItem(i+9, acquis);
				}else {
					List<String> lorenoacquis = new ArrayList<String>();
					lore.add("§fVous §cne possédez pas§f le chromatique");
					lorenoacquis.add("§fCliquez sur ce bouton pour le débloquer");
					lorenoacquis.add("§7Aucun remboursement n'est possible !");
					ItemStack nonacquis = getCustomItemWithLore(Material.STICK, "§4§lNon Acquis", false, 1, lorenoacquis);
					inv.setItem(i+9, nonacquis);
				}
			}
			
			ItemStack chroma = getCustomItemWithLore(Material.PAPER, ColorUtils.firename.get(i), false, 1, lore);
			if(chromas_choose.containsKey(player)) {
				if(chromas_choose.get(player).get(1) == i+1) {
			chroma = getCustomItemWithLore(Material.PAPER, ColorUtils.firename.get(i), true, 1, lore);
				}
			}
			inv.setItem(i, chroma);
		}
		
		for (int i = inv.getSize()-9; i < inv.getSize(); i++) {
			if(i != inv.getSize()-5) {
			inv.setItem(i, getCustomItemWithLore(Material.BLACK_STAINED_GLASS_PANE, "§8§l", false, 1, null));
			}
			else {
			inv.setItem(i, getCustomItemWithLore(Material.BARRIER, "§4§lRETOURNER DANS LE MENU", false, 1, null));	
			}
		}
		
		player.openInventory(inv);
		
	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		if(current != null && event.getView().getTitle().equals("§f§lChromas : §8" + player.getDisplayName())) {
			
			if(current.getType().equals(Material.BARRIER)) ShopGui.createGui(player);
			else if(current.getItemMeta().getDisplayName().equals("§4§lFeu")) openFireGui(player);
			
			event.setCancelled(true);
		}else if(current != null && event.getView().getTitle().equals("§f§lChromas(Feu) : §8" + player.getDisplayName())) {
			
			if(current.getType().equals(Material.PAPER)) {
				
				for (int i = 0; i < ColorUtils.fireskins.size(); i++) {
					
					String name = ColorUtils.firename.get(i);
					if(current.getItemMeta().getDisplayName().equals(name)) {
						if(PlayerChromatiques.getPlayerChromatiques().getFireChromas(player).size() > i) {
							if(PlayerChromatiques.getPlayerChromatiques().getFireChromas(player).get(i)) {
								if(!chromas_choose.containsKey(player)) { 
									List<Integer> base = new ArrayList<Integer>();
									for (int j = 0; j < 7; j++) {
										base.add(0);
									}
									chromas_choose.put(player, base);
								}
								List<Integer> chromas = chromas_choose.get(player);
								chromas.set(1, i+1);
								chromas_choose.replace(player, chromas);
								ColorUtils.getSkins().get(player).set(1, ColorUtils.fireskins.get(i));
								openFireGui(player);
							}else {
								
							}
						}
					}
					
				}
				
			}else if(current.getType().equals(Material.STICK)) {
				if(current.getItemMeta().getDisplayName().equals("§4§lNon Acquis")) {
					if(PlayerEconomy.getEconomy().getEssences(player) > ColorUtils.fireprice.get(event.getSlot()-9)) {
						//ACHAT
						PlayerEconomy.getEconomy().setEssences(player,PlayerEconomy.getEconomy().getEssences(player)-ColorUtils.fireprice.get(event.getSlot()-9));
						List<Boolean> chromas =  PlayerChromatiques.getPlayerChromatiques().getFireChromas(player);
						chromas.set(event.getSlot()-9, true);
						PlayerChromatiques.getPlayerChromatiques().setFireChromas(player, chromas);
						openFireGui(player);
					}
				}
			}else if(current.getType().equals(Material.BARRIER))openMain(player);
			
			event.setCancelled(true);
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
