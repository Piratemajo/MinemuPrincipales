package es.minemu.minemuprincipales.listeners;


import es.minemu.minemuprincipales.MinemuPrincipales;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;



// Evento de que escucha cuando se ejecuta el codigo le dice la localizacion y mucho mas

public class SpawnListeners implements Listener {

    private final MinemuPrincipales plugin;

    public SpawnListeners(MinemuPrincipales plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){


        if(!e.getPlayer().hasPlayedBefore()){
            Location location = plugin.getConfig().getLocation("spawn");
            if(location != null){
                e.getPlayer().teleport(location);
            }
        }

    }

    @EventHandler
    public void onPlayerDeath(PlayerRespawnEvent e){
        Location location = plugin.getConfig().getLocation("spawn");
        if(location != null){

            e.setRespawnLocation(location);
        }
    }

}