package fr.eazyender.donjon.donjon.weapons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ItemPoisonousSword implements Listener{

	public static ItemStack getWeapon() {
		return getWeaponDrop(Material.STONE_SWORD,
				"§2Epee empoisonnee",
				false,
				1,
				"§fUne arme pouvant infliger poison aux ennemis", "B");
	}
	
	@EventHandler
	public void onPlayerAttackEntity(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player && e.getEntity() instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) e.getEntity();
			Player player = (Player) e.getDamager();
			if(player.getItemInHand() != null && player.getItemInHand().hasItemMeta()) {
				if(player.getItemInHand().getItemMeta().getDisplayName().equals(getWeapon().getItemMeta().getDisplayName())) {
					
					if(RandomNumber(1,100) > 80) {
						entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*2, 1));
					}
					
				}
			}
		}
	}
	
	private static ItemStack getWeaponDrop(Material material, String customName, boolean EnchantEffect, int nbr, String description, String rarety) {
		
		ItemStack item = new ItemStack(material, nbr);
		ItemMeta itemMeta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(description);
		lore.add("§fRank : " + rarety);
		itemMeta.setLore(lore);
		if(customName != null) {itemMeta.setDisplayName(customName);}
		if(EnchantEffect) {itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 200, true);itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);}
		itemMeta.setUnbreakable(true);
		item.setItemMeta(itemMeta);
		
		
		return item;
		
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
