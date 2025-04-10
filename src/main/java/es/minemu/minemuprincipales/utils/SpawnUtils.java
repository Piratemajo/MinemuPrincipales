package es.minemu.minemuprincipales.utils;

import es.minemu.minemuprincipales.MinemuPrincipales;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.logging.Level;

public class SpawnUtils implements Listener {
    private  ConfigUtils config;
    private  Location spawn;

    public SpawnUtils(MinemuPrincipales plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);

        config = new ConfigUtils(plugin, "spawn.yml");

        String worldName = config.getConfig().getString("world");
        double x = config.getConfig().getDouble("x");
        double y = config.getConfig().getDouble("y");
        double z = config.getConfig().getDouble("z");
        float yaw = (float) config.getConfig().getDouble("yaw");
        float pitch = (float) config.getConfig().getDouble("pitch");

        if (worldName != null){
            World world = Bukkit.getWorld(worldName);
            if (world == null){
                Bukkit.getLogger().log(Level.SEVERE, "El mundo world " + worldName + "no existe");
                return;
            }

            spawn = new Location(world, x , y, z, yaw, pitch);
        }

    }


    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        if (spawn != null){
            event.setRespawnLocation(spawn);
        }
    }

    public void teleport(Player player){
        if (spawn != null){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"Spawn no asignado"));
            return;
        }
        player.teleport(spawn);

    }

    public  void  set(Location spawn){
        this.spawn = spawn;

        String worldName = spawn.getWorld().getName();
        double x = spawn.getX();
        double y = spawn.getY();
        double z = spawn.getZ();
        double yaw = spawn.getYaw();
        double pitch = spawn.getPitch();

        config.getConfig().set("world", worldName);
        config.getConfig().set("x", x);
        config.getConfig().set("y", y);
        config.getConfig().set("z", z);
        config.getConfig().set("yaw", yaw);
        config.getConfig().set("pitch", pitch);

    }


}
