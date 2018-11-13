package com.fpinjava.makingjavafunctional.listing03_09;

import com.fpinjava.makingjavafunctional.exercise03_01.Result;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmailValidationTest {

    @Test
    public void ShouldReturnFailureInvalidAddress() {
        Result<String> result = EmailValidation.emailChecker.apply("test");
        assertTrue((result instanceof Result.Failure));
        result.bind(System.out::println,System.out::println);
    }

    @Test
    public void ShouldReturnFailureEmptyAddress() {
        Result<String> result = EmailValidation.emailChecker.apply("");
        assertTrue((result instanceof Result.Failure));
    }

    @Test
    public void ShouldReturnFailureNullAddress() {
        Result<String> result = EmailValidation.emailChecker.apply(null);
        assertTrue((result instanceof Result.Failure));
    }

    @Test
    public void ShouldReturnSuccess() {
        Result<String> result = EmailValidation.emailChecker.apply("john.doe@gmail.com");
        assertTrue((result instanceof Result.Success));
    }

}
