package pl.makzyt.carrental.model

import org.springframework.web.multipart.MultipartFile

class CarForm {
    var name: String = ""
    var type: String = ""
    var airCondition: Boolean = false
    var gearbox: Int = 0
    var driveType: Int = 0
    var doorNumber: Int = 4
    var seatNumber: Int = 4
    var imageFile: MultipartFile? = null
}