package pl.makzyt.carrental.model

import javax.persistence.*

@Entity
@Table(name = "app_user")
class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var firstName: String = ""
    var lastName: String = ""
    var email: String = ""
    var password: String = ""
    var roles: Array<String> = arrayOf()
}