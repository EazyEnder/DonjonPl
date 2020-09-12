package fr.eazyender.donjon.spells.water;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import fr.eazyender.donjon.spells.ColorUtils;
import fr.eazyender.donjon.spells.ISpell;
import fr.eazyender.donjon.spells.ManaEvents;
import fr.eazyender.donjon.spells.poison.SpellPoisonousRain;

public class SpellIceCollapse extends ISpell{
	
	List<BukkitRunnable> brun = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun2 = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun3 = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun4 = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun5 = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun6 = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun7 = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun8 = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brunb = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun2b = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun3b = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun4b = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun5b = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun6b = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun7b = new ArrayList<BukkitRunnable>();
	List<BukkitRunnable> brun8b = new ArrayList<BukkitRunnable>();
	public static int basicCooldown = 30 * 1000;
	public static int basicCost = 60;
	
	public SpellIceCollapse(int cooldown) {
		super(basicCooldown);
	}

   public void launch(LivingEntity sender) {
	   if(sender instanceof Player) {
		   Player player = (Player)sender;
	if(ManaEvents.canUseSpell(player, basicCost)) {
       if (super.launch(player, SpellIceCollapse.class)) {
                	
    	  player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 3, 1);
    	  launchSpell(player);
    	  ManaEvents.useSpell(player, basicCost);
    	  
    	   
	   }
	}
       
	   }else {
		  
		   
		   if (super.launch(sender, SpellIceCollapse.class)) {
           	
			   	sender.getWorld().playSound(sender.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 3, 1);
		    	  launchSpell(sender);
		    	   
			   }
		   
	   }
   }
   
   private void launchSpell(LivingEntity sender) {

				for (int i = 1; i < 17; i++) {
					int w = i;
					new BukkitRunnable() {
						@Override
						public void run() {
							int x = RandomNumber(-10,10);
							int z = RandomNumber(-10,10);
							if(sender instanceof Player)
								launchProjectile(sender, sender.getLocation().add(x, 10, z), sender.getLocation().add(x,-15, z), ColorUtils.getSkins().get(sender).get(2),w);
							else
								launchProjectile(sender, sender.getLocation().add(x, 10, z), sender.getLocation().add(x,-15, z), Color.fromRGB(255,255,255),w);
						}
					}.runTaskLater(DonjonMain.instance, i*20);
				}
			
					
	    
	  }
   
   public BukkitRunnable bolt(Vector vector, int z, Location target, LivingEntity player, Color color, int nbr) {
	   return new BukkitRunnable() {
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
					if(!(target.getWorld().getEntities().get(j).equals(player))  && target.getWorld().getEntities().get(j) instanceof LivingEntity) {
						if(l.distance(target.getWorld().getEntities().get(j).getLocation()) < 3) {
							collide = true;
						}
					}
				}
				if(!collide) {
				  Particle.DustOptions dustOptions = new Particle.DustOptions(color, 2F + w*0.1f);
					 target.getWorld().spawnParticle(Particle.REDSTONE, v1.getX(), v1.getY(), v1.getZ() , 0, 0D, 0D, 0D, dustOptions);

				}else {
					  
					 
					target.getWorld().playSound(target, Sound.BLOCK_SNOW_FALL, 1, 1);
					  
					  for (int j = 0; j < target.getWorld().getEntities().size(); j++) {
							if(!(target.getWorld().getEntities().get(j).equals(player)) && target.getWorld().getEntities().get(j) instanceof LivingEntity) {
								if(l.distance(target.getWorld().getEntities().get(j).getLocation()) < 3) {
									LivingEntity entity = (LivingEntity)target.getWorld().getEntities().get(j);
									entity.teleport(new Location(entity.getWorld(), entity.getLocation().getX(), entity.getLocation().getY() + 0.5, entity.getLocation().getZ()));
									entity.setVelocity(new Vector(0,1.5,0));
									entity.damage(4, player);
									entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20,1,true));
									
									Particle.DustOptions dustOptions = new Particle.DustOptions(color, 4F + w*0.1f + 1);
									target.getWorld().spawnParticle(Particle.REDSTONE, entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ() , 0, 0D, 0D, 0D, dustOptions);
								}
							}
						}
					  
					  
					  
					  
					  if(nbr == 1) {
					    	for (int j = 0; j < brun.size(); j++) {
					    		brun.get(j).cancel();
					    	}
					    }else if(nbr == 2) {
					    	 for (int j = 0; j < brun2.size(); j++) {
					    		 brun2.get(j).cancel();
					 		}	
					    }else if(nbr == 3) {
					    	 for (int j = 0; j < brun3.size(); j++) {
					    		 brun3.get(j).cancel();
					 		}	
					    }else if(nbr == 4) {
					    	 for (int j = 0; j < brun4.size(); j++) {
					    		 brun4.get(j).cancel();
					 		}	
					    }else if(nbr == 5) {
					    	 for (int j = 0; j < brun5.size(); j++) {
					    		 brun5.get(j).cancel();
					 		}	
					    }else if(nbr == 6) {
					    	 for (int j = 0; j < brun6.size(); j++) {
					    		 brun6.get(j).cancel();
					 		}	
					    }else if(nbr == 7) {
					    	 for (int j = 0; j < brun7.size(); j++) {
					    		 brun7.get(j).cancel();
					 		}	
					    }else if(nbr == 8) {
					    	 for (int j = 0; j < brun8.size(); j++) {
					    		 brun8.get(j).cancel();
					 		}	
					    }else if(nbr == 9) {
					    	 for (int j = 0; j < brunb.size(); j++) {
					    		 brunb.get(j).cancel();
					 		}	
					    }else if(nbr == 10) {
					    	 for (int j = 0; j < brun2b.size(); j++) {
					    		 brun2b.get(j).cancel();
					 		}	
					    }else if(nbr == 11) {
					    	 for (int j = 0; j < brun3b.size(); j++) {
					    		 brun3b.get(j).cancel();
					 		}	
					    }else if(nbr == 12) {
					    	 for (int j = 0; j < brun4b.size(); j++) {
					    		 brun4b.get(j).cancel();
					 		}	
					    }else if(nbr == 13) {
					    	 for (int j = 0; j < brun5b.size(); j++) {
					    		 brun5b.get(j).cancel();
					 		}	
					    }else if(nbr == 14) {
					    	 for (int j = 0; j < brun6b.size(); j++) {
					    		 brun6b.get(j).cancel();
					 		}	
					    }else if(nbr == 15) {
					    	 for (int j = 0; j < brun7b.size(); j++) {
					    		 brun7b.get(j).cancel();
					 		}	
					    }else if(nbr == 16) {
					    	 for (int j = 0; j < brun8b.size(); j++) {
					    		 brun8b.get(j).cancel();
					 		}	
					    }
					  
					
				}
				  			
			}
		};
   }
   
   private void launchProjectile(LivingEntity player, Location target, Location target2, Color color, int nbr) {
	    double distance = target.distance(target2);
	    Vector v = target.toVector();
	    Vector v2 = target2.toVector();
	    Vector vector = v2.clone().subtract(v).normalize().multiply(0.25D);
	    double length = 0.0D;
	    for (int i = 0; length < distance;) {
	    	int z = i;
	    	 if(nbr == 1) {
	    		 brun.add(bolt(vector, z, target, player, color, 1));
	 	    }else if(nbr == 2) {
	 	    	brun2.add(bolt(vector, z, target, player, color, 2));
	 	    }else if(nbr == 3) {
	 	    	brun3.add(bolt(vector, z, target, player, color, 3));
	 	    }else if(nbr == 4) {
	 	    	brun4.add(bolt(vector, z, target, player, color, 4));
	 	    }else if(nbr == 5) {
	 	    	brun5.add(bolt(vector, z, target, player, color, 5));
	 	    }else if(nbr == 6) {
	 	    	brun6.add(bolt(vector, z, target, player, color, 6));
	 	    }else if(nbr == 7) {
	 	    	brun7.add(bolt(vector, z, target, player, color, 7));
	 	    }else if(nbr == 8) {
	 	    	brun8.add(bolt(vector, z, target, player, color, 8));
	 	    }else if(nbr == 9) {
	    		 brunb.add(bolt(vector, z, target, player, color, 9));
	 	    }else if(nbr == 10) {
	 	    	brun2b.add(bolt(vector, z, target, player, color, 10));
	 	    }else if(nbr == 11) {
	 	    	brun3b.add(bolt(vector, z, target, player, color, 11));
	 	    }else if(nbr == 12) {
	 	    	brun4b.add(bolt(vector, z, target, player, color, 12));
	 	    }else if(nbr == 13) {
	 	    	brun5b.add(bolt(vector, z, target, player, color, 13));
	 	    }else if(nbr == 14) {
	 	    	brun6b.add(bolt(vector, z, target, player, color, 14));
	 	    }else if(nbr == 15) {
	 	    	brun7b.add(bolt(vector, z, target, player, color, 15));
	 	    }else if(nbr == 16) {
	 	    	brun8b.add(bolt(vector, z, target, player, color, 16));
	 	    }	 	
	        
	    	i++;
	        length += 0.55D;
	    }
	    if(nbr == 1) {
	    	for (int j = 0; j < brun.size(); j++) {
	    		brun.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	    	}
	    }else if(nbr == 2) {
	    	 for (int j = 0; j < brun2.size(); j++) {
	    		 brun2.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 3) {
	    	 for (int j = 0; j < brun3.size(); j++) {
	    		 brun3.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 4) {
	    	 for (int j = 0; j < brun4.size(); j++) {
	    		 brun4.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 5) {
	    	 for (int j = 0; j < brun5.size(); j++) {
	    		 brun5.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 6) {
	    	 for (int j = 0; j < brun6.size(); j++) {
	    		 brun6.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 7) {
	    	 for (int j = 0; j < brun7.size(); j++) {
	    		 brun7.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 8) {
	    	 for (int j = 0; j < brun8.size(); j++) {
	    		 brun8.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 9) {
	    	for (int j = 0; j < brunb.size(); j++) {
	    		brunb.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	    	}
	    }else if(nbr == 10) {
	    	 for (int j = 0; j < brun2b.size(); j++) {
	    		 brun2b.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 11) {
	    	 for (int j = 0; j < brun3b.size(); j++) {
	    		 brun3b.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 12) {
	    	 for (int j = 0; j < brun4b.size(); j++) {
	    		 brun4b.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 13) {
	    	 for (int j = 0; j < brun5b.size(); j++) {
	    		 brun5b.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 14) {
	    	 for (int j = 0; j < brun6b.size(); j++) {
	    		 brun6b.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 15) {
	    	 for (int j = 0; j < brun7b.size(); j++) {
	    		 brun7b.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }else if(nbr == 16) {
	    	 for (int j = 0; j < brun8b.size(); j++) {
	    		 brun8b.get(j).runTaskLater(DonjonMain.instance, (int)(Math.log(j)*10));
	 		}	
	    }
	    
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

