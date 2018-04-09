package pl.makzyt.carrental.validator

import java.lang.annotation.Documented
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UniqueEmailValidator::class])
@Documented
annotation class UniqueEmail(val message:String = "{UniqueEmail.message}",
                             val groups:Array<KClass<*>> = [],
                             val payload:Array<KClass<out Payload>> = [])
