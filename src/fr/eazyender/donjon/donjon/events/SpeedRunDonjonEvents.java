package fr.eazyender.donjon.donjon.events;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eazyender.donjon.DonjonMain;
import fr.eazyender.donjon.donjon.DonjonGenerator;
import fr.eazyender.donjon.donjon.IDonjon;
import fr.eazyender.donjon.donjon.IRoom;
import fr.eazyender.donjon.donjon.LevelUtils;
import fr.eazyender.donjon.donjon.RoomUtils;
import fr.eazyender.donjon.files.PlayerEconomy;
import fr.eazyender.donjon.files.PlayerGroupSave;
import fr.eazyender.donjon.files.PlayerLevelStats;
import fr.eazyender.donjon.utils.PlayerGroup;

public class SpeedRunDonjonEvents implements Listener {
	
	public static Map<Player, Boolean> travelPlayer = new HashMap<Player, Boolean>();
	public static Map<Player, Integer> positionPlayer = new HashMap<Player, Integer>();
	public static Map<PlayerGroup, Integer> maxPositionPlayer = new HashMap<PlayerGroup, Integer>();
	public static Map<Player, Integer> entry = new HashMap<Player, Integer>();
	
	public static Map<Player, BossBar> current_room = new HashMap<Player, BossBar>();
	public static Map<Player, BossBar> current_entity = new HashMap<Player, BossBar>();
	public static Map<PlayerGroup, Long> score = new HashMap<PlayerGroup, Long>();
	public static Map<PlayerGroup, Long> timer = new HashMap<PlayerGroup, Long>();
	
	@EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
		
		Player player = e.getPlayer();
		PlayerGroup group = PlayerGroupSave.getPlayerGroup().getGroup(player);
		if(PlayerGroup.aGroupContainPlayer(player.getUniqueId()))
		{
			group = PlayerGroup.getGroupOfAPlayer(player);
		}
		if(EventSpeedRunDonjon.groups.contains(group)) {
			
			int levelmax = 0;
			for (Player p : group.getPlayers()){
				p.closeInventory();
				p.sendTitle("§7§lDONJON EN CHARGEMENT !", "§fLa génération peux prendre du temps", 5, 20 * 3, 5);
				if(PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(p) > levelmax) {levelmax = PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(p);}
			}
			int biomesel = 0;
			if(levelmax <= 10) {
				biomesel = 0;
			}else if(levelmax <= 20) {
				biomesel = 1;
			}else if(levelmax <= 30) {
				biomesel = 2;
			}
			
			IDonjon donjon = EventSpeedRunDonjon.donjons.get(biomesel);
				for (int j = 0; j <  donjon.getDonjon().get(positionPlayer.get(player)).getDoors().size(); j++) {
					if(!entry.containsKey(player)) 
						entry.put(player, 0);
					Location loc = donjon.getDonjon().get(positionPlayer.get(player)).getDoors().get(j);
					loc.setWorld(player.getWorld());
					if(player.getLocation().distance(loc) < 2) {

						if(travelPlayer.get(player)) {
							
						if(j == 0) {
						//SORT	
							if(positionPlayer.get(player) != 0) {
								Location loc1 = donjon.getDonjon().get(positionPlayer.get(player)-1).getDoors().get(1);
								loc1.setWorld(player.getWorld());
								
							player.teleport(loc1);
							player.playSound(player.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 1, 1);
							
							positionPlayer.replace(player, positionPlayer.get(player)-1);
							
							entry.replace(player, 1);
							player.setInvulnerable(true);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									player.setInvulnerable(false);
								}
							}.runTaskLater(DonjonMain.instance, 35);
							loc1 = null;
							}
						}else {
						//ENTRE
							Location loc1 = donjon.getDonjon().get(positionPlayer.get(player)+1).getDoors().get(0);
							loc1.setWorld(player.getWorld());
							player.teleport(loc1);
							player.playSound(player.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 1, 1);
							
							if(maxPositionPlayer.get(group) < positionPlayer.get(player)+1) {
								maxPositionPlayer.replace(group, positionPlayer.get(player)+1);
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
								if(donjon.getDonjon().get(positionPlayer.get(player)+1).getEntity_loc() != null) {
								donjon.getDonjon().get(positionPlayer.get(player)+1).setNumberOfMobs(donjon.getDonjon().get(positionPlayer.get(player)+1).getEntity_loc().size() * mMob);
								RoomUtils.genEntity(donjon, donjon.getDonjon().get(positionPlayer.get(player)+1), player.getWorld());
								
								BossBar bar = current_entity.get(player);
								bar.setColor(BarColor.RED);
						        bar.setProgress(1);
						        bar.setTitle("§fMonstres restants : " + donjon.getDonjon().get(positionPlayer.get(player)+1).getNumberOfMobs() + "/" +  donjon.getDonjon().get(positionPlayer.get(player)+1).getNumberOfMobs());
								}
							}else if(donjon.getDonjon().get(positionPlayer.get(player)+1).getNumberOfMobs() > 0){
								BossBar bar = current_entity.get(player);
								bar.setColor(BarColor.RED);
						        bar.setProgress((double) donjon.getDonjon().get(positionPlayer.get(player)).getNumberOfMobs() / (double) donjon.getDonjon().get(positionPlayer.get(player)).getEntity_loc().size());
						        bar.setTitle("§fMonstres restants : " + donjon.getDonjon().get(positionPlayer.get(player)+1).getNumberOfMobs() + "/" +  donjon.getDonjon().get(positionPlayer.get(player)+1).getNumberOfMobs());
							}
							
							positionPlayer.replace(player, positionPlayer.get(player)+1);
							
							entry.replace(player, 0);
							loc1 = null;
						}
						BossBar bar = current_room.get(player);
				        bar.setProgress((double)(positionPlayer.get(player)+1)/(double)donjon.getSize());
				        bar.setTitle("§fSalle actuelle : " + (positionPlayer.get(player)+1) + "/" +  donjon.getSize());
						travelPlayer.replace(player, false);
						}
					}else if(donjon.getDonjon().get(positionPlayer.get(player)).getNumberOfMobs() <= 0 && player.getLocation().distance(loc) > 2){
						if(j == entry.get(player))
						travelPlayer.replace(player, true);
	
					}
					loc = null;
				}
		}
		
	}
	
	@EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
		LivingEntity entity = e.getEntity();
		if(entity.getWorld().getName().contains("donjon") && !(entity instanceof Player)) {
			Player player = entity.getKiller();
			if(player == null) {player = entity.getWorld().getPlayers().get(0);}
			PlayerGroup group = PlayerGroupSave.getPlayerGroup().getGroup(player);
			if(PlayerGroup.aGroupContainPlayer(player.getUniqueId()))
			{
				group = PlayerGroup.getGroupOfAPlayer(player);
			}
			if(DonjonGenerator.donjons.containsKey(group)) {
				
				IDonjon donjon = DonjonGenerator.donjons.get(group);
				donjon.getDonjon().get(positionPlayer.get(player)).setNumberOfMobs(donjon.getDonjon().get(positionPlayer.get(player)).getNumberOfMobs()-1);
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
					

				for (int i = 0; i < group.getPlayersInARoom(positionPlayer.get(player)).size(); i++) {
					List<Player> players = group.getPlayersInARoom(positionPlayer.get(player));
					BossBar bar = current_entity.get(players.get(i));
					if (((double) donjon.getDonjon().get(positionPlayer.get(players.get(i))).getNumberOfMobs() / (double) donjon.getDonjon().get(positionPlayer.get(players.get(i))).getEntity_loc().size()) * mMob > 0.5) {
						bar.setColor(BarColor.RED);
					} else {
						bar.setColor(BarColor.YELLOW);
					}
					bar.setProgress((double) donjon.getDonjon().get(positionPlayer.get(players.get(i))).getNumberOfMobs() / (double) donjon.getDonjon().get(positionPlayer.get(players.get(i))).getEntity_loc().size()*mMob);
					bar.setTitle("§fMonstres restants : " + donjon.getDonjon().get(positionPlayer.get(players.get(i))).getNumberOfMobs() + "/" + donjon.getDonjon().get(positionPlayer.get(players.get(i))).getEntity_loc().size()* mMob);

					if (donjon.getDonjon().get(positionPlayer.get(players.get(i))).getNumberOfMobs() <= 0) {
						bar.setTitle("Pas de monstres !");
						bar.setColor(BarColor.GREEN);
						bar.setProgress(1.0);
						players.get(i).playSound(players.get(i).getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
					} else {
						players.get(i).playSound(players.get(i).getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
					}
				}
			        
			        if(donjon.getDonjon().get(positionPlayer.get(player)).getNumberOfMobs() <= 0 && maxPositionPlayer.get(group) == donjon.getSize()-1) {
			        	
			        	endDonjon(group, true);
			        	
			        }

			}
			
		}else if(entity instanceof Player && entity.getWorld().getName().contains("donjon")) {

			Player player = (Player)entity;
			PlayerGroup group = PlayerGroupSave.getPlayerGroup().getGroup(player);
			if(PlayerGroup.aGroupContainPlayer(player.getUniqueId()))
			{
				group = PlayerGroup.getGroupOfAPlayer(player);
			}
			
			if(DonjonGenerator.donjons.containsKey(group)) {
			IDonjon donjon = DonjonGenerator.donjons.get(group);
			if(donjon.getDifficulty() >= 3) {
				endDonjon(group, false);
			}else{
				endDonjon(group, false);
			}
			}
			
		}
	}
	
	@EventHandler
	  public void onPlayerQuit(PlayerQuitEvent e) {

		Player player = e.getPlayer();
		PlayerGroup group = PlayerGroupSave.getPlayerGroup().getGroup(player);
		if(PlayerGroup.aGroupContainPlayer(player.getUniqueId()))
		{
			group = PlayerGroup.getGroupOfAPlayer(player);
		}
		if(DonjonGenerator.donjons.containsKey(group))
		endDonjon(group, false);
		
	}
	
	private static void endDonjon(PlayerGroup group, boolean isEnd) {

		List<Player> players = group.getPlayers();
		for (Player player : players) {
			current_entity.get(player).removeAll();
			current_entity.remove(player);
			current_room.get(player).removeAll();
			current_room.remove(player);
			travelPlayer.remove(player);
			positionPlayer.remove(player);
			entry.remove(player);
		}

		maxPositionPlayer.remove(group);
		
		
		if(isEnd) {

			int mobs = 0;
			for (int i = 0; i < DonjonGenerator.donjons.get(group).getDonjon().size(); i++) {
				if (DonjonGenerator.donjons.get(group).getDonjon().get(i).getEntity_loc() != null) {
					for (int j = 0; j < DonjonGenerator.donjons.get(group).getDonjon().get(i).getEntity_loc().size(); j++) {
						mobs++;
					}
				}
			}
			
			Long modifyTimer = timer.get(group);
			modifyTimer = modifyTimer * group.getPlayers().size();
			if(modifyTimer < EventSpeedRunDonjon.bestTime) {
				EventSpeedRunDonjon.bestPlayer = group.getHost().getName();
				EventSpeedRunDonjon.bestTime = modifyTimer;
				group.getHost().sendMessage("§7[§bEvenement§7] §b" + "Vous avez battu l'ancien record de temps !");
			}
			
		
		int difficulty = DonjonGenerator.donjons.get(group).getDifficulty();
		Long time = timer.get(group);
		
		int essence = mobs / 5;
		for (Player player : players) {
			PlayerEconomy.getEconomy().setEssences(player, PlayerEconomy.getEconomy().getEssences(player) + essence);
			player.sendMessage("§7[§bEvenement§7] §b" + "Vous avez gagné " + essence + " essences");
		}
		
		double mTime = 1;
		
		int score = 0;
		int endtime = 0;
		String rank = "F";
		int xp = 0;
		List<IRoom> rooms = DonjonGenerator.donjons.get(group).getDonjon();
		for (int i = 0; i < rooms.size(); i++) {
			endtime = endtime + (int)(rooms.get(i).getMaxTime() * mTime);
			xp = xp + rooms.get(i).getXp();
		}
		if(time <= endtime / 1.5) {
			//S
		score = (int) ((xp*1.25) / group.getPlayers().size());
		rank = "§6S";
		}else if(time <= endtime){
			//A
		score = (int)(xp / group.getPlayers().size());
		rank = "§2A";
		}else if(time <= endtime*1.5) {
			//D
		score = (int) ((xp*0.5) / group.getPlayers().size());
		rank = "§cA";
		}else {
			score = 0;
			rank = "§4F";
		}
		
		switch(difficulty) {
		case 1: score = score / 2;
			break;
		case 2: 
			break;
		case 3: score = (int) (1.5 * score);
			break;
		case 4: score = 2 * score;
			break;
		}

			for (Player player : group.getPlayers()) {

				if (score < 0) {
					player.sendMessage("§8[§4Donjon§8] : §f" + "Vous avez mis trop de temps, vous n'avez pas gagné d'expérience.");
					score = 0;
				} else {
					player.sendMessage("§8[§4Donjon§8] : §f" + "Vous avez gagné " + score + "xp et obtenu le rang" + rank +  ".");
				}


				PlayerLevelStats.getPlayerLevelStats().setXpDonjon(player, PlayerLevelStats.getPlayerLevelStats().getXpDonjon(player) + score);
				LevelUtils.updateXp(player);
			}
		}

		for (Player player : group.getPlayers()) {
			for (int i = 0; i < 9; i++) {
				player.getInventory().clear(i);
			}
		}
		
		timer.remove(group);
		DonjonGenerator.delDonjon(group);
		
		
	}


}
