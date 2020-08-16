package fr.eazyender.donjon.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.spells.ColorUtils;

public class PlayerShop {
	
	public static PlayerShop playerShop;
	
	 private static Map<UUID, Integer> grades = new HashMap<UUID, Integer>();
	 private static Map<UUID, Long> timebuy = new HashMap<UUID, Long>();
	
	  private static File playerShopFile;
	  private static FileConfiguration playerShopConfig;
	
	  public PlayerShop() {
		  playerShop = this;
		    registerFile();
		    for (Player ps : Bukkit.getOnlinePlayers()) {
		      loadPlayer(ps);
		    }
		    for (OfflinePlayer ps : Bukkit.getOfflinePlayers()) {
				loadPlayer(ps);
			}
	  }
	  
	  public void onDisable() {
		  for (Player ps : Bukkit.getOnlinePlayers()) {
		  ConfigurationSection s = playerShopConfig.getConfigurationSection(ps.getUniqueId().toString());
		  s.set("grade", grades.get(ps.getUniqueId()));
		  s.set("timebuy", timebuy.get(ps.getUniqueId()));
		
		  }
		    saveFile();
		  }
	  
	  public static void createPlayerShop(Player p) {
		  grades.put(p.getUniqueId(), 0);
		  timebuy.put(p.getUniqueId(), (long) 0);
		   
		    ConfigurationSection s = playerShopConfig.createSection(p.getUniqueId().toString());
		    s.set("grade", 0);
		    s.set("timebuy", 0);
		    
		    saveFile();
		  }
	  
	  public static void createPlayerShop(OfflinePlayer p) {
		  grades.put(p.getUniqueId(), 0);
		  timebuy.put(p.getUniqueId(), (long) 0);
		   
		    ConfigurationSection s = playerShopConfig.createSection(p.getUniqueId().toString());
		    s.set("grade", 0);
		    s.set("timebuy", 0);
		    
		    saveFile();
		  }
	  
	  
	 private void registerFile() {
		 playerShopFile = new File(DonjonMain.instance.getDataFolder(), "PlayerShopProfil.yml");
		 playerShopConfig = YamlConfiguration.loadConfiguration(playerShopFile);
		    saveFile();
		  }
	 
	 private static void saveFile() {
		    try {		    
		    	playerShopConfig.save(playerShopFile);
		    } catch (IOException iOException) {}
		  }
	 
	 public void loadPlayer(Player p) {
		    if (playerShopConfig.contains(p.getUniqueId().toString())) {
		      ConfigurationSection s = playerShopConfig.getConfigurationSection(p.getUniqueId().toString());
		      	grades.putIfAbsent(p.getUniqueId(), s.getInt("grade"));
		      	timebuy.putIfAbsent(p.getUniqueId(), s.getLong("timebuy"));
		    } else {
		    	createPlayerShop(p);
		    }
		  }
	 
	 public void loadPlayer(OfflinePlayer p) {
		    if (playerShopConfig.contains(p.getUniqueId().toString())) {
		      ConfigurationSection s = playerShopConfig.getConfigurationSection(p.getUniqueId().toString());
		        grades.putIfAbsent(p.getUniqueId(), s.getInt("grade"));
		    	timebuy.putIfAbsent(p.getUniqueId(), s.getLong("timebuy"));
		    }else {
		    	createPlayerShop(p);
		    }
		  }
	 
	 
	 public int getGrade(Player p) {
		    if (playerExist(p)) {	
		    	return grades.get(p.getUniqueId());
		    }else {System.out.println("Player doesn't exist");}
		    return 0;
		  }
	 public void setGrade(Player p, int newV) {
		    if (playerExist(p)) {
		    	grades.replace(p.getUniqueId(), newV);
		    }else {System.out.println("Player doesn't exist");}
		  }
	 public long getTimeBuy(Player p) {
		    if (playerExist(p)) {	
		    	return timebuy.get(p.getUniqueId());
		    }else {System.out.println("Player doesn't exist");}
		    return 0;
		  }
	 public void setTimeBuy(Player p, long newV) {
		    if (playerExist(p)) {
		    	timebuy.replace(p.getUniqueId(), newV);
		    }else {System.out.println("Player doesn't exist");}
		  }
	 public int getGrade(OfflinePlayer p) {
		    if (playerExist(p)) {	
		    	return grades.get(p.getUniqueId());
		    }else {System.out.println("Player doesn't exist");}
		    return 0;
		  }
	 public void setGrade(OfflinePlayer p, int newV) {
		    if (playerExist(p)) {
		    	grades.replace(p.getUniqueId(), newV);
		    }else {System.out.println("Player doesn't exist");}
		  }
	 public long getTimeBuy(OfflinePlayer p) {
		    if (playerExist(p)) {	
		    	return timebuy.get(p.getUniqueId());
		    }else {System.out.println("Player doesn't exist");}
		    return 0;
		  }
	 public void setTimeBuy(OfflinePlayer p, long newV) {
		    if (playerExist(p)) {
		    	timebuy.replace(p.getUniqueId(), newV);
		    }else {System.out.println("Player doesn't exist");}
		  }

	 public void unloadPlayer(Player p) {
		 	onDisable();
		    if (playerExist(p)) {
		    	grades.remove(p.getUniqueId());
		    }
		  }
	 public void unloadPlayer(OfflinePlayer p) {
		 	onDisable();
		    if (playerExist(p)) {
		    	grades.remove(p.getUniqueId());
		    }
		  }
	 
	 public static PlayerShop getPlayerShopProfil() { return playerShop;  }
	 
	 public boolean playerExist(Player p) { return grades.containsKey(p.getUniqueId()) && timebuy.containsKey(p.getUniqueId()); }
	 
	 public boolean playerExist(OfflinePlayer p) { return grades.containsKey(p.getUniqueId()) && timebuy.containsKey(p.getUniqueId()); }



}

