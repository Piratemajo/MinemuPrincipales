package es.minemu.minemuprincipales.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.bukkit.Bukkit.getServer;

public class HoraCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        if (command.getName().equalsIgnoreCase("hora")) {
            // Implementa la lógica para el comando /timeleft aquí
            // Este comando podría usarse para mostrar el tiempo restante hasta el próximo día
            long timeUntilDay = 24000 - (getServer().getWorlds().get(0).getTime() % 24000);
            long hours = timeUntilDay / 1000;
            long minutes = (timeUntilDay % 1000) * 60 / 1000;
            sender.sendMessage(ChatColor.GREEN + "Tiempo restante hasta el próximo día: " + hours + " horas y " + minutes + " minutos.");
            return true;
        }

        return false;
    }
}
