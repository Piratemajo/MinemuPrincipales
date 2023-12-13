package es.minemu.minemuprincipales.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


// Evento de salidad del jugador y la entrada del jugador


public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        if (player.hasPlayedBefore()){
            e.setJoinMessage(ChatColor.GREEN + "¡Bienvenido de nuevo al servidor " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.GREEN + ".");
        }else{
            e.setJoinMessage(ChatColor.BLUE + "" + ChatColor.BOLD + player.getDisplayName() + ", " + ChatColor.BLUE + "Bienvenido al servidor");
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){

        Player player = e.getPlayer();

        e.setQuitMessage(ChatColor.YELLOW + player.getDisplayName() + ChatColor.RED + " ha salido, esperemos que regrese.");
    }


}