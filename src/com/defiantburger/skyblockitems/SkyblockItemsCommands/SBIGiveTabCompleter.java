package com.defiantburger.skyblockitems.SkyblockItemsCommands;

import com.defiantburger.skyblockitems.SkyblockItems.Items;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class SBIGiveTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> out = new ArrayList<>();
        for (String s : Items.items.keySet()) {
            if (s.startsWith(args[0].toUpperCase())) out.add(s);
        }

        return out;
    }

}
