package net.nekozouneko.commons.lang.collect;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/**
 * @author Taitaitatata
 * @since 1.0
 */
public final class Arrays2 {

    private Arrays2() {
        throw new ExceptionInInitializerError();
    }

    public static <E> E getOrNull(@NotNull E[] array, @Range(from = 0, to = Integer.MAX_VALUE) int pos) {
        Preconditions.checkArgument(array != null, "Array is null");
        Preconditions.checkArgument(pos >= 0, "pos is negative");
        return array.length > pos ? array[pos] : null;
    }


}
