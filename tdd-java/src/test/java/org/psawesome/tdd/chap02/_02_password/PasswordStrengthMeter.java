package org.psawesome.tdd.chap02._02_password;

import java.util.Arrays;

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
    if (s == null || s.isBlank()) return PasswordStrength.INVALID;
    int metCounts = 0;
    if (s.length() >= 8) metCounts++;
    if (meetsContainingNumberCriteria(s)) metCounts++;
    if (meetsContainingUppercaseCriteria(s)) metCounts++;

    if (metCounts == 1) return PasswordStrength.WEAK;
    if (metCounts == 2) return PasswordStrength.NORMAL;

    return PasswordStrength.STRONG;
  }

  private boolean meetsContainingUppercaseCriteria(String s) {
    for (char c : s.toCharArray()) {
      if (Character.isUpperCase(c)) {
        return true;
      }
    }
    return false;
  }

  private boolean meetsContainingNumberCriteria(String s) {
    for (char ch : s.toCharArray()) {
      if (ch >= '0' && ch <= '9') {
        return true;
      }
    }
    return false;
  }
}
