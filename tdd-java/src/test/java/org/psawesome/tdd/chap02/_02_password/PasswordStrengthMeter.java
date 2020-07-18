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

    boolean lengthEnough = s.length() >= 8;
    boolean containsNum = meetsContainingNumberCriteria(s);
    boolean containsUpp = meetsContainingUppercaseCriteria(s);

    if (lengthEnough && !containsNum && !containsUpp) return PasswordStrength.WEAK;
    if (!lengthEnough && containsNum && !containsUpp) return PasswordStrength.WEAK;
    if (!lengthEnough && !containsNum && containsUpp) return PasswordStrength.WEAK;

    if (!lengthEnough) return PasswordStrength.NORMAL;
    if (!containsNum) return PasswordStrength.NORMAL;
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
