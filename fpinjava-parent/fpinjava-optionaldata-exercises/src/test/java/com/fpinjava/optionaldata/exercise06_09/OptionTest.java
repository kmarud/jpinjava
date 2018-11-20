package com.fpinjava.optionaldata.exercise06_09;

import static org.junit.Assert.*;

import com.fpinjava.common.Function;
import org.junit.Test;

public class OptionTest {


  private Function<Option<String>, Option<Integer>> parseIntOption = Option.lift(Integer::parseInt);

  private Function<String, Option<Integer>> parseInt = Option.hlift(Integer::parseInt);

  @Test
  public void testLift() {
    assertEquals(Option.some(345).toString(), parseIntOption.apply(Option.some("345")).toString());
  }

  @Test
  public void testLiftNone() {
    assertEquals(Option.none(), parseIntOption.apply(Option.none()));
  }

  @Test
  public void testLiftException() {
    assertEquals(Option.none(), parseIntOption.apply(Option.some("abcd")));
  }

  @Test
  public void testHlift() {
    assertEquals(Option.some(345).toString(), parseInt.apply("345").toString());
  }

  @Test
  public void testHliftException() {
    assertEquals(Option.none(), parseInt.apply("abcd"));
  }
}
