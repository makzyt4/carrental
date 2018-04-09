package pl.makzyt.carrental.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class IndexController {
    @GetMapping("/")
    @PostMapping("/")
    fun index(): String {
        return "index"
    }
}