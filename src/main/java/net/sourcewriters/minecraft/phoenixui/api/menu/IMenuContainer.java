package net.sourcewriters.minecraft.phoenixui.api.menu;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;

public interface IMenuContainer {

    /**
     * Get the menu selected by the specified context
     * 
     * @param  context the inventory context
     * 
     * @return         the selected menu by the context or {@code null} if none
     *                     selected
     */
    public abstract IPhoenixMenu<?> getSelectedMenu(IPhoenixContext context);

}
