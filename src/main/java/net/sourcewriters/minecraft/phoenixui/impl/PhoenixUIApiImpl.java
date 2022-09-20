package net.sourcewriters.minecraft.phoenixui.impl;

import org.bukkit.entity.Player;

import me.lauriichan.laylib.localization.IMessage;
import me.lauriichan.laylib.localization.Key;
import me.lauriichan.laylib.localization.MessageManager;
import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;
import net.sourcewriters.minecraft.phoenixui.api.IPhoenixUIApi;
import net.sourcewriters.minecraft.phoenixui.api.menu.AbstractMenu;
import net.sourcewriters.minecraft.phoenixui.api.menu.IPhoenixMenu;

public final class PhoenixUIApiImpl implements IPhoenixUIApi {

    private final MessageManager messageManager;

    public PhoenixUIApiImpl(final MessageManager messageManager) {
        this.messageManager = messageManager;
    }

    @Override
    public IPhoenixContext getContext(Player player) {
        return null;
    }

    @Override
    public <M extends AbstractMenu> IPhoenixMenu<M> registerMenu(M menu) {
        return null;
    }

    @Override
    public String getRawMessage(String language, String messageId, Key... placeholders) {
        return getRawMessage(messageManager.getMessage(messageId, language), placeholders);
    }

    @Override
    public String getRawMessage(IMessage message, Key... placeholders) {
        return messageManager.format(message, placeholders);
    }

    @Override
    public IPhoenixMenu<?> createMenu(Key key) {
        // TODO Auto-generated method stub
        return null;
    }

}
