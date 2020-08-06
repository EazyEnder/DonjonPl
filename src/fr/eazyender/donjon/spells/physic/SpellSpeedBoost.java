package fr.eazyender.donjon.spells.physic;

import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.spells.ISpell;
import fr.eazyender.donjon.spells.ManaEvents;

public class SpellSpeedBoost extends ISpell{
	
	private float walkspeed = 0;
	
	public static int basicCooldown = 5 * 1000;
	public static int basicCost = 30;
	
	public SpellSpeedBoost(int cooldown) {
		super(basicCooldown);
	}

   public void launch(LivingEntity entity) {
	   if(entity instanceof Player) {
		   Player player = (Player)entity;
	   if(ManaEvents.canUseSpell(player, basicCost)) {
       if (super.launch(player, SpellSpeedBoost.class)) {
                	
    	  player.getWorld().playSound(player.getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_1, 1, 1);
    	   launchSpell(player);
    	   ManaEvents.useSpell(player, basicCost);
       }}}else {
    	   if (super.launch(entity, SpellSpeedBoost.class)) {
           	
    		   entity.getWorld().playSound(entity.getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_1, 1, 1);
    	    	   launchSpell(entity);
    	       } 
	   }
   }
   
   private void launchSpell(LivingEntity entity) {
	   
	   if(entity instanceof Player) {
			walkspeed = ((Player)entity).getWalkSpeed();
			((Player)entity).setWalkSpeed((float) (((Player)entity).getWalkSpeed()+0.3));
			
			new BukkitRunnable() {

				@Override
				public void run() {
					
					((Player)entity).setWalkSpeed(walkspeed);
					
				}
				
			}.runTaskLater(DonjonMain.instance, 30);
			
		}else {
		    entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30, 2));
		}	
	    
	  }

}

