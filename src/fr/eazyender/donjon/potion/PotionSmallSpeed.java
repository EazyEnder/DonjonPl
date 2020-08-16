package fr.eazyender.donjon.potion;

import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionSmallSpeed extends IPotion{
	
	static int basicCooldown = 5 * 1000;
	
	public PotionSmallSpeed(int cooldown) {
		super(basicCooldown);
	}

   public void launch(Player player) {
       if (super.launch(player, PotionSmallSpeed.class)) {
                	
    	  player.getWorld().playSound(player.getLocation(), Sound.ENTITY_WANDERING_TRADER_DRINK_POTION, 1, 1);
    	  drinkPotion(player);
       } else {
    	   
       }
   }
   
   private void drinkPotion(Player player) {
	   
	   player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*5, 1, true));
	   
	   player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 5, 1, 1, 1, new Particle.DustOptions(Color.GREEN, 1.0f));
	    
	  }
}
