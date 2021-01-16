package fr.eazyender.donjon.spells.weapon;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.eazyender.donjon.spells.ISpell;
import fr.eazyender.donjon.spells.ManaEvents;

public class ItemSpellDawnSword extends ISpell {
    
    public static int basicCooldown = 30 * 1000;
    public static int basicCost = 0;

    public ItemSpellDawnSword(int cooldown) {
        super(basicCooldown);
    }

    public void launch(Player player) {
        if(ManaEvents.canUseSpell(player, basicCost)) {
            if (super.launch(player, ItemSpellDawnSword.class)) {

                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 1, 1);
                launchSpell(player);
                ManaEvents.useSpell(player, basicCost);

            } else {

            }
        }
        basicCost = 30;
    }

    private void launchSpell(Player player) {

        List<Entity> entities = player.getNearbyEntities(25, 25, 25);
        for (Entity e : entities) {
			if(e instanceof LivingEntity) {
				LivingEntity entity = (LivingEntity) e;
				entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20*5, 1));
			}
		}

    }
}
