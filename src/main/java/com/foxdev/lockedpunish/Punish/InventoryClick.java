package com.foxdev.lockedpunish.Punish;

import com.foxdev.lockedpunish.menu.PunishmentMenu;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class InventoryClick implements Listener {

    @EventHandler
    public void InventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        PunishmentMenu menu = new PunishmentMenu();

        if (e.getView().getTitle().equals(replace("&4Punish System!"))) {
            e.setCancelled(true);

            if (e.getClick().isLeftClick() || e.getClick().isRightClick()) {
                String targetName = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()); // <-- is dan niet goed

                menu.openPunishmentMenu(player);
                menu.setTarget(targetName);

                System.out.println(menu.getTarget().getName());
            }
        } else if (e.getView().getTitle().equals(replace("Punish inventory"))) {
            e.setCancelled(true);
            System.out.println("PunishmentINV -> " + menu.getTarget().getName());

            if (e.getClick().isLeftClick() || e.getClick().isRightClick()) {
                switch (e.getCurrentItem().getType()) {
                    case ANVIL: {
                        player.sendMessage("Je hebt op KICK Geklickt!");
                        break;
                    }

                    case REDSTONE_BLOCK: {
                        Bukkit.getBanList(BanList.Type.NAME).addBan(menu.getTarget().getName(), "Je bent verbannen", null, null);
                        Bukkit.getPlayer(menu.getTarget().getName()).kickPlayer("Verbannen!");

                        player.sendMessage("Je hebt op BANNED Geklickt!");
                        break;
                    }
                }
            }
       }
    }

    public String replace(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
