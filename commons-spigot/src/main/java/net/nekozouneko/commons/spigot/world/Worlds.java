package net.nekozouneko.commons.spigot.world;

import net.nekozouneko.commons.lang.io.Files2;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

/**
 * @author Taitaitatata
 * @since 1.0
 */
public final class Worlds {

    private Worlds() {
        throw new ExceptionInInitializerError();
    }

    /**
     *
     * @param original コピー元のワールド
     * @param name コピーしたワールドの名前
     * @throws java.nio.file.FileAlreadyExistsException すでに引数「name」の名前でファイルもしくはフォルダが存在しています。
     * @throws IOException その他I/Oエラーが発生した場合
     * @return コピーしたワールド
     */
    public static World copyWorld(@NotNull World original, @NotNull String name) throws IOException {
        Path to = Paths.get(name);

        if (Files.exists(to))
            throw new FileAlreadyExistsException(name + " is already exists");

        Path from = original.getWorldFolder().toPath();

        Files.walkFileTree(from, new SimpleFileVisitor<Path>() {
            final List<String> DO_NOT_COPY = Arrays.asList("uid.dat", "session.lock");

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path copyTo = to.resolve(from.relativize(dir));
                Files.createDirectory(copyTo);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (!DO_NOT_COPY.contains(file.getFileName().toString())) {
                    Path copyTo = to.resolve(from.relativize(file));
                    Files.copy(file, copyTo, StandardCopyOption.COPY_ATTRIBUTES);
                }
                return FileVisitResult.CONTINUE;
            }
        });

        return WorldCreator.name(name).createWorld();
    }

}
