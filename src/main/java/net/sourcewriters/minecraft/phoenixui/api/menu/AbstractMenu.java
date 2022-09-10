package net.sourcewriters.minecraft.phoenixui.api.menu;

import org.bukkit.NamespacedKey;
import org.bukkit.event.inventory.InventoryType;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;
import net.sourcewriters.minecraft.phoenixui.api.inventory.ChestSize;
import net.sourcewriters.minecraft.phoenixui.util.AbstractUnique;

public abstract class AbstractMenu extends AbstractUnique {

    public AbstractMenu(NamespacedKey key) {
        super(key);
    }

    /**
     * Sets up the actual menu
     * 
     * @param menu the actual menu
     */
    public abstract void onSetup(IPhoenixMenu<?> menu);

    /**
     * Specifies the title for the inventory
     * 
     * @return the requested title
     */
    public String getTitle() {
        return "Menu";
    }

    /**
     * Specifies the type of the inventory
     * 
     * @return the requested type
     */
    public InventoryType getType() {
        return InventoryType.CHEST;
    }

    /**
     * Specifies the size of an chest inventory
     * 
     * This is only used if {@code getType} returns
     * {@code org.bukkit.event.inventory.InventoryType.CHEST}
     * 
     * @return the requested size
     */
    public ChestSize getSize() {
        return ChestSize.GRID_3x9;
    }

    /**
     * Called once the menu was set to a context
     * 
     * After this method was executed an update will be requested
     * 
     * @param context the ui context
     */
    public void onEnter(IPhoenixContext context) {

    }

    /**
     * Called once a update is requested
     * 
     * @param context the inventory context
     */
    public void onUpdate(IPhoenixContext context) {

    }

    /**
     * Called once the menu was removed from a context
     * 
     * @param context the ui context
     */
    public void onExit(IPhoenixContext context) {

    }

}
