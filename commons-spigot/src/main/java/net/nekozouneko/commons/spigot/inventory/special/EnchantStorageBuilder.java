package net.nekozouneko.commons.spigot.inventory.special;

import net.nekozouneko.commons.spigot.inventory.AbsItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class EnchantStorageBuilder extends AbsItemStackBuilder<EnchantStorageBuilder, EnchantmentStorageMeta> {

    protected EnchantStorageBuilder(@NotNull Material material) {
        super(material);
    }

    protected EnchantStorageBuilder(@NotNull ItemStack itemStack) {
        super(itemStack);
    }

    protected EnchantStorageBuilder(@NotNull ItemStack itemStack, @NotNull EnchantmentStorageMeta enchantStorageMeta) {
        super(itemStack, enchantStorageMeta);
    }

    public @NotNull EnchantStorageBuilder storedEnchant(@NotNull Enchantment ench, int level, boolean ignoreLevelRestriction) {
        meta.addStoredEnchant(ench, level, ignoreLevelRestriction);
        return this;
    }

    public @NotNull EnchantStorageBuilder removeStoredEnchant(Enchantment ench) {
        meta.removeStoredEnchant(ench);
        return this;
    }

    public @NotNull Map<Enchantment, Integer> storedEnchants() {
        return meta.getStoredEnchants();
    }

    public int storedEnchantLevel(@NotNull Enchantment ench) {
        return meta.getStoredEnchantLevel(ench);
    }

    public boolean hasConflictingStoredEnchant(@NotNull Enchantment ench) {
        return meta.hasConflictingStoredEnchant(ench);
    }

    public boolean hasStoredEnchant(@NotNull Enchantment ench) {
        return meta.hasStoredEnchant(ench);
    }

    public boolean hasStoredEnchants() {
        return meta.hasStoredEnchants();
    }

    public static @NotNull EnchantStorageBuilder of(@NotNull Material material) {
        return new EnchantStorageBuilder(material);
    }

    public static @NotNull EnchantStorageBuilder of(@NotNull ItemStack itemStack) {
        return new EnchantStorageBuilder(itemStack);
    }

    public static @NotNull EnchantStorageBuilder of(@NotNull ItemStack itemStack, @NotNull EnchantmentStorageMeta enchantStorageMeta) {
        return new EnchantStorageBuilder(itemStack, enchantStorageMeta);
    }

}
