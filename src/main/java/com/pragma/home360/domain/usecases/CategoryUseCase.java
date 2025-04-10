package com.pragma.home360.domain.usecases;

import com.pragma.home360.domain.exceptions.CategoryAlreadyExistsException;
import com.pragma.home360.domain.models.CategoryModel;
import com.pragma.home360.domain.ports.in.CategoryServicePort;
import com.pragma.home360.domain.ports.out.CategoryPersistencePort;
import org.springframework.data.domain.Page;


public class CategoryUseCase implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void save(CategoryModel categoryModel) {
        CategoryModel category = categoryPersistencePort.getCategoryByName(categoryModel.getName());

        if (category != null) {
            throw new CategoryAlreadyExistsException("Category with the same name already exists");
        }
        categoryPersistencePort.save(categoryModel);
    }

    @Override
    public Page<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryPersistencePort.getCategories(page, size, orderAsc);
    }
}
