package net.nekozouneko.commons.spigot.inventory.special;

import net.md_5.bungee.api.chat.BaseComponent;
import net.nekozouneko.commons.spigot.inventory.AbsItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BookBuilder extends AbsItemStackBuilder<BookBuilder, BookMeta> {

    protected BookBuilder(@NotNull Material material) {
        super(material);
    }

    protected BookBuilder(@NotNull ItemStack itemStack) {
        super(itemStack);
    }

    protected BookBuilder(@NotNull ItemStack itemStack, @NotNull BookMeta itemMeta) {
        super(itemStack, itemMeta);
    }

    public @NotNull BookBuilder author(@Nullable String author) {
        meta.setAuthor(author);
        return this;
    }

    public @Nullable String author() {
        return meta.getAuthor();
    }

    public boolean hasAuthor() {
        return meta.hasAuthor();
    }

    public @Nullable BookBuilder generation(BookMeta.Generation generation) {
        meta.setGeneration(generation);
        return this;
    }

    public @Nullable BookMeta.Generation generation() {
        return meta.getGeneration();
    }

    public boolean hasGeneration() {
        return meta.hasGeneration();
    }

    public @NotNull BookBuilder page(@NotNull String... pages) {
        meta.addPage(pages);
        return this;
    }

    public @NotNull BookBuilder page(int page, String data) {
        meta.setPage(page, data);
        return this;
    }

    public @NotNull String page(int page) {
        return meta.getPage(page);
    }

    public @NotNull BookBuilder pages(@NotNull String... pages) {
        meta.setPages(pages);
        return this;
    }

    public @NotNull BookBuilder pages(@NotNull List<String> pages) {
        meta.setPages(pages);
        return this;
    }

    public @NotNull List<String> pages() {
        return meta.getPages();
    }

    public int getPageCount() {
        return meta.getPageCount();
    }

    public boolean hasPages() {
        return meta.hasPages();
    }

    public @NotNull BookBuilder title(@NotNull String title) {
        meta.setTitle(title);
        return this;
    }

    public @Nullable String title() {
        return meta.getTitle();
    }

    public boolean hasTitle() {
        meta.spigot();
        return meta.hasTitle();
    }

    public @NotNull BookBuilder spigotPage(@NotNull BaseComponent[]... pages) {
        meta.spigot().addPage(pages);
        return this;
    }

    public @NotNull BookBuilder spigotPage(int page, @NotNull BaseComponent... data) {
        meta.spigot().setPage(page, data);
        return this;
    }

    public @NotNull BaseComponent[] spigotPage(int page) {
        return meta.spigot().getPage(page);
    }

    public @NotNull BookBuilder spigotPages(@NotNull BaseComponent... pages) {
        meta.spigot().setPages(pages);
        return this;
    }

    public @NotNull BookBuilder spigotPages(@NotNull List<BaseComponent[]> pages) {
        meta.spigot().setPages(pages);
        return this;
    }

    public @NotNull List<BaseComponent[]> spigotPages() {
        return meta.spigot().getPages();
    }

    public static @NotNull BookBuilder of(@NotNull Material material) {
        return new BookBuilder(material);
    }

    public static @NotNull BookBuilder of(@NotNull ItemStack itemStack) {
        return new BookBuilder(itemStack);
    }

    public static @NotNull BookBuilder of(@NotNull ItemStack itemStack, @NotNull BookMeta bookMeta) {
        return new BookBuilder(itemStack, bookMeta);
    }
}
