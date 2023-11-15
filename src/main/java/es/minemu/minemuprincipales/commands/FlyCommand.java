package es.minemu.minemuprincipales.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    public boolean onCommand (CommandSender sender, Command command,String label,String[] args ){
        if (command.getName().equalsIgnoreCase("fly")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.sendMessage("Modo vuelo desactivado.");
                } else {
                    player.setAllowFlight(true);
                    player.sendMessage("Modo vuelo activado.");
                }
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }
        return false;
    }
}
