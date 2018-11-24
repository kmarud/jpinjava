package com.fpinjava.handlingerrors.listing_own;

import com.fpinjava.common.Function;
import com.fpinjava.handlingerrors.exercise07_14.Result;

public class Constructors {

    static Result<String> getFirstName() {
        return Result.success("Mickey");
    }

    static Result<String> getLastName() {
        return Result.success("Mickey");
    }

    static Result<String> getMail() {
        return Result.success("mickey@disney.com");
    }

    Function<String, Function<String, Function<String, Toon>>> createPerson = x -> y -> z -> new Toon(x, y, z);

    public static void main(String[] args) {
        new Constructors().run();
    }

    void run() {
        Result<Toon> toon2 = Result.lift3(createPerson).apply(getFirstName()).apply(getLastName()).apply(getMail());
        toon2.map(Toon::getEmail).forEach(System.out::print);

        Result<Integer> result1 = Result.success(1);
        Result<Integer> result2 = Result.success(2);
        Result<Integer> result3 = Result.success(3);
        Result<Integer> result4 = Result.success(4);
        Result<Integer> result5 = Result.success(5);

        Result<Integer> result = result1
                .flatMap(p1 -> result2
                        .flatMap(p2 -> result3
                                .flatMap(p3 -> result4
                                        .flatMap(p4 -> result5
                                                .map(p5 -> compute(p1, p2, p3, p4, p5))))));
    }

    private int compute(int p1, int p2, int p3, int p4, int p5) {
        return p1 + p2 + p3 + p4 + p5;
    }
}
