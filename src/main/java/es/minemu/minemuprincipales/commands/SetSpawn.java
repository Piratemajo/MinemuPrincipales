package es.minemu.minemuprincipales.commands;

import es.minemu.minemuprincipales.utils.SpawnUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {
    private SpawnUtils spawnUtils;

    public SetSpawn(SpawnUtils spawnUtils){
        this.spawnUtils = spawnUtils;
    }




    @Override
    public boolean onCommand (CommandSender sender, Command command,String label,String[] args){
        if (!(sender instanceof Player)){
            sender.sendMessage("Solo los administradores  pueden usar este comando");
            return true;
        }

        Player player = (Player) sender;
        spawnUtils.set(player.getLocation());

        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&aSet Spawn esta colocado"));



        return false;
    }

}
