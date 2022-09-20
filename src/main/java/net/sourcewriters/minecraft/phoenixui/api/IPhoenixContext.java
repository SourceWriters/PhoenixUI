package net.sourcewriters.minecraft.phoenixui.api;

import java.util.Optional;

import org.bukkit.entity.Player;

import net.sourcewriters.minecraft.phoenixui.api.inventory.IPhoenixInventory;
import net.sourcewriters.minecraft.phoenixui.api.menu.AbstractMenuContainer;
import net.sourcewriters.minecraft.phoenixui.api.menu.IPhoenixMenu;

public interface IPhoenixContext {

    /**
     * Gets the PhoenixUI api
     * 
     * @return the api
     */
    IPhoenixUIApi getApi();

    /**
     * Gets the context inventory
     * 
     * @return the inventory
     */
    IPhoenixInventory getInventory();

    /**
     * Gets the player who owns this context
     * 
     * @return the player
     */
    Player getPlayer();

    /**
     * Gets the currently active menu
     * 
     * @return the active menu
     */
    Optional<IPhoenixMenu<?>> getMenu();

    /**
     * Opens a menu
     * 
     * @param  container the menu to be opened
     * 
     * @return           {@code true} if the menu was opened successfully otherwise
     *                       it returns {@code false}
     */
    boolean openMenu(AbstractMenuContainer container);

}
