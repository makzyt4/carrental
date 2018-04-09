package pl.makzyt.carrental.validator

import java.util.regex.Pattern
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class EmailValidator: ConstraintValidator<ValidEmail, String> {
    val EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$"

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        val pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher = pattern.matcher(value)
        return matcher.matches()
    }
}