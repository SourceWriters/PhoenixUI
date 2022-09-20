package net.sourcewriters.minecraft.phoenixui.api.inventory;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import net.sourcewriters.minecraft.phoenixui.api.inventory.item.ItemEditor;
import net.sourcewriters.minecraft.phoenixui.util.GridMath;

public interface IPhoenixInventory {

    /**
     * Gets the chest size of the inventory
     * 
     * @return the chest size or {@code null} if not a generic sized inventory
     */
    ChestSize getSize();

    /**
     * Gets the type of the inventory
     * 
     * @return the type of the inventory
     */
    InventoryType getType();

    /**
     * Gets the title of the inventory
     * 
     * @return the title of the inventory
     */
    String getTitle();

    /**
     * Gets the size of the rows of the inventory
     * 
     * @return the size of the rows
     */
    int getRowSize();

    /**
     * Gets the amount of columns that the inventory has
     * 
     * @return the amount of columns
     */
    int getColumnAmount();

    /**
     * Gets the slot amount of the inventory
     * 
     * @return the slot amount
     */
    int size();

    /**
     * Clears all items from all slots
     */
    void clear();

    /**
     * Gets the item of a slot
     * 
     * @param  index                     the slot index
     * 
     * @return                           the item at that slot or {@code null} if
     *                                       there is none
     * 
     * @throws IndexOutOfBoundsException if slot index is out of bounds
     */
    ItemStack get(int index) throws IndexOutOfBoundsException;

    /**
     * Gets the item of a slot
     * 
     * @param  index                     the slot index
     * 
     * @return                           the item at that slot or {@code null} if
     *                                       there is none
     * 
     * @throws IndexOutOfBoundsException if slot index is out of bounds
     */
    default ItemStack getItemStack(int index) throws IndexOutOfBoundsException {
        return get(index);
    }

    /**
     * Gets the item of a slot
     * 
     * @param  row                       the row index
     * @param  column                    the column index
     * 
     * @return                           the item at that slot or {@code null} if
     *                                       there is none
     * 
     * @throws IndexOutOfBoundsException if converted slot index would be out of
     *                                       bounds
     */
    default ItemStack getItemStack(int row, int column) throws IndexOutOfBoundsException {
        return getItemStack(GridMath.checkSlot(row, column, getRowSize(), getColumnAmount()));
    }

    /**
     * Gets the item of a slot as an editor
     * 
     * @param  index                     the slot index
     * 
     * @return                           the item editor of the item at that slot or
     *                                       {@code null} if there is none
     * 
     * @throws IndexOutOfBoundsException if slot index is out of bounds
     */
    default ItemEditor getItemEditor(int index) throws IndexOutOfBoundsException {
        return ItemEditor.ofNullable(getItemStack(index));
    }

    /**
     * Gets the item of a slot as an editor
     * 
     * @param  row                       the row index
     * @param  column                    the column index
     * 
     * @return                           the item editor of the item at that slot or
     *                                       {@code null} if there is none
     * 
     * @throws IndexOutOfBoundsException if converted slot index would be out of
     *                                       bounds
     */
    default ItemEditor getItemEditor(int row, int column) throws IndexOutOfBoundsException {
        return ItemEditor.ofNullable(getItemStack(row, column));
    }

    /**
     * Sets the item at a slot
     * 
     * @param  index                     the slot index
     * @param  itemStack                 the item to be set
     * 
     * @throws IndexOutOfBoundsException if slot index is out of bounds
     */
    void set(int index, ItemStack itemStack) throws IndexOutOfBoundsException;

    /**
     * Sets the item at a slot
     * 
     * @param  index                     the slot index
     * @param  itemStack                 the item to be set
     * 
     * @throws IndexOutOfBoundsException if slot index is out of bounds
     */
    default void setItemStack(int index, ItemStack itemStack) throws IndexOutOfBoundsException {
        set(index, itemStack);
    }

    /**
     * Sets the item at a slot
     * 
     * @param  row                       the row index
     * @param  column                    the column index
     * @param  itemStack                 the item to be set
     * 
     * @throws IndexOutOfBoundsException if converted slot index would be out of
     *                                       bounds
     */
    default void setItemStack(int row, int column, ItemStack itemStack) throws IndexOutOfBoundsException {
        setItemStack(GridMath.checkSlot(row, column, getRowSize(), getColumnAmount()), itemStack);
    }

    /**
     * Sets the item from an editor at a slot
     * 
     * @param  index                     the slot index
     * @param  itemStack                 the item editor to retrieve the item from
     *                                       that should be set
     * 
     * @throws IndexOutOfBoundsException if slot index is out of bounds
     */
    default void setItemEditor(int index, ItemEditor editor) throws IndexOutOfBoundsException {
        if (editor == null) {
            setItemStack(index, null);
            return;
        }
        setItemStack(index, editor.asItemStack());
    }

    /**
     * Sets the item from an editor at a slot
     * 
     * @param  row                       the row index
     * @param  column                    the column index
     * @param  itemStack                 the item editor to retrieve the item from
     *                                       that should be set
     * 
     * @throws IndexOutOfBoundsException if converted slot index would be out of
     *                                       bounds
     */
    default void setItemEditor(int row, int column, ItemEditor editor) throws IndexOutOfBoundsException {
        if (editor == null) {
            setItemStack(row, column, null);
            return;
        }
        setItemStack(row, column, editor.asItemStack());
    }

}
