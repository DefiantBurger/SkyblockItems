package com.defiantburger.skyblockitems;

import com.defiantburger.skyblockitems.SkyblockItems.Items;
import com.defiantburger.skyblockitems.SkyblockItemsCommands.SBIGive;
import com.defiantburger.skyblockitems.SkyblockItemsCommands.SBIGiveTabCompleter;
import com.defiantburger.skyblockitems.SkyblockItemsEvents.Events;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Skyblock extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new Events(), this);
        getCommand("sbigive").setExecutor(new SBIGive());
        getCommand("sbigive").setTabCompleter(new SBIGiveTabCompleter());

        Items.initialize();

        System.out.println(ChatColor.GREEN + "[SkyblockItems] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "[SkyblockItems] Plugin disabled!");
    }

    public static Plugin getPlugin() {
        return plugin;
    }

}
