package pl.makzyt.carrental.model

import javax.persistence.*

@Entity
@Table(name = "app_user")
class AppUser {
    var firstName: String = ""
    var lastName: String = ""
    @Id
    var email: String = ""
    var password: String = ""
    var roles: Array<String> = arrayOf()
}