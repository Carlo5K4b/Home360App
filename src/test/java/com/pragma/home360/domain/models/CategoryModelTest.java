package com.pragma.home360.domain.models;


import com.pragma.home360.domain.exceptions.DescriptionMaxSizeExceededException;
import com.pragma.home360.domain.exceptions.NameMaxSizeExceededException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryModelTest {

    @Test
    void testConstructorValidData() {
        CategoryModel category = new CategoryModel(1L, "Valid Name", "Valid Description");
        assertEquals(1L, category.getId());
        assertEquals("Valid Name", category.getName());
        assertEquals("Valid Description", category.getDescription());
    }

    @Test
    void testConstructorNameExceedsLimit() {
        String longName = "A".repeat(51); // Nombre con 51 caracteres
        Exception exception = assertThrows(NameMaxSizeExceededException.class, () ->
                new CategoryModel(1L, longName, "Valid Description")
        );
        assertEquals("Name exceeds maximum size of 50 characters", exception.getMessage());
    }

    @Test
    void testConstructorDescriptionExceedsLimit() {
        String longDescription = "A".repeat(91); // Descripción con 91 caracteres
        Exception exception = assertThrows(DescriptionMaxSizeExceededException.class, () ->
                new CategoryModel(1L, "Valid Name", longDescription)
        );
        assertEquals("Description exceeds maximum size of 90 characters", exception.getMessage());
    }

    @Test
    void testSetNameValid() {
        CategoryModel category = new CategoryModel(1L, "Valid Name", "Valid Description");
        category.setName("New Valid Name");
        assertEquals("New Valid Name", category.getName());
    }

    @Test
    void testSetNameExceedsLimit() {
        CategoryModel category = new CategoryModel(1L, "Valid Name", "Valid Description");
        String longName = "A".repeat(51); // Nombre con 51 caracteres
        Exception exception = assertThrows(NameMaxSizeExceededException.class, () ->
                category.setName(longName)
        );
        assertEquals("Name exceeds maximum size of 50 characters", exception.getMessage());
    }

    @Test
    void testSetDescriptionValid() {
        CategoryModel category = new CategoryModel(1L, "Valid Name", "Valid Description");
        category.setDescription("New Valid Description");
        assertEquals("New Valid Description", category.getDescription());
    }

 @Test
    void testSetDescriptionExceedsLimit() {
        CategoryModel category = new CategoryModel(1L, "Valid Name", "Valid Description");
        String longDescription = "A".repeat(91); // Descripción con 91 caracteres
        Exception exception = assertThrows(DescriptionMaxSizeExceededException.class, () ->
                category.setDescription(longDescription)
        );
        assertEquals("Description exceeds maximum size of 90 characters", exception.getMessage());
    }

    @Test
    void testSetNameNull() {
        CategoryModel category = new CategoryModel(1L, "Valid Name", "Valid Description");
        Exception exception = assertThrows(NullPointerException.class, () ->
                category.setName(null)
        );
        assertEquals("Field 'name' can not be null", exception.getMessage());
    }

    @Test
    void testSetDescriptionNull() {
        CategoryModel category = new CategoryModel(1L, "Valid Name", "Valid Description");
        Exception exception = assertThrows(NullPointerException.class, () ->
                category.setDescription(null)
        );
        assertEquals("Field 'description' can not be null", exception.getMessage());
    }
}