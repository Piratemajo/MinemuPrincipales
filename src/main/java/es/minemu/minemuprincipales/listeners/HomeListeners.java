package es.minemu.minemuprincipales.listeners;

import es.minemu.minemuprincipales.MinemuPrincipales;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;


// Listener para ir a tu casa o para irte a donde quieras ya que esta alojando  (sethome)

public class HomeListeners implements Listener {

    private final MinemuPrincipales plugin;

    public HomeListeners(MinemuPrincipales plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){


        if(!e.getPlayer().hasPlayedBefore()){
            Location location = plugin.getConfig().getLocation("home");
            if(location != null){
                e.getPlayer().teleport(location);
            }
        }

    }

    @EventHandler
    public void onPlayerDeath(PlayerRespawnEvent e){
        Location location = plugin.getConfig().getLocation("home");
        if(location != null){

            e.setRespawnLocation(location);
        }
    }


}
