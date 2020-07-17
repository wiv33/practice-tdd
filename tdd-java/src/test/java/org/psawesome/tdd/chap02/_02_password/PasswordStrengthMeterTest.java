package org.psawesome.tdd.chap02._02_password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ps [https://github.com/wiv33/practice-tdd]
 * @role
 *  길이사 8글자 이상,
 *  0부터 9 사이의 숫자를 포함,
 *  대문자 포함
 *
 *  세 규칙을 모두 충족하면 암호는 강함.
 *  두 규칙을 충족하면 암호는 보통.
 *  1개 이하의 규칙을 충족하면 암호는 약함.
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

    var result2 = meter.meter("abc1!Add");
    assertEquals(PasswordStrength.STRONG, result2);

  }
}
