package net.sourcewriters.minecraft.phoenixui.api.menu;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;

public final class SingleMenuContainer<M extends AbstractMenu> implements IMenuContainer {

    private final IPhoenixMenu<M> menu;

    public SingleMenuContainer(IPhoenixMenu<M> menu) {
        this.menu = menu;
    }

    @Override
    public IPhoenixMenu<M> getSelectedMenu(IPhoenixContext context) {
        return menu;
    }

}
