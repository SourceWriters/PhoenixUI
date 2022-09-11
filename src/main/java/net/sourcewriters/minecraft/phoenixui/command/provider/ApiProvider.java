package net.sourcewriters.minecraft.phoenixui.command.provider;

import me.lauriichan.laylib.command.Actor;
import me.lauriichan.laylib.command.IProviderArgumentType;
import net.sourcewriters.minecraft.phoenixui.api.IPhoenixUIApi;

public final class ApiProvider implements IProviderArgumentType<IPhoenixUIApi> {

    private final IPhoenixUIApi api;
    
    public ApiProvider(final IPhoenixUIApi api) {
        this.api = api;
    }

    @Override
    public IPhoenixUIApi provide(Actor<?> actor) {
        return api;
    }
    
}
