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

  public StubCardNumberValidator setInvalidNo(String invalidNo) {
    this.invalidNo = invalidNo;
    return this;
  }

  @Override
  public CardValidity validate(String cardNumber) {
    if (Objects.nonNull(invalidNo) && invalidNo.equals(cardNumber)) {
      return CardValidity.INVALID;
    }
    return CardValidity.VALID;
  }
}
