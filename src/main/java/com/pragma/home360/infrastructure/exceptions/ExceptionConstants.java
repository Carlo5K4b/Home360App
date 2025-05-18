package com.pragma.home360.infrastructure.exceptions;

//Declara una clase final que no puede ser extendida.
public final class ExceptionConstants {
    // Constructor privado para evitar la instanciación de la clase.
    private ExceptionConstants(){}

    // indica que el nombre de la categoría no puede exceder los 50 caracteres.
    public static final String NAME_MAX_SIZE_MESSAGE = "The name of the category can not exceed 50 characters";
    // indica que la descripción de la categoría no puede exceder los 90
    public static final String DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the category can not exceed 90 characters";
    //indica que la categoría ya existe.
    public static final String CATEGORY_EXISTS_EXCEPTION = "The category already exists";
}
