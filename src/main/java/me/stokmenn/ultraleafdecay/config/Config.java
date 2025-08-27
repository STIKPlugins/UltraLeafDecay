package me.stokmenn.ultraleafdecay.config;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
    private final JavaPlugin plugin;

    private int maxLogDistance;

    private String reloadPermission;

    private Component noPermissionToReload;
    private Component configReloaded;

    public Config(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        reload();
    }

    public void reload() {
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();

        maxLogDistance = config.getInt("max-log-distance", 6);

        reloadPermission = config.getString("reload-permission", "ultraLeafDecay.reload");

        noPermissionToReload = MiniMessage.miniMessage().deserialize(config.getString(
                "no-permission-to-reload", "<red>✘ <white>You don't have permission to reload Config!"));

        configReloaded = MiniMessage.miniMessage().deserialize(config.getString(
                "config-reloaded", "<green>✔ <white>Config reloaded!"));
    }

    public int getMaxLogDistance() {
        return maxLogDistance;
    }
    public String getReloadPermission() {
        return reloadPermission;
    }
    public Component getNoPermissionToReload() {
        return noPermissionToReload;
    }
    public Component getConfigReloaded() {
        return configReloaded;
    }
}
