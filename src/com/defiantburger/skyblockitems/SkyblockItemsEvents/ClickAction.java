package com.defiantburger.skyblockitems.SkyblockItemsEvents;

import com.defiantburger.skyblockitems.SkyblockItems.SkyblockItem;
import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemAbility;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashSet;
import java.util.Set;

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
            ability.activate();
        }
    }

    public void teleport(int blocks) {

        Block b = player.getLocation().getBlock();

        Set<Material> transparent = new HashSet<>();
        transparent.add(Material.WATER);
        transparent.add(Material.AIR);
        transparent.add(Material.VOID_AIR);
        transparent.add(Material.CAVE_AIR);
        try {
            b = player.getTargetBlock(transparent, blocks);
        } catch (Exception ignored) {}

        Location loc = new Location(b.getWorld(), b.getX()+0.5, b.getY()+0.5, b.getZ()+0.5, player.getLocation().getYaw(), player.getLocation().getPitch());
        player.teleport(loc);

    }


}
