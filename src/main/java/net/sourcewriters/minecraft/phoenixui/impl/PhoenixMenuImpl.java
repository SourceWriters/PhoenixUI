package net.sourcewriters.minecraft.phoenixui.impl;

import org.bukkit.event.inventory.InventoryType;

import net.sourcewriters.minecraft.phoenixui.api.menu.AbstractMenu;
import net.sourcewriters.minecraft.phoenixui.api.menu.IPhoenixMenu;
import net.sourcewriters.minecraft.phoenixui.api.slot.AbstractSlot;

public final class PhoenixMenuImpl<M extends AbstractMenu> implements IPhoenixMenu<M> {

    private final M menu;
    private final AbstractSlot[] slots;

    private final int rowSize;
    private final int columnAmount;

    public PhoenixMenuImpl(final M menu) {
        AbstractSlot[] slots;
        if (menu.getType() == InventoryType.CHEST) {
            this.rowSize = 9;
            slots = new AbstractSlot[menu.getSize().inventorySize()];
        } else {
            InventoryType type = menu.getType();
            this.rowSize = PhoenixInventoryImpl.getRowSize(menu.getType());
            slots = new AbstractSlot[type.getDefaultSize()];
        }
        this.columnAmount = slots.length / rowSize;
        this.slots = slots;
        menu.onSetup(this);
        this.menu = menu;
    }

    @Override
    public M getMenu() {
        return menu;
    }

    @Override
    public int getRowSize() {
        return rowSize;
    }

    @Override
    public int getColumnAmount() {
        return columnAmount;
    }

    @Override
    public boolean has(int index) {
        if (index < 0 || index >= slots.length) {
            throw new IndexOutOfBoundsException(index);
        }
        return slots[index] != null;
    }

    @Override
    public boolean has(int index, Class<? extends AbstractSlot> slotType) {
        if (index < 0 || index >= slots.length) {
            throw new IndexOutOfBoundsException(index);
        }
        AbstractSlot slot = slots[index];
        if (slot == null) {
            return false;
        }
        return slotType.isAssignableFrom(slot.getClass());
    }

    @Override
    public void set(int index, AbstractSlot slot) {
        if (index < 0 || index >= slots.length) {
            throw new IndexOutOfBoundsException(index);
        }
        slots[index] = slot;
    }

    @Override
    public AbstractSlot get(int index) {
        if (index < 0 || index >= slots.length) {
            throw new IndexOutOfBoundsException(index);
        }
        return slots[index];
    }

    @Override
    public <S extends AbstractSlot> S get(int index, Class<S> slotType) {
        if (index < 0 || index >= slots.length) {
            throw new IndexOutOfBoundsException(index);
        }
        AbstractSlot slot = slots[index];
        if (slot == null || !slotType.isAssignableFrom(slot.getClass())) {
            return null;
        }
        return slotType.cast(slot);
    }

}
