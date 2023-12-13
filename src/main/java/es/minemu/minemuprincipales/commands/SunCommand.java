package es.minemu.minemuprincipales.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SunCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("sun")) {
            sender.sendMessage(ChatColor.GREEN + "El clima se ha despejado.");
            return true;
        }

        return false;
    }


}
