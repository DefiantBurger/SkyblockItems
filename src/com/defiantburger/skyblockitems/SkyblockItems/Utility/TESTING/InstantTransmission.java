package com.defiantburger.skyblockitems.SkyblockItems.Utility.TESTING;

import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemAbility;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InstantTransmission extends ItemAbility {

    private int blocks;

    public InstantTransmission(String name, List<String> description, String activator, String id) {
        super(name, description, activator, id);
    }

    public void activate(Player player) {
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
