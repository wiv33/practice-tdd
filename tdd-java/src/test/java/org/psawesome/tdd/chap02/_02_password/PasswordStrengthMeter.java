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
    if (s == null || s.isBlank()) return PasswordStrength.INVALID;
    if (s.length() < 8) return PasswordStrength.NORMAL;

    boolean containsNum = meetsContainingNumberCriteria(s);
    if (!containsNum) return PasswordStrength.NORMAL;

    boolean containsUpp = meetsContainingUppercaseCriteria(s);
    if (!containsUpp) return PasswordStrength.NORMAL;

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
