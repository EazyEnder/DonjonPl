package fr.eazyender.donjon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.eazyender.donjon.gui.ShopSpellChromaGui;

public class CommandChromatiques implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("chromatique")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				
				ShopSpellChromaGui.openMain(player);
				
				return true;
			}
		}
		
		return false;
		
	}
	

}
