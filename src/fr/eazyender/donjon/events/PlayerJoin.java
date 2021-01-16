package fr.eazyender.donjon.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.donjon.DonjonEvents;
import fr.eazyender.donjon.donjon.LevelUtils;
import fr.eazyender.donjon.files.PlayerArena;
import fr.eazyender.donjon.files.PlayerChromatiques;
import fr.eazyender.donjon.files.PlayerEconomy;
import fr.eazyender.donjon.files.PlayerEquipment;
import fr.eazyender.donjon.files.PlayerGroupSave;
import fr.eazyender.donjon.files.PlayerLevelStats;
import fr.eazyender.donjon.files.PlayerShop;
import fr.eazyender.donjon.gui.InventoryGui;
import fr.eazyender.donjon.spells.ColorUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class PlayerJoin implements Listener {
	
	@EventHandler
	  public void onPlayerJoin(PlayerJoinEvent e) { 
		
		Player player = e.getPlayer();
		
		/* Chargement du joueur */
		ColorUtils.loadPlayer(player);
		PlayerEconomy.getEconomy().loadPlayer(player);
		PlayerLevelStats.getPlayerLevelStats().loadPlayer(player); 
		PlayerEquipment.getPlayerEquipment().loadPlayer(player);
		PlayerArena.getPlayerArena().loadPlayer(player);
		PlayerGroupSave.getPlayerGroup().loadPlayer(player);
		PlayerChromatiques.getPlayerChromatiques().loadPlayer(player);
		PlayerShop.getPlayerShopProfil().loadPlayer(player);
		
		player.setGameMode(GameMode.ADVENTURE);
		player.getInventory().clear();
		e.setJoinMessage("§7[§2§l+§7] " + player.getName());
		
		LevelUtils.updateName(player);
		
		player.setBedSpawnLocation(new Location(Bukkit.getWorld("lobby"), -42.5, 127.00, -15.5, -90, 0), true);
		if(!player.hasPlayedBefore()) {
				if(!PlayerEquipment.getPlayerEquipment().getWeapons(player).contains(4)) {
					List<Integer> weapons = PlayerEquipment.getPlayerEquipment().getWeapons(player);
					weapons.add(4);
					PlayerEquipment.getPlayerEquipment().setWeapons(player, weapons);
				}
				int[] sp = {1,2,3,4,5,13,14,16,17,18,23,26};
					List<Integer> spells = PlayerEquipment.getPlayerEquipment().getSpells(player);
					for (int i : sp) {
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(i))
							spells.add(i);
					}
					PlayerEquipment.getPlayerEquipment().setSpells(player, spells);
					
				
		}
		
		InventoryGui.updateInventory(player);
		player.teleport(new Location(Bukkit.getWorld("lobby"), -42.5, 127.00, -15.5, -90, 0));
		
	}
}
