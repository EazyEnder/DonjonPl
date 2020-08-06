package fr.eazyender.donjon.spells.physic;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import fr.eazyender.donjon.spells.ISpell;
import fr.eazyender.donjon.spells.ManaEvents;

public class SpellDash extends ISpell{
	
	public static int basicCooldown = 2 * 1000;
	public static int basicCost = 50;
	
	public SpellDash(int cooldown) {
		super(basicCooldown);
	}

   public void launch(Player player) {
	   if(ManaEvents.canUseSpell(player, basicCost)) {
       if (super.launch(player, SpellDash.class)) {
                	
    	  player.getWorld().playSound(player.getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_1, 1, 1);
    	   launchSpell(player);
    	   ManaEvents.useSpell(player, basicCost);
       } else {
    	   
       }
	   }
   }
   
   private void launchSpell(Player player) {
	   
					  Vector movement = player.getLocation().getDirection();
					  movement.normalize().multiply(1.5);
					  player.setVelocity(movement);
					  
					  player.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, player.getLocation().getX(),  player.getLocation().getY(),  player.getLocation().getZ(), 1, 0.1, 0.1, 0.1);
	    
	  }

}


