package pl.makzyt.carrental.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import pl.makzyt.carrental.model.LoginForm
import java.security.Principal

@Controller
class LoginController {
    @GetMapping("/login")
    fun login(model: Model, principal: Principal?): String {
        if (principal != null) {
            return "redirect:/"
        }

        model.addAttribute("form", LoginForm())
        return "login"
    }

    @PostMapping("/login")
    fun loginError(model: Model): String {
        model.addAttribute("form", LoginForm())
        model.addAttribute("loginError", true)
        return "login"
    }

    @PostMapping("/logout")
    fun logout(): String {
        return "logout"
    }
}