package net.sourcewriters.minecraft.phoenixui.impl;

import java.util.Optional;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;
import net.sourcewriters.minecraft.phoenixui.api.menu.AbstractMenuContainer;
import net.sourcewriters.minecraft.phoenixui.api.menu.IPhoenixMenu;
import net.sourcewriters.minecraft.phoenixui.util.Ref;
import net.sourcewriters.minecraft.phoenixui.util.WeakRef;

public final class PhoenixContextImpl implements IPhoenixContext {

    private final PhoenixUIApiImpl api;

    private final Ref<IPhoenixMenu<?>> menu = Ref.of();
    
    private final Ref<PhoenixInventoryImpl> inventory = Ref.of();
    private final WeakRef<Player> player = WeakRef.of();

    private final UUID ownerId;
    
    public PhoenixContextImpl(final PhoenixUIApiImpl api, final UUID ownerId) {
        this.api = api;
        this.ownerId = ownerId;
    }

    @Override
    public PhoenixUIApiImpl getApi() {
        return api;
    }

    @Override
    public PhoenixInventoryImpl getInventory() {
        return inventory.get();
    }

    @Override
    public Player getPlayer() {
        if (player.isPresent()) {
            return player.get();
        }
        return player.set(Bukkit.getPlayer(ownerId)).get();
    }

    @Override
    public Optional<IPhoenixMenu<?>> getMenu() {
        
        return null;
    }

    @Override
    public boolean openMenu(AbstractMenuContainer container) {
        
        return false;
    }

}
