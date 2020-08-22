package fr.eazyender.donjon.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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

import fr.eazyender.donjon.donjon.DonjonGenerator;
import fr.eazyender.donjon.donjon.RoomUtils;

public class DonjonGui implements Listener {
	
	public static void createGui(Player player){
		
		Inventory inv = Bukkit.createInventory(null, 9 , "�f�lDonjon : �8" + player.getDisplayName());
		
		List<String> str_donjon = new ArrayList<String>();
		str_donjon.add("�7Combattez�f des �7monstres�f dans un donjon");
		str_donjon.add("�f al�atoire afin de monter en �7puissance�f !");
		str_donjon.add("�7Donjons lanc�s : " + DonjonGenerator.donjons.size());
		str_donjon.add("�7Biomes diff�rents : " + RoomUtils.getNumberOfBiomes());
		ItemStack donjon = getCustomItemWithLore(Material.STICK,"�f�lDonjon",false,1,str_donjon);
		inv.setItem(3, donjon);
		
		List<String> str_custom = new ArrayList<String>();
		str_custom.add("�7Modifier�f les �7param�tres�f � volont�");
		str_custom.add("�fAfin de proposer un �7d�fi�f maximum � vous");
		str_custom.add("�f et � vos amis !");
		ItemStack custom = getCustomItemWithLore(Material.STICK,"�f�lDonjon personnalise",false,1,str_custom);
		inv.setItem(5, custom);

		player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
		player.openInventory(inv);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		if(current != null && event.getView().getTitle().contains("Donjon")) {
			
			List<String> str_donjon = new ArrayList<String>();
			str_donjon.add("�7Combattez�f des �7monstres�f dans un donjon");
			str_donjon.add("�f al�atoire afin de monter en �7puissance�f !");
			str_donjon.add("�7Donjons lanc�s : " + DonjonGenerator.donjons.size());
			str_donjon.add("�7Biomes diff�rents : " + RoomUtils.getNumberOfBiomes());
			ItemStack donjon = getCustomItemWithLore(Material.STICK,"�f�lDonjon",false,1,str_donjon);	
			List<String> str_custom = new ArrayList<String>();
			str_custom.add("�7Modifier�f les �7param�tres�f � volont�");
			str_custom.add("�fAfin de proposer un �7d�fi�f maximum � vous");
			str_custom.add("�f et � vos amis !");
			ItemStack custom = getCustomItemWithLore(Material.STICK,"�f�lDonjon personnalise",false,1,str_custom);
			
			ItemStack right = getCustomItemWithLore(Material.STICK,"�f�l==>",false,1,null);
			ItemStack left = getCustomItemWithLore(Material.STICK,"�f�l<==",false,1,null);
			ItemStack launch = getCustomItemWithLore(Material.STICK,"�2�lValider",false,1,null);
			
			if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon : �8" + player.getDisplayName())) {
				
				if(current.equals(donjon)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,0,0);
				}else if(current.equals(custom)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					//open(player,2);
				}
			
				
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection: �8" + player.getDisplayName())) {
				
				List<String> str_donjon_1 = new ArrayList<String>();
				str_donjon_1.add("�7Explorez�f une grotte remplis de �7verdure�f !");
				str_donjon_1.add("�7Donjons lanc�s : " + RoomUtils.getLaunchDonjonOnABiome(1));
				str_donjon_1.add("�7Salles diff�rentes : " + RoomUtils.getRoomsOfABiome(1).size());
				ItemStack donjon_1 = getCustomItemWithLore(Material.STICK,"�2�lGrotte Verdoyante",false,1,str_donjon_1);
				List<String> str_donjon_2 = new ArrayList<String>();
				str_donjon_2.add("�7D�couvrez�f des tunnels �7glaciales�f et dangereux !");
				str_donjon_2.add("�7Donjons lanc�s : " + RoomUtils.getLaunchDonjonOnABiome(2));
				str_donjon_2.add("�7Salles diff�rentes : " + RoomUtils.getRoomsOfABiome(2).size());
				ItemStack donjon_2 = getCustomItemWithLore(Material.STICK,"�b�lTunnel Enneige",false,1,str_donjon_2);
				List<String> str_donjon_3 = new ArrayList<String>();
				str_donjon_3.add("�7Visiter�f d'anciens passages �7d�sertiques�f !");
				str_donjon_3.add("�7Donjons lanc�s : " + RoomUtils.getLaunchDonjonOnABiome(3));
				str_donjon_3.add("�7Salles diff�rentes : " + RoomUtils.getRoomsOfABiome(3).size());
				ItemStack donjon_3 = getCustomItemWithLore(Material.STICK,"�6�lDesert Ancien",false,1,str_donjon_3);
				
				if(current.equals(donjon_1)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,1,1);
				}else if(current.equals(donjon_2)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,2,1);
				}else if(current.equals(donjon_3)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,3,1);
				}
			}
			
			else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[1][1]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
				}else if(current.equals(right)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,1,2);
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 1, 1);
				}
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[1][2]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,1,1);
				}else if(current.equals(right)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,1,3);
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 1, 2);
				}
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[1][3]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,1,2);
				}else if(current.equals(right)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,1,4);
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 1, 3);
				}
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[1][4]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,1,3);
				}else if(current.equals(right)) {
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 1, 4);
				}
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[2][1]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
				}else if(current.equals(right)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,2,2);
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 2, 1);
				}
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[2][2]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,2,1);
				}else if(current.equals(right)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,2,3);
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 2, 2);
				}
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[2][3]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,2,2);
				}else if(current.equals(right)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,2,4);
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 2, 3);
				}
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[2][4]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,2,3);
				}else if(current.equals(right)) {
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 2, 4);
				}
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[3][1]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
				}else if(current.equals(right)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,3,2);
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 3, 1);
				}
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[3][2]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,3,1);
				}else if(current.equals(right)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,3,3);
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 3, 2);
				}
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[3][3]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,3,2);
				}else if(current.equals(right)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,3,4);
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 3, 3);
				}
			}else if(event.getView().getTitle().equalsIgnoreCase("�f�lDonjon Selection[3][4]: �8" + player.getDisplayName())) {
				
				if(current.equals(left)) {
					player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
					openDonjonMenu(player,3,3);
				}else if(current.equals(right)) {
				}else if(current.getType() == Material.BARRIER) {player.teleport(new Location(player.getWorld(),-7.55, 127.00, -16.82, -90, 0));player.closeInventory();}
				else if(current.equals(launch)) {
					DonjonGenerator.launchDonjon(player, 3, 4);
				}
			}
			event.setCancelled(true);
			
		}
		
	}
	
	private static void openDonjonMenu(Player player,int biome, int difficulty) {
		
		if(difficulty == 0) {
			
			Inventory inv = Bukkit.createInventory(null, 9 , "�f�lDonjon Selection: �8" + player.getDisplayName());
			
			List<String> str_donjon_1 = new ArrayList<String>();
			str_donjon_1.add("�7Explorez�f une grotte remplis de �7verdure�f !");
			str_donjon_1.add("�7Donjons lanc�s : " + RoomUtils.getLaunchDonjonOnABiome(1));
			str_donjon_1.add("�7Salles diff�rentes : " + RoomUtils.getRoomsOfABiome(1).size());
			ItemStack donjon_1 = getCustomItemWithLore(Material.STICK,"�2�lGrotte Verdoyante",false,1,str_donjon_1);
			inv.setItem(0, donjon_1);
			
			List<String> str_donjon_2 = new ArrayList<String>();
			str_donjon_2.add("�7D�couvrez�f des tunnels �7glaciales�f et dangereux !");
			str_donjon_2.add("�7Donjons lanc�s : " + RoomUtils.getLaunchDonjonOnABiome(2));
			str_donjon_2.add("�7Salles diff�rentes : " + RoomUtils.getRoomsOfABiome(2).size());
			ItemStack donjon_2 = getCustomItemWithLore(Material.STICK,"�b�lTunnel Enneige",false,1,str_donjon_2);
			inv.setItem(1, donjon_2);
			
			List<String> str_donjon_3 = new ArrayList<String>();
			str_donjon_3.add("�7Visiter�f d'anciens passages �7d�sertiques�f !");
			str_donjon_3.add("�7Donjons lanc�s : " + RoomUtils.getLaunchDonjonOnABiome(3));
			str_donjon_3.add("�7Salles diff�rentes : " + RoomUtils.getRoomsOfABiome(3).size());
			ItemStack donjon_3 = getCustomItemWithLore(Material.STICK,"�6�lDesert Ancien",false,1,str_donjon_3);
			inv.setItem(2, donjon_3);
			

			player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
			player.openInventory(inv);
			
		}else {
			
			Inventory inv = Bukkit.createInventory(null, 9 , "�f�lDonjon Selection["+biome+"]["+difficulty+"]: �8" + player.getDisplayName());
			
			ItemStack donjon_difficulty = null;
			List<String> str_donjon_difficulty = new ArrayList<String>();
			
			switch(difficulty) {
			case 1:
				str_donjon_difficulty.add("�7Difficult� : �2FACILE");
				str_donjon_difficulty.add("�7R�g�n�ration de vie | 5 salles");
				str_donjon_difficulty.add("�70.5xXP | 0.5xCLoot | Monstres 0.5HP");
				donjon_difficulty = getCustomItemWithLore(Material.STICK,"�2�lFACILE",false,1,str_donjon_difficulty);
			break;
			case 2:
				str_donjon_difficulty.add("�7Difficult� : �eMOYEN");
				str_donjon_difficulty.add("�7R�g�n�ration de vie | 9 salles");
				str_donjon_difficulty.add("�71xXP | 1xCLoot");
				donjon_difficulty = getCustomItemWithLore(Material.STICK,"�e�lMOYEN",false,2,str_donjon_difficulty);
				break;
			case 3:
				str_donjon_difficulty.add("�7Difficult� : �4DIFFICILE");
				str_donjon_difficulty.add("�7R�g�n�ration de vie | 13 salles");
				str_donjon_difficulty.add("�72xMonstres");
				str_donjon_difficulty.add("�71.5xXP | 1.25xCLoot");
				donjon_difficulty = getCustomItemWithLore(Material.STICK,"�4�lDIFFICILE",false,3,str_donjon_difficulty);
				break;
			case 4:
				str_donjon_difficulty.add("�7Difficult� : �8EXPERT");
				str_donjon_difficulty.add("�7Pas de R�g�n�ration de vie | 17 salles");
				str_donjon_difficulty.add("�73xMonstres");
				str_donjon_difficulty.add("�72xXP | 1.75xCLoot");
				donjon_difficulty = getCustomItemWithLore(Material.STICK,"�8�lEXPERT",false,4,str_donjon_difficulty);
				break;
			}
			
			
			if(donjon_difficulty != null)
			inv.setItem(4, donjon_difficulty);
			
			ItemStack right = getCustomItemWithLore(Material.STICK,"�f�l==>",false,1,null);
			ItemStack left = getCustomItemWithLore(Material.STICK,"�f�l<==",false,1,null);
			inv.setItem(2, left);
			inv.setItem(6, right);
			
			ItemStack cancel = getCustomItemWithLore(Material.BARRIER,"�c�lAnnuler",false,1,null);
			ItemStack launch = getCustomItemWithLore(Material.STICK,"�2�lValider",false,1,null);
			inv.setItem(0, cancel);
			inv.setItem(8, launch);

			player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
			player.openInventory(inv);
			
		}
		
	}
	
	private static String generateBar(int percentage) {
		String str = "";
		if(percentage >= 0 && percentage <= 100) {
			if(percentage >= 0 && percentage < 10) {str = "�e----------";}
			else if(percentage >= 10 && percentage < 20) {str = "�a-�e---------";}
			else if(percentage >= 20 && percentage < 30) {str = "�a--�e-------";}
			else if(percentage >= 30 && percentage < 40) {str = "�a---�e-------";}
			else if(percentage >= 40 && percentage < 50) {str = "�a----�e------";}
			else if(percentage >= 50 && percentage < 60) {str = "�a-----�e-----";}
			else if(percentage >= 60 && percentage < 70) {str = "�a------�e----";}
			else if(percentage >= 70 && percentage < 80) {str = "�a-------�e---";}
			else if(percentage >= 80 && percentage < 90) {str = "�a--------�e--";}
			else if(percentage >= 90 && percentage < 100) {str = "�a---------�e-";}
			else if(percentage == 100) {str = "�a----------";}
			return str;
		}else {
			return str;
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

