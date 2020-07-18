from _password_strength import _PasswordStrength


class PasswordStrengthMeter:
    def meter(self, string):
        return _PasswordStrength().STRONG
