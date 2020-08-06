package fr.eazyender.donjon.donjon;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Sound;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Zombie;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.spells.ISpell;
import fr.eazyender.donjon.spells.earth.SpellEarthChocWave;
import fr.eazyender.donjon.spells.earth.SpellShield;
import fr.eazyender.donjon.spells.physic.SpellSpeedBoost;
import fr.eazyender.donjon.spells.poison.SpellPoisonousSacrifice;
import fr.eazyender.donjon.spells.water.SpellIceJail;
import fr.eazyender.donjon.spells.water.SpellIceSlowDown;
import fr.eazyender.donjon.spells.water.SpellIceSlowDownAOE;

public class EntityEvents {
	
	public static void launchEntityLoop(LivingEntity entity) {
		
		new BukkitRunnable() {

			@Override
			public void run() {
				
				if(entity.isDead()) {
					
					if(ISpell.cooldowns.containsKey(entity))ISpell.cooldowns.remove(entity);
					;this.cancel();}
				
				String customName = entity.getCustomName();
				if(customName == null)customName = "";
				switch(customName) {
				case "GRANITE_KING_SQUELETON": 
						if(!entity.getNearbyEntities(5, 5, 5).isEmpty()) {
							Skeleton skeleton = (Skeleton)entity;
							if(skeleton.getTarget() != null) {
								if(!ISpell.cooldowns.containsKey(entity)) ISpell.cooldowns.put(entity, new HashMap<Class<? extends ISpell>, Long>());
								if(RandomNumber(0,100) < 10) {
									SpellEarthChocWave spell = new SpellEarthChocWave(1000*2); 
									if(!ISpell.cooldowns.get(entity).containsKey(SpellShield.class))
									spell.launch(skeleton);
								}
								if(RandomNumber(0,100) < 4) {
									SpellShield spell = new SpellShield(1000*2); 
									if(!ISpell.cooldowns.get(entity).containsKey(SpellEarthChocWave.class))
									spell.launch(skeleton);
								}
							}
						}
					break;
				case "BUSH_ZOMBIE": 
					if(entity.getHealth() < 10) {
						if(!entity.getNearbyEntities(5, 5, 5).isEmpty()) {
							Zombie zombie = (Zombie)entity;
							if(zombie.getTarget() != null) {
								if(RandomNumber(0,100) < 50) {
									SpellPoisonousSacrifice spell = new SpellPoisonousSacrifice(1000*2); 
									spell.launch(zombie);
								}
							}
						}
					}
					break;
				case "BUSH_SQUELETON": 
					if(entity.getHealth() < 10) {
						if(!entity.getNearbyEntities(5, 5, 5).isEmpty()) {
							Skeleton squeleton = (Skeleton)entity;
							if(squeleton.getTarget() != null) {
								if(RandomNumber(0,100) < 50) {
									SpellPoisonousSacrifice spell = new SpellPoisonousSacrifice(1000*2); 
									spell.launch(squeleton);
								}
							}
						}
					}
					break;
				case "ICE_SLIME":
						if(!entity.getNearbyEntities(7, 7, 7).isEmpty()) {
							boolean ok = false;
							Player player = null;
							for (Entity entity : entity.getNearbyEntities(7, 7, 7)) {
								if(entity instanceof Player) {
									ok = true;
									player = (Player) entity;
								}
							}
							
							if(ok) {
							Slime slime = (Slime)entity;
							if(slime.getTarget() != null) {
									SpellIceSlowDown spell = new SpellIceSlowDown(1000*2); 
									spell.launch(slime);
									slime.damage(10, player);
							}
							}
						}
					break;
				case "ICE_BAT":
					if(!entity.getNearbyEntities(3, 3, 3).isEmpty()) {
						boolean ok = false;
						Player player = null;
						for (Entity entity : entity.getNearbyEntities(7, 7, 7)) {
							if(entity instanceof Player) {
								ok = true;
								player = (Player) entity;
							}
						}
						
						if(ok) {
						Bat bat = (Bat)entity;
							if(RandomNumber(0,100) < 50) {
								SpellIceJail spell = new SpellIceJail(1000*2); 
								spell.launch(bat);
								bat.damage(10, player);
								
							}
						}
					}
				break;
				case "ICE_BEAR": 
					if(!entity.getNearbyEntities(7, 7, 7).isEmpty()) {
						PolarBear bear = (PolarBear)entity;
						if(bear.getTarget() != null) {
							if(!ISpell.cooldowns.containsKey(entity)) ISpell.cooldowns.put(entity, new HashMap<Class<? extends ISpell>, Long>());
							if(RandomNumber(0,100) < 5 * (bear.getMaxHealth() / bear.getHealth())) {
								SpellSpeedBoost spell = new SpellSpeedBoost(1000*2); 
								if(!ISpell.cooldowns.get(entity).containsKey(SpellSpeedBoost.class))
								spell.launch(bear);
								entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_POLAR_BEAR_WARNING, 3, 1);
							}
							if(RandomNumber(0,100) < 5) {
								SpellIceSlowDownAOE spell = new SpellIceSlowDownAOE(1000*2); 
								if(!ISpell.cooldowns.get(entity).containsKey(SpellIceSlowDownAOE.class))
								spell.launch(bear);
							}
							if(RandomNumber(0,100) < 2) {
								SpellShield spell = new SpellShield(1000*2); 
								if(!ISpell.cooldowns.get(entity).containsKey(SpellEarthChocWave.class))
								spell.launch(bear);
							}
						}
					}
				break;
				case "SNOW_BEAR":
					if(entity.getHealth() < 15) {
						if(!entity.getNearbyEntities(5, 5, 5).isEmpty()) {
							PolarBear bear = (PolarBear)entity;
							if(bear.getTarget() != null) {
								if(RandomNumber(0,100) < 50) {
									SpellSpeedBoost spell = new SpellSpeedBoost(1000*2); 
									spell.launch(bear);
								}
							}
						}
					}
					break;
				}
				
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
