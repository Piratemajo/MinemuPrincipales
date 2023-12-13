package es.minemu.minemuprincipales.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class Ayuda implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.GOLD +"---------------[MinemuPrincipales]---------------");
        sender.sendMessage("| /broadcast - Enviar un mensaje a todo el servidor");
        sender.sendMessage("| /heal - Curar al jugador");
        sender.sendMessage("| /craft - Abrir un banco de trabajo");
        sender.sendMessage("| /nick - Cambiar el nombre visible del jugador");
        sender.sendMessage("| /hora - Mostrar tiempo restante hasta el próximo día");
        sender.sendMessage("| /weatherclear - Limpiar el clima");
        sender.sendMessage("| /feed - Rellenar la barra de hambre");
        sender.sendMessage("| /gm - Cambiar el modo de juego");
        sender.sendMessage("| /vanish - Activar o desactivar el modo invisible");
        sender.sendMessage("| /helpop - pide ayuda a un admin");
        sender.sendMessage("| /ayuda - pide ayuda");
        sender.sendMessage("| /spawn - ir al spawn ");
        sender.sendMessage("| /home - ir a tu casa o viajar a tu home deseado");
        sender.sendMessage("| /reglas - las reglas del servidor ");
        sender.sendMessage(ChatColor.GOLD +"---------------[MinemuPrincipales]---------------");
        return true;
    }
}

