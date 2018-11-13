package com.fpinjava.functions.exercise02_10;

public class FunctionExamples {

    public static <A, B, C> Function<A, Function<B, C>> curry(Function<Tuple<A, B>, C> f) {
        return a -> (Function<B, C>)
                b -> f.apply(new Tuple<>(a, b));
    }
}
