package pl.makzyt.carrental.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.security.Principal

@Controller
class IndexController {
    @GetMapping("/")
    fun index(principal: Principal?): String {
        if (principal != null) {
            println(principal.name)
        } else {
            println("none")
        }

        return "index"
    }

    @PostMapping("/")
    fun indexPost(): String {
        return "index"
    }
}