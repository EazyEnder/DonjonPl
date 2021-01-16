package fr.eazyender.donjon.donjon.weapons;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.eazyender.donjon.spells.weapon.ItemSpellBeginnerOrb;

public class ItemBeginnerOrb implements Listener{

	public static ItemStack getWeapon() {
		return getWeaponDrop(Material.IRON_INGOT,
				"�2Orbe du Commencement",
				false,
				1,
				"�fCondens� de mana de qualit� faible", "C");
	}
	
	@EventHandler
	public void onPlayerRightClickOnWeapon(PlayerInteractEvent e) {
		Player player = e.getPlayer();
	  	if((e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && player.getItemInHand() != null && player.getItemInHand().hasItemMeta()) {
	  		if(player.getItemInHand().getItemMeta().getDisplayName().equals(getWeapon().getItemMeta().getDisplayName())) {
	  			//Launch spell
	  			ItemSpellBeginnerOrb spell = new ItemSpellBeginnerOrb(1000*5); spell.launch(player);
	  			
	  		}
	  	}
	}
	
	private static ItemStack getWeaponDrop(Material material, String customName, boolean EnchantEffect, int nbr, String description, String rarety) {
		
		ItemStack item = new ItemStack(material, nbr);
		ItemMeta itemMeta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(description);
		lore.add("�fRank : " + rarety);
		itemMeta.setLore(lore);
		if(customName != null) {itemMeta.setDisplayName(customName);}
		if(EnchantEffect) {itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 200, true);itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);}
		itemMeta.setUnbreakable(true);
		item.setItemMeta(itemMeta);
		
		
		return item;
		
	}
	
}
