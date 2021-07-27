package com.defiantburger.skyblockitems.SkyblockItems.Utility;

import org.bukkit.entity.Player;

import java.util.List;

public abstract class ItemAbility {

    private String name;
    private List<String> description;
    private String activator;
    private String id;

    public ItemAbility(String name, List<String> description, String activator, String id) {
        this.name = name;
        this.description = description;
        this.activator = activator;
        this.id = id;
    }

    public abstract void activate(Player player);

    public String getName() {
        return name;
    }
    public List<String> getDescription() {
        return description;
    }
    public String getActivator() {
        return activator;
    }
    public String getId() {
        return id;
    }
}
