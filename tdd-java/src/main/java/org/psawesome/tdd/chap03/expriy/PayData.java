package org.psawesome.tdd.chap03.expriy;

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
 * @since 20. 7. 19. Sunday
 */
public class PayData {

  private LocalDate firstBillingDate;
  private LocalDate billingDate;
  private int payAmount;

  private PayData() {
  }

  public PayData(LocalDate firstBillingDate, LocalDate billingDate, int payAmount) {
    this.firstBillingDate = firstBillingDate;
    this.billingDate = billingDate;
    this.payAmount = payAmount;
  }

  public LocalDate getFirstBillingDate() {
    return firstBillingDate;
  }

  public LocalDate getBillingDate() {
    return billingDate;
  }

  public int getPayAmount() {
    return payAmount;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private final PayData data = new PayData();

    public Builder billingDate(LocalDate billingDate) {
      data.billingDate = billingDate;
      return this;
    }

    public Builder payAmount(int payAmount) {
      data.payAmount = payAmount;
      return this;
    }

    public PayData build() {
      return data;
    }

    public Builder firstBillingDate(LocalDate firstBillingDate) {
      data.firstBillingDate = firstBillingDate;
      return this;
    }
  }

}
