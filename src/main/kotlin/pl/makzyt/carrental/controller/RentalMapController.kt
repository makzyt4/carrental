package pl.makzyt.carrental.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RentalMapController {
    @GetMapping("/map")
    fun map(): String {
        return "map"
    }
}