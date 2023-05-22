package net.nekozouneko.commons.spigot.inventory.special;

import net.nekozouneko.commons.spigot.inventory.AbsItemStackBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LeatherArmorBuilder extends AbsItemStackBuilder<LeatherArmorBuilder, LeatherArmorMeta> {

    public static @NotNull LeatherArmorBuilder of(Material material) {
        return new LeatherArmorBuilder(material);
    }

    public static @NotNull LeatherArmorBuilder of(ItemStack itemStack) {
        return new LeatherArmorBuilder(itemStack);
    }

    public static @NotNull LeatherArmorBuilder of(ItemStack itemStack, LeatherArmorMeta itemMeta) {
        return new LeatherArmorBuilder(itemStack, itemMeta);
    }

    protected LeatherArmorBuilder(@NotNull Material material) {
        super(material);
    }

    protected LeatherArmorBuilder(@NotNull ItemStack itemStack) {
        super(itemStack);
    }

    protected LeatherArmorBuilder(@NotNull ItemStack itemStack, @NotNull LeatherArmorMeta itemMeta) {
        super(itemStack, itemMeta);
    }

    public @NotNull LeatherArmorBuilder color(@Nullable Color color) {
        meta.setColor(color);
        return this;
    }

    public @NotNull Color color() {
        return meta.getColor();
    }

}
