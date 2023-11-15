package es.minemu.minemuprincipales.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class HelpOpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("helpop")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length < 1) {
                    player.sendMessage("Uso: /helpop <mensaje>");
                } else {
                    // Combinar los argumentos en un solo mensaje
                    String message = String.join(" ", args);

                    // Envía el mensaje a los administradores en línea
                    for (Player admin : Bukkit.getOnlinePlayers()) {
                        if (admin.hasPermission("MinemuPrincipales.helpop.receive")) {
                            admin.sendMessage(ChatColor.RED + "El usuario : " + player.getName() + " necesita ayuda : " + message);
                        }
                    }

                    player.sendMessage("Tu mensaje ha sido enviado a los administradores.");
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por jugadores en el juego.");
            }
            return true;
        }
        return false;
    }
}