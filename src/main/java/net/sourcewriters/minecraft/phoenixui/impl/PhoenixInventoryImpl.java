package net.sourcewriters.minecraft.phoenixui.impl;

import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.sourcewriters.minecraft.phoenixui.api.inventory.ChestSize;
import net.sourcewriters.minecraft.phoenixui.api.inventory.IPhoenixInventory;
import net.sourcewriters.minecraft.phoenixui.util.color.BukkitColor;

public final class PhoenixInventoryImpl implements IPhoenixInventory {

    public static int getRowSize(InventoryType type) {
        switch (type) {
        case DISPENSER:
        case DROPPER:
            return 3;
        case HOPPER:
            return 5;
        case CHEST:
        case BARREL:
        case ENDER_CHEST:
            return 9;
        default:
            return 1;
        }
    }

    private final ChestSize size;
    private final InventoryType type;
    private final String title;

    private final int rowSize;
    private final int columnAmount;

    private final Inventory handle;

    public PhoenixInventoryImpl(PhoenixContextHolder holder, String title, InventoryType type) {
        Objects.requireNonNull(type);
        this.type = type == InventoryType.ENDER_CHEST ? InventoryType.CHEST : type;
        if (!type.isCreatable()) {
            throw new IllegalArgumentException("InventoryType '" + type.name() + "' is not creatable!");
        }
        this.rowSize = getRowSize(type);
        this.columnAmount = type.getDefaultSize() / rowSize;
        this.size = null;
        this.title = title;
        this.handle = Bukkit.createInventory(holder, type, BukkitColor.apply(title));
    }

    public PhoenixInventoryImpl(PhoenixContextHolder holder, String title, ChestSize size) {
        this.type = InventoryType.CHEST;
        this.size = Objects.requireNonNull(size);
        this.title = title;
        this.rowSize = 9;
        this.columnAmount = size.inventorySize() / rowSize;
        this.handle = Bukkit.createInventory(holder, size.inventorySize(), BukkitColor.apply(title));
    }

    public Inventory getHandle() {
        return handle;
    }

    @Override
    public ChestSize getSize() {
        return size;
    }

    @Override
    public InventoryType getType() {
        return type;
    }

    @Override
    public String getTitle() {
        return title;
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
    public int size() {
        return handle.getSize();
    }

    @Override
    public void clear() {
        handle.clear();
    }

    @Override
    public ItemStack get(int index) {
        if (index < 0 || index >= handle.getSize()) {
            throw new IndexOutOfBoundsException(index);
        }
        ItemStack stack = handle.getItem(index);
        if (stack != null && stack.getType().isAir()) {
            return null;
        }
        return stack;
    }

    @Override
    public void set(int index, ItemStack itemStack) {
        if (index < 0 || index >= handle.getSize()) {
            throw new IndexOutOfBoundsException(index);
        }
        handle.setItem(index, itemStack);
    }

}
