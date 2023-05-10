package net.nekozouneko.commons.spigot.inventory;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * @author Taitaitatata
 * @param <B> Builder
 * @param <M> ItemMeta Class
 * @since 1.0
 * @see ItemStackBuilder
 */
@SuppressWarnings({"unchecked", "unused"})
public abstract class AbsItemStackBuilder<B extends AbsItemStackBuilder<B, M>, M extends ItemMeta> implements Cloneable{

    protected ItemStack stack;
    protected M meta;

    protected AbsItemStackBuilder(@NotNull Material material) {
        Preconditions.checkArgument(material.isAir(), "Air materials is not supported.");

        stack = new ItemStack(material);
        meta = (M) stack.getItemMeta();
    }

    protected AbsItemStackBuilder(@NotNull ItemStack itemStack) {
        stack = itemStack.clone();
        meta = (M) stack.getItemMeta();
    }

    protected AbsItemStackBuilder(@NotNull ItemStack itemStack, @NotNull M itemMeta) {
        stack = itemStack.clone();
        meta = itemMeta;
    }

    @Override
    public B clone() throws CloneNotSupportedException {
        B builder = (B) super.clone();

        builder.stack = stack.clone();
        builder.meta = (M) meta.clone();

        return builder;
    }

    public @NotNull B amount(int amount) {
        stack.setAmount(amount);
        return (B) this;
    }

    public int amount() {
        return stack.getAmount();
    }

    public @NotNull B material(Material material) {
        stack.setType(material);
        return (B) this;
    }

    public Material material() {
        return stack.getType();
    }

    public @NotNull B name(@Nullable String name) {
        meta.setDisplayName(name);
        return (B) this;
    }

    public @Nullable String name() {
        return meta.hasDisplayName() ? meta.getDisplayName() : null;
    }

    public @NotNull B localizedName(@Nullable String localized) {
        meta.setLocalizedName(localized);
        return (B) this;
    }

    public @Nullable String localizedName() {
        return meta.hasLocalizedName() ? meta.getLocalizedName() : null;
    }

    public @NotNull B lore(List<String> lore) {
        meta.setLore(lore);
        return (B) this;
    }

    public @NotNull B lore(String... lore) {
        meta.setLore(Arrays.asList(lore));
        return (B) this;
    }

    public @NotNull List<String> lore() {
        return meta.hasLore() ? meta.getLore() : Collections.emptyList();
    }

    public @NotNull B customModelData(@Nullable Integer customModelData) {
        meta.setCustomModelData(customModelData);
        return (B) this;
    }

    public @Nullable Integer customModelData() {
        return meta.hasCustomModelData() ? meta.getCustomModelData() : null;
    }

    public @NotNull B unbreakable(boolean isUnbreakable) {
        meta.setUnbreakable(isUnbreakable);
        return (B) this;
    }

    public boolean unbreakable() {
        return meta.isUnbreakable();
    }

    public @NotNull B attribute(@NotNull Attribute attribute, @NotNull AttributeModifier modifier) {
        meta.addAttributeModifier(attribute, modifier);
        return (B) this;
    }

    public @NotNull B attributes(@Nullable Multimap<Attribute, AttributeModifier> attributes) {
        meta.setAttributeModifiers(attributes);
        return (B) this;
    }

    public boolean hasAttributes() {
        return meta.hasAttributeModifiers();
    }

    public @NotNull B removeAttribute(@NotNull Attribute attribute) {
        meta.removeAttributeModifier(attribute);
        return (B) this;
    }

    public @NotNull B removeAttribute(@NotNull Attribute attribute, @NotNull AttributeModifier modifier) {
        meta.removeAttributeModifier(attribute, modifier);
        return (B) this;
    }

    public @NotNull B removeAttributes(@NotNull EquipmentSlot slot) {
        meta.removeAttributeModifier(slot);
        return (B) this;
    }

    public @NotNull B clearAttributes() {
        meta.setAttributeModifiers(null);
        return (B) this;
    }

    public @NotNull Multimap<Attribute, AttributeModifier> attributes() {
        return meta.hasAttributeModifiers() ? meta.getAttributeModifiers() : ImmutableMultimap.of();
    }

    public @NotNull B enchant(@NotNull Enchantment enchant, int level, boolean ignoreLevelRestriction) {
        meta.addEnchant(enchant, level, ignoreLevelRestriction);
        return (B) this;
    }

    public @NotNull B removeEnchant(@NotNull Enchantment enchant) {
        meta.removeEnchant(enchant);
        return (B) this;
    }

    public @NotNull B clearEnchants() {
        new HashMap<>(meta.getEnchants()).keySet().forEach(meta::removeEnchant);
        return (B) this;
    }

    public boolean hasEnchant(@NotNull Enchantment enchant) {
        return meta.hasEnchant(enchant);
    }

    public boolean hasEnchants() {
        return meta.hasEnchants();
    }

    public boolean hasConflictingEnchant(@NotNull Enchantment enchant) {
        return meta.hasConflictingEnchant(enchant);
    }

    public @NotNull B enchants(@NotNull Map<Enchantment, Integer> enchants) {
        clearEnchants();
        enchants.forEach((ench, lvl) -> meta.addEnchant(ench, lvl, ench.getMaxLevel() >= lvl));
        return (B) this;
    }

    public Map<Enchantment, Integer> enchants() {
        return meta.getEnchants();
    }

    public @NotNull B itemFlags(@NotNull ItemFlag... flags) {
        meta.addItemFlags(flags);
        return (B) this;
    }

    public @NotNull B removeItemFlags(@NotNull ItemFlag... flags) {
        meta.removeItemFlags(flags);
        return (B) this;
    }

    public boolean hasItemFlag(@NotNull ItemFlag flag) {
        return meta.hasItemFlag(flag);
    }

    public @NotNull Set<ItemFlag> itemFlags() {
        return meta.getItemFlags();
    }

    public @NotNull <T, Z> B persistentData(@NotNull NamespacedKey key, @NotNull PersistentDataType<T, Z> type, @NotNull Z value) {
        meta.getPersistentDataContainer().set(key, type, value);
        return (B) this;
    }

    public @NotNull B removePersistentData(@NotNull NamespacedKey key) {
        meta.getPersistentDataContainer().remove(key);
        return (B) this;
    }

    public @NotNull B clearPersistentData() {
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.getKeys().forEach(pdc::remove);
        return (B) this;
    }

    public boolean hasPersistentData(@NotNull NamespacedKey key, @NotNull PersistentDataType<?, ?> type) {
        return meta.getPersistentDataContainer().has(key, type);
    }

    public @NotNull Set<NamespacedKey> persistentDataKeys() {
        return meta.getPersistentDataContainer().getKeys();
    }

    public @Nullable <T, Z> Z getPersistentData(@NotNull NamespacedKey key, @NotNull PersistentDataType<T, Z> type){
        return meta.getPersistentDataContainer().get(key, type);
    }

    public @NotNull <T, Z> Z getPersistentData(@NotNull NamespacedKey key, @NotNull PersistentDataType<T, Z> type, @NotNull Z def){
        return meta.getPersistentDataContainer().getOrDefault(key, type, def);
    }

    public @NotNull ItemStack build() {
        stack.setItemMeta(meta);
        return stack;
    }

}
