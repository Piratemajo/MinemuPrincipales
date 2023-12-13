package es.minemu.minemuprincipales.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Broadcast implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        if (command.getName().equalsIgnoreCase("broadcast")) {
            // Este comando podría usarse para enviar un mensaje a todo el servidor
            if (args.length > 0) {
                String message = String.join(" ", args);
                Bukkit.broadcastMessage(ChatColor.GOLD + "Minemu: " + ChatColor.RESET + message);
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Debes proporcionar un mensaje para el broadcast.");
                return false;
            }
        }


        return false;
    }
}
