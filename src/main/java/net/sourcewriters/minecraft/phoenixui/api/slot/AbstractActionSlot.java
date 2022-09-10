package net.sourcewriters.minecraft.phoenixui.api.slot;

import org.bukkit.inventory.ItemStack;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;

public abstract class AbstractActionSlot extends AbstractSlot {

    /**
     * Called if a player clicks on a slot handled by this class
     * 
     * @param context   the inventory context
     * @param index     the clicked slot
     * @param itemStack the involved item
     */
    public abstract void onClick(final IPhoenixContext context, final int index, final ItemStack itemStack);

    @Override
    public final boolean onDrop(final IPhoenixContext context, final int index, final ItemStack itemStack, final int amount) {
        onClick(context, index, itemStack);
        return false;
    }

    @Override
    public final boolean onPickup(final IPhoenixContext context, final int index, final ItemStack itemStack, final int amount,
        final boolean cursor) {
        onClick(context, index, itemStack);
        return false;
    }

    @Override
    public final boolean onPlace(final IPhoenixContext context, final int index, final ItemStack itemStack, final int amount) {
        onClick(context, index, itemStack);
        return false;
    }

    @Override
    public final boolean onPut(final IPhoenixContext context, final int index, final ItemStack itemStack, final int amount) {
        onClick(context, index, itemStack);
        return false;
    }

    @Override
    public final boolean onSwap(final IPhoenixContext context, final int index, final ItemStack previousItem, final ItemStack newItem) {
        onClick(context, index, newItem);
        return false;
    }

}
