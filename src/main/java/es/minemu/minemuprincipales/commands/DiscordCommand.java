package es.minemu.minemuprincipales.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DiscordCommand implements  CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.GOLD +"---------------[MinemuPrincipales]---------------");
        sender.sendMessage(ChatColor.AQUA + "minemu.es/discord");
        sender.sendMessage(ChatColor.GOLD +"---------------[MinemuPrincipales]---------------");
        return true;
    }
}
