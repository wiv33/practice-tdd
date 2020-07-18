from _password_strength import _PasswordStrength


class PasswordStrengthMeter:
    @staticmethod
    def meter(s):
        if len(s) < 8:
            return _PasswordStrength().NORMAL

        contains_num = False
        for ch in s:
            if str.isdigit(ch):
                contains_num = True
                break

        if not contains_num:
            return _PasswordStrength().NORMAL

        return _PasswordStrength().STRONG
