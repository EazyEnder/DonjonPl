package fr.eazyender.donjon.donjon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.PolarBear;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
		return 2;
	}
	
	public static int getLaunchDonjonOnABiome(int biome) {

		int count = 0;
		if(!DonjonGenerator.donjons.isEmpty())
		for (int i = 0; i < DonjonGenerator.donjons.size(); i++) {
			IDonjon donjon = DonjonGenerator.donjons.get(i);
			if(donjon.getBiome() == biome) {
				count++;
			}
		}
		return count;
		
	}
	
	public static List<IRoom> getRoomsOfABiome(int biome){
		switch(biome) {
		case 1: return RoomsInit.rooms_1;
		case 2: return RoomsInit.rooms_2;
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
	
	public static void genEntity(IRoom room,World world) {
		
		for (int i = 0; i < room.getEntity_loc().size(); i++) {
			genCustomMobs(room.getEntity_type().get(i), room.getEntity_loc().get(i), world);
		}
		
	}
	
	public static void genCustomMobs(String name, Location loc, World world) {
		
		if(name.contains("SQUELETON")) {
			
		Skeleton skeleton = (Skeleton) world.spawnEntity(loc, EntityType.SKELETON);
		switch(name) {
		case "BUSH_SQUELETON": skeleton.setCustomName("BUSH_SQUELETON");
			break;	
		case "GRANITE_ARCHER_SQUELETON": skeleton.setCustomName("GRANITE_ARCHER_SQUELETON");
			break;	
		case "GRANITE_KNIGHT_SQUELETON": skeleton.setCustomName("GRANITE_KNIGHT_SQUELETON");
		skeleton.getEquipment().setItemInMainHand(LootUtils.getWeaponById(5));
			break;	
		case "GRANITE_KING_SQUELETON": skeleton.setCustomName("GRANITE_KING_SQUELETON");
		ItemStack sword1 = LootUtils.getWeaponById(1);
		skeleton.getEquipment().setItemInMainHand(sword1);
		skeleton.getEquipment().setHelmet(LootUtils.getArmorById(1, 1, "IRON"));
		skeleton.getEquipment().setChestplate(LootUtils.getArmorById(1, 2, "IRON"));
		skeleton.getEquipment().setLeggings(LootUtils.getArmorById(1, 3, "IRON"));
		skeleton.getEquipment().setBoots(LootUtils.getArmorById(1, 4, "IRON"));
			break;	
		case "ICE_SKELETON": skeleton.setCustomName("ICE_SKELETON");;
		skeleton.setSkeletonType(SkeletonType.STRAY);
			break;
		}
		skeleton.setCustomNameVisible(false);
		EntityEvents.launchEntityLoop(skeleton);
		
		}else if(name.contains("ZOMBIE")) {
			
			Zombie zombie = (Zombie) world.spawnEntity(loc, EntityType.ZOMBIE);
			switch(name) {
			case "BUSH_ZOMBIE": zombie.setCustomName("BUSH_ZOMBIE");
				break;	
			}
			zombie.setCustomNameVisible(false);
			EntityEvents.launchEntityLoop(zombie);
			
		}else if(name.contains("GOLEM")) {
			
			Golem golem = (Golem) world.spawnEntity(loc, EntityType.IRON_GOLEM);
				switch(name) {
				case "BUSH_GOLEM": golem.setCustomName("BUSH_GOLEM");
					//golem.setMaxHealth(200);
					break;
				}
			golem.setCustomNameVisible(false);
			EntityEvents.launchEntityLoop(golem);
			
		}else if(name.contains("PHANTOM")) {
			
			Phantom phantom = (Phantom) world.spawnEntity(loc, EntityType.PHANTOM);
			switch(name) {
			case "BUSH_PHANTOM": phantom.setCustomName("BUSH_PHANTOM");
				break;
			}
			phantom.setCustomNameVisible(false);
			EntityEvents.launchEntityLoop(phantom);
		}else if(name.contains("SLIME")) {
			
			Slime slime = (Slime) world.spawnEntity(loc,  EntityType.SLIME);
			slime.setSize(1);
			switch(name) {
			case "ICE_SLIME": slime.setCustomName("ICE_SLIME");
				break;
			}
			EntityEvents.launchEntityLoop(slime);
			
		}else if(name.contains("BAT")) {
			Bat bat = (Bat) world.spawnEntity(loc, EntityType.BAT);
			switch(name) {
			case "ICE_BAT": bat.setCustomName("ICE_BAT");
				break;
			}
			EntityEvents.launchEntityLoop(bat);
		}else if(name.contains("PILLAGER")) {
			Pillager pillager = (Pillager)world.spawnEntity(loc,  EntityType.PILLAGER);
			switch(name) {
			case "ICE_PILLAGER": pillager.setCustomName("ICE_PILLAGER");
			pillager.getEquipment().setItemInMainHand(LootUtils.getWeaponById(3));
				break;
			}
			
			EntityEvents.launchEntityLoop(pillager);
		}else if(name.contains("BEAR")) {
			PolarBear bear = (PolarBear)world.spawnEntity(loc,  EntityType.POLAR_BEAR);
			switch(name) {
			case "SNOW_BEAR": bear.setCustomName("SNOW_BEAR");
				break;
			case "ICE_BEAR": bear.setCustomName("ICE_BEAR");
				break;
			}
			EntityEvents.launchEntityLoop(bear);
		}
		
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

}
