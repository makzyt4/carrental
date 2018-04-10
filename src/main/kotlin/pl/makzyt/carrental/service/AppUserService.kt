package pl.makzyt.carrental.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import pl.makzyt.carrental.model.RegisterForm
import pl.makzyt.carrental.model.AppUser
import pl.makzyt.carrental.repository.AppUserRepository
import java.util.*

@Service
class AppUserService {
    @Autowired
    lateinit var repository: AppUserRepository

    fun registerUser(form: RegisterForm): AppUser? {
        if (emailExists(form.email)) {
            return null
        }
        val user = AppUser()
        user.firstName = form.firstName
        user.lastName = form.lastName
        user.email = form.email
        user.password = BCryptPasswordEncoder().encode(form.password)
        user.roles = arrayOf("USER")
        repository.save(user)
        return user
    }

    fun findById(id: Long): Optional<AppUser>? {
        return repository.findById(id)
    }

    fun findByEmail(email: String): AppUser? {
        return repository.findByEmail(email)
    }

    fun emailExists(email: String): Boolean {
        val user = repository.findByEmail(email)
        return user != null
    }
}