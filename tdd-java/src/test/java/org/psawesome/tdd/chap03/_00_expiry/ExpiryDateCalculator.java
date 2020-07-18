package org.psawesome.tdd.chap03._00_expiry;

import java.time.LocalDate;
import java.util.Objects;

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
  int addedMonths = 1;

  public LocalDate calculateExpiryDate(PayData payData) {

    if (Objects.nonNull(payData.getFirstBillingDate())) {
//      return this.firstTestSuccess(payData);
      LocalDate candidateExp = secondTestSuccess(payData);
      if (candidateExp != null) return candidateExp;
    }
    return payData.getBillingDate().plusMonths(addedMonths);
  }

  // 두 번째 - 상수를 유연한 로직으로 처리
  private LocalDate secondTestSuccess(PayData payData) {
    // V - 후보 만료일 구함
    LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);

    // V - 첫 납부일의 일자와 후보 만료일의 일자가 다르면
    if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
      // V - 첫 번째 납부일의 만료일로 적용해서 반환한다.
      return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
    }

    return null;
  }

  // 첫 번째 - 상수를 이용해 테스트를 통과시킨다.
  private LocalDate firstTestSuccess(PayData payData) {
    if (payData.getFirstBillingDate().equals(LocalDate.of(2019, 1, 31)))
      return LocalDate.of(2019, 3, 31);
    return null;
  }
}
