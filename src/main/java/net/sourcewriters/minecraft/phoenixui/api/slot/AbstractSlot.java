package net.sourcewriters.minecraft.phoenixui.api.slot;

import org.bukkit.inventory.ItemStack;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;
import net.sourcewriters.minecraft.phoenixui.api.inventory.IPhoenixInventory;

public abstract class AbstractSlot {

    /**
     * Called if a inventory is being generated
     * 
     * @param context   the inventory context
     * @param inventory the inventory specified in the context
     * @param index     the slot index that the item representing this handler
     *                      should be located at
     */
    public void onGenerate(final IPhoenixContext context, final IPhoenixInventory inventory, final int index) {}

    /**
     * Called if a player tries to pickup an item from a slot handled by this class
     * 
     * @param  context   the inventory context
     * @param  index     the clicked slot
     * @param  itemStack the clicked item
     * @param  amount    the amount of the item
     * @param  cursor    if it is picked up to the cursor
     * 
     * @return           if the action is allowed or not
     */
    public boolean onPickup(final IPhoenixContext context, final int index, final ItemStack itemStack, final int amount,
        final boolean cursor) {
        return false;
    }

    /**
     * Called if a player tries to place an item into a slot handled by this class
     * 
     * @param  context   the inventory context
     * @param  index     the clicked slot
     * @param  itemStack the item placed to the slot
     * @param  amount    the amount of the item
     * 
     * @return           if the action is allowed or not
     */
    public boolean onPlace(final IPhoenixContext context, final int index, final ItemStack itemStack, final int amount) {
        return false;
    }

    /**
     * Called if a player tries to shift move an item into a slot handled by this
     * class
     * 
     * @param  context   the inventory context
     * @param  index     the clicked slot
     * @param  itemStack the item put into the slot
     * @param  amount    the amount of the item
     * 
     * @return           if the action is allowed or not
     */
    public boolean onPut(final IPhoenixContext context, final int index, final ItemStack itemStack, final int amount) {
        return false;
    }

    /**
     * Called if a player tries to swap the item with a slot handled by this class
     * 
     * @param  context      the inventory context
     * @param  index        the clicked slot
     * @param  previousItem the item that was in the slot before
     * @param  newItem      the item that is placed into the slot
     * 
     * @return              if the action is allowed or not
     */
    public boolean onSwap(final IPhoenixContext context, final int index, final ItemStack previousItem, final ItemStack newItem) {
        return false;
    }

    /**
     * Called if a player tries to drop items from a slot handled by this class
     * 
     * @param  context   the inventory context
     * @param  index     the clicked slot
     * @param  itemStack the dropped item
     * @param  amount    the amount of the item
     * 
     * @return           if the action is allowed or not
     */
    public boolean onDrop(final IPhoenixContext context, final int index, final ItemStack itemStack, final int amount) {
        return false;
    }

}
