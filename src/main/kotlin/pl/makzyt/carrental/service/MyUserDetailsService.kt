package pl.makzyt.carrental.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import pl.makzyt.carrental.repository.AppUserRepository

@Service
@Transactional
open class MyUserDetailsService : UserDetailsService {
    @Autowired
    lateinit var appUserRepository: AppUserRepository

    override fun loadUserByUsername(email: String): UserDetails {
        val user = appUserRepository.findByEmail(email.toLowerCase()) ?: throw UsernameNotFoundException("User not found: $email")

        val builder = User.withUsername(email)
        builder.password(user.password)
        builder.roles(*user.roles)
        return builder.build()
    }
}