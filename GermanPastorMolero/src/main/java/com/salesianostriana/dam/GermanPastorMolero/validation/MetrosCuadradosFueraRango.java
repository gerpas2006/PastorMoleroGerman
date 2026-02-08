package com.salesianostriana.dam.GermanPastorMolero.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD})
@Constraint(validatedBy = MetrosCuadradosValidators.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MetrosCuadradosFueraRango {

    String message() default "metrosCuadrados fuera de rango";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default{};

    int metrosCuadrados();


}
