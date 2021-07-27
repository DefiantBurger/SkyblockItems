package com.defiantburger.skyblockitems.SkyblockItems.Utility;

import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemAbilitiesClasses.InstantTransmission1;
import com.defiantburger.skyblockitems.SkyblockItems.Utility.ItemAbilitiesClasses.InstantTransmission8;

import java.util.Arrays;

public class ItemAbilities {

    public static InstantTransmission8 INSTANT_TRANSMISSION_8 = new InstantTransmission8("Instant Transmission", Arrays.asList("Teleport 8 blocks ahead of you"), "RIGHT CLICK", Arrays.asList("RIGHT_CLICK_BLOCK", "RIGHT_CLICK_AIR"), "INSTANT_TRANSMISSION_8");
    public static InstantTransmission1 INSTANT_TRANSMISSION_1 = new InstantTransmission1("Instant Transmission", Arrays.asList("Teleport 1 blocks ahead of you"), "RIGHT CLICK", Arrays.asList("RIGHT_CLICK_BLOCK", "RIGHT_CLICK_AIR"),"INSTANT_TRANSMISSION_1");

}
