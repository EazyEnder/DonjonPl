package fr.eazyender.donjon.spells.water;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.spells.ColorUtils;
import fr.eazyender.donjon.spells.ISpell;
import fr.eazyender.donjon.spells.ManaEvents;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class SpellHealAOE extends ISpell {

    public static int basicCooldown = 45 * 1000;
    public static int basicCost = 60;

    public int timer = 0;
    public int maxTimer = 5;

    public SpellHealAOE(int cooldown) {
        super(basicCooldown);
    }

    public void launch(Player player) {
        if(ManaEvents.canUseSpell(player, basicCost)) {
            if (super.launch(player, SpellHealAOE.class)) {

                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 3, 1);
                launchSpell(player, ColorUtils.getSkins().get(player).get(2));
                ManaEvents.useSpell(player,basicCost);
            }
        }

    }

    private void launchSpell(Player player, Color color) {

        Location send = player.getLocation();
        Particle.DustOptions dustOptions = new Particle.DustOptions(color, 2.0F);

        new BukkitRunnable() {
            @Override
            public void run() {

                if(timer < maxTimer) {

                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 1, true)) ;

                    for (int i = 0; i < 360; i=i+10) {
                        player.getWorld().spawnParticle(Particle.HEART, send.getX() + Math.cos(i) * RandomNumber(0, 5), send.getY() + RandomNumber(-1, 1), send.getZ() + Math.sin(i)   * RandomNumber(0, 5), 0, 0D, 0.025D * RandomNumber(1, 4), 0D);
                        player.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 5, send.getY(), send.getZ() + Math.sin(i)  * 5, 0, 0D, 0.5D, 0D, dustOptions);
                        player.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 4, send.getY(), send.getZ() + Math.sin(i)  * 4, 0, 0D, 0.5D, 0D, dustOptions);
                        player.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 3, send.getY(), send.getZ() + Math.sin(i)  * 3, 0, 0D, 0.5D, 0D, dustOptions);
                        player.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 2, send.getY(), send.getZ() + Math.sin(i)  * 2, 0, 0D, 0.5D, 0D, dustOptions);
                        player.getWorld().spawnParticle(Particle.REDSTONE, send.getX() + Math.cos(i) * 1, send.getY(), send.getZ() + Math.sin(i)  * 1, 0, 0D, 0.5D, 0D, dustOptions);
                    }

                    for (Entity entity : player.getNearbyEntities(5, 2, 5)) {
                        if(entity instanceof LivingEntity) {
                            if(entity instanceof Player) {
                             player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 1, true)) ;
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

