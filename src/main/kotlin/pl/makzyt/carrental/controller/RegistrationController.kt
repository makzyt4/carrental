package pl.makzyt.carrental.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import pl.makzyt.carrental.model.LoginForm

@Controller
class RegistrationController {
    @GetMapping("/register")
    fun register(model: Model): String {
        model.addAttribute("form", LoginForm())
        return "register"
    }
}