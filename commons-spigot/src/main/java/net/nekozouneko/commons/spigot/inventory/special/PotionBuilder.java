package net.nekozouneko.commons.spigot.inventory.special;

import net.nekozouneko.commons.spigot.inventory.AbsItemStackBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    /**
     * @see PotionMeta#setBasePotionData(PotionData)
     */
    public @NotNull PotionBuilder basePotionData(@NotNull PotionData data) {
        meta.setBasePotionData(data);
        return this;
    }

    /**
     * @see PotionMeta#getBasePotionData()
     */
    public @NotNull PotionData basePotionData() {
        return meta.getBasePotionData();
    }

    /**
     * @see PotionMeta#setColor(Color)
     */
    public @NotNull PotionBuilder color(@Nullable Color color) {
        meta.setColor(color);
        return this;
    }

    /**
     * @see PotionMeta#getColor()
     */
    public @Nullable Color color() {
        return meta.getColor();
    }

    /**
     * @see PotionMeta#hasColor()
     */
    public boolean hasColor() {
        return meta.hasColor();
    }

    /**
     * @see PotionMeta#addCustomEffect(PotionEffect, boolean)
     */
    public @NotNull PotionBuilder customEffect(@NotNull PotionEffect effect, boolean overwrite) {
        meta.addCustomEffect(effect, overwrite);
        return this;
    }

    /**
     * @see PotionMeta#removeCustomEffect(PotionEffectType)
     */
    public @NotNull PotionBuilder removeCustomEffect(@NotNull PotionEffectType effectType) {
        meta.removeCustomEffect(effectType);
        return this;
    }

    /**
     * @see PotionMeta#clearCustomEffects()
     */
    public @NotNull PotionBuilder clearCustomEffects() {
        meta.clearCustomEffects();
        return this;
    }

    /**
     * @see PotionMeta#getCustomEffects()
     */
    public @NotNull List<PotionEffect> customEffects() {
        return meta.getCustomEffects();
    }

    /**
     * @see PotionMeta#hasCustomEffects()
     */
    public boolean hasCustomEffects() {
        return meta.hasCustomEffects();
    }

    /**
     * @see PotionMeta#hasCustomEffect(PotionEffectType)
     */
    public boolean hasCustomEffect(PotionEffectType effectType) {
        return meta.hasCustomEffect(effectType);
    }

}
