package net.sourcewriters.minecraft.phoenixui.api.menu;

import java.util.EnumMap;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;

public final class EnumMenuContainer<E extends Enum<E>, M extends AbstractMenu> implements IMenuContainer {

    private final EnumMap<E, IPhoenixMenu<M>> menus;

    private boolean locked = false;

    private E defaultMenu;

    public EnumMenuContainer(Class<E> enumType) {
        this.menus = new EnumMap<>(enumType);
    }

    public final boolean set(E type, IPhoenixMenu<M> menu) {
        return set(type, menu, false);
    }

    public final boolean set(E type, IPhoenixMenu<M> menu, boolean force) {
        if (locked || menus.containsKey(type) && !force) {
            return false;
        }
        menus.put(type, menu);
        return true;
    }

    public final void setDefaultMenuType(E type) {
        if (locked) {
            return;
        }
        this.defaultMenu = type;
    }

    public E getDefaultMenuType() {
        return defaultMenu;
    }

    @Override
    public final IPhoenixMenu<M> getSelectedMenu(IPhoenixContext context) {
        // TODO: Properties
        return menus.get(null);
    }

    public final IPhoenixMenu<M> getDefaultMenu() {
        return menus.get(defaultMenu);
    }

    public final IPhoenixMenu<M> getMenu(E type) {
        return menus.get(type);
    }

    public final IPhoenixMenu<M> getMenuOrDefault(E type) {
        IPhoenixMenu<M> menu = menus.get(type);
        if (menu != null) {
            return menu;
        }
        return getDefaultMenu();
    }

}
