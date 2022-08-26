package com.foxdev.lockedpunish;

import com.foxdev.lockedpunish.Punish.InventoryClick;
import com.foxdev.lockedpunish.Punish.PunishCmd;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lockedpunish extends JavaPlugin {

    public static Lockedpunish INSTANCE;

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
