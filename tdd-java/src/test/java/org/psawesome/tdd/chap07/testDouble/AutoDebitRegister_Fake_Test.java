package org.psawesome.tdd.chap07.testDouble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ps [https://github.com/wiv33/practice-tdd]
 * @role
 * @responsibility
 * @cooperate {
 * input:
 * output:
 * }
 * @see
 * @since 20. 7. 20. Monday
 */
public class AutoDebitRegister_Fake_Test {
  private AutoDebitRegister register;
  private StubCardNumberValidator validator;
  private MemoryAutoDebitInfoRepository repository;

  @BeforeEach
  void setUp() {
    validator = new StubCardNumberValidator();
    repository = new MemoryAutoDebitInfoRepository();
    register = new AutoDebitRegister(validator, repository);
  }

  @Test
  void testAlreadyRegistered_Info_Updated() {
    repository.save(new AutoDebitInfo("ps2", "1111222233334444", LocalDateTime.now()));

    final AutoDebitReq req = new AutoDebitReq("ps2", "1234123412341234");
    final RegisterResult result = this.register.register(req);
    final AutoDebitInfo saved = repository.findOne("ps2");

    assertEquals(CardValidity.VALID, result.getValidity());
    assertEquals("1234123412341234", saved.getCardNumber());
  }
}
