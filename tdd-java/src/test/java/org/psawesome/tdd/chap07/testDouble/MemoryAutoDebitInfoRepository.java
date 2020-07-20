package org.psawesome.tdd.chap07.testDouble;

import java.util.HashMap;
import java.util.Map;

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
public class MemoryAutoDebitInfoRepository implements AutoDebitInfoRepository {
  private Map<String, AutoDebitInfo> infos = new HashMap<>();

  @Override
  public void save(AutoDebitInfo info) {
    infos.put(info.getUserId(), info);
  }

  @Override
  public AutoDebitInfo findOne(String userId) {
    return infos.get(userId);
  }
}
