package org.psawesome.tdd.chap02._02_password;

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
public class PasswordStrengthMeter {
  public PasswordStrength meter(String s) {
    if (s.length() < 8) return PasswordStrength.NORMAL;
    return PasswordStrength.STRONG;
  }
}
