package es.minemu.minemuprincipales.commands;

import es.minemu.minemuprincipales.MinemuPrincipales;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeComand implements CommandExecutor {


    private final MinemuPrincipales homePlugin;

    public SetHomeComand(MinemuPrincipales homePlugin){
        this.homePlugin = homePlugin ;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Make sure that they are a player
        if (sender instanceof Player){
            Player player = (Player) sender;

            //get the players location
            Location location = player.getLocation();


/*
            set the spawn location in the config.yml
            homePlugin.getConfig().set("spawn.x", location.getX());
            homePlugin.getConfig().set("spawn.y", location.getY());
            homePlugin.getConfig().set("spawn.z", location.getZ());
*/

            //This is because it implements ConfigurationSerializable
            homePlugin.getConfig().set("home", location);


            //save the config.yml
            homePlugin.saveConfig();

            //send a message to the player
            player.sendMessage(ChatColor.YELLOW +"Home establecido");

        }else{
            System.out.println("Este comando no sirve en terminal .");
        }

        return true;
    }

}
