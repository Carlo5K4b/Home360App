package com.pragma.home360.commons.constans;

public final class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    //Un mensaje constante que indica que una categoría ha sido creada exitosamente.
    public static final String SAVE_CATEGORY_RESPONSE_MESSAGE = "Category created successfully.";

    //Un nombre de campo constante utilizado para la paginación.
    public static final String PAGEABLE_FIELD_NAME = "name";

    //Un mensaje constante que indica que una locación ha sido creada exitosamente.
    public static final String SAVE_LOCATION_RESPONSE_MESSAGE = "Location created successfully.";
}
