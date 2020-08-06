package fr.eazyender.donjon.events;

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
import fr.eazyender.donjon.files.PlayerEconomy;
import fr.eazyender.donjon.files.PlayerEquipment;
import fr.eazyender.donjon.files.PlayerGroupSave;
import fr.eazyender.donjon.files.PlayerLevelStats;
import fr.eazyender.donjon.gui.InventoryGui;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class PlayerJoin implements Listener {
	
	@EventHandler
	  public void onPlayerJoin(PlayerJoinEvent e) { 
		
		Player player = e.getPlayer();
		
		/* Chargement du joueur */
		PlayerEconomy.getEconomy().loadPlayer(player);
		PlayerLevelStats.getPlayerLevelStats().loadPlayer(player); 
		PlayerEquipment.getPlayerEquipment().loadPlayer(player);
		PlayerArena.getPlayerArena().loadPlayer(player);
		PlayerGroupSave.getPlayerGroup().loadPlayer(player);
		
		player.getInventory().clear();
		e.setJoinMessage("§7[§2§l+§7] " + player.getName());
		
		LevelUtils.updateName(player);
		
		if(!player.hasPlayedBefore()) {

		}
		
		InventoryGui.updateInventory(player);
		
	}
}
