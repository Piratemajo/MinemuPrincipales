package es.minemu.minemuprincipales.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CurarCommand implements CommandExecutor {

    public boolean onCommand (CommandSender sender, Command command,String label, String[] args){
        if (command.getName().equalsIgnoreCase("curar")){
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setHealth(20.0);
                player.sendMessage("Has sido curado ");
                return true;
            } else {
                sender.sendMessage("Este commando solo puede ser utilizado por un usuario");
                return false;
            }

        }
        return false;
    }
}
