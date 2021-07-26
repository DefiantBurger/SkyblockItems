package com.defiantburger.skyblockitems.SkyblockItems.Utility;

import org.bukkit.ChatColor;

public class ItemRarity {

    private String name;
    private ChatColor color;

    public ItemRarity(String name, ChatColor color) {
        this.name = name;
        this.color = color;
    }

    public ChatColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
