package es.minemu.minemuprincipales;
import es.minemu.minemuprincipales.commands.*;


import es.minemu.minemuprincipales.utils.ConfigUtils;
import es.minemu.minemuprincipales.utils.SpawnUtils;
import org.bukkit.command.CommandExecutor;

import org.bukkit.plugin.java.JavaPlugin;




public class MinemuPrincipales extends JavaPlugin implements CommandExecutor {



    @Override
    public void onEnable() {

        ConfigUtils config = new ConfigUtils(this, "config.yml");
        config.getConfig().set("Autor","Javier");
        config.getConfig().set("Version","9.0");
        config.getConfig().set("Descripcion","Plugin con comandos esenciales para minemu compatible con folia");
        config.getConfig().set("Problemas","Setspawn y spawn");
        config.save();

        SpawnUtils spawnUtils = new SpawnUtils(this);


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
        getCommand("spawn").setExecutor(new Spawn(spawnUtils));
        getCommand("setSpawn").setExecutor(new SetSpawn(spawnUtils));
    }

    @Override
    public void onDisable() {
        // Cualquier limpieza o tareas de apagado aquí
    }

}
