def constant(f):
    def fset(self, value):
        raise TypeError

    def fget(self):
        return f(self)

    return property(fget, fset)


class _PasswordStrength:
    @constant
    def STRONG(self):
        return "STRONG"

    @constant
    def NORMAL(self):
        return "NORMAL"

    @constant
    def INVALID(self):
        return "INVALID"
