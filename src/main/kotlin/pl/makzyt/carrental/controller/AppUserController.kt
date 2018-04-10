package pl.makzyt.carrental.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import pl.makzyt.carrental.service.AppUserService
import java.security.Principal

@Controller
class AppUserController {
    @Autowired
    lateinit var appUserService: AppUserService

    @GetMapping("/user/{id}")
    fun showUser(@PathVariable("id") id: Long, principal: Principal?, model: Model): String {
        val user = appUserService.findById(id)?.get()

        if (principal != null) {
            val currentUser = appUserService.findByEmail(principal.name)
            if (currentUser?.email.equals(user?.email)) {
                model.addAttribute("currentUser", true)
            }
        }

        model.addAttribute("user", user)

        return "user"
    }
}