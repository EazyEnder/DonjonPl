package fr.eazyender.donjon.spells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Color;
import org.bukkit.entity.Player;

public class ColorUtils {
	
	private static Map<Player, List<Color>> skins = new HashMap<Player, List<Color>>(); 
	
	public static List<String> firename = new ArrayList<String>();
	public static List<Color> fireskins = new ArrayList<Color>();
	public static List<Integer> fireprice = new ArrayList<Integer>();
	
	public static final Color earth = Color.fromRGB(115, 78, 72),
		fire = Color.fromRGB(120,0,0),
		water = Color.fromRGB(132,165,255),
		wind = Color.fromRGB(255,255,255),
		shadow = Color.fromRGB(66,56,64),
		light = Color.fromRGB(251,255,84),
		poison = Color.fromRGB(0,120,0);
	
	public static void initColorSkin() {
		initFireSkins();
	}
	
	private static void initFireSkins() {
		//BASIC RED
		firename.add("Rouge");
		fireskins.add(fire);
		fireprice.add(0);
		//LIGHT RED
		firename.add("Rouge clair");
		fireskins.add(Color.fromRGB(209,85,73));
		fireprice.add(250);
		//PINK RED
		firename.add("Rouge peche");
		fireskins.add(Color.fromRGB(226,140,111));
		fireprice.add(300);
		//DARK RED
		firename.add("Rouge sombre");
		fireskins.add(Color.fromRGB(76, 30, 26));
		fireprice.add(200);
		//LEMON
		firename.add("Sable");
		fireskins.add(Color.fromRGB(198, 159, 97));
		fireprice.add(325);
		//PURPLE RED
		firename.add("Rouge violet");
		fireskins.add(Color.fromRGB(119, 73, 73));
		fireprice.add(250);
	}
	
	public static void loadPlayer(Player player) {
		
		if(!skins.containsKey(player)) {
			
			List<Color> colors = new ArrayList<Color>();
			colors.add(earth);
			colors.add(fire);
			colors.add(water);
			colors.add(wind);
			colors.add(shadow);
			colors.add(light);
			colors.add(poison);
			skins.put(player, colors);
			
		}
		
	}
	
	public static void unloadPlayer(Player player) {
		
		if(skins.containsKey(player)) {
			skins.remove(player);
		}
		
	}

	public static Map<Player, List<Color>> getSkins() {
		return skins;
	}

	public static void setSkins(Map<Player, List<Color>> skins) {
		ColorUtils.skins = skins;
	}
	
	

}
