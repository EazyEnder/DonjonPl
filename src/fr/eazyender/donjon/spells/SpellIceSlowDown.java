package fr.eazyender.donjon.spells;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import fr.eazyender.donjon.DonjonMain;

public class SpellIceSlowDown extends ISpell{
	
	List<BukkitRunnable> brun = new ArrayList<BukkitRunnable>();
	static int basicCooldown = 10 * 1000;
	static int basicCost = 50;
	
	public SpellIceSlowDown(int cooldown) {
		super(basicCooldown);
	}

   public void launch(LivingEntity sender) {
	   if(sender instanceof Player) {
		   Player player = (Player)sender;
	   if(ManaEvents.canUseSpell(player, basicCost)) {
       if (super.launch(player, SpellIceSlowDown.class)) {
                	
    	  player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 1, 1);
    	   launchSpell(player,player.getEyeLocation(), player.getTargetBlock(null, 40).getLocation());
    	   ManaEvents.useSpell(player, basicCost);
    	   
       } else {
    	   
       }
	   }
	   }else {
		   if (super.launch(sender, SpellIceSlowDown.class)) {
           	
			       sender.getWorld().playSound(sender.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 1, 1);
		    	   launchSpell(sender,sender.getEyeLocation(), sender.getTargetBlock(null, 40).getLocation());
		    	   
		       } else {
		    	   
		       }
	   }
   }
   
   private void launchSpell(LivingEntity sender, Location target, Location target2) {
	    double distance = target.distance(target2);
	    Vector v = target.toVector();
	    Vector v2 = target2.toVector();
	    Vector vector = v2.clone().subtract(v).normalize().multiply(0.25D);
	    double length = 0.0D;
	    for (int i = 0; length < distance;) {
	    	int z = i;
	    	brun.add(new BukkitRunnable() {
				@Override
				public void run() {
					final int w = z;
					Vector v1 = target.toVector();
					for (int j = 0; j < w; j++) {
						v1.add(vector);
					}
					boolean collide = false;
					Location l = new Location(target.getWorld(),v1.getX(), v1.getBlockY(), v1.getBlockZ());
					for (int j = 0; j < target.getWorld().getEntities().size(); j++) {
						if(!(target.getWorld().getEntities().get(j).equals(sender))  && target.getWorld().getEntities().get(j) instanceof LivingEntity) {
							if(l.distance(target.getWorld().getEntities().get(j).getLocation()) < 1.5) {
								collide = true;
							}
						}
					}
					if(!collide) {
					  Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(132,165,255), 1.0F);
					  
					  target.getWorld().spawnParticle(Particle.REDSTONE, v1.getX(), v1.getY(), v1.getZ() , 0, 0D, 0D, 0D, dustOptions);
				
					}else {
						
						  for (int j = 0; j < target.getWorld().getEntities().size(); j++) {
								if(!(target.getWorld().getEntities().get(j).equals(sender)) && target.getWorld().getEntities().get(j) instanceof LivingEntity) {
									if(l.distance(target.getWorld().getEntities().get(j).getLocation()) < 1.5) {
										LivingEntity entity = (LivingEntity)target.getWorld().getEntities().get(j);
										entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5*20, 1));
										sender.getWorld().playSound(entity.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 5, 1);
									}
								}
							}
						  
						  
						  for (int j = 0; j < brun.size(); j++) {
								brun.get(j).cancel();
							}
						  
						
					}
					  			
				}
			});   	
	        
	    	i++;
	        length += 0.25D;
	    }
	    for (int j = 0; j < brun.size(); j++) {
			brun.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
		}
	    
	  }
}