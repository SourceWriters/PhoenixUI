package net.sourcewriters.minecraft.phoenixui.api.module;

import com.syntaxphoenix.avinity.module.Module;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixUIApi;

public abstract class AbstractAvinityModule extends Module implements IPhoenixModule {

    @Override
    public final void enable() throws Exception {

        try {
            onEnable();
        } finally {

        }
    }

    @Override
    public final void disable() throws Exception {

        try {
            onDisable();
        } finally {

        }
    }

    /*
     * 
     */

    protected void onEnable() throws Exception {}

    protected void onDisable() throws Exception {}
    
    @Override
    public void onLoad(IPhoenixUIApi api) {}
    
    @Override
    public void onUnload(IPhoenixUIApi api) {}

}
