package fr.eazyender.donjon.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.eazyender.donjon.arena.ArenaEvents;
import fr.eazyender.donjon.gui.CraftPotionsGui;
import fr.eazyender.donjon.gui.ForgeGui;

public class PlayerInteract implements Listener {
	
	@EventHandler
	public void onPlayerAttack(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Player) {
		Player p = (Player) event.getEntity();
		if(p.getWorld().getName().contains("lobby")) {
			if(!ArenaEvents.currentlyPlayer.contains(p)) {
				event.setCancelled(true);
			}
		}
		}
	}
	
	@EventHandler
	  public void interactWithArmorStand(PlayerArmorStandManipulateEvent e)
	  {
	          if(!e.getRightClicked().isVisible())
	          {
	              e.setCancelled(true);
	          }
	  }
	
	  @EventHandler
	  public void onPlayerInteractWithCraftTable(PlayerInteractEvent e) {
		  
		  	Player p = e.getPlayer();
		  	if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
		  		if(e.hasBlock()) {
		  		if(e.getClickedBlock().getType().equals(Material.CAULDRON)) {
		  				
		  				CraftPotionsGui.createMainGui(p);
		  				e.setCancelled(true);
		  		}
		  		else if(e.getClickedBlock().getType().equals(Material.BLAST_FURNACE)) {
	  				
	  				ForgeGui.createMainGui(p);
	  				e.setCancelled(true);
		  		}
		  		}
		  	}
	  }

}
