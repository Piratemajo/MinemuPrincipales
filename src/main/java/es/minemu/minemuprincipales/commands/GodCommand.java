package es.minemu.minemuprincipales.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        if (command.getName().equalsIgnoreCase("god")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (player.hasPermission("minemu.god")) {
                    if (args.length == 0) {
                        if (player.isInvulnerable()) {
                            player.setInvulnerable(false);
                            player.sendMessage("Modo Dios desactivado.");
                        } else {
                            player.setInvulnerable(true);
                            player.sendMessage("Modo Dios activado.");
                        }
                    } else {
                        player.sendMessage("Uso incorrecto. No debes proporcionar argumentos.");
                    }
                } else {
                    player.sendMessage("No tienes permiso para utilizar este comando.");
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
            }
            return true;
        }
        return false;
    }
}
