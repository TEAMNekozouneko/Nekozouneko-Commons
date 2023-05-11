package net.nekozouneko.commons.spigot.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * @author Taitaitatata
 * @since 1.0
 */
public class ItemStackBuilder extends AbsItemStackBuilder<ItemStackBuilder, ItemMeta> {

    protected ItemStackBuilder(@NotNull Material material) {
        super(material);
    }

    protected ItemStackBuilder(@NotNull ItemStack itemStack) {
        super(itemStack);
    }

    protected ItemStackBuilder(@NotNull ItemStack itemStack, @NotNull ItemMeta itemMeta) {
        super(itemStack, itemMeta);
    }

    public static @NotNull ItemStackBuilder of(@NotNull Material material) {
        return new ItemStackBuilder(material);
    }

    public static @NotNull ItemStackBuilder of(@NotNull ItemStack itemStack) {
        return new ItemStackBuilder(itemStack);
    }

    public static @NotNull ItemStackBuilder of(@NotNull ItemStack itemStack, @NotNull ItemMeta itemMeta) {
        return new ItemStackBuilder(itemStack, itemMeta);
    }

}
