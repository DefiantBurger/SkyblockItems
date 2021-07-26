package com.defiantburger.skyblockitems.SkyblockItems;

import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemAbility;
import com.defiantburger.skyblockitems.SkyblockItems.Utility.NamespacedKeys;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class MetaBuilder {

    private SkyblockItem item;

    public MetaBuilder(SkyblockItem sbItem) {
        this.item = sbItem;

        buildInternals();
        buildExternals();
    }

    public ItemStack getItem() { return this.item.get(); }

    public void buildInternals() {

        ItemMeta meta = item.get().getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.set(NamespacedKeys.isSkyblockItem, PersistentDataType.INTEGER, 1);
        pdc.set(NamespacedKeys.skyblockID, PersistentDataType.STRING, item.getId());

        item.get().setItemMeta(meta);

    }

    public void buildExternals() {

        ItemMeta meta = item.get().getItemMeta();
        meta.setDisplayName(item.getRarity().getColor() + item.getName());
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DYE, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_PLACED_ON);

        List<String> lore = new ArrayList<>();
        lore.add("");

        for (ItemAbility ia : item.getAbilities()) {
            lore.add(ChatColor.GOLD + "Ability: " + ia.getName() + " " + ChatColor.YELLOW + ChatColor.BOLD + ia.getActivator());
            for (String s : ia.getDescription()) {
                lore.add(s);
            }
            lore.add("");
        }


        lore.add(item.getRarity().getColor() + "" + ChatColor.BOLD + item.getRarity().getName() + " " + item.getType().getName());

        meta.setLore(lore);
        item.get().setItemMeta(meta);

    }

}
