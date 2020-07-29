package fr.eazyender.donjon.events;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.eazyender.donjon.commands.CommandGroup;
import fr.eazyender.donjon.files.PlayerEconomy;
import fr.eazyender.donjon.files.PlayerEquipment;
import fr.eazyender.donjon.files.PlayerGroupSave;
import fr.eazyender.donjon.files.PlayerLevelStats;
import fr.eazyender.donjon.utils.PlayerGroup;

public class PlayerQuit implements Listener {
	
	@EventHandler
	  public void onPlayerQuit(PlayerQuitEvent e) { 
		
		e.setQuitMessage("§7[§c§l-§7] " + e.getPlayer().getName());
		Player player = e.getPlayer();
		
		if(PlayerGroup.aGroupContainPlayer(player.getUniqueId()))
		{
			PlayerGroup group = PlayerGroup.getGroupOfAPlayer(player);
			for (int i = 0; i < group.getGroup().size(); i++) {
				Player member = Bukkit.getPlayer(group.getGroup().get(i));
				if(member.getUniqueId() == player.getUniqueId()) {
					List<UUID> newGroup = group.getGroup();
					newGroup.remove(group.getGroup().get(i));
					PlayerGroup.getGroupOfAPlayer(player).setGroup(newGroup);
					for (Player mate : group.getPlayers()) {
						mate.playSound(mate.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
						mate.sendMessage(CommandGroup.srv_msg + "Le joueur " + player.getName() + " s'est déconnecté et a donc quitté le groupe");
					}
					
				}
			}
		}else if(!PlayerGroupSave.getPlayerGroup().getGroup(player).getGroup().isEmpty()) {
			PlayerGroup group = PlayerGroupSave.getPlayerGroup().getGroup(player);
			PlayerGroupSave.getPlayerGroup().getGroup(player).setGroup(new ArrayList<UUID>());
			for (UUID mUUID : group.getGroup()) {
				Player member = Bukkit.getPlayer(mUUID);
				member.playSound(member.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
				member.sendMessage(CommandGroup.srv_msg + "Le chef du groupe " + player.getName() + " s'est déconnecté, vous avez donc été exclue du groupe.");
			}
		}
		
		/* Dechargement du joueur */
		PlayerLevelStats.getPlayerLevelStats().unloadPlayer(player);
		PlayerEquipment.getPlayerEquipment().unloadPlayer(player);
		PlayerEconomy.getEconomy().unloadPlayer(player);
		PlayerGroupSave.getPlayerGroup().unloadPlayer(player);
		
	}
}
