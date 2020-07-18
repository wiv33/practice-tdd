package org.psawesome.tdd.chap03._00_expiry;

import java.time.LocalDate;

/**
 * @author ps [https://github.com/wiv33/practice-tdd]
 * @role
 * @responsibility
 * @cooperate {
 * input:
 * output:
 * }
 * @see
 * @since 20. 7. 18. Saturday
 */
public class ExpiryDateCalculator {
  public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
    return billingDate.plusMonths(1);
  }
}
