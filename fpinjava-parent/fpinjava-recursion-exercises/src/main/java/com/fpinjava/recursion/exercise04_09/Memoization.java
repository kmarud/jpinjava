package com.fpinjava.recursion.exercise04_09;

import com.fpinjava.common.TailCall;

import java.math.BigInteger;
import java.util.List;

import static com.fpinjava.common.CollectionUtilities.*;

public class Memoization {

    public static String fibo(int number) {
        List<BigInteger> list = fibo_(list(BigInteger.ZERO), BigInteger.ONE, BigInteger.ZERO,
                BigInteger.valueOf(number)).eval();
        return makeString(list, ", ");
    }

    public static TailCall<List<BigInteger>> fibo_(List<BigInteger> acc, BigInteger acc1, BigInteger acc2,
                                                   BigInteger x) {
        return x.equals(BigInteger.ZERO)
                ? TailCall.ret(acc)
                : x.equals(BigInteger.ONE)
                    ? TailCall.ret(append(acc, acc1.add(acc2)))
                    : TailCall.sus(() -> fibo_(append(acc, acc1.add(acc2)),
                        acc2, acc1.add(acc2), x.subtract(BigInteger.ONE)));
    }

    public static <T> String makeString(List<T> list, String separator) {
        return list.isEmpty()
                ? ""
                : tail(list).isEmpty()
                    ? head(list).toString()
                    : head(list) + foldLeft(tail(list), "", x -> y -> x + separator + y);
    }
}
