package org.psawesome.tdd.chap07.testDouble;

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
public class AutoDebitReq {
  private String userId;
  private String cardNumber;

  public AutoDebitReq(String userId, String cardNumber) {
    this.userId = userId;
    this.cardNumber = cardNumber;
  }

  public String getUserId() {
    return userId;
  }

  public String getCardNumber() {
    return cardNumber;
  }
}

