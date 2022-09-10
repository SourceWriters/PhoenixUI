package net.sourcewriters.minecraft.phoenixui.api.menu;

import net.sourcewriters.minecraft.phoenixui.api.slot.AbstractSlot;

public interface IPhoenixMenu<M extends AbstractMenu> {

    /**
     * Gets the handling menu
     * 
     * @return the menu
     */
    M getMenu();

    /**
     * Checks if a slot exists
     * 
     * @param  index the slot index to be checked
     * 
     * @return       {@code true} if there is a slot at the specified index
     *                   otherwise {@code false}
     */
    boolean has(int index);

    /**
     * Checks if a slot exists and has the specified type
     * 
     * @param  index    the slot index to be checked
     * @param  slotType the type that the slot supposed have
     * 
     * @return          {@code true} if there is a slot at the specified index with
     *                      the specified type otherwise {@code false}
     */
    boolean has(int index, Class<? extends AbstractSlot> slotType);

    /**
     * Sets a slot
     * 
     * @param index the slot index
     * @param slot  the slot handler
     */
    void set(int index, AbstractSlot slot);

    /**
     * Gets a slot
     * 
     * @param  index the slot index to be get
     * 
     * @return       the slot at the specified index or {@code null} if none is
     *                   there
     */
    AbstractSlot get(int index);

    /**
     * Gets a slot with a specified type
     * 
     * @param  index    the slot index to be get
     * @param  slotType the type that the slot supposed have
     * 
     * @return          the slot at the specified index with the specified type or
     *                      {@code null} if none is there or the slot has the wrong
     *                      type
     */
    <S extends AbstractSlot> S get(int index, Class<S> slotType);

}
