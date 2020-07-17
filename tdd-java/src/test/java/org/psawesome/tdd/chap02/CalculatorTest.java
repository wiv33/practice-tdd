package org.psawesome.tdd.chap02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ps [https://github.com/wiv33/practice-tdd]
 * @role
 * @responsibility
 * @cooperate {
 * input:
 * output:
 * }
 * @see
 * @since 20. 7. 17. Friday
 */
public class CalculatorTest {
  @Test
  void testPlus() {
    int result = Calculator.plus(2, 5);
    assertEquals(7, result);
    assertEquals(3, Calculator.plus(1, 2));
  }
}
