package me.stokmenn.ultraleafdecay.config;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
    private static JavaPlugin plugin;

    public static int maxLogDistance;

    public static Component noPermissionToReload;
    public static Component configReloaded;

    public static void init(JavaPlugin plugin) {
        Config.plugin = plugin;
        plugin.saveDefaultConfig();
        reload();
    }

    public static void reload() {
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();

        maxLogDistance = config.getInt("maxLogDistance", 6);

        noPermissionToReload = MiniMessage.miniMessage().deserialize(config.getString(
                "noPermissionToReload", "<red>✘ <white>You don't have permission to reload Config!"));

        configReloaded = MiniMessage.miniMessage().deserialize(config.getString(
                "configReloaded", "<green>✔ <white>Config reloaded!"));
    }
}
