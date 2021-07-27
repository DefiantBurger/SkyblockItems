package com.defiantburger.skyblockitems.SkyblockItems.Utility;

import org.bukkit.entity.Player;

import java.util.List;

public abstract class ItemAbility {

    private String name;
    private List<String> description;
    private String activator;
    private List<String> activator_ids;
    private String id;

    public ItemAbility(String name, List<String> description, String activator, List<String> activator_ids, String id) {
        this.name = name;
        this.description = description;
        this.activator = activator;
        this.activator_ids = activator_ids;
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
    public List<String> getActivator_ids() {
        return activator_ids;
    }
}
