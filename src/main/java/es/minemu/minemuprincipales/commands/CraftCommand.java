package es.minemu.minemuprincipales.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CraftCommand implements CommandExecutor {

    public boolean onCommand (CommandSender sender, Command command,String label,String[] args) {
        if (command.getName().equalsIgnoreCase("craft")) {
            // Este comando podría usarse para abrir un banco de trabajo para el jugador
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.openWorkbench(null, true);
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        return false;
    }
}
