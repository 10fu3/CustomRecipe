package jp.msfblue1.customrecipe;

import jp.msfblue1.customrecipe.Commands.Register;
import jp.msfblue1.customrecipe.Event.Event;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class CustomRecipe extends JavaPlugin {

    List<Recipe> customrecipe = new ArrayList<>();
    public static CustomRecipe plugin;

    @Override
    public void onEnable() {
        plugin = this;
        if(!Bukkit.getBukkitVersion().equalsIgnoreCase("1.12.2-R0.1-SNAPSHOT")){
            Bukkit.getPluginManager().disablePlugin(this);
        }
        Bukkit.getPluginCommand("cr").setExecutor(new Register());
        Bukkit.getPluginManager().registerEvents(new Event(this),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void addRecipes(){

    }
}
