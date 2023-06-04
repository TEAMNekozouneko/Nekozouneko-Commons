package net.nekozouneko.commons.spigot.inventory.special;

import net.nekozouneko.commons.spigot.inventory.AbsItemStackBuilder;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FireworkBuilder extends AbsItemStackBuilder<FireworkBuilder, FireworkMeta> {

    protected FireworkBuilder(@NotNull Material material) {
        super(material);
    }

    protected FireworkBuilder(@NotNull ItemStack itemStack) {
        super(itemStack);
    }

    protected FireworkBuilder(@NotNull ItemStack itemStack, @NotNull FireworkMeta itemMeta) {
        super(itemStack, itemMeta);
    }

    public @NotNull FireworkBuilder effect(@NotNull FireworkEffect effect) {
        meta.addEffect(effect);
        return this;
    }

    public @NotNull FireworkBuilder effects(@NotNull Iterable<FireworkEffect> effects) {
        meta.addEffects(effects);
        return this;
    }

    public @NotNull FireworkBuilder effects(@NotNull FireworkEffect... effects) {
        meta.addEffects(effects);
        return this;
    }

    public @NotNull List<FireworkEffect> effects() {
        return meta.getEffects();
    }

    public @NotNull FireworkBuilder clearEffects() {
        meta.clearEffects();
        return this;
    }

    public @NotNull FireworkBuilder removeEffect(int index) {
        meta.removeEffect(index);
        return this;
    }

    public int getEffectsSize() {
        return meta.getEffectsSize();
    }

    public @NotNull FireworkBuilder power(int power) {
        meta.setPower(power);
        return this;
    }

    public int power() {
        return meta.getPower();
    }

    public static @NotNull FireworkBuilder of(@NotNull Material material) {
        return new FireworkBuilder(material);
    }

    public static @NotNull FireworkBuilder of(@NotNull ItemStack itemStack) {
        return new FireworkBuilder(itemStack);
    }

    public static @NotNull FireworkBuilder of(@NotNull ItemStack itemStack, @NotNull FireworkMeta fireworkMeta) {
        return new FireworkBuilder(itemStack, fireworkMeta);
    }

}
