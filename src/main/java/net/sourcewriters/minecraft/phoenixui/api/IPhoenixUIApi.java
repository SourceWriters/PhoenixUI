package net.sourcewriters.minecraft.phoenixui.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.lauriichan.laylib.command.Actor;
import me.lauriichan.laylib.localization.IMessage;
import me.lauriichan.laylib.localization.Key;
import net.sourcewriters.minecraft.phoenixui.api.menu.AbstractMenu;
import net.sourcewriters.minecraft.phoenixui.api.menu.IPhoenixMenu;
import net.sourcewriters.minecraft.phoenixui.api.message.Component;

public interface IPhoenixUIApi {

    static IPhoenixUIApi get() {
        return Bukkit.getServicesManager().getRegistration(IPhoenixUIApi.class).getProvider();
    }

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

    /**
     * Creates a new menu instance
     * 
     * @param  key the key of the requested menu
     * 
     * @return     the menu instance or {@code null} if there is no menu with the
     *                 specified key available
     */
    IPhoenixMenu<?> createMenu(Key key);

    /**
     * Get a message in the default language as component
     * 
     * @param  messageId    the id of the message
     * @param  placeholders the placeholders provided for the message
     * 
     * @return              the message component
     */
    default Component getMessage(String messageId, Key... placeholders) {
        return getMessage(Actor.DEFAULT_LANGUAGE, messageId, placeholders);
    }

    /**
     * Get a raw message in the default language
     * 
     * @param  messageId    the id of the message
     * @param  placeholders the placeholders provided for the message
     * 
     * @return              the raw message
     */
    default String getRawMessage(String messageId, Key... placeholders) {
        return getRawMessage(Actor.DEFAULT_LANGUAGE, messageId, placeholders);
    }

    /**
     * Get a message in the specified language as component
     * 
     * @param  language     the language the message should be in
     * @param  messageId    the id of the message
     * @param  placeholders the placeholders provided for the message
     * 
     * @return              the message component
     */
    default Component getMessage(String language, String messageId, Key... placeholders) {
        return new Component(this, getRawMessage(language, messageId, placeholders));
    }

    /**
     * Get a raw message in the specified language
     * 
     * @param  language     the language the message should be in
     * @param  messageId    the id of the message
     * @param  placeholders the placeholders provided for the message
     * 
     * @return              the raw message
     */
    String getRawMessage(String language, String messageId, Key... placeholders);

    /**
     * Get a message as component from an message object
     * 
     * @param  message      the message object
     * @param  placeholders the placeholders provided for the message
     * 
     * @return              the message component
     */
    default Component getMessage(IMessage message, Key... placeholders) {
        return new Component(this, getRawMessage(message, placeholders));
    }

    /**
     * Get a raw message from an message object
     * 
     * @param  message      the message object
     * @param  placeholders the placeholders provided for the message
     * 
     * @return              the raw message
     */
    String getRawMessage(IMessage message, Key... placeholders);

}
