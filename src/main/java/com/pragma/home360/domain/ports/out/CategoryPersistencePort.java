package com.pragma.home360.domain.ports.out;

import com.pragma.home360.domain.models.CategoryModel;
import org.springframework.data.domain.Page;

public interface CategoryPersistencePort {

    void save(CategoryModel categoryModel);

    CategoryModel getCategoryByName(String categoryName);

    Page<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);

}
