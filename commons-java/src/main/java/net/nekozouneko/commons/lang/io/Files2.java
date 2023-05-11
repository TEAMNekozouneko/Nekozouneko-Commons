package net.nekozouneko.commons.lang.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Taitaitatata
 * @since 1.0
 */
public final class Files2 {

    private Files2() { throw new ExceptionInInitializerError(); }

    /**
     * @see java.nio.file.Files#deleteIfExists(Path) Files.deleteIfExists(Path)
     */
    public static void deleteIfExists(Path path) throws IOException {
        if (!Files.exists(path)) return;

        if (Files.isDirectory(path)) {
            AtomicReference<IOException> e = new AtomicReference<>();
            Files.list(path)
                    .forEach((p) -> {
                        if (e.get() != null) return;

                        try {
                           if (Files.isDirectory(p)) {
                               deleteIfExists(p);
                           } else Files.deleteIfExists(p);
                        }
                        catch (IOException ioe) {
                             e.set(ioe);
                        }
                    });

            if (e.get() != null) {
                throw e.get();
            }
        }
        Files.deleteIfExists(path);
    }

}
