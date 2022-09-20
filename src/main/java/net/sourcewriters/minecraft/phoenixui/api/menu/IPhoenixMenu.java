package net.sourcewriters.minecraft.phoenixui.api.menu;

import net.sourcewriters.minecraft.phoenixui.api.slot.AbstractSlot;
import net.sourcewriters.minecraft.phoenixui.util.GridMath;

public interface IPhoenixMenu<M extends AbstractMenu> {

    /**
     * Gets the handling menu
     * 
     * @return the menu or {@code null} if menu was unloaded
     */
    M getMenu();

    /**
     * Gets the row size of the menu
     * 
     * @return the row size of the menu
     */
    int getRowSize();

    /**
     * Gets the column amount of the menu
     * 
     * @return the column amount of the menu
     */
    int getColumnAmount();

    /**
     * Checks if a slot exists
     * 
     * @param  index                     the slot index to be checked
     * 
     * @return                           {@code true} if there is a slot at the
     *                                       specified index otherwise {@code false}
     * 
     * @throws IndexOutOfBoundsException if slot index is out of bounds
     */
    boolean has(int index) throws IndexOutOfBoundsException;

    /**
     * Checks if a slot exists
     * 
     * @param  row                       the row index to be checked
     * @param  column                    the column index to be checked
     * 
     * @return                           {@code true} if there is a slot at the
     *                                       specified index otherwise {@code false}
     * 
     * @throws IndexOutOfBoundsException if converted slot index would be out of
     *                                       bounds
     */
    default boolean has(int row, int column) throws IndexOutOfBoundsException {
        return has(GridMath.checkSlot(row, column, getRowSize(), getColumnAmount()));
    }

    /**
     * Checks if a slot exists and has the specified type
     * 
     * @param  index                     the slot index to be checked
     * @param  slotType                  the type that the slot supposed have
     * 
     * @return                           {@code true} if there is a slot at the
     *                                       specified index with the specified type
     *                                       otherwise {@code false}
     * 
     * @throws IndexOutOfBoundsException if slot index is out of bounds
     */
    boolean has(int index, Class<? extends AbstractSlot> slotType) throws IndexOutOfBoundsException;

    /**
     * Checks if a slot exists and has the specified type
     * 
     * @param  row                       the row index to be checked
     * @param  column                    the column index to be checked
     * @param  slotType                  the type that the slot supposed have
     * 
     * @return                           {@code true} if there is a slot at the
     *                                       specified index with the specified type
     *                                       otherwise {@code false}
     * 
     * @throws IndexOutOfBoundsException if converted slot index would be out of
     *                                       bounds
     */
    default boolean has(int row, int column, Class<? extends AbstractSlot> slotType) throws IndexOutOfBoundsException {
        return has(GridMath.checkSlot(row, column, getRowSize(), getColumnAmount()), slotType);
    }

    /**
     * Sets a slot
     * 
     * @param  index                     the slot index
     * @param  slot                      the slot handler
     * 
     * @throws IndexOutOfBoundsException if slot index is out of bounds
     */
    void set(int index, AbstractSlot slot) throws IndexOutOfBoundsException;

    /**
     * Sets a slot
     * 
     * @param  row                       the row index
     * @param  column                    the column index
     * @param  slot                      the slot handler
     * 
     * @throws IndexOutOfBoundsException if converted slot index would be out of
     *                                       bounds
     */
    default void set(int row, int column, AbstractSlot slot) throws IndexOutOfBoundsException {
        set(GridMath.checkSlot(row, column, getRowSize(), getColumnAmount()), slot);
    }

    /**
     * Gets a slot
     * 
     * @param  index                     the slot index to be get
     * 
     * @return                           the slot at the specified index or
     *                                       {@code null} if none is there
     * 
     * @throws IndexOutOfBoundsException if slot index is out of bounds
     */
    AbstractSlot get(int index) throws IndexOutOfBoundsException;

    /**
     * Gets a slot
     * 
     * @param  row                       the row index
     * @param  column                    the column index
     * 
     * @return                           the slot at the specified index or
     *                                       {@code null} if none is there
     * 
     * @throws IndexOutOfBoundsException if converted slot index would be out of
     *                                       bounds
     */
    default AbstractSlot get(int row, int column) throws IndexOutOfBoundsException {
        return get(GridMath.checkSlot(row, column, getRowSize(), getColumnAmount()));
    }

    /**
     * Gets a slot with a specified type
     * 
     * @param  index                     the slot index to be get
     * @param  slotType                  the type that the slot supposed have
     * 
     * @return                           the slot at the specified index with the
     *                                       specified type or {@code null} if none
     *                                       is there or the slot has the wrong type
     * 
     * @throws IndexOutOfBoundsException if slot index is out of bounds
     */
    <S extends AbstractSlot> S get(int index, Class<S> slotType) throws IndexOutOfBoundsException;

    /**
     * Gets a slot with a specified type
     * 
     * @param  row                       the row index
     * @param  column                    the column index
     * @param  slotType                  the type that the slot supposed have
     * 
     * @return                           the slot at the specified index with the
     *                                       specified type or {@code null} if none
     *                                       is there or the slot has the wrong type
     * 
     * @throws IndexOutOfBoundsException if converted slot index would be out of
     *                                       bounds
     */
    default <S extends AbstractSlot> S get(int row, int column, Class<S> slotType) throws IndexOutOfBoundsException {
        return get(GridMath.checkSlot(row, column, getRowSize(), getColumnAmount()), slotType);
    }

}
