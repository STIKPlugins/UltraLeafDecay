package me.stokmenn.ultraleafdecay.commands;

import me.stokmenn.ultraleafdecay.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public record ReloadCommand(JavaPlugin plugin, Config config) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission(config.getReloadPermission())) {
            sender.sendMessage(config.getNoPermissionToReload());
            return false;
        }
        Bukkit.getAsyncScheduler().runNow(plugin, task -> config.reload());

        sender.sendMessage(config.getConfigReloaded());
        return true;
    }
}
