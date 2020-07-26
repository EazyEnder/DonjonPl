package fr.eazyender.donjon.files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.eazyender.donjon.utils.PlayerGroup;

public class PlayerGroupSave {

    public static PlayerGroupSave playerGrp;

    private static Map<UUID, PlayerGroup> groups = new HashMap<UUID, PlayerGroup>();

    public PlayerGroupSave() {
    	playerGrp = this;
        for (Player ps : Bukkit.getOnlinePlayers()) {
            loadPlayer(ps);
        }
    }

    public static void createPlayerGroup(Player p) {
        groups.put(p.getUniqueId(), new PlayerGroup(p));
    }

    public void loadPlayer(Player p) {
        	createPlayerGroup(p);
    }
    
    public List<PlayerGroup> getAllGroup() {
    	List<PlayerGroup> newgroups = new ArrayList<PlayerGroup>();
    	  for (Player ps : Bukkit.getOnlinePlayers()) {
    		  newgroups.add(getGroup(ps));
    	  }
          return newgroups;
    }

    public PlayerGroup getGroup(Player p) {
        if (playerExist(p)) {
            return groups.get(p.getUniqueId());
        }else {System.out.println("Player doesn't exist");
            return null;}
    }
    public void setGroup(Player p, PlayerGroup newValue) {
        if (playerExist(p)) {
            groups.replace(p.getUniqueId(), newValue);
        }else {System.out.println("Player doesn't exist");}
    }
    public void unloadPlayer(Player p) {
        if (playerExist(p)) {
            groups.remove(p.getUniqueId());
        }
    }

    public static PlayerGroupSave getPlayerGroup() { return playerGrp;  }

    public boolean playerExist(Player p) { return groups.containsKey(p.getUniqueId()); }


}
