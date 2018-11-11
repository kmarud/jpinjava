package com.fpinjava.makingjavafunctional.exercise03_01;

import com.fpinjava.common.Function;

import java.util.regex.Pattern;

public class EmailValidation {

    static Pattern emailPattern =
            Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static Function<String, Result<String>> emailChecker = s -> {
        if (s == null)
            return Result.failure("E-mail cannot be null");
        else if (s.isEmpty())
            return Result.failure("E-mail cannot be empty");
        else if (emailPattern.matcher(s).matches())
            return Result.success("E-mail OK!");
        else
            return Result.failure("E-mail is invalid");
    };

    public static void main(String... args) {
        emailChecker.apply("this.is@my.email").bind(success, failure);
        emailChecker.apply(null).bind(success, failure);
        emailChecker.apply("").bind(success, failure);
        emailChecker.apply("john.doe@acme.com").bind(success, failure);
    }

    static Effect<String> success = s -> System.out.println("Success: " + s);

    static Effect<String> failure = s -> System.out.println("Fail: " + s);
}