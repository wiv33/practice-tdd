package org.psawesome.tdd.chap03._00_expiry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
 * @since 20. 7. 18. Saturday
 */
public class ExpiryDateCalculatorTest {
/*
  구현하기 쉬운 것부터 먼저 테스트
  예외 상황을 먼저 테스트
*/


  @Test
  @DisplayName("첫 번째 테스트 - input 납부금, 납부일, output 서비스 만료일")
  void test_만원_납부하면_한달_뒤가_만료일() {
    LocalDate billingDate = LocalDate.of(2020, 7, 1);
    int payAmount = 10_000;
    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);
    assertEquals(LocalDate.of(2020, 8, 1), expiryDate);

    // 예를 추가하면서 구현을 일반화
    LocalDate billingDate2 = LocalDate.of(2020, 7, 6);
    int payAmount2 = 20_000;

    ExpiryDateCalculator cal2 = new ExpiryDateCalculator();
    LocalDate expiryDate2 = cal2.calculateExpiryDate(billingDate2, payAmount2);
    assertEquals(LocalDate.of(2020, 8, 6), expiryDate2);

  }



}
