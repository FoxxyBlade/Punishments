package com.foxdev.lockedpunish.Punish;

import com.foxdev.lockedpunish.menu.menu.chat.ChatMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PunishCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&4Punish System!"));

        Bukkit.getOnlinePlayers().forEach(onlinePlayer -> {
            ItemStack i = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

            SkullMeta im = (SkullMeta) i.getItemMeta();
            im.setOwner(onlinePlayer.getName());
            im.setDisplayName(onlinePlayer.getName());
            i.setItemMeta(im);

            inv.addItem(i);

        });

        new ChatMenu(player).openMenu(player);

        return true;
    }
}
