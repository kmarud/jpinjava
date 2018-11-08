package com.fpinjava.functions.exercise02_05;

public interface Function<T, U> {

    U apply(T arg);

    static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> higherCompose() {
        return arg1 -> (Function<Function<T, U>, Function<T, V>>)
                arg2 -> (Function<T, V>)
                        arg3 -> arg1
                                .apply(arg2.apply(arg3));
    }
}
