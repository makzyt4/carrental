package pl.makzyt.carrental.model

import javax.persistence.Entity

@Entity
class User {
    var firstName = ""
    var lastName = ""
    var email = ""
    var passwordHash = ""
}