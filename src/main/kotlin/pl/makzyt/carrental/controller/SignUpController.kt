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
import pl.makzyt.carrental.service.AppUserService
import java.security.Principal
import javax.validation.Valid

@Controller
class SignUpController {
    @Autowired
    lateinit var service: AppUserService

    @GetMapping("/signup")
    fun register(model: Model, principal: Principal?): String {
        if (principal != null) {
            return "redirect:/"
        }

        model.addAttribute("form", RegisterForm())
        return "signup"
    }

    @PostMapping("/signup")
    fun registerUser(@Valid @ModelAttribute("form") form: RegisterForm, result: BindingResult, model: Model): String {
        val user = createUserAccount(form)

        if (!result.hasErrors()) {
             model.addAttribute("signUpSuccess", true)
        }

        return "signup"
    }

    private fun createUserAccount(form: RegisterForm): AppUser? {
        return service.registerUser(form)
    }
}