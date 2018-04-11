package pl.makzyt.carrental.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import pl.makzyt.carrental.model.Car
import pl.makzyt.carrental.service.CarService

@Controller
class CarController {
    @Autowired
    lateinit var service: CarService

    @GetMapping("/car/{id}")
    fun showCar(@PathVariable("id") id: Long, model: Model): String {
        val car: Car? = service.findById(id)?.get()

        model.addAttribute("car", car)

        return "carinfo"
    }
}