package org.psawesome.tdd.chap07.testDouble;

import java.time.LocalDateTime;
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
public class AutoDebitRegister {
  private CardNumberValidator validator; // 카드번호 유효 기능
  private AutoDebitInfoRepository repository; // 자동이체 등록 기능

  public AutoDebitRegister(CardNumberValidator validator, AutoDebitInfoRepository repository) {
    this.validator = validator;
    this.repository = repository;
  }

  public RegisterResult register(AutoDebitReq req) {
    CardValidity validity = validator.validate(req.getCardNumber());
    if (validity != CardValidity.VALID) return RegisterResult.error(validity);

    AutoDebitInfo info = repository.findOne(req.getUserId());
    if (Objects.nonNull(info)) {
      info.changeCardNumber(req.getCardNumber());
    } else {
      final AutoDebitInfo newInfo = new AutoDebitInfo(req.getUserId(), req.getCardNumber(), LocalDateTime.now());
      repository.save(newInfo);
    }
    return RegisterResult.success();
  }
}
