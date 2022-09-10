package net.sourcewriters.minecraft.phoenixui.util;

import java.util.Objects;

import org.bukkit.NamespacedKey;

public abstract class AbstractUnique implements IUnique {

    protected final NamespacedKey key;

    public AbstractUnique(final NamespacedKey key) {
        this.key = Objects.requireNonNull(key, "NamespacedKey can't be null");
    }

    @Override
    public final NamespacedKey getKey() {
        return key;
    }

}
