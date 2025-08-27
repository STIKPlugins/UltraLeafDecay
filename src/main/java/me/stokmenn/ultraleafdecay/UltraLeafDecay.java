package me.stokmenn.ultraleafdecay;

import me.stokmenn.ultraleafdecay.commands.ReloadCommand;
import me.stokmenn.ultraleafdecay.config.Config;
import me.stokmenn.ultraleafdecay.listeners.BlockBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class UltraLeafDecay extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config(this);
        getCommand("ultraleafdecay").setExecutor(new ReloadCommand(this, config));

        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(config), this);
    }
}