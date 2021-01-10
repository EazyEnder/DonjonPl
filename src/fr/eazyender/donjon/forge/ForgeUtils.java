package fr.eazyender.donjon.forge;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.donjon.LootUtils;
import fr.eazyender.donjon.files.PlayerEconomy;
import fr.eazyender.donjon.files.PlayerEquipment;
import fr.eazyender.donjon.gui.ForgeGui;
import fr.eazyender.donjon.forge.IWeaponRecipe;

public class ForgeUtils {
	
	public static int weaponscraft = 1;
	private static Map<Player, Integer> timer = new HashMap<Player, Integer>();
	
	public static int getCraftCooldown(Player player) {
		if(timer.containsKey(player)) {
			return timer.get(player);
		}else {
			return 0;
		}
	}
	
	public static boolean launchCraft(Player player, IWeaponRecipe recipe) {
		
		if(getCraftCooldown(player) <= 0 && PlayerEconomy.getEconomy().getMoney(player) >= recipe.getCost()) {
			
			if(!timer.containsKey(player))timer.put(player, recipe.getTime());
			else timer.replace(player, recipe.getTime());
			
			new BukkitRunnable() {

				@Override
				public void run() {
					
					if(getCraftCooldown(player) <= 0) {
						
						if(recipe.getCost() > 0) {PlayerEconomy.getEconomy().setMoney(player, PlayerEconomy.getEconomy().getMoney(player)-recipe.getCost());}
						
						PlayerEquipment.getPlayerEquipment().getWeapons(player).add(LootUtils.getIDWeaponByItem(recipe.getCraft()));
						LootUtils.removeItemsOfRessources(player, recipe.getIngredients());
						
						player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
						player.sendMessage("§f[§7Craft§f] : " + "Vous avez fini de fabriquer §7" + recipe.getCraft().getItemMeta().getDisplayName());
						
						timer.remove(player);
						this.cancel();
					}else {
						timer.replace(player, getCraftCooldown(player)-1);
					}
					
					if(timer.containsKey(player))
					ForgeGui.launchCraft(player, timer.get(player), recipe.getTime());
					
				}
				
			}.runTaskTimer(DonjonMain.instance, 20, 20);
			return true;
			
		}else {
			return false;
		}
		
	}

}
