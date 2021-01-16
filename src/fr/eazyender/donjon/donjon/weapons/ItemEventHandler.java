package fr.eazyender.donjon.donjon.weapons;

import org.bukkit.plugin.PluginManager;

import fr.eazyender.donjon.DonjonMain;

public class ItemEventHandler {
	
	public static void initEvents(DonjonMain main) {
		
		PluginManager pm = main.getServer().getPluginManager();
		
		pm.registerEvents(new ItemBeginnerOrb(), main);
		pm.registerEvents(new ItemPoisonousSword(), main);
		pm.registerEvents(new ItemDawnSword(), main);
		
	}

}
