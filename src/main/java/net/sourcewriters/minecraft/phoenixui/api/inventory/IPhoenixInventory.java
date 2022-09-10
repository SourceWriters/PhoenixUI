package net.sourcewriters.minecraft.phoenixui.api.inventory;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import net.sourcewriters.minecraft.phoenixui.api.inventory.item.ItemEditor;
import net.sourcewriters.minecraft.phoenixui.util.GridMath;

public interface IPhoenixInventory {

    // TODO: Documentation
    
    ChestSize getSize();

    InventoryType getType();

    String getTitle();

    int getRowSize();

    boolean isGridSupported();

    int size();

    void clear();

    ItemStack get(int slot);

    default ItemStack getItemStack(int slot) {
        return get(Math.max(slot, 0));
    }

    default ItemStack getItemStack(int row, int column) {
        if (!isGridSupported()) {
            return null;
        }
        return getItemStack(GridMath.toSlot(row, column, getRowSize()));
    }

    default ItemEditor getItemEditor(int slot) {
        return ItemEditor.ofNullable(getItemStack(slot));
    }

    default ItemEditor getItemEditor(int row, int column) {
        return ItemEditor.ofNullable(getItemStack(row, column));
    }

    void set(int slot, ItemStack itemStack);

    default void setItemStack(int slot, ItemStack itemStack) {
        set(Math.max(slot, 0), itemStack);
    }

    default void setItemStack(int row, int column, ItemStack itemStack) {
        if (!isGridSupported()) {
            return;
        }
        setItemStack(GridMath.toSlot(row, column), itemStack);
    }

    default void setItemEditor(int slot, ItemEditor editor) {
        if (editor == null) {
            setItemStack(slot, null);
            return;
        }
        setItemStack(slot, editor.asItemStack());
    }

    default void setItemEditor(int row, int column, ItemEditor editor) {
        if (editor == null) {
            setItemStack(row, column, null);
            return;
        }
        setItemStack(row, column, editor.asItemStack());
    }

}
