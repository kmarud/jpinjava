package com.fpinjava.functions.listing02_02;

import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionTest {
    private Function<Integer, Double> addTwo = a -> a + 2.0;
    private Function<Double, Double> multiplyByTwo = a -> a * 2;

    @Test
    public void apply() {
        assertEquals(3.0, addTwo.apply(1), 0.0);
    }

    @Test
    public void compose() {
        assertEquals(14.0, multiplyByTwo.compose(addTwo).apply(5), 0.0);
    }

    @Test
    public void andThen() {
        assertEquals(14.0, addTwo.andThen(multiplyByTwo).apply(5), 0.0);
    }

    @Test
    public void identity() {
        assertEquals(7.0, addTwo.andThen(Function.identity()).apply(5), 0.0);
    }

    @Test
    public void compose1() {
    }

    @Test
    public void andThen1() {
    }

    @Test
    public void compose2() {
    }

    @Test
    public void andThen2() {
    }

    @Test
    public void TestHigherCompose() {

        Function<Double, Integer> f = a -> (int) (a * 3);
        Function<Integer, Double> g = a -> a + 2.0;

        assertEquals(Integer.valueOf(9), f.compose(g).apply(1));
        assertEquals(Integer.valueOf(9), Function.<Integer, Double, Integer>higherCompose().apply(f).apply(g).apply(1));
    }

    @Test
    public void TestHigherAndThen() {

        Function<Double, Integer> f = a -> (int) (a * 3);
        Function<Integer, Double> g = a -> a + 2.0;

        assertEquals(Integer.valueOf(9), g.andThen(f).apply(1));
        assertEquals(Integer.valueOf(9), Function.<Integer, Double, Integer>higherAndThen().apply(g).apply(f).apply(1));
    }
}