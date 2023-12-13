package es.minemu.minemuprincipales.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        if (command.getName().equalsIgnoreCase("nick")) {
            // Este comando podría usarse para cambiar el nombre visible del jugador
            if (args.length == 1) {
                String newNick = args[0];
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    player.setDisplayName(newNick);
                    player.sendMessage(ChatColor.GREEN + "Tu nuevo nombre es: " + newNick);
                    return true;
                } else {
                    sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                    return false;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Uso incorrecto. Debes proporcionar un nombre.");
                return false;
            }
        }

        return false;
    }
}
