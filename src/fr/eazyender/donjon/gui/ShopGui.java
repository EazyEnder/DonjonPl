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

import fr.eazyender.donjon.donjon.DonjonEvents;
import fr.eazyender.donjon.files.PlayerChromatiques;
import fr.eazyender.donjon.files.PlayerEconomy;
import fr.eazyender.donjon.files.PlayerShop;
import fr.eazyender.donjon.spells.ColorUtils;

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
	
	public static void openGradeShop(Player player) {
		
		Inventory inv = Bukkit.createInventory(null, 27 , "§f§lShop Grades : §8" + player.getDisplayName());
		
		List<String> str_ange = new ArrayList<String>();
		str_ange.add("§f§lPrix : §7500E");
		str_ange.add("§fVous obtenez : ");
		str_ange.add("§f > Angel Box hebdomadaire");
		str_ange.add("§f > Grade sur le discord et serveur");
		str_ange.add("§f > 100E hebdomadaire");
		str_ange.add("§f > Costume : Poussière des cieux");
		str_ange.add("§f§lType : §7Cycle de 31 jours");
		ItemStack angeM = getCustomItemWithLore(Material.PAPER,"§f§lGrade : ANGE(MENSUEL)",false,1,str_ange);
		inv.setItem(0, angeM);
		str_ange.set(0,"§f§lPrix : §715€");
		str_ange.set(6,"§f§lType : §7A vie");
		ItemStack ange = getCustomItemWithLore(Material.PAPER,"§f§lGrade : ANGE(VIE)",false,1,str_ange);
		inv.setItem(6, ange);
		
		System.out.println(System.currentTimeMillis() + "    " + PlayerShop.getPlayerShopProfil().getTimeBuy(player)+(60*60*24*31*1000));
		long timerleft = (PlayerShop.getPlayerShopProfil().getTimeBuy(player)+(2678400000L) - System.currentTimeMillis()) / 1000;
		
		List<String> loreacquis = new ArrayList<String>();
		loreacquis.add("§fVous avez le grade, merci pour le soutien");
		if(timerleft != ((2678400000L) - System.currentTimeMillis()) / 1000) {
			
			long seconde = timerleft % 60;
			long minute = (long) (timerleft / 60);
			long heure = (long)(minute / 60);
			long day = (long)(heure / 24);
			minute = minute - heure * 60;
			heure = heure - day * 24;
			loreacquis.add("§fTemps restant : " + day + "d" + heure + "h" + minute + "min" + seconde + "s");
		}
		ItemStack acquis = getCustomItemWithLore(Material.STICK, "§2§lAcquis", false, 1, loreacquis);
		
		List<String> lorenoacquis = new ArrayList<String>();
		lorenoacquis.add("§fCliquez sur ce bouton pour le débloquer");
		lorenoacquis.add("§7Aucun remboursement n'est possible !");
		ItemStack nonacquis = getCustomItemWithLore(Material.STICK, "§4§lNon Acquis", false, 1, lorenoacquis);
		List<String> buydiscordl = new ArrayList<String>();
		buydiscordl.add("§fPaiement du grade via le bot discord");
		buydiscordl.add("§7Suivez les procédures pour obtenir le grade sous 24H");
		ItemStack buydiscord = getCustomItemWithLore(Material.STICK, "§4§lPaiement par Discord", false, 1, buydiscordl);
		if(PlayerShop.getPlayerShopProfil().getGrade(player) == 1) {
			inv.setItem(9, acquis);
			inv.setItem(10, nonacquis);
			inv.setItem(11, nonacquis);
			inv.setItem(15, buydiscord);
			inv.setItem(16, buydiscord);
			inv.setItem(17, buydiscord);
		}else if(PlayerShop.getPlayerShopProfil().getGrade(player) == 2){
			inv.setItem(9, nonacquis);
			inv.setItem(10, acquis);
			inv.setItem(11, nonacquis);
			inv.setItem(15, buydiscord);
			inv.setItem(16, buydiscord);
			inv.setItem(17, buydiscord);
		}else if(PlayerShop.getPlayerShopProfil().getGrade(player) == 3){
			inv.setItem(9, nonacquis);
			inv.setItem(10, nonacquis);
			inv.setItem(11, acquis);
			inv.setItem(15, buydiscord);
			inv.setItem(16, buydiscord);
			inv.setItem(17, buydiscord);
		}else if(PlayerShop.getPlayerShopProfil().getGrade(player) == 1 && PlayerShop.getPlayerShopProfil().getTimeBuy(player) <= 0){
			inv.setItem(9, nonacquis);
			inv.setItem(10, nonacquis);
			inv.setItem(11, nonacquis);
			inv.setItem(15, acquis);
			inv.setItem(16, buydiscord);
			inv.setItem(17, buydiscord);
		}else if(PlayerShop.getPlayerShopProfil().getGrade(player) == 1 && PlayerShop.getPlayerShopProfil().getTimeBuy(player) <= 0){
			inv.setItem(9, nonacquis);
			inv.setItem(10, nonacquis);
			inv.setItem(11, nonacquis);
			inv.setItem(15, buydiscord);
			inv.setItem(16, acquis);
			inv.setItem(17, buydiscord);
		}else if(PlayerShop.getPlayerShopProfil().getGrade(player) == 1 && PlayerShop.getPlayerShopProfil().getTimeBuy(player) <= 0){
			inv.setItem(9, nonacquis);
			inv.setItem(10, nonacquis);
			inv.setItem(11, nonacquis);
			inv.setItem(15, buydiscord);
			inv.setItem(16, buydiscord);
			inv.setItem(17, acquis);
		}else {
			inv.setItem(9, nonacquis);
			inv.setItem(10, nonacquis);
			inv.setItem(11, nonacquis);
			inv.setItem(15, buydiscord);
			inv.setItem(16, buydiscord);
			inv.setItem(17, buydiscord);
		}

		List<String> str_essence = new ArrayList<String>();
		str_essence.add("§fRegardez les prix afin d'acheter la monnaie payante");
		str_essence.add("§fAchat sur le discord via ticket");
		ItemStack essence = getCustomItemWithLore(Material.STICK,"§f§lEssences",false,1,str_essence);
		inv.setItem(4+9, essence);
		
		List<String> str_archange = new ArrayList<String>();
		str_archange.add("§f§lPrix : §71000E");
		str_archange.add("§fVous obtenez : ");
		str_archange.add("§f > Archange Box hebdomadaire");
		str_archange.add("§f > Grade sur le discord et serveur");
		str_archange.add("§f > 200E hebdomadaire");
		str_archange.add("§f > Costume : Auréole divin");
		str_archange.add("§f > Customisation de donjon");
		str_archange.add("§f§lType : §7Cycle de 31 jours");
		ItemStack archangeM = getCustomItemWithLore(Material.PAPER,"§f§lGrade : Archange(MENSUEL)",false,1,str_archange);
		inv.setItem(1, archangeM);
		str_archange.set(0,"§f§lPrix : §730€");
		str_archange.set(7,"§f§lType : §7A vie");
		ItemStack archange = getCustomItemWithLore(Material.PAPER,"§f§lGrade : Archange(VIE)",false,1,str_archange);
		inv.setItem(7, archange);
		
		List<String> str_seraphin = new ArrayList<String>();
		str_seraphin.add("§f§lPrix : §72000E");
		str_seraphin.add("§fVous obtenez : ");
		str_seraphin.add("§f > Seraphin Box hebdomadaire");
		str_seraphin.add("§f > Grade sur le discord et serveur");
		str_seraphin.add("§f > 400E hebdomadaire");
		str_seraphin.add("§f > Costume : Ailes angéliques(+precedent)");
		str_seraphin.add("§f > Customisation de donjon");
		str_seraphin.add("§f§lType : §7Cycle de 31 jours");
		ItemStack seraphinM = getCustomItemWithLore(Material.PAPER,"§f§lGrade : Seraphin(MENSUEL)",false,1,str_seraphin);
		inv.setItem(2, seraphinM);
		str_seraphin.set(0,"§f§lPrix : §760€");
		str_seraphin.set(7,"§f§lType : §7A vie");
		ItemStack seraphin = getCustomItemWithLore(Material.PAPER,"§f§lGrade : Seraphin(VIE)",false,1,str_seraphin);
		inv.setItem(8, seraphin);
	
		
		inv.setItem(4, getCustomItemWithLore(Material.BLACK_STAINED_GLASS_PANE, "§8§l", false, 1, null));
		
		
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
					openGradeShop(player);
				}else if(current.equals(chroma)) {
					ShopSpellChromaGui.openMain(player);
				}else if(current.equals(boostxp)) {
					
				}else if(current.equals(cosplays)) {
					
				}
				
				event.setCancelled(true);
			}else if(event.getView().getTitle().equals("§f§lShop Essence : §8" + player.getDisplayName())){
				
				if(current.getType().equals(Material.BARRIER)) createGui(player);
				
				event.setCancelled(true);
			}else if(event.getView().getTitle().equals("§f§lShop Grades : §8" + player.getDisplayName())){
				
				if(current.getType().equals(Material.BARRIER)) createGui(player);
				else if(current.getItemMeta().getDisplayName().equals("§f§lEssences")) openEssenceShop(player);
				else if(current.getType().equals(Material.STICK)) {
					if(current.getItemMeta().getDisplayName().equals("§4§lNon Acquis")) {
						int price = 0;
						switch(event.getSlot()) {
						case 9: price = 500;
							break;
						case 10: price = 1000;
							break;
						case 11: price = 2000;
							break;
						}
						if(PlayerEconomy.getEconomy().getEssences(player) > price) {
							//ACHAT
							PlayerEconomy.getEconomy().setEssences(player,PlayerEconomy.getEconomy().getEssences(player)-price);
							switch(event.getSlot()) {
							case 9: PlayerShop.getPlayerShopProfil().setGrade(player, 1);
							player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
							player.sendMessage("§f§lVotre achat a bien été pris en compte");
							PlayerShop.getPlayerShopProfil().setTimeBuy(player, System.currentTimeMillis());;
								break;
							case 10: PlayerShop.getPlayerShopProfil().setGrade(player, 2);
							player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
							player.sendMessage("§f§lVotre achat a bien été pris en compte");
							PlayerShop.getPlayerShopProfil().setTimeBuy(player, System.currentTimeMillis());;
								break;
							case 11: PlayerShop.getPlayerShopProfil().setGrade(player, 3);
							player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
							player.sendMessage("§f§lVotre achat a bien été pris en compte");
							PlayerShop.getPlayerShopProfil().setTimeBuy(player, System.currentTimeMillis());;
								break;
							}
							openGradeShop(player);
						}
					}
				}
				
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
