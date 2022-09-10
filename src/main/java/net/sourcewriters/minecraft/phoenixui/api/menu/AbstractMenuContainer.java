package net.sourcewriters.minecraft.phoenixui.api.menu;

import org.bukkit.NamespacedKey;

import net.sourcewriters.minecraft.phoenixui.api.IPhoenixContext;
import net.sourcewriters.minecraft.phoenixui.util.AbstractUnique;

public abstract class AbstractMenuContainer extends AbstractUnique {

    public AbstractMenuContainer(NamespacedKey key) {
        super(key);
    }

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
