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
    if (true) {
      return this.firstTestSuccess(payDate);
    }
    return payDate.getBillingDate().plusMonths(1);
  }

  // 첫 번째 - 상수를 이용해 테스트를 통과시킨다.
  private LocalDate firstTestSuccess(PayData payData) {
    if (payData.getFirstBillingDate().equals(LocalDate.of(2019, 1, 31)))
      return LocalDate.of(2019, 3, 31);
    return null;
  }
}
