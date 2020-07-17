package org.psawesome.tdd.chap02._02_password;

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
public class PasswordStrengthMeterTest {
  @Test
  void meetsAllCriteria_Then_Strong() {
    var meter = new PasswordStrengthMeter();
    var result = meter.meter("ab12!@AB");
    assertEquals(PasswordStrength.STRONG, result);
  }
}
