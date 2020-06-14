package core.util;

import com.google.common.base.Preconditions;

import java.util.function.Supplier;

public class GameUtils {
    public static void checkNotNull(final Object obj) {
        Preconditions.checkNotNull(obj);
    }

    public static void checkArgument(final boolean expression, Supplier<? extends RuntimeException> exceptionToThrowSupplier) {
        if (!expression) {
            throw exceptionToThrowSupplier.get();
        }
    }
}
