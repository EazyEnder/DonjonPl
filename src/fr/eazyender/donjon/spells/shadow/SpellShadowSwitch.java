package fr.eazyender.donjon.spells.shadow;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.spells.ColorUtils;
import fr.eazyender.donjon.spells.ISpell;
import fr.eazyender.donjon.spells.ManaEvents;

public class SpellShadowSwitch extends ISpell{
	
	List<BukkitRunnable> brun = new ArrayList<BukkitRunnable>();
	public static int basicCooldown = 25 * 1000;
	public static int basicCost = 80;
	
	public SpellShadowSwitch(int cooldown) {
		super(basicCooldown);
	}

   public void launch(LivingEntity sender) {
	   if(sender instanceof Player) {
		   Player player = (Player)sender;
	   if(ManaEvents.canUseSpell(player, basicCost)) {
       if (super.launch(player, SpellShadowSwitch.class)) {
                	
    	  player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 1, 1);
    	   launchSpell(player,player.getEyeLocation(), player.getTargetBlock(null, 40).getLocation());
    	   ManaEvents.useSpell(player, basicCost);
    	   
       } else {
    	   
       }
	   }
	   }else {
		   if (super.launch(sender, SpellShadowSwitch.class)) {
           	
			   if(sender instanceof Monster) {
				   sender.getWorld().playSound(sender.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 1, 1);
			       launchSpell(sender,sender.getEyeLocation(), ((Monster)sender).getTarget().getLocation());
				   }else {
				   sender.getWorld().playSound(sender.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 1, 1);
				   launchSpell(sender,sender.getEyeLocation(), sender.getNearbyEntities(7, 7, 7).get(0).getLocation().add(0, 1, 0));   
				   }
		    	   
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
						  if(sender instanceof Player) {
							  dustOptions = new Particle.DustOptions(ColorUtils.getSkins().get((Player)sender).get(4), 1.0F);
						  }
					  
					  target.getWorld().spawnParticle(Particle.REDSTONE, v1.getX(), v1.getY(), v1.getZ() , 0, 0D, 0D, 0D, dustOptions);
				
					}else {
						
						  for (int j = 0; j < target.getWorld().getEntities().size(); j++) {
								if(!(target.getWorld().getEntities().get(j).equals(sender)) && target.getWorld().getEntities().get(j) instanceof LivingEntity) {
									if(l.distance(target.getWorld().getEntities().get(j).getLocation()) < 1.5) {
										LivingEntity entity = (LivingEntity)target.getWorld().getEntities().get(j);
										
										Location loc1 = sender.getLocation();
										Location loc2 = entity.getLocation();
										
										sender.teleport(loc2);
										entity.teleport(loc1);
										
										sender.getWorld().playSound(entity.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 1, 1);
										sender.getWorld().playSound(sender.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 1, 1);
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
