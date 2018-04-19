package com.github.jettyrun.common.utils.exception;

/**
 * Created by jetty on 18/2/9.
 */
public class ExceptionUtils {



    public static boolean isCheckedException(Throwable ex) {
        return !(ex instanceof RuntimeException || ex instanceof Error);
    }


    public static boolean isCompatibleWithThrowsClause(Throwable ex, Class<?>... declaredExceptions) {
        if (!isCheckedException(ex)) {
            return true;
        }
        if (declaredExceptions != null) {
            for (Class<?> declaredException : declaredExceptions) {
                if (declaredException.isInstance(ex)) {
                    return true;
                }
            }
        }
        return false;
    }
}
