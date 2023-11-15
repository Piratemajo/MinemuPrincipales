package es.minemu.minemuprincipales.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SaludoCommand implements CommandExecutor {

    public boolean onCommand (CommandSender sender, Command command,String label,String[] args){
        if (command.getName().equalsIgnoreCase("saludo")){
            if (sender instanceof Player) {
                sender.sendMessage("Hola, servidor");
            }
        }
        return false;
    }
}
