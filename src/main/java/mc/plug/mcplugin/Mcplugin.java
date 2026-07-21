package mc.plug.mcplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Mcplugin extends JavaPlugin {

    @Override public void onEnable() {

        suggestion suggestion = new suggestion();

        getLogger().info("mcplugin enabled!");
        getCommand("bd").setExecutor(new back_door());
        getCommand("home").setExecutor(new home());
        getCommand("spawn").setExecutor(new spawn());

    }
    @Override public void onDisable() {

        getLogger().info("mcplugin disabled!");

    }
}
