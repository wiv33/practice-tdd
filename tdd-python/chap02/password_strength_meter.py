from _password_strength import _PasswordStrength


class PasswordStrengthMeter:
    @staticmethod
    def meter(s):
        if s is None or len(s) < 1:
            return _PasswordStrength().INVALID

        length_enough = len(s) >= 8
        contains_num = PasswordStrengthMeter.meets_containing_number_criteria(s)
        contains_upp = PasswordStrengthMeter.meets_containing_uppercase_criteria(s)

        if length_enough and not contains_num and not contains_upp:
            return _PasswordStrength().WEAK
        if not length_enough and contains_num and not contains_upp:
            return _PasswordStrength().WEAK
        if not length_enough and not contains_num and contains_upp:
            return _PasswordStrength().WEAK

        if not length_enough:
            return _PasswordStrength().NORMAL
        if not contains_num:
            return _PasswordStrength().NORMAL
        if not contains_upp:
            return _PasswordStrength().NORMAL

        return _PasswordStrength().STRONG

    @staticmethod
    def meets_containing_uppercase_criteria(s):
        contains_upp = False
        for ch in s:
            if str.isupper(ch):
                contains_upp = True
                break
        return contains_upp

    @staticmethod
    def meets_containing_number_criteria(s):
        contains_num = False
        for ch in s:
            if str.isdigit(ch):
                contains_num = True
                break
        return contains_num
