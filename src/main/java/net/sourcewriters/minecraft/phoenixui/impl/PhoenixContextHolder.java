package net.sourcewriters.minecraft.phoenixui.impl;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public final class PhoenixContextHolder implements InventoryHolder {
    
    private final PhoenixContextImpl context;
    
    public PhoenixContextHolder(final PhoenixContextImpl context) {
        this.context = context;
    }

    @Override
    public Inventory getInventory() {
        return context.getInventory().getHandle();
    }
    
    public PhoenixContextImpl getContext() {
        return context;
    }

}
