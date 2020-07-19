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
        self.assertStrength("ab!@#AB2", _PasswordStrength().STRONG)
        self.assertStrength("abc12@3D", _PasswordStrength().STRONG)

    # 두 번째 테스트 - 암호 조건 중 2개를 충족하므로 NORMAL
    def test_meets_other_criteria_expect_for_length_then_normal(self):
        self.assertStrength("ab12!@A", _PasswordStrength().NORMAL)
        self.assertStrength("Ab12!c", _PasswordStrength().NORMAL)

    # 세 번째 테스트 - 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
    def test_meets_other_criteria_expect_for_number_then_normal(self):
        self.assertStrength("ab!@ABqw", _PasswordStrength().NORMAL)

    def test_null_input_then_invalid(self):
        self.assertStrength(None, _PasswordStrength().INVALID)

    def test_empty_input_then_invalid(self):
        self.assertStrength("", _PasswordStrength().INVALID)

    def assertStrength(self, password, expected):
        actual = self.meter.meter(password)
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
