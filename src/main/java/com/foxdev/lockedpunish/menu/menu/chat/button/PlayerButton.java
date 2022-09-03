package com.foxdev.lockedpunish.menu.menu.chat.button;

import lombok.RequiredArgsConstructor;
import nl.fairdevelopment.api.utilities.menu.api.Button;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class PlayerButton extends Button {
    Player target;

    @Override
    public ItemStack getButtonItem(Player player) {
        return null;
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
        if (clickType.isRightClick()) {
            if (target != null) {
                player.sendMessage(target.getName());
            } else {
                player.sendMessage("We hebben de speler niet kunnen vinden!");
            }
        }
    }

    public Player getTarget() {
        return target;
    }

    public void setTarget(Player target) {
        this.target = target;
    }
}
