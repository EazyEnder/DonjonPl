package fr.eazyender.donjon.spells.physic;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

import fr.eazyender.donjon.spells.ISpell;
import fr.eazyender.donjon.spells.ManaEvents;

public class SpellOneTarget extends ISpell{
	
	public static int basicCooldown = 15 * 1000;
	public static int basicCost = 50;
	
	public SpellOneTarget(int cooldown) {
		super(basicCooldown);
	}

   public void launch(Player player) {
	   if(ManaEvents.canUseSpell(player, basicCost)) {
       if (super.launch(player, SpellDash.class)) {
                	
    	  player.getWorld().playSound(player.getLocation(), Sound.ENTITY_GHAST_SCREAM, 1, 1);
    	   launchSpell(player);
    	   ManaEvents.useSpell(player, basicCost);
       } else {
    	   
       }
	   }
   }
   
   private void launchSpell(Player player) {
	   
			List<Entity> nearby = player.getNearbyEntities(10, 10, 10);
			for (int i = 0; i < nearby.size(); i++) {
				if(!(nearby.get(i) instanceof Player)) {
					if(nearby.get(i) instanceof Monster) {
						Monster entity = (Monster)nearby.get(i);
						entity.setTarget(player);
					}
				}
			}
	    
	  }

}
