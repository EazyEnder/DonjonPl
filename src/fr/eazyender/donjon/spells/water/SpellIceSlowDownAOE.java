package fr.eazyender.donjon.spells.water;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.spells.ISpell;
import fr.eazyender.donjon.spells.ManaEvents;

public class SpellIceSlowDownAOE extends ISpell{
	
	private int timer = 0; private static final int maxTimer = 5*2;
	public static int basicCooldown = 15 * 1000;
	public static int basicCost = 70;
	
	public SpellIceSlowDownAOE(int cooldown) {
		super(basicCooldown);
	}

   public void launch(LivingEntity sender) {
	   if(sender instanceof Player) {
		   Player player = (Player)sender;
	   if(ManaEvents.canUseSpell(player, basicCost)) {
       if (super.launch(player, SpellIceSlowDownAOE.class)) {
                	
    	  player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 1, 1);
    	   launchSpell(player);
    	   ManaEvents.useSpell(player, basicCost);
    	   
       } else {
    	   
       }
	   }
	   }else {
		   if (super.launch(sender, SpellIceSlowDownAOE.class)) {
           	
			       sender.getWorld().playSound(sender.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 1, 1);
		    	   launchSpell(sender);
		    	   
		       } else {
		    	   
		       }
	   }
   }
   
   private void launchSpell(LivingEntity sender) {
	    
	   Location send = sender.getLocation();
	   Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(132,165,255), 3.0F);
		  
		  new BukkitRunnable() {
			  @Override
				public void run() {
				  
				  if(timer < maxTimer) {
				  
						for (int i = 0; i < 360; i=i+10) {
							 sender.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 5, send.getY(), send.getZ() + Math.sin(i)  * 5, 0, 0D, 0.5D, 0D, dustOptions);
							 sender.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 4, send.getY(), send.getZ() + Math.sin(i)  * 4, 0, 0D, 0.5D, 0D, dustOptions);
							 sender.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 3, send.getY(), send.getZ() + Math.sin(i)  * 3, 0, 0D, 0.5D, 0D, dustOptions);
							  sender.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 2, send.getY(), send.getZ() + Math.sin(i)  * 2, 0, 0D, 0.5D, 0D, dustOptions);
							  sender.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 1, send.getY(), send.getZ() + Math.sin(i)  * 1, 0, 0D, 0.5D, 0D, dustOptions);
						}
						
						for (Entity entity : sender.getNearbyEntities(5, 2, 5)) {
							if(entity instanceof LivingEntity) {
								if(!entity.equals(sender)) {
									((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30, 1));
								}
							}
						}
						
					timer++;
				  }else {
					  this.cancel();
				  }
				  
			  }
			  
		  }.runTaskTimer(DonjonMain.instance, 0, 10);
	   
   }
}
