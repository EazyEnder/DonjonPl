package fr.eazyender.donjon.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_14_R1.CraftServer;
import org.bukkit.craftbukkit.v1_14_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.mojang.authlib.GameProfile;

import fr.eazyender.donjon.DonjonMain;
import net.minecraft.server.v1_14_R1.EntityPlayer;
import net.minecraft.server.v1_14_R1.MinecraftServer;
import net.minecraft.server.v1_14_R1.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_14_R1.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_14_R1.PlayerConnection;
import net.minecraft.server.v1_14_R1.PlayerInteractManager;
import net.minecraft.server.v1_14_R1.WorldServer;

public class CommandNPC implements CommandExecutor {

	String srv_msg = "";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (cmd.getName().equalsIgnoreCase("npc")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                
                if(args.length >= 1) {
                	if(args[0].equalsIgnoreCase("player")) {
                		if(args.length >= 2) {
                			String name = args[1];
                			for (int i = 0; i < Integer.parseInt(args[2]); i++) {
                				DonjonMain.instance.npcManager.createNPC(player, name);
							}
                			
                		}
                	}else if(args[0].equalsIgnoreCase("quete")) {
                		
                	}else if(args[0].equalsIgnoreCase("commerce")) {
                		
                	}else {
                		player.sendMessage(srv_msg + "Usage : /npc <player/quete/commerce>");
                	}
                }else {
                	player.sendMessage(srv_msg + "Usage : /npc <player/quete/commerce>");
                }

                return true;
            }
        }
		
		return false;
	}
	

}
