package pl.makzyt.carrental.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import pl.makzyt.carrental.model.RegisterForm
import pl.makzyt.carrental.model.AppUser
import pl.makzyt.carrental.repository.UserRepository

@Service
class UserService {
    @Autowired
    lateinit var repository: UserRepository

    fun registerUser(form: RegisterForm): AppUser? {
        if (emailExists(form.email)) {
            return null
        }
        val user = AppUser()
        user.firstName = form.firstName
        user.lastName = form.lastName
        user.email = form.email
        user.password = BCryptPasswordEncoder().encode(form.password)
        repository.save(user)
        return user
    }

    fun emailExists(email: String): Boolean {
        val user = repository.findByEmail(email)
        return user != null
    }
}