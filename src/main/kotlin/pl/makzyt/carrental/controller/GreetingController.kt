package pl.makzyt.carrental.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class GreetingController {
    @GetMapping("/")
    fun form(): String {
        return "index"
    }
}