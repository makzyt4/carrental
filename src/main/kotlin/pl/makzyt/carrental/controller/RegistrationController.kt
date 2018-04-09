package pl.makzyt.carrental.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import pl.makzyt.carrental.model.RegisterForm
import pl.makzyt.carrental.model.AppUser
import pl.makzyt.carrental.service.UserService
import javax.validation.Valid

@Controller
class RegistrationController {
    @Autowired
    lateinit var service: UserService

    @GetMapping("/register")
    fun register(model: Model): String {
        model.addAttribute("form", RegisterForm())
        return "register"
    }

    @PostMapping("/register")
    fun registerUser(@Valid @ModelAttribute("form") form: RegisterForm, result: BindingResult, model: Model): String {
        val user = createUserAccount(form)

        if (result.hasErrors()) {
            return "register"
        }

        return "registersuccess"
    }

    @PostMapping("/register/success")
    fun success(): String {
        return "registersuccess"
    }

    private fun createUserAccount(form: RegisterForm): AppUser? {
        return service.registerUser(form)
    }
}