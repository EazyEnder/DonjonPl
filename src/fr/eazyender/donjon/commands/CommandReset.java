package fr.eazyender.donjon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.eazyender.donjon.files.PlayerLevelStats;

public class CommandReset implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (cmd.getName().equalsIgnoreCase("reset")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                PlayerLevelStats.getPlayerLevelStats().setStatsPoints(player, 1, 0);
                PlayerLevelStats.getPlayerLevelStats().setStatsPoints(player, 1, 0);
                PlayerLevelStats.getPlayerLevelStats().setStatsPoints(player, 1, 0);
                
                PlayerLevelStats.getPlayerLevelStats().setSkillPoints(player, 3+PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(player));;

                return true;
            }
        }

        return false;
    }

    }
