package com.defiantburger.skyblockitems.SkyblockItemsCommands;

import com.defiantburger.skyblockitems.SkyblockItems.Items;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SBIGive implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Please specify an ID!");
            return true;
        }

        args[0] = args[0].toUpperCase();

        try {
            player.getInventory().addItem(Items.items.get(args[0]).get());
        } catch (Exception e) {
            player.sendMessage(ChatColor.RED + "Item not found with id: \"" + args[0] + "\"!");
        }

        return true;
    }

}
