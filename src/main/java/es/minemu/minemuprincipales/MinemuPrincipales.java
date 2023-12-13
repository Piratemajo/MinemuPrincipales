package es.minemu.minemuprincipales;
import es.minemu.minemuprincipales.commands.*;

import es.minemu.minemuprincipales.listeners.HomeListeners;
import es.minemu.minemuprincipales.listeners.JoinLeaveListener;
import es.minemu.minemuprincipales.listeners.SpawnListeners;
import org.bukkit.command.CommandExecutor;

import org.bukkit.plugin.java.JavaPlugin;




public class MinemuPrincipales extends JavaPlugin implements CommandExecutor {



    @Override
    public void onEnable() {


        // Registra los comandos y asigna este objeto como su ejecutor
        getCommand("saludo").setExecutor(new SaludoCommand());
        getCommand("curar").setExecutor(new CurarCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("broadcast").setExecutor(new Broadcast());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("craft").setExecutor(new CraftCommand());
        getCommand("nick").setExecutor(new NickCommand());
        getCommand("hora").setExecutor(new HoraCommand());
        getCommand("sun").setExecutor(new SunCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("gm").setExecutor(new GmCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("ayuda").setExecutor(new Ayuda());
        getCommand("helpop").setExecutor(new HelpOpCommand());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("reglas").setExecutor(new ReglasComand());


        // Comados de spawn
        //Setup/Load Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("sethome").setExecutor(new SetHomeComand(this));
        getCommand("home").setExecutor(new HomeCommand(this));

        //register the commands
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        //register the events
        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new HomeListeners(this), this);
    }

    @Override
    public void onDisable() {
        // Cualquier limpieza o tareas de apagado aquí
    }

}
