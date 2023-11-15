package es.minemu.minemuprincipales.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        if (command.getName().equalsIgnoreCase("gm")) {
            // Este comando podría usarse para cambiar el modo de juego del jugador
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    try {
                        int mode = Integer.parseInt(args[0]);
                        if (mode >= 0 && mode <= 3) {
                            player.setGameMode(GameMode.values()[mode]);
                            sender.sendMessage(ChatColor.GREEN + "Modo de juego cambiado a " + GameMode.values()[mode]);
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.RED + "El modo de juego debe estar entre 0 y 3.");
                            return false;
                        }
                    } catch (NumberFormatException e) {
                        sender.sendMessage(ChatColor.RED + "Uso incorrecto. Debes proporcionar un número entre 0 y 3.");
                        return false;
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Uso incorrecto. Debes proporcionar un número entre 0 y 3.");
                    return false;
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        return false;
    }
}
