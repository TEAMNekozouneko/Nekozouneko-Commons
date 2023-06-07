package net.nekozouneko.commons.spigot.command;

import org.bukkit.OfflinePlayer;
import org.bukkit.World;

import java.util.*;
import java.util.stream.Collectors;

public final class TabCompletes {

    private TabCompletes() {
        throw new ExceptionInInitializerError();
    }

    public static List<String> sorted(String input, String... suggests) {
        return sorted(input, Arrays.asList(suggests));
    }

    public static List<String> sorted(String input, Collection<String> suggests) {
        List<String> list = new ArrayList<>(suggests);
        List<String> result = new ArrayList<>();

        for (String s : list) {
            if (s.toLowerCase().startsWith(input.toLowerCase()))
                result.add(s);
        }

        Collections.sort(result);
        return result;
    }

    public static List<String> simple(String input, String... suggests) {
        return simple(input, Arrays.asList(suggests));
    }

    public static List<String> simple(String input, Collection<String> suggests) {
        List<String> list = new ArrayList<>(suggests);
        List<String> result = new ArrayList<>();

        for (String s : list) {
            if (s.toLowerCase().startsWith(input.toLowerCase()))
                result.add(s);
        }

        return result;
    }

    public static List<String> players(String input, Collection<? extends OfflinePlayer> players) {
        return sorted(
                input,
                players.stream()
                        .map(OfflinePlayer::getName)
                        .collect(Collectors.toList())
        );
    }

    public static List<String> worlds(String input, Collection<World> worlds) {
        return sorted(
                input,
                worlds.stream()
                        .map(World::getName)
                        .collect(Collectors.toList())
        );
    }

}
