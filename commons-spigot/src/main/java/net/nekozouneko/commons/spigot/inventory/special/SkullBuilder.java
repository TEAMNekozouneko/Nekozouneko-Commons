package net.nekozouneko.commons.spigot.inventory.special;

import net.nekozouneko.commons.spigot.inventory.AbsItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Taitaitatata
 * @see SkullMeta
 * @since 1.0
 */
public class SkullBuilder extends AbsItemStackBuilder<SkullBuilder, SkullMeta> {

    public static @NotNull SkullBuilder of(Material material) {
        return new SkullBuilder(material);
    }

    public static @NotNull SkullBuilder of(ItemStack itemStack) {
        return new SkullBuilder(itemStack);
    }

    public static @NotNull SkullBuilder of(ItemStack itemStack, SkullMeta itemMeta) {
        return new SkullBuilder(itemStack, itemMeta);
    }

    protected SkullBuilder(@NotNull Material material) {
        super(material);
    }

    protected SkullBuilder(@NotNull ItemStack itemStack) {
        super(itemStack);
    }

    protected SkullBuilder(@NotNull ItemStack itemStack, @NotNull SkullMeta itemMeta) {
        super(itemStack, itemMeta);
    }

    /**
     * @see SkullMeta#setOwningPlayer(OfflinePlayer)
     */
    public @NotNull SkullBuilder owningPlayer(@Nullable OfflinePlayer player) {
        meta.setOwningPlayer(player);
        return this;
    }

    /**
     * @see SkullMeta#getOwningPlayer()
     */
    public @Nullable OfflinePlayer owningPlayer() {
        return meta.getOwningPlayer();
    }

    /**
     * @see SkullMeta#setOwnerProfile(PlayerProfile)
     */
    public @NotNull SkullBuilder ownerProfile(@Nullable PlayerProfile profile) {
        meta.setOwnerProfile(profile);
        return this;
    }

    /**
     * @see SkullMeta#getOwnerProfile()
     */
    public @Nullable PlayerProfile ownerProfile() {
        return meta.getOwnerProfile();
    }

    /**
     * @see SkullMeta#hasOwner()
     */
    public boolean hasOwner() {
        return meta.hasOwner();
    }

    /**
     * <b>WARNING: This feature available in 1.20 or snapshot.</b>
     * @see SkullMeta#setNoteBlockSound(NamespacedKey)
     */
    @ApiStatus.Experimental
    public @NotNull SkullBuilder noteBlockSound(@Nullable NamespacedKey key) {
        meta.setNoteBlockSound(key);
        return this;
    }
}
