package com.foxdev.lockedpunish;

import com.foxdev.lockedpunish.Punish.InventoryClick;
import com.foxdev.lockedpunish.Punish.PunishCmd;
import com.foxdev.lockedpunish.menu.PunishmentMenu;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Lockedpunish extends JavaPlugin {

    public static Lockedpunish INSTANCE;

    private PunishmentMenu punishmentMenu;

    @Override
    public void onEnable() {
        INSTANCE = this;

        getCommand("punish").setExecutor(new PunishCmd());

        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
    }

    @Override
    public void onDisable() {
        INSTANCE = null;
    }
}
