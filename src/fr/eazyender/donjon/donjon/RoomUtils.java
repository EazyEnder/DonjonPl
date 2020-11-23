package fr.eazyender.donjon.donjon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Golem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.PolarBear;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Stray;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class RoomUtils {
	
	public static String getStringType(int type) {
		switch(type) {
		case 0: return "Begin";
		case 1: return "Corridor";
		case 2: return "Small";
		case 3: return "Medium";
		case 4: return "Big";
		case 5: return "Huge";
		case 6: return "Boss";
		default: return "Undefinied";
		}
	}
	
	public static int getNumberOfBiomes() {
		return 3;
	}
	
	public static int getLaunchDonjonOnABiome(int biome) {

		int count = 0;
		if(!DonjonGenerator.donjons.isEmpty()) {
		List<IDonjon> dj = new ArrayList<IDonjon>();
		dj.addAll(DonjonGenerator.donjons.values());
		for (int i = 0; i < dj.size(); i++) {
			IDonjon donjon = dj.get(i);
			if(donjon.getBiome() == biome) {
				count++;
			}
		}
		}
		return count;
		
	}
	
	public static List<IRoom> getRoomsOfABiome(int biome){
		switch(biome) {
		case 1: return RoomsInit.rooms_1;
		case 2: return RoomsInit.rooms_2;
		case 3: return RoomsInit.rooms_3;
		default: return null;
		}
	}
	
	public static int getNumberOfASimilarRoom(int biome, int type) {
		
		int nbr = 0;
		for (int i = 0; i < getRoomsOfABiome(biome).size(); i++) {
			if(getRoomsOfABiome(biome).get(i).getType() == type) {
				nbr++;
			}
		}
		return nbr;
	}
	
	public static List<IRoom> getSimilarRooms(int biome,int type){
		
		List<IRoom> rooms = new ArrayList<IRoom>();
		for (int i = 0; i < getRoomsOfABiome(biome).size(); i++) {
			if(getRoomsOfABiome(biome).get(i).getType() == type) {
				rooms.add(getRoomsOfABiome(biome).get(i));
			}
		}
		return rooms;
		
	}
	
	public static void genEntity(IDonjon donjon,IRoom room,World world) {
		
		int mMob = 1;
		switch(donjon.getDifficulty()) {
		case 1: mMob = 1;
			break;
		case 2: mMob = 1;
			break;
		case 3: mMob = 2;
			break;
		case 4: mMob = 3;
			break;
		}
		
		Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
		Team yellow=null,red=null,black = null;
		if(board.getTeam("mobYellow"+world.getName()) == null)
		yellow = board.registerNewTeam("mobYellow"+world.getName());
		else yellow = board.getTeam("mobYellow"+world.getName());
		yellow.setColor(ChatColor.YELLOW);
		if(board.getTeam("mobRed"+world.getName()) == null)
		red = board.registerNewTeam("mobRed"+world.getName());
		else red = board.getTeam("mobRed"+world.getName());
		red.setColor(ChatColor.RED);
		if(board.getTeam("mobBlack"+world.getName()) == null)
		black = board.registerNewTeam("mobBlack"+world.getName());
		else black = board.getTeam("mobBlack"+world.getName());
		black.setColor(ChatColor.BLACK);
		
		for (int i = 0; i < room.getEntity_loc().size(); i++) {
			for (int j = 0; j < mMob; j++) {
				LivingEntity entity = genCustomMobs(donjon,room.getEntity_type().get(i), room.getEntity_loc().get(i), world);
				
				if(room.equals(donjon.getDonjon().get(donjon.getDonjon().size()-1))) {
					int chance = RandomNumber(0, 10000);
				if(chance < 1000) {
					entity.setMaxHealth(entity.getMaxHealth()+entity.getMaxHealth()/2);
					entity.setHealth(entity.getMaxHealth());
					entity.setGlowing(true);
					yellow.addEntry(entity.getUniqueId().toString());
				}
				else if(chance < 100) {
					entity.setMaxHealth(entity.getMaxHealth()+entity.getMaxHealth()/1.5);
					entity.setHealth(entity.getMaxHealth());
					entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 1, true));
					entity.setGlowing(true);
					red.addEntry(entity.getUniqueId().toString());
				}
				else if(chance < 10) {
					entity.setMaxHealth(entity.getMaxHealth()+entity.getMaxHealth());
					entity.setHealth(entity.getMaxHealth());
					entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 1, true));
					entity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 1, true));
					entity.setGlowing(true);
					black.addEntry(entity.getUniqueId().toString());
				}
				}
			}
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static LivingEntity genCustomMobs(IDonjon donjon, String name, Location loc, World world) {
		
		double mHp = 1;
		switch(donjon.getDifficulty()) {
		case 1: mHp = 0.5;
			break;
		case 2: mHp = 1;
			break;
		case 3: mHp = 1;
			break;
		case 4: mHp = 1;
			break;
		}
		LivingEntity entity = null;
		
		if(name.contains("SQUELETON")) {
			
		Skeleton skeleton = (Skeleton) world.spawnEntity(loc, EntityType.SKELETON);
		switch(name) {
		case "BUSH_SQUELETON": skeleton.setCustomName("BUSH_SQUELETON"); skeleton.setHealth(mHp*skeleton.getMaxHealth()); skeleton.setMaxHealth(mHp*skeleton.getMaxHealth());
			break;	
		case "GRANITE_ARCHER_SQUELETON": skeleton.setCustomName("GRANITE_ARCHER_SQUELETON");skeleton.setHealth(mHp*skeleton.getMaxHealth()); skeleton.setMaxHealth(mHp*skeleton.getMaxHealth());
			break;	
		case "GRANITE_KNIGHT_SQUELETON": skeleton.setCustomName("GRANITE_KNIGHT_SQUELETON");skeleton.setHealth(mHp*skeleton.getMaxHealth()); skeleton.setMaxHealth(mHp*skeleton.getMaxHealth());
		skeleton.getEquipment().setItemInMainHand(LootUtils.getWeaponById(5));
			break;	
		case "GRANITE_KING_SQUELETON": skeleton.setCustomName("GRANITE_KING_SQUELETON");
		ItemStack sword1 = LootUtils.getWeaponById(1);
		skeleton.getEquipment().setItemInMainHand(sword1);
		skeleton.getEquipment().setHelmet(LootUtils.getArmorById(1, 1, "IRON"));
		skeleton.getEquipment().setChestplate(LootUtils.getArmorById(1, 2, "IRON"));
		skeleton.getEquipment().setLeggings(LootUtils.getArmorById(1, 3, "IRON"));
		skeleton.getEquipment().setBoots(LootUtils.getArmorById(1, 4, "IRON"));
		skeleton.setHealth(mHp*skeleton.getMaxHealth()); skeleton.setMaxHealth(mHp*skeleton.getMaxHealth());
			break;	
		case "ICE_SQUELETON": Stray stray = (Stray) world.spawnEntity(loc, EntityType.STRAY);
		stray.setCustomName("ICE_SQUELETON"); skeleton.remove();
		skeleton.setHealth(mHp*skeleton.getMaxHealth()); skeleton.setMaxHealth(mHp*skeleton.getMaxHealth());
		
			break;
		case "SAND_SQUELETON": skeleton.setCustomName("SAND_SQUELETON");
		skeleton.setMaxHealth(mHp*30); skeleton.setHealth(mHp*30);
			break;
		case "ANCIENT_SQUELETON": skeleton.setCustomName("ANCIENT_SQUELETON");
		skeleton.setMaxHealth(mHp*45); skeleton.setHealth(mHp*45);
			break;
		}
		skeleton.setCustomNameVisible(false);
		entity = skeleton;
		EntityEvents.launchEntityLoop(skeleton);
		
		}else if(name.contains("ZOMBIE")) {
			
			Zombie zombie = (Zombie) world.spawnEntity(loc, EntityType.ZOMBIE);
			switch(name) {
			case "BUSH_ZOMBIE": zombie.setCustomName("BUSH_ZOMBIE");
			zombie.setHealth(mHp*zombie.getMaxHealth()); zombie.setMaxHealth(mHp*zombie.getMaxHealth());
				break;
			case "ICE_ZOMBIE": zombie.setCustomName("ICE_ZOMBIE"); zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9000, 1, true));
			zombie.setHealth(mHp*zombie.getMaxHealth()); zombie.setMaxHealth(mHp*zombie.getMaxHealth());
				break;
			case "FROZEN_ZOMBIE": zombie.setCustomName("FROZEN_ZOMBIE"); zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9000, 1, true));
			zombie.setHealth(35*mHp); zombie.setMaxHealth(35*mHp);
			zombie.getEquipment().setItemInMainHand(LootUtils.getWeaponById(3));
				break;
			case "MOMIE_ZOMBIE": zombie.setCustomName("MOMIE_ZOMBIE");zombie.setMaxHealth(45*mHp);zombie.setHealth(45*mHp);
				break;
			}
			zombie.setCustomNameVisible(false);
			entity = zombie;
			EntityEvents.launchEntityLoop(zombie);
			
		}else if(name.contains("GOLEM")) {
			
			Golem golem = (Golem) world.spawnEntity(loc, EntityType.IRON_GOLEM);
				switch(name) {
				case "BUSH_GOLEM": golem.setCustomName("BUSH_GOLEM"); golem.setHealth(45*mHp); golem.setMaxHealth(45*mHp);
					break;
				case "BONE_GOLEM": golem.setCustomName("BONE_GOLEM");
				golem.setHealth(mHp*golem.getMaxHealth()); golem.setMaxHealth(mHp*golem.getMaxHealth());
					break;
				}
			golem.setCustomNameVisible(false);
			entity = golem;
			EntityEvents.launchEntityLoop(golem);
			
		}else if(name.contains("PHANTOM")) {
			
			Phantom phantom = (Phantom) world.spawnEntity(loc, EntityType.PHANTOM);
			switch(name) {
			case "BUSH_PHANTOM": phantom.setCustomName("BUSH_PHANTOM");
			phantom.setHealth(mHp*phantom.getMaxHealth()); phantom.setMaxHealth(mHp*phantom.getMaxHealth());
				break;
			}
			phantom.setCustomNameVisible(false);
			entity = phantom;
			EntityEvents.launchEntityLoop(phantom);
		}else if(name.contains("SLIME")) {
			
			Slime slime = (Slime) world.spawnEntity(loc,  EntityType.SLIME);
			slime.setSize(1);
			switch(name) {
			case "ICE_SLIME": slime.setCustomName("ICE_SLIME");
				break;
			}
			entity = slime;
			EntityEvents.launchEntityLoop(slime);
			
		}else if(name.contains("BAT")) {
			Bat bat = (Bat) world.spawnEntity(loc, EntityType.BAT);
			switch(name) {
			case "ICE_BAT": bat.setCustomName("ICE_BAT");
				break;
			}
			entity = bat;
			EntityEvents.launchEntityLoop(bat);
		}else if(name.contains("PILLAGER")) {
			Pillager pillager = (Pillager)world.spawnEntity(loc,  EntityType.PILLAGER);
			switch(name) {
			case "ICE_PILLAGER": pillager.setCustomName("ICE_PILLAGER"); 
			pillager.getEquipment().setItemInMainHand(LootUtils.getWeaponById(3));
			pillager.setMaxHealth(35*mHp); pillager.setHealth(35*mHp);
				break;
			}
			entity = pillager;
			EntityEvents.launchEntityLoop(pillager);
		}else if(name.contains("BEAR")) {
			PolarBear bear = (PolarBear)world.spawnEntity(loc,  EntityType.POLAR_BEAR);
			switch(name) {
			case "SNOW_BEAR": bear.setCustomName("SNOW_BEAR"); bear.setAdult();  bear.setAdult(); bear.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9000, 0, true));
			bear.setMaxHealth(bear.getMaxHealth()*mHp); bear.setHealth(bear.getMaxHealth()*mHp);	
			break;
			case "ICE_BEAR": bear.setCustomName("ICE_BEAR"); bear.setMaxHealth(100*mHp); bear.setHealth(100*mHp); bear.setAdult(); bear.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9000, 1, true));
				break;
			}
			entity = bear;
			EntityEvents.launchEntityLoop(bear);
		}else if(name.contains("SPIDER")) {
			Spider spider = (Spider)world.spawnEntity(loc, EntityType.SPIDER);
			switch(name) {
			case "SAND_SPIDER": spider.setCustomName("SAND_SPIDER");
			spider.setMaxHealth(spider.getMaxHealth()*mHp); spider.setHealth(spider.getMaxHealth()*mHp);	
				break;
			
			}
			entity = spider;
			EntityEvents.launchEntityLoop(spider);
		}else if(name.contains("SILVERFISH")) {
			Silverfish silverfish = (Silverfish)world.spawnEntity(loc, EntityType.SILVERFISH);
			switch(name) {
			case "BONE_SILVERFISH": silverfish.setCustomName("SAND_SILVERFISH");
				break;
			
			}
			entity = silverfish;
			EntityEvents.launchEntityLoop(silverfish);
		}
		
		return entity;
	}
	
	public static ItemStack getCustomItemWithLore(Material material, String customName, boolean EnchantEffect, int nbr, List<String> lore) {
		
		ItemStack item = new ItemStack(material, nbr);
		ItemMeta itemMeta = item.getItemMeta();
		if(lore != null) {
		itemMeta.setLore(lore);
		}
		if(customName != null) {itemMeta.setDisplayName(customName);}
		if(EnchantEffect) {itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 200, true);itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);}
		item.setItemMeta(itemMeta);
		
		
		return item;
		
	}
	
	public static ItemStack getDrop(Material material, String customName, boolean EnchantEffect, int nbr, String description, String rarety) {
		
		ItemStack item = new ItemStack(material, nbr);
		ItemMeta itemMeta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(description);
		lore.add("§fRareté : " + rarety);
		itemMeta.setLore(lore);
		if(customName != null) {itemMeta.setDisplayName(customName);}
		if(EnchantEffect) {itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 200, true);itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);}
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
