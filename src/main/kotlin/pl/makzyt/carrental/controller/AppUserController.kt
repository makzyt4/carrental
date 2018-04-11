package pl.makzyt.carrental.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import pl.makzyt.carrental.service.AppUserService
import pl.makzyt.carrental.util.PathUtil
import java.security.Principal

@Controller
class AppUserController {
    @Autowired
    lateinit var appUserService: AppUserService

    @GetMapping("/user/account")
    fun showUser(principal: Principal?, model: Model): String {
        if (principal != null) {
            val user = appUserService.findByEmail(principal.name)
            model.addAttribute("user", user)
        }

        return "useraccount"
    }
}