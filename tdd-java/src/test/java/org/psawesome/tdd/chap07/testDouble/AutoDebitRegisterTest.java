package org.psawesome.tdd.chap07.testDouble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.psawesome.tdd.chap07.testDouble.CardValidity.THEFT;
import static org.psawesome.tdd.chap07.testDouble.CardValidity.VALID;

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
class AutoDebitRegisterTest {

  private AutoDebitRegister register;
  CardNumberValidator validator;
  JpaAutoDebitInfoRepository stubRepository;

  @BeforeEach
  void setUp() {
    validator = new CardNumberValidator();
    stubRepository = new JpaAutoDebitInfoRepository();
    register = new AutoDebitRegister(validator, stubRepository);
  }

  @Test
  void testValidCard() {
    // 업체에서 받은 테스트용 유효한 카드번호 사용
    AutoDebitReq req = new AutoDebitReq("ps", "1234123412341234" /*"1234" * 4*/);
    final RegisterResult result = this.register.register(req);
    assertEquals(VALID, result.getValidity());
  }

  @Test
  void testTheftCard() {
    // 업체에서 받은 도난 테스트용 카드번호 사용
    AutoDebitReq req = new AutoDebitReq("ps", "1234567812345678");
    final RegisterResult result = this.register.register(req);
    assertEquals(THEFT, result.getValidity());
  }
}