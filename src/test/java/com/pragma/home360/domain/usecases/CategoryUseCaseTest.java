package com.pragma.home360.domain.usecases;


import com.pragma.home360.domain.exceptions.CategoryAlreadyExistsException;
import com.pragma.home360.domain.models.CategoryModel;
import com.pragma.home360.domain.ports.out.CategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryUseCaseTest {

    @Mock
    private CategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCategorySuccessfully() {
        CategoryModel categoryModel = new CategoryModel(1L, "category", "description");
        when(categoryPersistencePort.getCategoryByName(categoryModel.getName())).thenReturn(null);

        categoryUseCase.save(categoryModel);

        verify(categoryPersistencePort, times(1)).save(categoryModel);
    }

    @Test
    void testSaveCategoryAlreadyExists() {
        CategoryModel categoryModel = new CategoryModel(1L, "category", "description");
        when(categoryPersistencePort.getCategoryByName(categoryModel.getName())).thenReturn(categoryModel);

        assertThrows(CategoryAlreadyExistsException.class, () -> categoryUseCase.save(categoryModel));

        verify(categoryPersistencePort, never()).save(categoryModel);
    }

    @Test
    void testGetCategories() {
        int page = 0;
        int size = 10;
        boolean orderAsc = true;
        long totalElements = 2;

        List<CategoryModel> categories = Arrays.asList(
                new CategoryModel(1L, "category", "description"),
                new CategoryModel(2L, "category2", "description2")
        );
        Page<CategoryModel> expectedPage = new PageImpl<>(categories, PageRequest.of(page, size), totalElements);
        when(categoryPersistencePort.getCategories(page, size, orderAsc)).thenReturn(expectedPage);

        Page<CategoryModel> result = categoryUseCase.getCategories(page, size, orderAsc);

        assertEquals(expectedPage, result);
        verify(categoryPersistencePort, times(1)).getCategories(page, size, orderAsc);
    }
}