package fr.eazyender.donjon.spells.blood;

import java.util.Random;

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

public class SpellBloodyPond extends ISpell{
	
	public static int basicCooldown = 60 * 1000;
	public static double basicCost = 10;
	
	public int timer = 0;
	public int maxTimer = 10;
	
	public SpellBloodyPond(int cooldown) {
		super(basicCooldown);
	}

   public void launch(Player player) {
	   
       if (super.launch(player, SpellBloodyBurst.class)) {
                	
    	   player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 3, 1);
    	   launchSpell(player, Color.fromRGB(36,17,21));
    	   player.damage(basicCost);
       }
   }
   
   private void launchSpell(Player player, Color color) {
	   
	   	Location send = player.getLocation();
			Particle.DustOptions dustOptions = new Particle.DustOptions(color, 2.0F);
					  
			new BukkitRunnable() {
				@Override
				public void run() {
				
				if(timer < maxTimer) {	
					
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,40,2,false));
				
				for (int i = 0; i < 360; i=i+10) {
					player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, send.getX() + Math.cos(i) * RandomNumber(0, 5), send.getY() + RandomNumber(-1, 1), send.getZ() + Math.sin(i)   * RandomNumber(0, 5), 0, 0D, 0.05D * RandomNumber(1, 4), 0D);
					player.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 5, send.getY(), send.getZ() + Math.sin(i)  * 5, 0, 0D, 0.5D, 0D, dustOptions);
					player.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 4, send.getY(), send.getZ() + Math.sin(i)  * 4, 0, 0D, 0.5D, 0D, dustOptions);
					player.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 3, send.getY(), send.getZ() + Math.sin(i)  * 3, 0, 0D, 0.5D, 0D, dustOptions);
					player.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 2, send.getY(), send.getZ() + Math.sin(i)  * 2, 0, 0D, 0.5D, 0D, dustOptions);
					player.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 1, send.getY(), send.getZ() + Math.sin(i)  * 1, 0, 0D, 0.5D, 0D, dustOptions);
				}
				
				for (Entity entity : player.getNearbyEntities(5, 2, 5)) {
					if(entity instanceof LivingEntity) {
						if(!entity.equals(player)) {
							((LivingEntity) entity).damage(2);
						}else {
							player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,30,0,false));
						}
					}
				}
				
				timer++;
				
				}else {
					
				player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1, 1);
				this.cancel();
				
				}
				
				if(player.isDead()) {this.cancel();}
				
				}
						
			}.runTaskTimer(DonjonMain.instance, 0, 20);
	    
	  }
   
   private static int RandomNumber(int Min , int Max)
   {
		if(Min == Max) {return Max;}
		Min = Min-1;
   	Random rand = new Random();
   	int randomNbr = rand.nextInt(Max - Min) + Min;
   	
   	if(randomNbr > Max){randomNbr = Max;}
   	if(randomNbr <= Min){randomNbr = Max;}
   return randomNbr;}

}
