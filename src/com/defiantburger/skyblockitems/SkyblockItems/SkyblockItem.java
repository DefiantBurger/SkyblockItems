package com.defiantburger.skyblockitems.SkyblockItems;

import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemAbility;
import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemRarity;
import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SkyblockItem {

    private ItemStack item;
    private String name;
    private Material material;
    private int count;
    private String id;
    private ItemRarity rarity;
    private ItemType type;
    private ItemAbility[] abilities;

    public SkyblockItem(String name, Material material, int count, String id, ItemRarity rarity, ItemType type, ItemAbility[] abilities) {
        this.name = name;
        this.material = material;
        this.count = count;
        this.id = id;
        this.rarity = rarity;
        this.type = type;
        this.abilities = abilities;

        create();
    }

    public void create() {
        item = new ItemStack(material, count);
        item = new MetaBuilder(this).getItem();
    }

    public ItemStack get() {
        return item;
    }

    public String getName() { return name; }
    public Material getMaterial() { return material; }
    public int getCount() { return count; }
    public String getId() { return id; }
    public ItemRarity getRarity() { return rarity; }
    public ItemType getType() {
        return type;
    }
    public ItemAbility[] getAbilities() {
        return abilities;
    }
}
