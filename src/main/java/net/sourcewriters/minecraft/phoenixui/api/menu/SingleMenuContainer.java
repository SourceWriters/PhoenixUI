package net.sourcewriters.minecraft.phoenixui.api.menu;

import org.bukkit.NamespacedKey;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;

public final class SingleMenuContainer<M extends AbstractMenu> extends AbstractMenuContainer {

    private final IPhoenixMenu<M> menu;

    public SingleMenuContainer(IPhoenixMenu<M> menu, NamespacedKey key) {
        super(key);
        this.menu = menu;
    }

    @Override
    public IPhoenixMenu<M> getSelectedMenu(IPhoenixContext context) {
        return menu;
    }

}
