package org.psawesome.tdd.chap03.expriy;

import java.time.LocalDate;
import java.time.YearMonth;
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
 * @since 20. 7. 19. Sunday
 */
public class ExpiryDateCalculator {
  int addedMonths = 1;

  public LocalDate calculateExpiryDate(PayData payData) {
    this.addedMonths = payData.getPayAmount() == 100_000 ?
            12 : payData.getPayAmount() / 10_000;

    if (Objects.nonNull(payData.getFirstBillingDate())) {
      return expiryDateUsingFirstBillingDate(payData, addedMonths);
    } else {
      return payData.getBillingDate().plusMonths(addedMonths);
    }
  }

  private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
    LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);

    final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
    if (isSameDayOfMonth(dayOfFirstBilling, candidateExp)) {
      final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
      if (dayLenOfCandiMon < dayOfFirstBilling) {
        return candidateExp.withDayOfMonth(dayLenOfCandiMon);
      }
      return candidateExp.withDayOfMonth(dayOfFirstBilling);
    } else {
      return candidateExp;
    }
  }

  private int lastDayOfMonth(LocalDate date) {
    return YearMonth.from(date).lengthOfMonth();
  }

  private boolean isSameDayOfMonth(int date1, LocalDate date2) {
    return date1 != date2.getDayOfMonth();
  }
}
