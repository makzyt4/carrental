package pl.makzyt.carrental.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import pl.makzyt.carrental.model.CarForm
import java.security.Principal

@Controller
@RequestMapping("/admin")
class AdminController {
    @GetMapping("/create/car")
    fun index(model: Model): String {
        model.addAttribute("form", CarForm())
        return "createcar"
    }
}