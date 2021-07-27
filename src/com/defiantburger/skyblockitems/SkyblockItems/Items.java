package com.defiantburger.skyblockitems.SkyblockItems;

import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemAbilities;
import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemAbility;
import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemRarities;
import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemTypes;
import org.bukkit.Material;

import java.util.HashMap;

public class Items {

    public static HashMap<String, SkyblockItem> items = new HashMap<>();

    public static void initialize() {
        items.put("ASPECT_OF_THE_END", new SkyblockItem("Aspect of the End", Material.DIAMOND_SWORD, 1, "ASPECT_OF_THE_END", ItemRarities.RARE, ItemTypes.SWORD, new ItemAbility[]{ItemAbilities.INSTANT_TRANSMISSION}));
        items.put("COW_TELEPORTER", new SkyblockItem("Cow Teleporter", Material.COW_SPAWN_EGG, 1, "COW_TELEPORTER", ItemRarities.MYTHIC, ItemTypes.CHESTPLATE, new ItemAbility[]{ItemAbilities.INSTANT_TRANSMISSION}));
    }

}
