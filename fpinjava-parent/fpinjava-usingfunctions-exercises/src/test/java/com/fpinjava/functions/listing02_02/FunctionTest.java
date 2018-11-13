package com.fpinjava.functions.listing02_02;

import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionTest {
    private Function<Integer, Double> addTwo = a -> a + 2.0;

    private Function<Double, Long> multiplyByTwo = a -> (long) (a * 2);

    @Test
    public void apply() {
        assertEquals(3.0, addTwo.apply(1), 0.0);
    }

    @Test
    public void compose() {
        assertEquals(Long.valueOf(14), multiplyByTwo.compose(addTwo).apply(5));
    }

    @Test
    public void andThen() {
        assertEquals(Long.valueOf(14), addTwo.andThen(multiplyByTwo).apply(5));
    }

    @Test
    public void identity() {
        assertEquals(7.0, addTwo.andThen(Function.identity()).apply(5), 0.0);
    }

    @Test
    public void compose1() {
        assertEquals(Long.valueOf(14), Function.compose(multiplyByTwo, addTwo).apply(5));
    }

    @Test
    public void andThen1() {
        assertEquals(Long.valueOf(14), Function.andThen(addTwo, multiplyByTwo).apply(5));
    }

    @Test
    public void compose2() {
        Function<Function<Integer, Double>, Function<Function<Double, Long>, Function<Integer, Long>>> s = Function
                .compose();
        assertEquals(Long.valueOf(14), s.apply(addTwo).apply(multiplyByTwo).apply(5));
    }

    @Test
    public void andThen2() {
        Function<Function<Double, Long>, Function<Function<Integer, Double>, Function<Integer, Long>>> s = Function
                .andThen();
        assertEquals(Long.valueOf(14), s.apply(multiplyByTwo).apply(addTwo).apply(5));
    }

    @Test
    public void TestHigherCompose() {
        assertEquals(Long.valueOf(14), multiplyByTwo.compose(addTwo).apply(5));
        assertEquals(Long.valueOf(14),
                Function.<Integer, Double, Long>higherCompose().apply(multiplyByTwo).apply(addTwo).apply(5));
    }

    @Test
    public void TestHigherAndThen() {
        assertEquals(Long.valueOf(14), addTwo.andThen(multiplyByTwo).apply(5));
        assertEquals(Long.valueOf(14),
                Function.<Integer, Double, Long>higherAndThen().apply(addTwo).apply(multiplyByTwo).apply(5));
    }
}
