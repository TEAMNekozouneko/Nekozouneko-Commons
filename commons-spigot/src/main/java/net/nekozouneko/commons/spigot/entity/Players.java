package net.nekozouneko.commons.spigot.entity;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class Players {

    private Players() { throw new ExceptionInInitializerError(); }

    public static void clearPotionEffects(@NotNull Player player) {
        player.getActivePotionEffects().forEach(effect -> player.removePotionEffect(effect.getType()));
    }

    public static void healHealth(@NotNull Player player) {
        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
    }

    public static void healFoodLevel(@NotNull Player player) {
        player.setFoodLevel(20);
    }

    public static void healSaturation(@NotNull Player player) {
        player.setSaturation(20);
    }

    public static void healExhaustion(@NotNull Player player) {
        player.setExhaustion(0);
    }

    public static void healAll(@NotNull Player player) {
        healHealth(player);
        healFoodLevel(player);
        healSaturation(player);
        healExhaustion(player);
    }

}
