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
public interface AutoDebitInfoRepository {
  void save(AutoDebitInfo info);
  AutoDebitInfo findOne(String userId);
}
