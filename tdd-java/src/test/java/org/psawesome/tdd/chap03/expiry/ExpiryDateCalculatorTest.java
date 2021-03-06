package org.psawesome.tdd.chap03.expiry;

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
    assertExpiryDate(
            org.psawesome.tdd.chap03.expriy.PayData.builder()
                    .billingDate(LocalDate.of(2020, 7, 1))
                    .payAmount(10_000)
                    .build(),
            LocalDate.of(2020, 8, 1)
    );
    // 예를 추가하면서 구현을 일반화
    assertExpiryDate(org.psawesome.tdd.chap03.expriy.PayData.builder()
                    .billingDate(LocalDate.of(2020, 7, 6))
                    .payAmount(10_000)
                    .build(),
            LocalDate.of(2020, 8, 6)
    );
  }

  @Test
  @DisplayName("두 번째 테스트 - 예외 상황")
  void 납부일과_한달_뒤_일자가_같지_않음() {
    assertExpiryDate(org.psawesome.tdd.chap03.expriy.PayData.builder()
                    .billingDate(LocalDate.of(2019, 1, 31))
                    .payAmount(10_000)
                    .build(),
            LocalDate.of(2019, 2, 28)
    );
    assertExpiryDate(org.psawesome.tdd.chap03.expriy.PayData.builder()
                    .billingDate(LocalDate.of(2019, 5, 31))
                    .payAmount(10_000)
                    .build(),
            LocalDate.of(2019, 6, 30)
    );

    assertExpiryDate(
            org.psawesome.tdd.chap03.expriy.PayData.builder().billingDate(LocalDate.of(2020, 1, 31))
                    .payAmount(10_000)
                    .build(),
            LocalDate.of(2020, 2, 29)
    );
  }

  @Test
  @DisplayName("세 번째 테스트 - 예외 상황 테스트 추가 (서비스일 연장하기)")
  void test_첫_납부일과_만료일_일자가_다를_때_만원_납부() {
    org.psawesome.tdd.chap03.expriy.PayData payData = org.psawesome.tdd.chap03.expriy.PayData.builder()
            .firstBillingDate(LocalDate.of(2019, 1, 31))
            .billingDate(LocalDate.of(2019, 2, 28))
            .payAmount(10_000)
            .build();
    assertExpiryDate(payData, LocalDate.of(2019, 3, 31));


    org.psawesome.tdd.chap03.expriy.PayData payData2 = org.psawesome.tdd.chap03.expriy.PayData.builder()
            .firstBillingDate(LocalDate.of(2019, 1, 30))
            .billingDate(LocalDate.of(2019, 2, 28))
            .payAmount(10_000)
            .build();
    assertExpiryDate(payData2, LocalDate.of(2019, 3, 30));

    org.psawesome.tdd.chap03.expriy.PayData payData3 = org.psawesome.tdd.chap03.expriy.PayData.builder()
            .firstBillingDate(LocalDate.of(2019, 5, 31))
            .billingDate(LocalDate.of(2019, 6, 30))
            .payAmount(10_000)
            .build();

    assertExpiryDate(payData3, LocalDate.of(2019, 7, 31));
  }

  @Test
  @DisplayName("네 번째 테스트 - 기능 추가로 돈에 비례한 만료일 처리")
  void 이만원_이상_납부하면_비례해서_만료일_계산() {
    // 2개월
    assertExpiryDate(org.psawesome.tdd.chap03.expriy.PayData.builder()
                    .billingDate(LocalDate.of(2019, 3, 1))
                    .payAmount(20_000)
                    .build(),
            LocalDate.of(2019, 5, 1));

    // 3개월
    assertExpiryDate(org.psawesome.tdd.chap03.expriy.PayData.builder()
                    .billingDate(LocalDate.of(2019, 3, 1))
                    .payAmount(30_000)
                    .build(),
            LocalDate.of(2019, 6, 1));
  }

  @Test
  @DisplayName("다섯 번째 테스트 - 예외 테스트 추가")
  void test_첫_납부일과_만료일_일자가_다를_때_이만원_이상_납부() {
    assertExpiryDate(org.psawesome.tdd.chap03.expriy.PayData.builder()
                    .firstBillingDate(LocalDate.of(2019, 1, 31))
                    .billingDate(LocalDate.of(2019, 2, 28))
                    .payAmount(20_000)
                    .build(),
            LocalDate.of(2019, 4, 30));

    assertExpiryDate(org.psawesome.tdd.chap03.expriy.PayData.builder()
                    .firstBillingDate(LocalDate.of(2019, 1, 31))
                    .billingDate(LocalDate.of(2019, 2, 28))
                    .payAmount(40_000)
                    .build(),
            LocalDate.of(2019, 6, 30));

    assertExpiryDate(org.psawesome.tdd.chap03.expriy.PayData.builder()
                    .firstBillingDate(LocalDate.of(2019, 3, 31))
                    .billingDate(LocalDate.of(2019, 4, 30))
                    .payAmount(30_000)
                    .build(),
            LocalDate.of(2019, 7, 31));

  }

  @Test
  @DisplayName("여섯 번째 테스트 - [기능 추가] 10만원 납부하면 1년(12개월) 서비스 제공")
  void test_십만원_납부하면_1년_제공() {
    assertExpiryDate(org.psawesome.tdd.chap03.expriy.PayData.builder()
                    .billingDate(LocalDate.of(2019, 1, 28))
                    .payAmount(100_000).build(),
            LocalDate.of(2020, 1, 28));
  }

  private void assertExpiryDate(org.psawesome.tdd.chap03.expriy.PayData payData, LocalDate expectedExpiryDate) {
    var cal = new org.psawesome.tdd.chap03.expriy.ExpiryDateCalculator();
    LocalDate expiryDate = cal.calculateExpiryDate(payData);
    assertEquals(expectedExpiryDate, expiryDate);
  }

}
