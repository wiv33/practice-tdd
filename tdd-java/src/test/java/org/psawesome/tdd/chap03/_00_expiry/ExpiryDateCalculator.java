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
  public LocalDate calculateExpiryDate(PayData payDate) {
    return payDate.getBillingDate().plusMonths(1);
  }
}
