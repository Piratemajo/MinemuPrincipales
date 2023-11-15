package es.minemu.minemuprincipales.commands;

import es.minemu.minemuprincipales.utils.SpawnUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor  {
    private SpawnUtils spawnUtils;

    public Spawn(SpawnUtils spawnUtils){
        this.spawnUtils = spawnUtils;
    }

    @Override
    public boolean onCommand (CommandSender sender, Command command,String label,String[] args){
        if (!(sender instanceof Player)){
            sender.sendMessage("Solo los administradores  pueden usar este comando");
            return true;
        }

        Player player = (Player) sender;
        spawnUtils.teleport(player);



        return false;
    }

}
