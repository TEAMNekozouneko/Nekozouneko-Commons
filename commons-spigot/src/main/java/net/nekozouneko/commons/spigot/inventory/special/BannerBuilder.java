package net.nekozouneko.commons.spigot.inventory.special;

import net.nekozouneko.commons.spigot.inventory.AbsItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BannerBuilder extends AbsItemStackBuilder<BannerBuilder, BannerMeta> {

    protected BannerBuilder(@NotNull Material material) {
        super(material);
    }

    protected BannerBuilder(@NotNull ItemStack itemStack) {
        super(itemStack);
    }

    protected BannerBuilder(@NotNull ItemStack itemStack, @NotNull BannerMeta itemMeta) {
        super(itemStack, itemMeta);
    }

    /**
     * @see BannerMeta#addPattern(Pattern)
     */
    public @NotNull BannerBuilder pattern(@NotNull Pattern pattern) {
        meta.addPattern(pattern);
        return this;
    }

    /**
     * @see BannerMeta#setPattern(int, Pattern)
     */
    public @NotNull BannerBuilder pattern(int i, @NotNull Pattern pattern) {
        meta.setPattern(i, pattern);
        return this;
    }

    /**
     * @see BannerMeta#getPattern(int)
     */
    public @NotNull Pattern pattern(int i) {
        return meta.getPattern(i);
    }

    /**
     * @see BannerMeta#getPatterns()
     */
    public @NotNull List<Pattern> patterns() {
        return meta.getPatterns();
    }

    /**
     * @see BannerMeta#removePattern(int)
     */
    public @NotNull BannerBuilder removePattern(int i) {
        meta.removePattern(i);
        return this;
    }

    /**
     * @see BannerMeta#numberOfPatterns()
     */
    public int numberOfPatterns() {
        return meta.numberOfPatterns();
    }

    public static @NotNull BannerBuilder of(@NotNull Material material) {
        return new BannerBuilder(material);
    }

    public static @NotNull BannerBuilder of(@NotNull ItemStack itemStack) {
        return new BannerBuilder(itemStack);
    }

    public static @NotNull BannerBuilder of(@NotNull ItemStack itemStack, @NotNull BannerMeta bannerMeta) {
        return new BannerBuilder(itemStack, bannerMeta);
    }
}
