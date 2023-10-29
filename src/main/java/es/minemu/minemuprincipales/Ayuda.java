package es.minemu.minemuprincipales;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class Ayuda implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.GOLD +"---------------[MinemuPrincipales]---------------");
        sender.sendMessage("| /tpa - Enviar solicitud de teletransporte");
        sender.sendMessage("| /tpaccept - Aceptar solicitud de teletransporte");
        sender.sendMessage("| /tpall - Teletransportar a todos los jugadores");
        sender.sendMessage("| /broadcast - Enviar un mensaje a todo el servidor");
        sender.sendMessage("| /heal - Curar al jugador");
        sender.sendMessage("| /setspawn - Establecer el punto de aparición");
        sender.sendMessage("| /workbench - Abrir un banco de trabajo");
        sender.sendMessage("| /nick - Cambiar el nombre visible del jugador");
        sender.sendMessage("| /timeleft - Mostrar tiempo restante hasta el próximo día");
        sender.sendMessage("| /weatherclear - Limpiar el clima");
        sender.sendMessage("| /feed - Rellenar la barra de hambre");
        sender.sendMessage("| /gm - Cambiar el modo de juego");
        sender.sendMessage("| /spawn - Teletransportar al punto de aparición");
        sender.sendMessage("| /setwarp - Establecer una ubicación de warp");
        sender.sendMessage("| /warp - Teletransportar a una ubicación de warp");
        sender.sendMessage("| /vanish - Activar o desactivar el modo invisible");
        sender.sendMessage("| /pet - Obtener una mascota");
        sender.sendMessage("| /petlist - Mostrar la lista de mascotas");
        sender.sendMessage("| /petrename - Cambiar el nombre de una mascota");
        sender.sendMessage("| /petrelease - Liberar a una mascota");
        sender.sendMessage(ChatColor.GOLD +"---------------[MinemuPrincipales]---------------");
        return true;
    }
}

