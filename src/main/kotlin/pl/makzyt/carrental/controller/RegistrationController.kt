package pl.makzyt.carrental.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import pl.makzyt.carrental.model.LoginForm
import javax.validation.Valid

@Controller
class RegistrationController {
    @GetMapping("/register")
    fun register(model: Model): String {
        model.addAttribute("form", LoginForm())
        return "register"
    }

    @PostMapping("/register")
    fun registerUser(@Valid @ModelAttribute("form") form: LoginForm, result: BindingResult, model: Model): String {
        if (result.hasErrors()) {
            return "register"
        }

        return "index"
    }
}