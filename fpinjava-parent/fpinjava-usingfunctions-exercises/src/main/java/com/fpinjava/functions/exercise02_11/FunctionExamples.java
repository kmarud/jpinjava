package com.fpinjava.functions.exercise02_11;

public class FunctionExamples {

    public static <T, U, V> Function<U, Function<T, V>> reverseArgs(Function<T, Function<U, V>> f) {
        return arg1 -> (Function<T, V>) arg2 -> f.apply(arg2).apply(arg1);
    }
}
