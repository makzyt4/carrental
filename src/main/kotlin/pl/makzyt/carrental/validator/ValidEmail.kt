package pl.makzyt.carrental.validator

import java.lang.annotation.Documented
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [EmailValidator::class])
@Documented
annotation class ValidEmail(val message:String = "{ValidEmail.message}",
                              val groups:Array<KClass<*>> = [],
                              val payload:Array<KClass<out Payload>> = [])
