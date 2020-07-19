from _password_strength import _PasswordStrength


class PasswordStrengthMeter:
    @staticmethod
    def meter(s):
        if len(s) < 8:
            return _PasswordStrength().NORMAL

        contains_num = PasswordStrengthMeter.meets_containing_number_criteria(s)

        if not contains_num:
            return _PasswordStrength().NORMAL

        return _PasswordStrength().STRONG

    @staticmethod
    def meets_containing_number_criteria(s):
        contains_num = False
        for ch in s:
            if str.isdigit(ch):
                contains_num = True
                break
        return contains_num
