package net.nekozouneko.commons.spigot.inventory.special;

import net.nekozouneko.commons.spigot.inventory.AbsItemStackBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.jetbrains.annotations.NotNull;

public class PotionBuilder extends AbsItemStackBuilder<PotionBuilder, PotionMeta> {

    public static @NotNull PotionBuilder of(Material material) {
        return new PotionBuilder(material);
    }

    public static @NotNull PotionBuilder of(ItemStack itemStack) {
        return new PotionBuilder(itemStack);
    }

    public static @NotNull PotionBuilder of(ItemStack itemStack, PotionMeta itemMeta) {
        return new PotionBuilder(itemStack, itemMeta);
    }

    protected PotionBuilder(@NotNull Material material) {
        super(material);
    }

    protected PotionBuilder(@NotNull ItemStack itemStack) {
        super(itemStack);
    }

    protected PotionBuilder(@NotNull ItemStack itemStack, @NotNull PotionMeta itemMeta) {
        super(itemStack, itemMeta);
    }

    public PotionBuilder basePotionData(PotionData data) {
        meta.setBasePotionData(data);
        return this;
    }

    public PotionData basePotionData() {
        return meta.getBasePotionData();
    }

    public PotionBuilder color(Color color) {
        meta.setColor(color);
        return this;
    }

    public Color color() {
        return meta.getColor();
    }

}
