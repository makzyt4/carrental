package pl.makzyt.carrental.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.makzyt.carrental.model.AppUser
import java.util.*

@Repository
interface UserRepository : JpaRepository<AppUser, Long> {
    override fun findById(id: Long): Optional<AppUser>?
    fun findByEmail(email: String): AppUser?
}