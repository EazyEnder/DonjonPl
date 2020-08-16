package fr.eazyender.donjon.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.spells.ColorUtils;

public class PlayerChromatiques {
	
	public static PlayerChromatiques playerChromatique;
	
	 private static Map<UUID, List<Boolean>> chromatiques_fire = new HashMap<UUID, List<Boolean>>();
	
	  private static File ChromatiqueFile;
	  private static FileConfiguration ChromatiqueConfig;
	
	  public PlayerChromatiques() {
		  playerChromatique = this;
		    registerFile();
		    for (Player ps : Bukkit.getOnlinePlayers()) {
		      loadPlayer(ps);
		    }
	  }
	  
	  public void onDisable() {
		  for (Player ps : Bukkit.getOnlinePlayers()) {
		  ConfigurationSection s = ChromatiqueConfig.getConfigurationSection(ps.getUniqueId().toString());
		  s.set("chromatiques_fire", chromatiques_fire.get(ps.getUniqueId()));
		
		  }
		    saveFile();
		  }
	  
	  public static void createPlayerChromatiques(Player p) {
		  chromatiques_fire.put(p.getUniqueId(), new ArrayList<Boolean>());
		   
		    ConfigurationSection s = ChromatiqueConfig.createSection(p.getUniqueId().toString());
		    List<Boolean> chromasfire = new ArrayList<Boolean>();
		    for (int i = 0; i < ColorUtils.fireskins.size(); i++) {
				chromasfire.add(false);
			}
		    chromasfire.set(0,true);
		    s.set("chromatiques_fire", chromasfire);
		    
		    saveFile();
		  }
	  
	  
	 private void registerFile() {
		 ChromatiqueFile = new File(DonjonMain.instance.getDataFolder(), "PlayerChromatiques.yml");
		 ChromatiqueConfig = YamlConfiguration.loadConfiguration(ChromatiqueFile);
		    saveFile();
		  }
	 
	 private static void saveFile() {
		    try {		    
		    	ChromatiqueConfig.save(ChromatiqueFile);
		    } catch (IOException iOException) {}
		  }
	 
	 public void loadPlayer(Player p) {
		    if (ChromatiqueConfig.contains(p.getUniqueId().toString())) {
		      ConfigurationSection s = ChromatiqueConfig.getConfigurationSection(p.getUniqueId().toString());
		      	List<Boolean> chromatiques_fire_list = s.getBooleanList("chromatiques_fire");
		      	if(chromatiques_fire_list.size() < ColorUtils.fireskins.size()) {for (int i = 0; i < ColorUtils.fireskins.size() - chromatiques_fire_list.size(); i++) {
		      		chromatiques_fire_list.add(false);
				}}
		      	chromatiques_fire.put(p.getUniqueId(), chromatiques_fire_list);
		    } else {
		    	createPlayerChromatiques(p);
		    }
		  }
	 
	 
	 public List<Boolean> getFireChromas(Player p) {
		    if (playerExist(p)) {	
		    	return chromatiques_fire.get(p.getUniqueId());
		    }else {System.out.println("Player doesn't exist");}
		    return null;
		  }
	 public void setFireChromas(Player p, List<Boolean> newIT) {
		    if (playerExist(p)) {
		    	chromatiques_fire.replace(p.getUniqueId(), newIT);
		    }else {System.out.println("Player doesn't exist");}
		  }
	 public void unloadPlayer(Player p) {
		 	onDisable();
		    if (playerExist(p)) {
		    	chromatiques_fire.remove(p.getUniqueId());
		    }
		  }
	 
	 public static PlayerChromatiques getPlayerChromatiques() { return playerChromatique;  }
	 
	 public boolean playerExist(Player p) { return chromatiques_fire.containsKey(p.getUniqueId()); }



}
