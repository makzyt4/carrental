package pl.makzyt.carrental.model

import pl.makzyt.carrental.validator.UniqueEmail
import pl.makzyt.carrental.validator.ValidEmail
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class RegisterForm {
    @NotNull
    @NotEmpty(message = "{validation.emptyData}")
    var firstName = ""
    @NotNull
    @NotEmpty(message = "{validation.emptyData}")
    var lastName = ""
    @ValidEmail(message = "{validation.incorrectEmail}")
    @NotNull
    @NotEmpty(message = "{validation.emptyData}")
    @UniqueEmail(message = "{validation.emailExists}")
    var email = ""
    @NotNull
    @NotEmpty(message = "{validation.emptyData}")
    var password = ""
}