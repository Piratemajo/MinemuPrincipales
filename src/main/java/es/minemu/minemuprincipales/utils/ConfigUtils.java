package es.minemu.minemuprincipales.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigUtils implements Listener  {
    private  File file;
    private  FileConfiguration config;


    public ConfigUtils(Plugin plugin,String path){
        this(plugin.getDataFolder().getAbsolutePath() + "/" + path);
    }


    public ConfigUtils(String path) {
        this.file = new File(path);
        this.config = new YamlConfiguration().loadConfiguration(this.file);
    }


    public  boolean save (){
        try {
            this.config.save(this.file);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public File getFile(){

        return this.file;
    }

    public  FileConfiguration getConfig() {
        return this.config;
    }
}
