package fr.eazyender.donjon.spells.blood;

import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.spells.ISpell;

public class SpellBloodyBurst extends ISpell{
	
	public static int basicCooldown = 60 * 1000;
	public static double cost = 0.5;
	
	public boolean isActive = false;
	
	public SpellBloodyBurst(int cooldown) {
		super(basicCooldown);
	}

   public void launch(Player player) {
	   if(!isActive) {
       if (super.launch(player, SpellBloodyBurst.class)) {
                	
    	   player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 3, 1);
    	   launchSpell(player, Color.fromRGB(36,17,21));
    	   
       }
	   
	   }else {
		   isActive = false;
	   }
   }
   
   private void launchSpell(Player player, Color color) {
	   
			Particle.DustOptions dustOptions = new Particle.DustOptions(color, 1.0F);
					  
			new BukkitRunnable() {
				@Override
				public void run() {
				
				if(isActive) {	
					
					player.damage(cost);
				
					
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,40,2,false));
				
				player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation().getX()-1 + Math.random()*2, player.getLocation().getY() + 0.5 + Math.random(), player.getLocation().getZ()-1 + Math.random()*2 , 0, 0D, 3D, 0D);	
				player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation().getX()-1 + Math.random()*2, player.getLocation().getY() + 0.5 + Math.random(), player.getLocation().getZ()-1 + Math.random()*2 , 0, 0D, 3D, 0D);	
				player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation().getX()-1 + Math.random()*2, player.getLocation().getY() + 0.5 + Math.random(), player.getLocation().getZ()-1 + Math.random()*2 , 0, 0D, 3D, 0D);	
				player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation().getX()-1 + Math.random()*2, player.getLocation().getY() + 0.5 + Math.random(), player.getLocation().getZ()-1 + Math.random()*2 , 0, 0D, 3D, 0D);			  
				player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().getX()-1 + Math.random()*2, player.getLocation().getY() + 0.5 + Math.random(), player.getLocation().getZ()-1 + Math.random()*2 , 0, 1D, 0D, 0D, dustOptions);
				player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().getX()-1 + Math.random()*2, player.getLocation().getY() + 0.5 + Math.random(), player.getLocation().getZ()-1 + Math.random()*2 , 0, 1D, 0D, 0D, dustOptions);
				player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().getX()-1 + Math.random()*2, player.getLocation().getY() + 0.5 + Math.random(), player.getLocation().getZ()-1 + Math.random()*2 , 0, 1D, 0D, 0D, dustOptions);
				player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().getX()-1 + Math.random()*2, player.getLocation().getY() + 0.5 + Math.random(), player.getLocation().getZ()-1 + Math.random()*2 , 0, 1D, 0D, 0D, dustOptions);
				
				}else {
					
				player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1, 1);
				this.cancel();
				
				}
				
				if(player.isDead()) {this.cancel();}
				
				}
						
			}.runTaskTimer(DonjonMain.instance, 0, 20);
	    
	  }

}
