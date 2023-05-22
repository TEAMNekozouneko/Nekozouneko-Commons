package net.nekozouneko.commons.lang.collect;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Taitaitatata
 * @since 1.0
 */
public final class Collections3 {

    private Collections3() {
        throw new ExceptionInInitializerError();
    }

    public static <E> boolean allValueEquals(Collection<E> collect, E elem) {
        return Collections.frequency(collect, elem) == collect.size();
    }


    public static <E> E getOrNull(@NotNull Collection<E> collect, @Range(from = 0, to = Integer.MAX_VALUE) int pos) {
        Preconditions.checkArgument(collect != null, "Collection is null");
        Preconditions.checkArgument(pos >= 0, "pos is negative");

        Iterator<E> iter = collect.iterator();
        int nowpos = 0;
        while (iter.hasNext()) {
            E now = iter.next();

            if (pos == nowpos) return now;
            else nowpos++;
        }

        return null;
    }
}
