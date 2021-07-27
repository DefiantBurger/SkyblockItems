package com.defiantburger.skyblockitems.SkyblockItemsEvents;

import com.defiantburger.skyblockitems.SkyblockItems.SkyblockItem;
import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemAbility;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickAction {

    PlayerInteractEvent event;
    Player player;
    SkyblockItem item;
    String skyblockID;

    public ClickAction(PlayerInteractEvent event, SkyblockItem item) {
        this.event = event;
        this.player = event.getPlayer();
        this.item = item;
        this.skyblockID = item.getId();

        for (ItemAbility ability : item.getAbilities()) {
            ability.activate(player);
        }
    }


}
