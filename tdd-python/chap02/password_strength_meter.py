from _password_strength import _PasswordStrength


class PasswordStrengthMeter:
    @staticmethod
    def meter(s):
        if len(s) < 8:
            return _PasswordStrength().NORMAL
        return _PasswordStrength().STRONG
