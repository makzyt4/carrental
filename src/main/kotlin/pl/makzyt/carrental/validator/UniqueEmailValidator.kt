package pl.makzyt.carrental.validator

import org.springframework.beans.factory.annotation.Autowired
import pl.makzyt.carrental.service.UserService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class UniqueEmailValidator : ConstraintValidator<ValidEmail, String> {
    @Autowired
    lateinit var userService: UserService

    override fun isValid(value: String, context: ConstraintValidatorContext?): Boolean {
        return !userService.emailExists(value)
    }
}