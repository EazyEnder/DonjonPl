package fr.eazyender.donjon.spells.water;

import fr.eazyender.donjon.spells.ColorUtils;
import fr.eazyender.donjon.spells.ISpell;
import fr.eazyender.donjon.spells.ManaEvents;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SpellHealSelf extends ISpell {
    
    public static int basicCooldown = 15 * 1000;
    public static int basicCost = 30;

    private static final double valueHp = 6;

    public SpellHealSelf(int cooldown) {
        super(basicCooldown);
    }

    public void launch(Player player) {
        if(ManaEvents.canUseSpell(player, basicCost)) {
            if (super.launch(player, SpellHealProjectile.class)) {

                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 1, 1);
                launchSpell(player);
                ManaEvents.useSpell(player, basicCost);

            } else {

            }
        }
    }

    private void launchSpell(Player player) {

        Particle.DustOptions dustOptions = new Particle.DustOptions(ColorUtils.getSkins().get(player).get(2), 0.5F);
        player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().getX()-1, player.getLocation().getY()+1, player.getLocation().getZ()+1, 10, 1D, 1D, 1D, dustOptions);

        if(player.getHealth() >= player.getMaxHealth()){

        }else if(player.getHealth() + valueHp >= player.getMaxHealth()){
            player.setHealth(player.getMaxHealth());
        }else{
            player.setHealth(player.getHealth()+valueHp);
        }

    }

}

