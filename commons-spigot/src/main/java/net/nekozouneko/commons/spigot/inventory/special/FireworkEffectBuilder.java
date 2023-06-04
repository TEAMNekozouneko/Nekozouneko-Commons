package net.nekozouneko.commons.spigot.inventory.special;

import net.nekozouneko.commons.spigot.inventory.AbsItemStackBuilder;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FireworkEffectBuilder extends AbsItemStackBuilder<FireworkEffectBuilder, FireworkEffectMeta> {

    protected FireworkEffectBuilder(@NotNull Material material) {
        super(material);
    }

    protected FireworkEffectBuilder(@NotNull ItemStack itemStack) {
        super(itemStack);
    }

    protected FireworkEffectBuilder(@NotNull ItemStack itemStack, @NotNull FireworkEffectMeta itemMeta) {
        super(itemStack, itemMeta);
    }

    public @NotNull FireworkEffectBuilder effect(@Nullable FireworkEffect effect) {
        meta.setEffect(effect);
        return this;
    }

    public @Nullable FireworkEffect effect() {
        return meta.getEffect();
    }

    public boolean hasEffect() {
        return meta.hasEffect();
    }

    public static @NotNull FireworkEffectBuilder of(@NotNull Material material) {
        return new FireworkEffectBuilder(material);
    }

    public static @NotNull FireworkEffectBuilder of(@NotNull ItemStack itemStack) {
        return new FireworkEffectBuilder(itemStack);
    }

    public static @NotNull FireworkEffectBuilder of(@NotNull ItemStack itemStack, @NotNull FireworkEffectMeta fireworkEffectMeta) {
        return new FireworkEffectBuilder(itemStack, fireworkEffectMeta);
    }

}
