package net.ssgssp.createfarmeco;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CreateFarmECO extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("插件已加载");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new BlkbreakEvListener(),this);
        Bukkit.getPluginManager().registerEvents(new BlockHarvEvListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("插件已卸载");
    }
}
