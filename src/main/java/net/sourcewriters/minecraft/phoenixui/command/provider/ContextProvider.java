package net.sourcewriters.minecraft.phoenixui.command.provider;

import org.bukkit.entity.Player;

import me.lauriichan.laylib.command.Actor;
import me.lauriichan.laylib.command.IProviderArgumentType;
import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;
import net.sourcewriters.minecraft.phoenixui.api.IPhoenixUIApi;

public final class ContextProvider implements IProviderArgumentType<IPhoenixContext> {

    private final IPhoenixUIApi api;

    public ContextProvider(final IPhoenixUIApi api) {
        this.api = api;
    }

    @Override
    public IPhoenixContext provide(Actor<?> actor) {
        if (!actor.as(Player.class).isValid()) {
            return null;
        }
        return api.getContext(actor.as(Player.class).getHandle());
    }

}
