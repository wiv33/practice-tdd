from _password_strength import _PasswordStrength


class PasswordStrengthMeter:
    @staticmethod
    def meter(s):
        if s is None or len(s) < 1:
            return _PasswordStrength().INVALID
        met_counts = 0
        if len(s) >= 8:
            met_counts += 1
        if PasswordStrengthMeter.meets_containing_number_criteria(s):
            met_counts += 1
        if PasswordStrengthMeter.meets_containing_uppercase_criteria(s):
            met_counts += 1

        if met_counts == 1:
            return _PasswordStrength().WEAK

        if met_counts == 2:
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
