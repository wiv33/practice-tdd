import unittest
from _password_strength import _PasswordStrength
from password_strength_meter import PasswordStrengthMeter


class PasswordStrengthMeterTest(unittest.TestCase):
    def setUp(self) -> None:
        self.meter = PasswordStrengthMeter()

    def test_constant(self):
        self.assertEqual(_PasswordStrength().STRONG, "STRONG")

    # 첫 번째 테스트 - 전부 만족
    def test_meets_all_criteria_then_strong(self):
        result = self.meter.meter("ab!@#AB2")
        self.assertEqual(_PasswordStrength().STRONG, result)

        result2 = self.meter.meter("abc12@3D")
        self.assertEqual(_PasswordStrength().STRONG, result2)

    # 두 번째 테스트 - 암호 조건 중 2개를 충족하므로 NORMAL
    def test_meets_other_criteria_expect_for_length_then_normal(self):
        result = self.meter.meter("ab12!@A")
        self.assertEqual(_PasswordStrength().NORMAL, result)

        result2 = self.meter.meter("Ab12!c")
        self.assertEqual(_PasswordStrength().NORMAL, result2)

    # 세 번째 테스트 - 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
    def test_meets_other_criteria_expect_for_number_then_normal(self):
        result = self.meter.meter("ab!@ABqw")
        self.assertEqual(_PasswordStrength().NORMAL, result)


if __name__ == '__main__':
    unittest.main()
