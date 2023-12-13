package es.minemu.minemuprincipales.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        if (command.getName().equalsIgnoreCase("vanish")) {
            // Este comando podría usarse para activar o desactivar el modo invisible del jugador
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("minemu.vanish")) {
                    if (player.isInvisible()) {
                        player.setInvisible(false);
                        player.sendMessage(ChatColor.GREEN + "Modo invisible desactivado.");
                    } else {
                        player.setInvisible(true);
                        player.sendMessage(ChatColor.GREEN + "Modo invisible activado.");
                    }
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "No tienes permiso para utilizar este comando.");
                    return false;
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }
        return true;
    }
}
