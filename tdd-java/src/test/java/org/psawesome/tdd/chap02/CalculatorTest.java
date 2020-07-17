package org.psawesome.tdd.chap02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    Assertions.assertEquals(7, result);
  }
}
