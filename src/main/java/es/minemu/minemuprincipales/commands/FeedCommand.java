package es.minemu.minemuprincipales.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        if (command.getName().equalsIgnoreCase("feed")) {
            // Este comando podría usarse para rellenar la barra de hambre del jugador
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setFoodLevel(20);
                player.sendMessage(ChatColor.GREEN + "Has sido alimentado.");
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }
        return false;
    }
}
