package com.salesianostriana.dam.GermanPastorMolero.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MetrosCuadradosValidators implements ConstraintValidator<MetrosCuadradosFueraRango,Integer> {


    private int  metrosCuadrados;


    @Override
    public void initialize(MetrosCuadradosFueraRango constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        metrosCuadrados = constraintAnnotation.metrosCuadrados();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer !=null && integer < metrosCuadrados;
    }
}
