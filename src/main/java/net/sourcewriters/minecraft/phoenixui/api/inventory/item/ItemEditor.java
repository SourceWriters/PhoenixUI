package net.sourcewriters.minecraft.phoenixui.api.inventory.item;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.syntaxphoenix.syntaxapi.nbt.NbtCompound;

import net.sourcewriters.minecraft.phoenixui.util.StringUtil;
import net.sourcewriters.minecraft.phoenixui.util.version.NbtProvider;

public final class ItemEditor {

    public static ItemEditor ofTexture(String texture) {
        return new ItemEditor(Material.PLAYER_HEAD).setHeadTexture(texture);
    }

    public static ItemEditor of(NbtCompound compound) {
        return new ItemEditor(compound);
    }

    public static ItemEditor ofNullable(ItemStack itemStack) {
        if(itemStack == null) {
            return null;
        }
        return new ItemEditor(itemStack);
    }

    public static ItemEditor of(ItemStack itemStack) {
        return new ItemEditor(itemStack);
    }

    public static ItemEditor of(Material material) {
        return new ItemEditor(material);
    }

    private static final HeadProfileProvider profile_provider = new HeadProfileProvider();

    private final ItemStack itemStack;
    private ItemMeta itemMeta;

    private ColoredLoreEditor lore;
    private ColoredNameEditor name;

    public ItemEditor(final Material material) {
        this(new ItemStack(material));
    }

    public ItemEditor(final NbtCompound compound) {
        this(NbtProvider.itemStackFromNbt(compound));
    }

    public ItemEditor(final ItemStack stack) {
        Objects.requireNonNull(stack, "ItemStack can't be null");
        this.itemStack = stack;
        this.itemMeta = stack.getItemMeta();
    }

    public boolean hasItemMeta() {
        return itemMeta != null;
    }

    public ItemMeta getItemMeta() {
        return itemMeta;
    }

    public ItemEditor applyItemMeta(Consumer<ItemMeta> consumer) {
        if (itemMeta != null) {
            consumer.accept(itemMeta);
            itemStack.setItemMeta(itemMeta);
        }
        return this;
    }

    /*
     * Setter / Getter
     */

    // Name
    public String getName() {
        if (itemMeta == null) {
            return StringUtil.formatPascalCase(itemStack.getType().getKey().getKey().replace('_', ' '));
        }
        return name().asPlainString();
    }

    public ItemEditor setName(String name) {
        return name().set(name).apply();
    }

    // Lore
    public List<String> getLore() {
        if (itemMeta == null) {
            return Collections.emptyList();
        }
        return lore().asPlainList();
    }

    public ItemEditor setLore(Collection<String> lines) {
        return lore().set(lines).apply();
    }

    public ItemEditor setLore(String... lines) {
        return lore().set(lines).apply();
    }

    // Durability
    public boolean isDamageable() {
        return itemMeta != null && itemMeta instanceof Damageable;
    }

    public boolean isUnbreakable() {
        return itemMeta != null && itemMeta.isUnbreakable();
    }

    public int getMaxDurability() {
        if (isDamageable()) {
            return itemStack.getType().getMaxDurability();
        }
        return 0;
    }

    public int getDamage() {
        if (isDamageable()) {
            return ((Damageable) itemMeta).getDamage();
        }
        return 0;
    }

    public int getDurability() {
        if (isDamageable()) {
            return itemStack.getType().getMaxDurability() - ((Damageable) itemMeta).getDamage();
        }
        return -1;
    }

    public ItemEditor setDamage(int damage) {
        if (isDamageable()) {
            ((Damageable) itemMeta).setDamage(Math.max(Math.min(damage, 0), itemStack.getType().getMaxDurability()));
            return this;
        }
        return this;
    }

    public ItemEditor setDurability(int durability) {
        if (isDamageable()) {
            ((Damageable) itemMeta).setDamage(Math.max(itemStack.getType().getMaxDurability() - Math.min(durability, 0), 0));
            return this;
        }
        return this;
    }

    // Texture
    public boolean isHead() {
        return itemMeta != null && itemMeta instanceof SkullMeta;
    }

    public ItemEditor setHeadTexture(String texture) {
        if (!isHead()) {
            return this;
        }
        profile_provider.setTexture((SkullMeta) itemMeta, texture);
        return this;
    }

    public String getHeadTexture() {
        if (!isHead()) {
            return null;
        }
        return profile_provider.getTexture((SkullMeta) itemMeta);
    }

    // Model
    public boolean hasModel() {
        return itemMeta != null && itemMeta.hasCustomModelData();
    }

    public int getModel() {
        if (itemMeta != null) {
            return itemMeta.getCustomModelData();
        }
        return 0;
    }

    public ItemEditor setModel(int model) {
        if (itemMeta != null) {
            itemMeta.setCustomModelData(Math.max(model, 0));
        }
        return this;
    }

    public ItemEditor clearModel() {
        if (itemMeta != null) {
            itemMeta.setCustomModelData(null);
        }
        return this;
    }

    // Enchantment
    public boolean hasEnchantments() {
        return itemMeta != null && itemMeta.hasEnchants();
    }

    public boolean hasEnchantment(final Enchantment enchantment) {
        return itemMeta != null && itemMeta.hasEnchant(enchantment);
    }

    public boolean hasEnchantmentConflict(final Enchantment enchantment) {
        return itemMeta != null && itemMeta.hasConflictingEnchant(enchantment);
    }

    public int getEnchantment(final Enchantment enchantment) {
        if (itemMeta == null) {
            return 0;
        }
        return itemMeta.getEnchantLevel(enchantment);
    }

    public ItemEditor setEnchantment(final Enchantment enchantment, final int level) {
        return setEnchantment(enchantment, level, false);
    }

    public ItemEditor setEnchantment(final Enchantment enchantment, final int level, final boolean ignoreRestriction) {
        if (itemMeta == null) {
            return this;
        }
        if (itemMeta.hasEnchant(enchantment)) {
            itemMeta.removeEnchant(enchantment);
        }
        if (level <= 0) {
            return this;
        }
        itemMeta.addEnchant(enchantment, level, ignoreRestriction);
        return this;
    }

    // Material
    public Material getMaterial() {
        return itemStack.getType();
    }

    public ItemEditor setMaterial(Material material) {
        if (material == null) {
            return this;
        }
        asItemStack().setType(material);
        itemMeta = itemStack.getItemMeta();
        return this;
    }

    // Amount
    public int getMaxAmount() {
        return itemStack.getMaxStackSize();
    }

    public int getAmount() {
        return itemStack.getAmount();
    }

    public ItemEditor setAmount(final int amount) {
        return setAmount(amount, false);
    }

    public ItemEditor setAmount(int amount, final boolean ignoreRestriction) {
        if (ignoreRestriction) {
            itemStack.setAmount(Math.max(amount, 0));
            return this;
        }
        itemStack.setAmount(Math.max(Math.min(amount, itemStack.getMaxStackSize()), 0));
        return this;
    }

    /*
     * Editors
     */

    public ColoredLoreEditor lore() {
        if (itemMeta == null) {
            if (lore != null) {
                return lore;
            }
            return (lore = new ColoredLoreEditor(this));
        }
        if (lore != null) {
            return lore.set(itemMeta.getLore());
        }
        return (lore = new ColoredLoreEditor(this)).set(itemMeta.getLore());
    }

    public ColoredNameEditor name() {
        if (itemMeta == null) {
            if (name != null) {
                return name;
            }
            return (name = new ColoredNameEditor(this));
        }
        if (name != null) {
            return name.set(itemMeta.getDisplayName());
        }
        return (name = new ColoredNameEditor(this)).set(itemMeta.getDisplayName());
    }

    /*
     * Actions
     */

    public ItemEditor apply() {
        if (itemMeta != null) {
            itemStack.setItemMeta(itemMeta);
        }
        return this;
    }

    public ItemStack asItemStack() {
        if (itemMeta != null) {
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }

    public NbtCompound asNbtCompound() {
        return NbtProvider.itemStackToNbt(asItemStack());
    }

}
