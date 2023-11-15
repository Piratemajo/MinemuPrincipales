package es.minemu.minemuprincipales.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


import  static  org.bukkit.Bukkit.getServer;

public class SunCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        if (command.getName().equalsIgnoreCase("sun")) {
            // Este comando podría usarse para limpiar el clima y establecer el tiempo en claro
            getServer().getWorlds().get(0).setStorm(false);
            getServer().getWorlds().get(0).setThundering(false);
            sender.sendMessage(ChatColor.GREEN + "El clima se ha despejado.");
            return true;
        }

        return false;
    }
}
