package es.minemu.minemuprincipales.commands;

import es.minemu.minemuprincipales.MinemuPrincipales;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

public class HomeCommand implements CommandExecutor {

    private final MinemuPrincipales plugin;

    public HomeCommand(MinemuPrincipales plugin) {
        this.plugin = plugin;
    }


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Asegúrate de que sea un jugador
        if (sender instanceof Player) {

            Player player = (Player) sender;

            // Verifica si el plugin tiene un punto de spawn configurado en el archivo de configuración
            Location location = plugin.getConfig().getLocation("home");
            if (location != null) {

                // Utiliza CompletableFuture para manejar la teleportación de manera asincrónica
                CompletableFuture.runAsync(() -> {
                    // Teleporta al jugador al punto de spawn de manera asincrónica
                    player.teleportAsync(location).thenRun(() -> {
                        // Envía un mensaje al jugador después de la teleportación
                        player.sendMessage(ChatColor.AQUA + "Viajando a tu home");
                    });
                });

            } else {
                player.sendMessage("No hay home");
            }

        } else {
            // Si el comando es ejecutado por la consola u otro origen no jugador
            sender.sendMessage("Este comando solo puede ser ejecutado por jugadores");
        }

        return true;
    }

}
