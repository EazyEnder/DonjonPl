package fr.eazyender.donjon.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandHologrammes implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
			if(sender instanceof Player) {
				
				Player player = (Player) sender;
					
					if(args.length >= 1) {
						
						
						if(args[0].equals("donjon")) {
							
							Location lc = player.getLocation();
							createHologram(lc,"§r§f§l§kKKK§6§l§nDonjon§r§f§l§kKKK");
							Location lc2 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.3,
									player.getLocation().getZ());
							createHologram(lc2,"§r§f§lUn mode de jeu §r§e§lRogue Like§r§f§l !");
							Location lc3 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.6,
									player.getLocation().getZ());
							createHologram(lc3,"§f§lExplorez des §r§e§ldonjons§r§f§l aléatoires avec vos §r§e§lamis§r§f§l...");
							Location lc4 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.9,
									player.getLocation().getZ());
							createHologram(lc4,"§f§lEn lootant des §r§e§lsorts,armes et ressources.§r§f§l");
							Location lc5 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 1.2,
									player.getLocation().getZ());
							createHologram(lc5,"§f§lAfin d'améliorez votre §r§e§léquipement§r§f§l et montez dans le §r§e§lclassement§r§f§l");
							Location lc6 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 1.5,
									player.getLocation().getZ());
							createHologram(lc6,"§f§lFaites attention au §r§e§ltemps§r§f§l, plus vous serez §r§e§lrapide§r§f§l,");
							Location lc7 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 1.8,
									player.getLocation().getZ());
							createHologram(lc7,"§f§lplus vous gagnerez d'§r§e§lexpérience§r§f§l !");
						}else if(args[0].equals("arena")) {
							Location lc = player.getLocation();
							createHologram(lc,"§r§f§l§kKKK§6§l§nArena§r§f§l§kKKK");
							Location lc2 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.3,
									player.getLocation().getZ());
							createHologram(lc2,"§r§f§lUn mode de jeu §r§e§lPVP§r§f§l !");
							Location lc3 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.6,
									player.getLocation().getZ());
							createHologram(lc3,"§f§lAffrontez des §r§e§ljoueurs§r§f§l dans une grosse §r§e§larène§r§f§l...");
							Location lc4 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.9,
									player.getLocation().getZ());
							createHologram(lc4,"§f§lAidez vous de vos §r§e§lsorts,armes...§r§f§l");
							Location lc5 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 1.2,
									player.getLocation().getZ());
							createHologram(lc5,"§f§lAfin d'améliorez votre §r§e§lposition§r§f§l dans le §r§e§lclassement PVP§r§f§l");
							
						}else if(args[0].equals("tutorial") || args[0].equals("tutoriel")) {
							Location lc = player.getLocation();
							createHologram(lc,"§r§f§l§kKKK§6§l§nLes Bases§r§f§l§kKKK");
							Location lc2 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.3,
									player.getLocation().getZ());
							createHologram(lc2,"§r§f§lLancez un §r§e§ldonjon§r§f§l via le §r§e§lgros portail§r§f§l sur la place");
							Location lc3 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.6,
									player.getLocation().getZ());
							createHologram(lc3,"§f§lCombattez en §r§e§larène§r§f§l via le §r§e§lpetit portail§r§f§l sur le côté de la ville");
							Location lc4 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.9,
									player.getLocation().getZ());
							createHologram(lc4,"§f§lInvitez des §r§e§lamis§r§f§l via le §r§e§l/group§r§f§l et §r§e§lacceptez§r§f§l via §r§e§l/accept§r§f§l");
							Location lc5 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 1.2,
									player.getLocation().getZ());
							createHologram(lc5,"§f§lVisitez afin de trouver le §r§e§lforgeron, alchimiste, bibliothèque...§r§f§l");
							
						}else if(args[0].equals("biblio")) {
							Location lc = player.getLocation();
							createHologram(lc,"§r§f§l§kKKK§6§l§nBibliothèque§r§f§l§kKKK");
							Location lc2 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.3,
									player.getLocation().getZ());
							createHologram(lc2,"§f§lApprenez de nouveaux §r§e§lsorts§r§f§l");
							Location lc3 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.6,
									player.getLocation().getZ());
							createHologram(lc3,"§f§lConfectionnez de puissants §r§e§lparchemins§r§f§l");
						}else if(args[0].equals("forge")) {
							Location lc = player.getLocation();
							createHologram(lc,"§r§f§l§kKKK§6§l§nForge§r§f§l§kKKK");
							Location lc2 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.3,
									player.getLocation().getZ());
							createHologram(lc2,"§r§f§l§r§e§lAméliorez§r§f§l votre équipement");
							Location lc3 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.6,
									player.getLocation().getZ());
							createHologram(lc3,"§f§lOu §r§e§lforgez§r§f§l en un nouveau");
						}else if(args[0].equals("alchimiste")) {
							Location lc = player.getLocation();
							createHologram(lc,"§r§f§l§kKKK§6§l§nAlchimiste§r§f§l§kKKK");
							Location lc2 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.3,
									player.getLocation().getZ());
							createHologram(lc2,"§f§lFabriquez vos §r§e§lpotions§r§f§l");
							Location lc3 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.6,
									player.getLocation().getZ());
							createHologram(lc3,"§f§lOu §r§e§lachetez§r§f§l en");
						}else if(args[0].equals("commerce")) {
							Location lc = player.getLocation();
							createHologram(lc,"§r§f§l§kKKK§6§l§nCommerce§r§f§l§kKKK");
							Location lc2 = new Location(
									player.getWorld(),
									player.getLocation().getX(),
									player.getLocation().getY() - 0.3,
									player.getLocation().getZ());
							createHologram(lc2,"§f§lAchetez ou vendez des biens");
						}
					
				}
					
					return true;
			}
		
		return false;
		
	}
	
	private static void createHologram(Location lc, String txt) {
		
		
		ArmorStand as = (ArmorStand) lc.getWorld().spawnEntity(lc, EntityType.ARMOR_STAND); //Spawn the ArmorStand
		as.setGravity(false); //Make sure it doesn't fall
		as.setCanPickupItems(false); //I'm not sure what happens if you leave this as it is, but you might as well disable it
		as.setCustomName(txt); //Set this to the text you want
		as.setCustomNameVisible(true); //This makes the text appear no matter if your looking at the entity or not
		as.setVisible(false); //Makes the ArmorStand invisible
		
	}

}
