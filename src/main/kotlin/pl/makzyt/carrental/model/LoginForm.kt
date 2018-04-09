package pl.makzyt.carrental.model

import pl.makzyt.carrental.validator.ValidEmail
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class LoginForm {
    @NotNull
    @NotEmpty(message = "{validation.emptyData}")
    var firstName = ""
    @NotNull
    @NotEmpty(message = "{validation.emptyData}")
    var lastName = ""
    @ValidEmail(message = "{validation.incorrectEmail}")
    @NotNull
    @NotEmpty(message = "{validation.emptyData}")
    var email = ""
    @NotNull
    @NotEmpty(message = "{validation.emptyData}")
    var password = ""
}