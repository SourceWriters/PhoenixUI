package net.sourcewriters.minecraft.phoenixui.api.module;

import java.util.Objects;

import org.bukkit.plugin.Plugin;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixUIApi;

public abstract class AbstractPluginModule implements IPhoenixModule {

    private final Plugin plugin;

    public AbstractPluginModule(Plugin plugin) {
        this.plugin = Objects.requireNonNull(plugin);
        // TODO: Register
    }

    public Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onLoad(IPhoenixUIApi api) {}

    @Override
    public void onUnload(IPhoenixUIApi api) {}

}
