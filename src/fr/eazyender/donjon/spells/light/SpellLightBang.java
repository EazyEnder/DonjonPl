package fr.eazyender.donjon.spells.light;

import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.spells.ISpell;
import fr.eazyender.donjon.spells.ManaEvents;
import fr.eazyender.donjon.spells.fire.SpellEmbrasement;

public class SpellLightBang extends ISpell{
	
	public static int basicCooldown = 25 * 1000;
	int timer = 0, maxTimer = 10*2;
	public static int basicCost = 30;
	
	public SpellLightBang(int cooldown) {
		super(basicCooldown);
	}

   public void launch(Player player) {
	   if(ManaEvents.canUseSpell(player, basicCost)) {
       if (super.launch(player, SpellEmbrasement.class)) {
                	
    	  player.getWorld().playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 4, 1);
    	   launchSpell(player);
    	   ManaEvents.useSpell(player, basicCost);
    	   
       } else {
    	   
       }
	   }
   }
   
   private void launchSpell(Player player) {
					  
					  new BukkitRunnable() {
						  @Override
							public void run() {
							  Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(251,255,84), 1.0F + ((float)timer/10F));
							  if(timer < maxTimer) {
							  
							  Vector v1 = player.getLocation().toVector();
							  v1.add(new Vector(0, 1, 0));
					 int nbrcircle = 7 + timer;
					  for (double i = 0; i <= Math.PI; i += Math.PI / nbrcircle) {
						   double radius = Math.sin(i) * (timer / 2);
						   double y = Math.cos(i) *  (timer / 2);
						   for (double a = 0; a < Math.PI * 2; a+= Math.PI / nbrcircle) {
						      double x = Math.cos(a) * radius;
						      double z = Math.sin(a) * radius;
						      v1.add(new Vector(x, y, z));
						      player.getWorld().spawnParticle(Particle.REDSTONE, v1.getX(), v1.getY(), v1.getZ() , 0, 0D, 0D, 0D, dustOptions);
						      v1.subtract(new Vector(x, y, z));
						      
						   }
						   
						}
					    
					    for (int j = 0; j < player.getWorld().getEntities().size(); j++) {
							if(!(player.getWorld().getEntities().get(j).equals(player)) && player.getWorld().getEntities().get(j) instanceof LivingEntity) {
								if(player.getLocation().distance(player.getWorld().getEntities().get(j).getLocation()) < (timer / 2)) {
									LivingEntity entity = (LivingEntity)player.getWorld().getEntities().get(j);
								    
								    entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*4, 1, false));
								}
							}
						}
					  
					  timer++;
					  
							  }else {
								  this.cancel();
							  }
					  
						  }
					  }.runTaskTimer(DonjonMain.instance, 0, 2);
	    
	  }

}
