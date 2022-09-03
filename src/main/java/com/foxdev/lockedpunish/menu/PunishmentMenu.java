package com.foxdev.lockedpunish.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PunishmentMenu {

    private final Player target;

    public PunishmentMenu(Player target) {
        this.target = target;
    }

    public void openPunishmentMenu(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9, "Punish inventory");

        inventory.setItem(0, new ItemStack(Material.ANVIL));
        inventory.setItem(2, new ItemStack(Material.REDSTONE_BLOCK));

        player.openInventory(inventory);
    }

    public String getTarget() {
        return target.getName();
    }

    public Player getTargetPlayer() {
        return target;
    }

    public void setTarget(String target) {
        System.out.println(target);
        target = target;
    }
}
