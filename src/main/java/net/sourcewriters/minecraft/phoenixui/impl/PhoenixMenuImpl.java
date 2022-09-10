package net.sourcewriters.minecraft.phoenixui.impl;

import org.bukkit.event.inventory.InventoryType;

import net.sourcewriters.minecraft.phoenixui.api.menu.AbstractMenu;
import net.sourcewriters.minecraft.phoenixui.api.menu.IPhoenixMenu;
import net.sourcewriters.minecraft.phoenixui.api.slot.AbstractSlot;

public final class PhoenixMenuImpl<M extends AbstractMenu> implements IPhoenixMenu<M> {

    private final M menu;
    private final AbstractSlot[] slots;

    public PhoenixMenuImpl(final M menu) {
        AbstractSlot[] slots;
        if (menu.getType() == InventoryType.CHEST) {
            slots = new AbstractSlot[menu.getSize().inventorySize()];
        } else {
            int size = PhoenixInventoryImpl.getRowSize(menu.getType());
            if (size == -1) {
                throw new IllegalStateException("Unsupported InventoryType '" + menu.getType() + "'!");
            }
            slots = new AbstractSlot[size];
        }
        this.slots = slots;
        menu.onSetup(this);
        this.menu = menu;
    }

    @Override
    public M getMenu() {
        return menu;
    }

    @Override
    public boolean has(int index) {
        return slots[index] != null;
    }

    @Override
    public boolean has(int index, Class<? extends AbstractSlot> slotType) {
        AbstractSlot slot = slots[index];
        if (slot == null) {
            return false;
        }
        return slotType.isAssignableFrom(slot.getClass());
    }

    @Override
    public void set(int index, AbstractSlot slot) {
        if (menu != null) {
            return;
        }
        slots[index] = slot;
    }

    @Override
    public AbstractSlot get(int index) {
        return slots[index];
    }

    @Override
    public <S extends AbstractSlot> S get(int index, Class<S> slotType) {
        AbstractSlot slot = slots[index];
        if (slot == null || !slotType.isAssignableFrom(slot.getClass())) {
            return null;
        }
        return slotType.cast(slot);
    }

}
