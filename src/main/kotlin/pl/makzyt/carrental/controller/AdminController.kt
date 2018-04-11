package pl.makzyt.carrental.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import pl.makzyt.carrental.model.CarForm
import pl.makzyt.carrental.service.CarService
import javax.validation.Valid

@Controller
@RequestMapping("/admin")
class AdminController {
    @Autowired
    lateinit var service: CarService

    @GetMapping("/create/car")
    fun carForm(model: Model): String {
        // TODO un-hardcode types of car
        model.addAttribute("form", CarForm())
        return "createcar"
    }

    @PostMapping("/create/car")
    fun carFormPost(@Valid form: CarForm, result: BindingResult, model: Model): String {
        model.addAttribute("success", !result.hasErrors())

        service.addCarFromForm(form)

        // TODO un-hardcode types of car
        model.addAttribute("form", CarForm())
        return "createcar"
    }
}