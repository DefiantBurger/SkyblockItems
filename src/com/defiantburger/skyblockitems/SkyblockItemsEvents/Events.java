package com.defiantburger.skyblockitems.SkyblockItemsEvents;

import com.defiantburger.skyblockitems.SkyblockItems.Items;
import com.defiantburger.skyblockitems.SkyblockItems.SkyblockItem;
import com.defiantburger.skyblockitems.SkyblockItems.Utility.NamespacedKeys;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Events implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if (event.getPlayer().getInventory().getItemInMainHand() != null) {
            PersistentDataContainer pdc = event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer();
            if (pdc.has(NamespacedKeys.isSkyblockItem, PersistentDataType.INTEGER)) {
                if (pdc.get(NamespacedKeys.isSkyblockItem, PersistentDataType.INTEGER) == 1) {
                    event.setCancelled(true);
                    SkyblockItem item = Items.items.get(pdc.get(NamespacedKeys.skyblockID, PersistentDataType.STRING));
                    new ClickAction(event, item);
                }
            }
        }

    }

}
