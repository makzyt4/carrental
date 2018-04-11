package pl.makzyt.carrental.model

import pl.makzyt.carrental.enums.DriveType
import pl.makzyt.carrental.enums.GearboxType
import javax.persistence.*

@Entity
@Table(name = "car")
class Car {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var name: String = ""
    var type: String = ""
    var imagePath: String = ""
    var airCondition: Boolean = false
    var gearbox: GearboxType = GearboxType.MANUAL
    var driveType: DriveType = DriveType.PETROL
    var doorNumber: Int = 0
    var seatNumer: Int = 0
}