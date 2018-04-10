package pl.makzyt.carrental.validator

import org.springframework.beans.factory.annotation.Autowired
import pl.makzyt.carrental.service.AppUserService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class UniqueEmailValidator : ConstraintValidator<ValidEmail, String> {
    @Autowired
    lateinit var appUserService: AppUserService

    override fun isValid(value: String, context: ConstraintValidatorContext?): Boolean {
        return !appUserService.emailExists(value)
    }
}