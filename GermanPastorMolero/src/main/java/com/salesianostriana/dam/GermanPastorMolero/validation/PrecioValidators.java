package com.salesianostriana.dam.GermanPastorMolero.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrecioValidators implements ConstraintValidator<PrecioFueraDeRango,Integer> {


    private int precio;

    @Override
    public void initialize(PrecioFueraDeRango constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        precio = constraintAnnotation.precio();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer != null && integer<precio;
    }
}
