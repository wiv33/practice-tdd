package org.psawesome.tdd.chap07.testDouble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.psawesome.tdd.chap07.testDouble.CardValidity.INVALID;
import static org.psawesome.tdd.chap07.testDouble.CardValidity.THEFT;

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
public class AutoDebitRegister_Stub_Test {
  private AutoDebitRegister register;
  private StubCardNumberValidator stubValidator;
  private StubAutoDebitInfoRepository stubRepository;

  @BeforeEach
  void setUp() {
    stubValidator = new StubCardNumberValidator();
    stubRepository = new StubAutoDebitInfoRepository();
    register = new AutoDebitRegister(stubValidator, stubRepository);
  }

  @Test
  void testInvalidCard() {
    stubValidator.setInvalidNo("111122223333");

    final AutoDebitReq req = new AutoDebitReq("ps1", "111122223333");
    final RegisterResult result = this.register.register(req);
    assertEquals(INVALID, result.getValidity());
//    assertEquals(ERROR, result.getValidity());
  }

  @Test
  void testTheftCard() {
    stubValidator.setTheftNo("1234567812345678");

    final AutoDebitReq req = new AutoDebitReq("ps2", "1234567812345678");
    final RegisterResult result = this.register.register(req);
    assertEquals(THEFT, result.getValidity());

  }
}
