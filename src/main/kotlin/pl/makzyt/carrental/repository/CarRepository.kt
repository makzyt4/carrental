package pl.makzyt.carrental.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.makzyt.carrental.model.Car
import java.util.*

@Repository
interface CarRepository : JpaRepository<Car, Long> {
    override fun findById(id: Long): Optional<Car>?
}