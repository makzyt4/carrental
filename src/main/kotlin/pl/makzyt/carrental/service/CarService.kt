package pl.makzyt.carrental.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import pl.makzyt.carrental.enums.DriveType
import pl.makzyt.carrental.enums.GearboxType
import pl.makzyt.carrental.model.Car
import pl.makzyt.carrental.model.CarForm
import pl.makzyt.carrental.repository.CarRepository
import pl.makzyt.carrental.util.PathUtil
import java.io.File
import java.util.*

@Service
class CarService {
    @Autowired
    lateinit var repository: CarRepository

    fun addCarFromForm(form: CarForm) {
        var car = Car()
        car.name = form.name
        car.type = form.type
        car.airCondition = form.airCondition
        car.doorNumber = form.doorNumber
        car.driveType = DriveType.values()[form.driveType]
        car.gearbox = GearboxType.values()[form.gearbox]
        car.seatNumber = form.seatNumber
        car.imageFilename = getImageFilename(form.imageFile)

        repository.save(car)
    }

    fun findById(id: Long): Optional<Car>? {
        return repository.findById(id)
    }

    private fun getImageFilename(file: MultipartFile?): String {
        val filename = System.currentTimeMillis().toString() + ".png"
        val newFile = File(PathUtil.uploadsPath() + "car/" + filename)
        newFile.parentFile.mkdirs()
        newFile.createNewFile()

        file?.transferTo(newFile)

        return filename
    }
}