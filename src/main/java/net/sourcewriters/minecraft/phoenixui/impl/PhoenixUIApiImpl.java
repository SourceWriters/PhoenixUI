package net.sourcewriters.minecraft.phoenixui.impl;

import org.bukkit.entity.Player;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;
import net.sourcewriters.minecraft.phoenixui.api.IPhoenixUIApi;
import net.sourcewriters.minecraft.phoenixui.api.menu.AbstractMenu;
import net.sourcewriters.minecraft.phoenixui.api.menu.IPhoenixMenu;

public final class PhoenixUIApiImpl implements IPhoenixUIApi {

    @Override
    public IPhoenixContext getContext(Player player) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <M extends AbstractMenu> IPhoenixMenu<M> registerMenu(M menu) {
        // TODO Auto-generated method stub
        return null;
    }

}
