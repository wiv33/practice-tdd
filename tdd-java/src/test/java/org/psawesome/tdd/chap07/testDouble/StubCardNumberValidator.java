package org.psawesome.tdd.chap07.testDouble;

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
public class StubCardNumberValidator extends CardNumberValidator {
  private String invalidNo;
  private String theftNo;

  public StubCardNumberValidator setInvalidNo(String invalidNo) {
    this.invalidNo = invalidNo;
    return this;
  }

  public StubCardNumberValidator setTheftNo(String theftNo) {
    this.theftNo = theftNo;
    return this;
  }

  @Override
  public CardValidity validate(String cardNumber) {
    if (Objects.nonNull(invalidNo) && invalidNo.equals(cardNumber)) {
      return CardValidity.INVALID;
    }
    if (Objects.nonNull(theftNo) && theftNo.equals(cardNumber)) {
      return CardValidity.THEFT;
    }

    return CardValidity.VALID;
  }
}
