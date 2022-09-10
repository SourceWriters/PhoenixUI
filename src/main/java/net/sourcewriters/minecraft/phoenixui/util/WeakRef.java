package net.sourcewriters.minecraft.phoenixui.util;

import java.lang.ref.WeakReference;

public final class WeakRef<E> {

    private WeakReference<E> value;

    private WeakRef(final E value) {
        set(value);
    }

    public E get() {
        if (value == null) {
            return null;
        }
        return value.get();
    }

    public WeakRef<E> set(final E value) {
        if (this.value != null) {
            this.value.clear();
            this.value = null;
        }
        if (value != null) {
            this.value = new WeakReference<>(value);
        }
        return this;
    }

    public boolean isPresent() {
        return value != null && value.get() != null;
    }

    public boolean isEmpty() {
        return !isPresent();
    }

    public static <E> WeakRef<E> of() {
        return new WeakRef<>(null);
    }

    public static <E> WeakRef<E> of(final E value) {
        return new WeakRef<>(value);
    }

}
