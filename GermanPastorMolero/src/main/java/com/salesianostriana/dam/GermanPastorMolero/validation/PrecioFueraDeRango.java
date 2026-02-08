package com.salesianostriana.dam.GermanPastorMolero.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD})
@Constraint(validatedBy = PrecioValidators.class)
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface PrecioFueraDeRango {

    String message() default "precio fuera de rango";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

    int precio();
}
