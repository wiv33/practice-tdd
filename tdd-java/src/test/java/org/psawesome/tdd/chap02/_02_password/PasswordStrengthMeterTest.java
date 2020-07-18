package org.psawesome.tdd.chap02._02_password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ps [https://github.com/wiv33/practice-tdd]
 * @role 길이사 8글자 이상,
 * 0부터 9 사이의 숫자를 포함,
 * 대문자 포함
 * <p>
 * 세 규칙을 모두 충족하면 암호는 강함.
 * 두 규칙을 충족하면 암호는 보통.
 * 1개 이하의 규칙을 충족하면 암호는 약함.
 * @responsibility
 * @cooperate {
 * input:
 * output:
 * }
 * @see
 * @since 20. 7. 17. Friday
 */
public class PasswordStrengthMeterTest {
  PasswordStrengthMeter meter;

  @BeforeEach
  void setUp() {
    meter = new PasswordStrengthMeter();
  }

  @Test
  @DisplayName("첫 번째 - 모든 암호를 만족할 때 Strong")
  void meetsAllCriteria_Then_Strong() {
    assertStrength("ab12!@AB", PasswordStrength.STRONG);
    assertStrength("abc1!Add", PasswordStrength.STRONG);
  }


  @Test
  @DisplayName("두 번째 - 길이가 부족해서 Normal")
  void meetsOtherCriteria_expect_for_Length_Then_Normal() {
    assertStrength("ab12!@A", PasswordStrength.NORMAL);
    assertStrength("Ab12!c", PasswordStrength.NORMAL);
  }

  @Test
  @DisplayName("세 번째 - 숫자는 없고 나머지는 만족해서 Normal")
  void testMeetsOtherCriteria_expect_for_number_Then_Normal() {
    assertStrength("ab!@Abqwer", PasswordStrength.NORMAL);
  }

  @Test
  @DisplayName("네 번째 - 대문자를 포함하지 ㅏㅇㄶ고 나머지 조건을 충족하는 경우")
  void testMeetsOtherCriteria_expect_for_Uppercase_Then_Normal() {
    assertStrength("ab12!@df", PasswordStrength.NORMAL);
  }

  @Test
  @DisplayName("다섯 번째 - null, empty 입력 시 INVALID")
  void testNullInput_Then_Invalid() {
    assertStrength(null, PasswordStrength.INVALID);
    assertStrength("", PasswordStrength.INVALID);
  }

  @Test
  @DisplayName("여섯 번째 - 길이가 8글자 이상인 조건만 충족하는 경우")
  void test() {
    assertStrength("abdefegi", PasswordStrength.WEAK);
  }

  @Test
  @DisplayName("일곱 번째 - 숫자로만 작성된 경우")
  void testOnlyNumberCriteria_Then_weak() {
    assertStrength("12345", PasswordStrength.WEAK);
  }

  @Test
  @DisplayName("여덟 번째 - 대문자만 작성된 경우")
  void testMeetOnlyUppercaseCriteria_Then_Weak() {
    assertStrength("ABSTREW", PasswordStrength.WEAK);
  }

  @Test
  @DisplayName("아홉 번째 - 아무 조건도 충족하지 않은 경우")
  void testMeetsNoCriteria_Then_Weak() {
    assertStrength("abc", PasswordStrength.WEAK);
  }

  private void assertStrength(String s, PasswordStrength strong) {
    var result = meter.meter(s);
    assertEquals(strong, result);
  }
}
