package net.sourcewriters.minecraft.phoenixui.api;

import org.bukkit.entity.Player;

import net.sourcewriters.minecraft.phoenixui.api.menu.AbstractMenu;
import net.sourcewriters.minecraft.phoenixui.api.menu.IPhoenixMenu;

public interface IPhoenixUIApi {

    /**
     * Gets the UI context of an player
     * 
     * @param  player the player that owns the context
     * 
     * @return        the context of the specified player
     */
    IPhoenixContext getContext(Player player);

    /**
     * Registers a menu
     * 
     * @param  menu the unique menu
     * 
     * @return      the registered menu or {@code null} if a menu with the same key
     *                  was already registered
     */
    <M extends AbstractMenu> IPhoenixMenu<M> registerMenu(M menu);

}
