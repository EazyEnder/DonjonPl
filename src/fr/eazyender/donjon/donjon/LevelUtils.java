package fr.eazyender.donjon.donjon;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.eazyender.donjon.arena.ArenaUtils;
import fr.eazyender.donjon.files.PlayerArena;
import fr.eazyender.donjon.files.PlayerEquipment;
import fr.eazyender.donjon.files.PlayerLevelStats;
import fr.eazyender.donjon.gui.InventoryGui;
import fr.eazyender.donjon.spells.SpellUtils;

public class LevelUtils {
	
	public static int[] pallierSkill = {1,5,10,20};
	private static final int[] xpneed = {25,35,50,70,100,125,150,175,200,225
			,260,290,325,360,400,440,490,540,590,650
			,700,770,840,910,980,1050,1130,1210,1290,1400};
	
	public static void updateXp(Player player) {
		
		int level = PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(player);
		long xp = PlayerLevelStats.getPlayerLevelStats().getXpDonjon(player);
		if(xp > getXpNecessary(level+1)) {
			PlayerLevelStats.getPlayerLevelStats().setLevelDonjon(player, level+1);
			PlayerLevelStats.getPlayerLevelStats().setXpDonjon(player, 0);
			
			player.sendMessage("§8[§4Donjon§8] : §f" + "Vous êtes monté d'un niveau ! (niveau:" + (level+1) +")");
			PlayerLevelStats.getPlayerLevelStats().setSkillPoints(player, PlayerLevelStats.getPlayerLevelStats().getSkillPoints(player)+1);
			
			updateName(player);
		}
		InventoryGui.updateInventory(player);
		
	}
	
	public static void updateName(Player player) {
		
		String name = player.getName();
		
		int level = PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(player);
		name = "§r§f[§r" +ArenaUtils.getCircleOfRank(PlayerLevelStats.getPlayerLevelStats().getLevelRank(player)) + "§r§f/" + LevelUtils.getRankName(level) + "§r§f]§r" + name;
		if(player.isOp()) name = "§r§c[§4⚠§r§c]§r" + name;
		
		player.setDisplayName(name);
	}
	
	public static void updateSkill(Player player, int id) {
		
		for (int i = 0; i < pallierSkill.length; i++) {
			if(PlayerLevelStats.getPlayerLevelStats().getAStatsPoints(player, id) == pallierSkill[i]+1) {
				switch(id) {
				case 1: 
					switch(i) {
					case 0:
						
						break;
					case 1:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(3))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(3);
						break;
					case 2:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(5))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(5);
						break;
					case 3:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(13))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(13);
						break;
					}
					break;
				case 2:
					switch(i) {
					case 0:
						break;
					case 1:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(2))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(2);
						break;
					case 2:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(15))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(15);
						break;
					}
					break;
				case 3:
					switch(i) {
					case 0:
						
						break;
					case 1:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(1))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(1);
						break;
					case 2:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(8))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(8);
						break;
					case 3:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(9))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(9);
						break;
					}
					break;
				}
				player.sendMessage("Vous avez gagné : " + getAwardSkill(id, i).getItemMeta().getDisplayName() + " !");
			}
		}
		
	}
	
	public static ItemStack getAwardSkill(int id, int stape) {
		ItemStack item = getCustomItemWithLore(Material.GRAY_CONCRETE, "§fPas de récompense", false, 1, null);
		switch(id) {
		//ATQ
		case 1:
			switch(stape) {
			case 1: item = SpellUtils.getItemSpellById(3);
				break;
			case 2: item = SpellUtils.getItemSpellById(5);
				break;
			case 3: item = SpellUtils.getItemSpellById(13);
				break;
			}
			break;
		//DEF
		case 2:
			switch(stape) {
			case 1: item = SpellUtils.getItemSpellById(2);
				break;
			case 2: item = SpellUtils.getItemSpellById(15);
				break;
			}
			break;
		//MAG
		case 3:
			switch(stape) {
			case 1: item = SpellUtils.getItemSpellById(1);
				break;
			case 2: item = SpellUtils.getItemSpellById(8);
				break;
			case 3: item = SpellUtils.getItemSpellById(9);
				break;
			}
			break;
		}
		return item;
	}
	
	public static String getRankName(int level) {
		String rank = "§7Voyageur";
		if(level < 1) {rank = "§7Voyageur";}
		else if(level == 1) {rank = "§7Novice";}
		else if(level <= 5) {rank = "§7Adepte";}
		else if(level <= 10) {rank = "§7Aventurier§r§f-" + "§7PR";}
		else if(level <= 20) {rank = "§7Aventurier§r§f-" + "§6CU";}
		else if(level <= 30) {rank = "§7Aventurier§r§f-" + "§8FE";}
		return rank;
	}
	
	public static long getXpNecessary(int level) {
		
		long xp = 0;
		if(level > 0 && level <= xpneed.length) {
			xp = xpneed[level-1];
		}
		
		return xp;
		
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
