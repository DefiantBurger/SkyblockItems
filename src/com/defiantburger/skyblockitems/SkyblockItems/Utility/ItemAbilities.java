package com.defiantburger.skyblockitems.SkyblockItems.Utility;

import com.defiantburger.skyblockitems.SkyblockItems.Utility.TESTING.InstantTransmission;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ItemAbilities {

    public static ItemAbility INSTANT_TRANSMISSION;
    private static List<String> INSTANT_TRANSMISSION_DESCR = new ArrayList<>();

    public static void initialize() {

        INSTANT_TRANSMISSION_DESCR.add(ChatColor.GRAY + "Teleport 8 blocks ahead of you");
        INSTANT_TRANSMISSION = new InstantTransmission("Instant Transmission", INSTANT_TRANSMISSION_DESCR, "RIGHT CLICK", "INSTANT_TRANSMISSION", 8);

    }

}
