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
 * 교훈: 구현하기 쉬운 것부터 찾아서 tdd 리스트를 만든다.
 * @see
 * @since 20. 7. 17. Friday
 */
public class PasswordStrengthMeter {
  public PasswordStrength meter(String s) {
    if (s == null || s.isBlank()) return PasswordStrength.INVALID;
    int metCounts = getMetCriteriaCounts(s);

    if (metCounts <= 1) return PasswordStrength.WEAK;
    if (metCounts == 2) return PasswordStrength.NORMAL;

    return PasswordStrength.STRONG;
  }

  private int getMetCriteriaCounts(String s) {
    int metCounts = 0;
    if (s.length() >= 8) metCounts++;
    if (meetsContainingNumberCriteria(s)) metCounts++;
    if (meetsContainingUppercaseCriteria(s)) metCounts++;
    return metCounts;
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
