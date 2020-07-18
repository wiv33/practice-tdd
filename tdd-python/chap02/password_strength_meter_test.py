import unittest
from _password_strength import _PasswordStrength
from password_strength_meter import PasswordStrengthMeter


class MyTestCase(unittest.TestCase):
    def test_constant(self):
        self.assertEqual(_PasswordStrength().STRONG, "STRONG")

    def test_meets_all_criteria_then_strong(self):
        meter = PasswordStrengthMeter()
        result = meter.meter("ab!@#AB2")
        self.assertEqual(_PasswordStrength().STRONG, result)


if __name__ == '__main__':
    unittest.main()
