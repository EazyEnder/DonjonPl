package fr.eazyender.donjon.donjon.events;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.donjon.IDonjon;
import fr.eazyender.donjon.donjon.IRoom;
import fr.eazyender.donjon.donjon.LootUtils;
import fr.eazyender.donjon.donjon.RoomUtils;
import fr.eazyender.donjon.files.PlayerGroupSave;
import fr.eazyender.donjon.files.PlayerLevelStats;
import fr.eazyender.donjon.gui.PotionGui;
import fr.eazyender.donjon.gui.SpellGui;
import fr.eazyender.donjon.gui.WeaponGui;
import fr.eazyender.donjon.potion.PotionUtils;
import fr.eazyender.donjon.spells.SpellUtils;
import fr.eazyender.donjon.utils.PlayerGroup;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class EventSpeedRunDonjon {
	
	public static List<IDonjon> donjons = new ArrayList<IDonjon>();
	public static List<PlayerGroup> groups = new ArrayList<PlayerGroup>();
	
	public static long bestTime = 999999;
	public static String bestPlayer = ""; 
	
	public static void genDonjonsEvent(int size, short difficulty) {
		
		for (int w = 0; w < 3; w++) {
			
		List<IRoom> rooms_donjon = new ArrayList<IRoom>();
		for (int i = 0; i < size; i++) {
			rooms_donjon.add(null);
		}
	
		//SPAWN ROOM
		rooms_donjon.set(0, RoomUtils.getSimilarRooms(w, 0).get(RandomNumber(0,RoomUtils.getNumberOfASimilarRoom(w, 0)-1)));
		for (int i = 1; i < size; i++) {
			
			//IMPAIR
			if(i % 2 == 1) {
				int type = 2;
				int chance = RandomNumber(1,100);
				int[] proba = {20,60,90,100};
				if(chance < proba[0]){type = 2;}
				else if(chance < proba[1]){type = 3;}
				else if(chance < proba[2]){type = 4;}
				else if(chance <= proba[3]){type = 5;}
				while(RoomUtils.getNumberOfASimilarRoom(w, type) <= 0) {
					chance = RandomNumber(1,100);
					if(chance < proba[0]){type = 2;}
					else if(chance < proba[1]){type = 3;}
					else if(chance < proba[2]){type = 4;}
					else if(chance <= proba[3]){type = 5;}
				}
				rooms_donjon.set(i, RoomUtils.getSimilarRooms(w, type).get(RandomNumber(0,RoomUtils.getNumberOfASimilarRoom(w, type)-1)));
			}
			//NO BOSS ROOM
			else if(i < size-1) {
				//FIGHT ROOM
				int type = 2;
				int chance = RandomNumber(1,100);
				int[] proba = {20,60,90,100};
				if(chance < proba[0]){type = 2;}
				else if(chance < proba[1]){type = 3;}
				else if(chance < proba[2]){type = 4;}
				else if(chance <= proba[3]){type = 5;}
				while(RoomUtils.getNumberOfASimilarRoom(w, type) <= 0) {
					chance = RandomNumber(1,100);
					if(chance < proba[0]){type = 2;}
					else if(chance < proba[1]){type = 3;}
					else if(chance < proba[2]){type = 4;}
					else if(chance <= proba[3]){type = 5;}
				}
				rooms_donjon.set(i, RoomUtils.getSimilarRooms(w, type).get(RandomNumber(0,RoomUtils.getNumberOfASimilarRoom(w, type)-1)));
			}
			
		}
		//BOSS ROOM
		rooms_donjon.set(size-1, RoomUtils.getSimilarRooms(w, 6).get(RandomNumber(0,RoomUtils.getNumberOfASimilarRoom(w, 6)-1)));
		
		donjons.add(new IDonjon(rooms_donjon, size, w, difficulty));
		}
	}
	
	public static void launchDonjon(Player host) {

		PlayerGroup group = PlayerGroupSave.getPlayerGroup().getGroup(host);

		int levelmax = 0;
		for (Player player : group.getPlayers()){
			player.closeInventory();
			player.sendTitle("§7§lDONJON EN CHARGEMENT !", "§fLa génération peux prendre du temps", 5, 20 * 3, 5);
			if(PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(player) > levelmax) {levelmax = PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(player);}
		}
		
		int biomesel = 0;
		if(levelmax <= 10) {
			biomesel = 0;
		}else if(levelmax <= 20) {
			biomesel = 1;
		}else if(levelmax <= 30) {
			biomesel = 2;
		}
		
		Location donjon_loc = donjons.get(biomesel).getDonjon().get(0).getDoors().get(0);
		donjon_loc.setWorld(createNewDonjon(donjons.get(biomesel), DonjonMain.donjons.get(donjons.get(biomesel).getBiome()-1), host));
		
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				
				if(groups.contains(group)) {

					for (Player player : group.getPlayers()) {

						player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000000, 1, true));

						if (!SpeedRunDonjonEvents.timer.containsKey(group)) {
							SpeedRunDonjonEvents.timer.put(group, (long) 0);
						}
						SpeedRunDonjonEvents.timer.replace(group, SpeedRunDonjonEvents.timer.get(group) + 1);
						String seconde = "" + SpeedRunDonjonEvents.timer.get(group) % 60;
						String minute = "" + (long) (SpeedRunDonjonEvents.timer.get(group) / 60);
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§f§lTemps : §f" + minute + ":" + seconde));
					}
					}else{
					for (Player player : group.getPlayers()) {
						player.removePotionEffect(PotionEffectType.NIGHT_VISION);
					}
						this.cancel();
					}

			}
		}.runTaskTimer(DonjonMain.instance, 0, 20);

		for (Player player : group.getPlayers()) {
			if (!SpeedRunDonjonEvents.current_room.containsKey(player)) {
				BossBar bossBar = Bukkit.createBossBar("Salle actuelle : 1 / " + donjons.get(biomesel).getSize(), BarColor.WHITE, BarStyle.SOLID);
				bossBar.addPlayer(player);
				bossBar.setVisible(true);

				SpeedRunDonjonEvents.current_room.putIfAbsent(player, bossBar);
			}

			if (!SpeedRunDonjonEvents.current_entity.containsKey(player)) {
				BossBar bossBar = Bukkit.createBossBar("Pas de monstres !", BarColor.GREEN, BarStyle.SOLID);
				bossBar.addPlayer(player);
				bossBar.setVisible(true);

				SpeedRunDonjonEvents.current_entity.putIfAbsent(player, bossBar);
			}

			if (WeaponGui.weapon_choose.containsKey(player)) {
				player.getInventory().setItem(0, LootUtils.getWeaponById(WeaponGui.weapon_choose.get(player)));
			} else {

			}

			if (SpellGui.spells_choose.containsKey(player)) {
				for (int i = 0; i < SpellGui.spells_choose.get(player).size(); i++) {
					if (SpellGui.spells_choose.get(player).get(i) != 0) {
						player.getInventory().setItem(i + 1, SpellUtils.getItemSpellById(SpellGui.spells_choose.get(player).get(i)));
					}
				}
			}

			if (PotionGui.potions_choose.containsKey(player)) {
				for (int i = 0; i < PotionGui.potions_choose.get(player).size(); i++) {
					if (PotionGui.potions_choose.get(player).get(i) != "0:0") {
						ItemStack potion = PotionUtils.getItemPotionById(PotionGui.potions_choose.get(player).get(i));
						potion.setAmount(Integer.parseInt(PotionGui.potions_choose.get(player).get(i).split("\\:")[1]));
						player.getInventory().setItem(i + 4, potion);
					}
				}
			}

			player.teleport(donjon_loc);
		}
		
		
	}
	
	private static World createNewDonjon(IDonjon donjon, World world, Player player){
	     File worldDir = world.getWorldFolder();
	     String newName = world.getName() + "_temp" + "_" + player.getName();
	     
	     try {
			FileUtils.copyDirectory(worldDir, new File(worldDir.getParent(), newName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	     File uid = new File(newName, "uid.dat");
	     uid.delete();
	     
	     WorldCreator creator = new WorldCreator(newName);
	     World newWorld = Bukkit.createWorld(creator);
	     if(donjon.getDifficulty() != 4)
	    	 newWorld.setGameRule(GameRule.NATURAL_REGENERATION, true);
	     else
	    	  newWorld.setGameRule(GameRule.NATURAL_REGENERATION, false);
	     newWorld.setGameRule(GameRule.DO_MOB_SPAWNING, false);
	     newWorld.setGameRule(GameRule.KEEP_INVENTORY, true);
	     return newWorld;
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
