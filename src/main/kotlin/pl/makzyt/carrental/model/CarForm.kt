package pl.makzyt.carrental.model

import org.springframework.web.multipart.MultipartFile

class CarForm {
    var name: String = ""
    var type: String = ""
    var airCondition: Boolean = false
    var gearboxManual: Byte = 0
    var driveType: Byte = 0
    var doorNumber: Byte = 0
    var seatNumer: Byte = 0
    var imageFile: MultipartFile? = null
}